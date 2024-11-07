# run the test
```bash
sudo dnf install maven
mvn clean test

```
```log
INFO] --- maven-surefire-plugin:3.5.2:test (default-test) @ rules-unit-demo ---
[INFO] Using auto detected provider org.apache.maven.surefire.junit4.JUnit4Provider
[INFO] 
[INFO] -------------------------------------------------------
[INFO]  T E S T S
[INFO] -------------------------------------------------------
[INFO] Running drools8.RuleTest
2024-11-06 20:48:39,553 [main] INFO  Creating RuleUnit
2024-11-06 20:48:41,383 [main] INFO  Insert data
2024-11-06 20:48:41,435 [main] INFO  Run query. Rules are also fired
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 3.567 s -- in drools8.RuleTest
[INFO] 
[INFO] Results:
[INFO] 
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0
[INFO] 
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  17.878 s
[INFO] Finished at: 2024-11-06T20:48:41-05:00
[INFO] ------------------------------------------------------------------------
pradhyushrestha@penguin ~/g/d/rules-unit-demo (main)> 

```
