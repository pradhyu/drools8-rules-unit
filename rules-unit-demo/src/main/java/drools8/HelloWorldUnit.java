package drools8;

import java.util.ArrayList;
import java.util.List;

import org.drools.ruleunits.api.DataSource;
import org.drools.ruleunits.api.DataStore;
import org.drools.ruleunits.dsl.RuleUnitDefinition;
import org.drools.ruleunits.dsl.RulesFactory;

import static org.drools.model.Index.ConstraintType.EQUAL;
import static org.drools.model.Index.ConstraintType.GREATER_THAN;
import static org.drools.model.Index.ConstraintType.LESS_THAN;

public class HelloWorldUnit implements RuleUnitDefinition {

    private final DataStore<String> strings;
    private final DataStore<Integer> ints;
    private final List<String> results = new ArrayList<>();

    public HelloWorldUnit() {
        this(DataSource.createStore(), DataSource.createStore());
    }

    public HelloWorldUnit(DataStore<String> strings, DataStore<Integer> ints) {
        this.strings = strings;
        this.ints = ints;
    }

    public DataStore<String> getStrings() {
        return strings;
    }

    public DataStore<Integer> getInts() {
        return ints;
    }

    public List<String> getResults() {
        return results;
    }

    @Override
    public void defineRules(RulesFactory rulesFactory) {
        // /strings[ this == "Hello World" ]
        rulesFactory.rule()
                    .on(strings)
                    .filter(EQUAL, "Hello World") // when no extractor is provided "this" is implicit
                    .execute(results, r -> r.add("it worked!")); // the consequence can ignore the matched facts

        // /strings[ length > 5 ]
        rulesFactory.rule()
                    .on(strings) // since the datasource has been already initialized its class can be inferred without the need of explicitly passing it
                    .filter(s -> s.length(), GREATER_THAN, 5) // when no property name is provided it's impossible to generate indexes and property reactivity
                    .execute(results, (r, s) -> r.add("it also worked with " + s.toUpperCase())); // this consequence also uses the matched fact

        // /strings[ length < 5 ]
        rulesFactory.rule("MyRule") // it is possible to optionally set a name for the rule
                    .on(strings)
                    .filter("length", s -> s.length(), LESS_THAN, 5) // providing the name of the property used in the constraint allows index and property reactivity generation
                    .execute(results, r -> r.add("this shouldn't fire"));

        // $s: /strings[ length > 5 ]
        // /ints[ this > 5, this == $s.length ]
        rulesFactory.rule()
                    .on(strings)
                    .filter("length", s -> s.length() > 5) // it is also possible to use a plain lambda predicate, but in this case no index can be generated
                    .join(
                          rule -> rule.on(ints) // creates a new pattern ...
                                      .filter(GREATER_THAN, 5) // ... add an alpha filter to it
                    ) // ... and join it with the former one
                    .filter(EQUAL, String::length) // this filter is applied to the result of the join, so it is a beta constraint
                    .execute(results, (r, s, i) -> r.add("String '" + s + "' is " + i + " characters long")); // the consequence captures all the joined variables positionally
    }


}