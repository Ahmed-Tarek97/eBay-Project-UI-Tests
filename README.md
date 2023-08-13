# Luftborn(eBay) Project - UI Automated Tests

This repository will be used to create and execute automated tests to the Luftborn eBay Project.  
To be able to do that, below we can find some insights about:
1. System Requirements
2. Project Structure
3. How to run tests

## 1. System Requirements
In order to be able to work with this repository and run the automated tests, we need to previously install the 
following tools and plugins:
- Java - https://www.oracle.com/java/technologies/javase-jdk11-downloads.html
- Maven - https://maven.apache.org/install.html
- Intellij Idea - https://www.jetbrains.com/idea/download/#section=windows
    - Gherkin
    - Cucumber for Java
    - CheckStyle
    - SonarLint

After install the above tools and plugins, make sure you have a local settings.xml file under your .m2 folder and, 
that the settings.xml file is connecting to a maven repository so that Intellij can export all the needed dependencies.    


## 2. Project Structure
    src
        |_ main
            |_ java
                |_ org.example
                    |_ Main
            |_ resources
                |_ features
        |_ test
            |_ java
                |_ org.example
                    |_ pages
                    |_ stepDefs
                    |_ testRunner
                |_ testData
    target
    pom.xml
    README.md

There are 3 important groups of files to be placed to create a test:
- **Feature**
  - Can be found under: src/main/resources/features
  - Written in Gherkin language and mirroring business scenarios using a readable and accessible language for everybody
- **StepDefinitions**
  - Can be found under: src/test/java/org.example/stepDefs
  - They are written in Java language and, they define what is supposed to be done for each of the steps from one 
    business scenario described in the Feature file
- **TestData**
  - Can be found under: src/test/java/testData/
  - They are written in JSON language
  - We can save here information such as URLs, Locators and test data.
    
Aside from these, we also have some other folders and/or files important to keep the project working:
- **pom.xml**
  - As this is a Maven project, which is base on the concept of a Project Object Model (POM),
  we must have a pom.xml file to manage all the required dependencies and plugins
- **target**
  - This is a folder which contains our code (after packaging it) and our reports
  - The report is located under the target file as "cucumber.html"

## 3. How to run tests
There are 2 ways to run tests locally:
- Opening the feature from the features file, clicking in the play button (at left) of the feature or of the scenario.
- Using the testRunner to run and generate the report needed(based on configurations).
