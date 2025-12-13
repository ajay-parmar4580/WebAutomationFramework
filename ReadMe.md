
# Web Automation Framework

This is a Java-based test automation framework.
The framework is designed to be scalable, configurable, and CI/CD friendly, supporting:

Local execution,
Headless execution for faster runs,
Cloud execution using LambdaTest,
Data-driven testing,
Rich reporting and logging

The framework follows industry-standard automation practices such as modular design, reusability, and configuration via CLI parameters.


## 🚀 About Me
Hi, My name is Ajay Singh Parmar and I have 8.5 years of experience in Automation Testing using technologies like Selenium Webdriver, RestAssured.

My major expertise is in Java Programming language.


## Author

- [@ajay-parmar4580](https://github.com/ajay-parmar4580)

- EmailAddress: parmarajay1087@gmail.com
## 🔗 Links
[![portfolio](https://img.shields.io/badge/my_portfolio-000?style=for-the-badge&logo=ko-fi&logoColor=white)](https://github.com/ajay-parmar4580/)

[![linkedin](https://img.shields.io/badge/linkedin-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/parmarajay1087/)


## Prerequisites

Before running this framework, ensure the following software is installed on your system:

- **Java 11** - Make sure Java is installed and the JAVA_HOME environment variable is set.
- **Maven** - Ensure Maven is installed and added to the system path.


## Features

 - Java 11 + TestNG based automation framework
 - Page Object Model (POM) for clean, maintainable test design
 - Data-driven testing using CSV (OpenCSV), JSON (Gson), and Excel (Apache POI)
 - Dynamic test data generation using Java Faker
 - Cross-browser testing with runtime browser selection
 - Headless execution for faster and CI/CD-ready test runs
 - Cloud execution on LambdaTest for scalable cross-browser testing
 - CLI-based execution using Maven Surefire parameters
 - Rich HTML reports generated with Extent Reports
 - Centralized logging using Log4j
 - Scalable and CI/CD friendly architecture

 ## Technologies Used

  - **Language** - Java 11
  - **Test Framework** - TestNG
  - **Build Tool** - Maven
  - **Browser Automation** - Selenium WebDriver
  - **Cloud Execution** - LambdaTest
  - **Reporting** - Extent Reports
  - **Logging** - Log4j
  - **Data Driven Testing** - OpenCSV, Gson, Apache POI
  - **Fake Test Data** - Java Faker
  - **Execution Mode** - Headed / Headless
  - **CLI Execution** - Maven Surefire Plugin
## Installation

**Clone the Repository**

```bash
git clone https://github.com/ajay-parmar4580/WebAutomationFramework.git

cd WebAutomationFramework
```

**Run Tests Locally (Normal Mode)**
```bash
mvn clean test -Dbrowser=chrome -DisHeadless=false -DisLambdaTest=false -X
```

**Run Tests in Headless Mode**
```bash
mvn clean test -Dbrowser=chrome -DisHeadless=true -DisLambdaTest=false -X
```

**Run Tests on LambdaTest**
```bash
mvn clean test -Dbrowser=chrome -DisHeadless=false -DisLambdaTest=true -X
```

## Reports & Logs
- **ExtentReport** - Detailed HTML report will be generated at ./report/ExtentReport.html. Report contains information on test cases executed/passed/failed/skipped along with screenshots for failed test cases.
- **Logs** - Logs are created during the test execution and stored in ./logs directory.

## Github Actions

This project uses GitHub Actions to automatically execute the test automation framework on every push and pull request to the master branch. The workflow runs tests using Maven in headless mode on LambdaTest, uploads logs, screenshots, and Extent Reports as artifacts, and publishes the latest execution report to GitHub Pages for easy access.

## How to View GitHub Pages Report

Once the GitHub Actions workflow completes, the latest Extent Report is published to GitHub Pages.
Click on the below url for report.

https://ajay-parmar4580.github.io/WebAutomationFramework/ExtentReport.html


    
