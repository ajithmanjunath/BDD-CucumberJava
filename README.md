# BDD Framework - Cucumber/Java

BDD framework is built using Cucumber, Java and Maven. JUnit and TestNG are used as testing frameworks to drive and execute tests.

## Getting Started

You can clone from the repository link.

### Prerequisites

To make sure java and maven path are set in system environment variables.

```
Example:

JAVA_HOME = C:\Program Files\Java\jdk1.8.0_221\bin

MAVEN_HOME = C:\apache-maven-3.6.1\bin
```

## Framework capabilities

1. Modular designed using POM
2. Testdata modularised for different environment using Json
3. Report generation with screenshots on failure scenarios. Can be extended to all scenarios.
4. Extension for multi browser support test execution
5. Auto-Rerun of failed scenarios
6. Reusable and Scalable
7. Tests can be scripted as per needs with JUnit or TestNG
8. No external storage of screenshot captured.
9. Report back up after test execution is completed.
10. Logging mechanism is implement using log4j.

## Running the tests

1. Maven command execution ( mvn verify -Denv=prod)
2. testng.xml file execution ( Please provide -Denv=prod in runtime arguments for TestRunner.Java file before execution)
3. JUnit level test execution ( Please provide -Denv=prod in runtime arguments for TestRunner.Java file before execution)

### And coding style tests

Java code style template is used

```
/**
* Created by Ajith Manjunath 
* @author:	Ajith Manjunath 
* Date:		17 Aug 2019
* Purpose:	To have collective action methods for particular page
*/
```

## Deployment

Java and Maven environment with required browser driver. At this point, it is targeted with chrome browser.

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management

## Versioning

None

## Authors

* **Ajith Manjunath**
