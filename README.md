# TutorialsNinja Automation Framework by Aziza Sultana

[![Java](https://img.shields.io/badge/Java-17%2B-blue)](https://www.java.com/)
[![Maven](https://img.shields.io/badge/Maven-3.8%2B-blue)](https://maven.apache.org/)
[![TestNG](https://img.shields.io/badge/TestNG-7.8.0-blue)](https://testng.org/)
[![Selenium](https://img.shields.io/badge/Selenium-4.8.0-blue)](https://www.selenium.dev/)

A robust test automation framework for TutorialsNinja e-commerce platform, implementing best practices in test automation.

## Features

- **Page Object Model (POM)** design pattern
- Data-driven testing with CSV files
- Extent Reports for detailed test reporting
- Cross-browser & cross-platform compatibility
- CI/CD integration with scheduled executions
- Parallel test execution capability
- Automatic screenshot capture on failures

## Prerequisites

- Java JDK 17+
- Maven 3.8+
- Git
- Chrome/Firefox/Edge browser
- Internet connection

## Installation

1. Clone the repository:
```bash
git clone https://github.com/your-username/tutorialsninja-automation.git
cd tutorialsninja-automation
```

2. Install dependencies:
```bash
mvn clean install
```

## Configuration
1. Environment Setup:

Update `src/test/resources/config.properties`:
```bash
# Environment settings
homeUrl=https://tutorialsninja.com/demo/index.php

# Browser settings
browser=chrome
headless=false
timeout=10

# Cross-platform settings
download.dir=${user.home}/Downloads
screenshot.dir=target/screenshots/
```

2. Test Data:

Add test data files:

    * Registration data: src/test/resources/testdata/registration_data.csv

    * Checkout data: src/test/resources/testdata/checkout_data.csv

3. Reporting:

Customize reports in `src/test/resources/extent-config.xml`

## Running Tests
**Local Execution**:
```bash
mvn clean test
```

**Browser Options**:
```bash
mvn test -Dbrowser=firefox -Dheadless=true
```

**Specific Test Suite**:
```bash
mvn test -DsuiteXmlFile=testng.xml
```

## Test Cases
1. User Registration
```bash
Scenario Outline: Successful user registration
Given User navigates to registration page
When User enters valid registration details
Then Account should be created successfully
```

1. Guest Checkout
```bash
Scenario: Successful guest checkout
Given User adds product to cart
When User completes checkout process as guest
Then Order should be placed successfully
```

## Reports
After test execution, view reports at:
```
target/extent-reports/index.html
```

## CI/CD Integration
### Jenkins Setup
1. Create new Pipeline job
2. Set cron trigger: H 0 * * * (daily midnight UTC)
3. Pipeline script from SCM: Jenkinsfile
### GitHub Actions
Nightly tests automatically run via `.github/workflows/nightly-tests.yml`

## Project Structure
```
tutorialsninja-automation/
├── src/main/java/
│   └── com/tutorialsninja/
│       ├── pages/          # Page Object classes
│       └── utils/          # Utility classes
├── src/test/java/
│   └── com/tutorialsninja/
│       ├── tests/          # Test classes
│       └── dataproviders/  # Data providers
│       └── listeners/      # Listeners
├── src/test/resources/
│   ├── config.properties   # Environment config
│   ├── testdata/           # CSV test data
│   └── extent-config/      # Report customization
├── target/                 # Generated reports
├── pom.xml                 # Maven config
└── testng.xml              # TestNG config
```