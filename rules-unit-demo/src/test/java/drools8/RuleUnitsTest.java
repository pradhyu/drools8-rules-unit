package drools8;


import org.drools.ruleunits.api.RuleUnitInstance;
import org.drools.ruleunits.api.RuleUnitProvider;
import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;


public class RuleUnitsTest {

    @Test
    public void helloWorld() {
        HelloWorldUnit unit = new HelloWorldUnit();
        unit.getStrings().add("Hello World");

        RuleUnitInstance<HelloWorldUnit> unitInstance = RuleUnitProvider.get().createRuleUnitInstance(unit);

        assertThat(unitInstance.fire()).isEqualTo(2);
        assertThat(unit.getResults()).containsExactlyInAnyOrder("it worked!", "it also worked with HELLO WORLD");

        unit.getResults().clear();
        unit.getInts().add(11);
        assertThat(unitInstance.fire()).isEqualTo(1);
        assertThat(unit.getResults()).containsExactly("String 'Hello World' is 11 characters long");

        unitInstance.close();
    }

}

