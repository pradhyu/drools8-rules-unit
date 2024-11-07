# Pre-requisites install 
```bash
# install maven depending on whether you are using rhel based or deb based linux
sudo dnf install maven
or 
sudo apt-install maven

# maven version
pradhyushrestha@penguin ~/g/d/rules-unit-demo (main) [127]> mvn --version
Apache Maven 3.8.7
Maven home: /usr/share/maven
Java version: 17.0.13, vendor: Debian, runtime: /usr/lib/jvm/java-17-openjdk-amd64
Default locale: en_US, platform encoding: UTF-8
OS name: "linux", version: "6.6.30-02728-g8557330097f3", arch: "amd64", family: "unix"
pradhyushrestha@penguin ~/g/d/rules-unit-demo (main)>


# run the test
```bash
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
