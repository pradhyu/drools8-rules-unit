
package drools8;

import org.drools.ruleunits.api.RuleUnitProvider;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.drools.ruleunits.api.RuleUnitInstance;

import static java.util.stream.Collectors.toList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.List;

public class RuleTest {

  static final Logger LOG = LoggerFactory.getLogger(RuleTest.class);

  /*
   * @Test
   * public void testMortgage() {
   * LOG.info("Creating RuleUnit");
   * MeasurementUnit measurementUnit = new MeasurementUnit();
   * 
   * RuleUnitInstance<MeasurementUnit> instance =
   * RuleUnitProvider.get().createRuleUnitInstance(measurementUnit);
   * try {
   * LOG.info("Insert color measurement data");
   * measurementUnit.getMeasurements().add(new Measurement("color", "red"));
   * LOG.info("Run query. Rules are  also fired");
   * List<Measurement> queryResult =
   * instance.executeQuery("FindColor").toList("$m");
   * assertTrue(queryResult.size() > 0);
   * List<Measurement> redResult =
   * instance.executeQuery("FindColorRed").toList("$m");
   * LOG.info("Found: RedResult");
   * redResult.forEach(m -> LOG.info("Found: " + m));
   * 
   * } finally {
   * instance.close();
   * }
   * }
   * 
   */

//   @Test 
//   public void javaDSL() {
// var ruleUnit = MeasurementRules.createInstance();
// var measurement = new Measurement("color", "green");
// ruleUnit.variables().get(MeasurementUnit.class).getMeasurements().append(measurement);
// ruleUnit.fire()
//   }
    // @Test
    // public void helloWorld() {
    //     HelloWorldUnit unit = new HelloWorldUnit();
    //     unit.getStrings().add("Hello World");

    //     RuleUnitInstance<HelloWorldUnit> unitInstance = RuleUnitProvider.get().createRuleUnitInstance(unit);

    //     assertThat(unitInstance.fire()).isEqualTo(2);
    //     assertThat(unit.getResults()).containsExactlyInAnyOrder("it worked!", "it also worked with HELLO WORLD");

    //     unit.getResults().clear();
    //     unit.getInts().add(11);
    //     assertThat(unitInstance.fire()).isEqualTo(1);
    //     assertThat(unit.getResults()).containsExactly("String 'Hello World' is 11 characters long");

    //     unitInstance.close();
    // }
    @Test
  public void test() {
    LOG.info("Creating RuleUnit");
    MeasurementUnit measurementUnit = new MeasurementUnit();

    RuleUnitInstance<MeasurementUnit> instance = RuleUnitProvider.get().createRuleUnitInstance(measurementUnit);
    try {
      LOG.info("Insert color measurement data");
      measurementUnit.getMeasurements().add(new Measurement("color", "red"));
      measurementUnit.getMeasurements().add(new Measurement("color", "green"));
      measurementUnit.getMeasurements().add(new Measurement("color", "blue"));
      measurementUnit.getMeasurements().add(new Measurement("color", "red"));
      measurementUnit.getMeasurements().add(new Measurement("color", "red"));
      measurementUnit.getMeasurements().add(new Measurement("color", "red"));
      measurementUnit.getMeasurements().add(new Measurement("color", "red"));
      measurementUnit.getMeasurements().add(new Measurement("color", "red"));
      measurementUnit.getMeasurements().add(new Measurement("color", "red"));
      measurementUnit.getMeasurements().add(new Measurement("color", "red"));
      measurementUnit.getMeasurements().add(new Measurement("color", "red"));
      measurementUnit.getMeasurements().add(new Measurement("color", "red"));
      measurementUnit.getMeasurements().add(new Measurement("color", "red"));

      LOG.info("Insert shape measurement data");
      measurementUnit.getMeasurements().add(new Measurement("shape", "triangle"));
      measurementUnit.getMeasurements().add(new Measurement("shape", "triangle"));
      measurementUnit.getMeasurements().add(new Measurement("shape", "triangle"));
      measurementUnit.getMeasurements().add(new Measurement("shape", "square"));
      measurementUnit.getMeasurements().add(new Measurement("shape", "square"));
      measurementUnit.getMeasurements().add(new Measurement("shape", "square"));
      measurementUnit.getMeasurements().add(new Measurement("shape", "square"));
      measurementUnit.getMeasurements().add(new Measurement("shape", "rectangle"));
      measurementUnit.getMeasurements().add(new Measurement("shape", "rectangle"));
      measurementUnit.getMeasurements().add(new Measurement("shape", "rectangle"));
      measurementUnit.getMeasurements().add(new Measurement("shape", "rectangle"));
      measurementUnit.getMeasurements().add(new Measurement("shape", "pentagon"));
      measurementUnit.getMeasurements().add(new Measurement("shape", "pentagon"));
      measurementUnit.getMeasurements().add(new Measurement("shape", "pentagon"));
      measurementUnit.getMeasurements().add(new Measurement("shape", "pentagon"));
      measurementUnit.getMeasurements().add(new Measurement("shape", "pentagon"));
      LOG.info("Run query. Rules are  also fired");
      List<Measurement> queryResult = instance.executeQuery("FindColor").toList("$m");

      assertTrue(queryResult.size() > 0);
      assertTrue("contains red", measurementUnit.getControlSet().contains("red"));
      assertTrue("contains green", measurementUnit.getControlSet().contains("green"));
      assertTrue("contains blue", measurementUnit.getControlSet().contains("blue"));
      List<Measurement> redResult = instance.executeQuery("FindColorRed").toList("$m");
      LOG.info("Found: RedResult");
      redResult.forEach(m -> LOG.info("Found: " + m));

    } finally {
      instance.close();
    }
  }
}
