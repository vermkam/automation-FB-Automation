#Facebook
****About the Project***
Automation framework for ‘UI testing’ of Facebook Application.
[URL]: (https://www.facebook.com/)
Only three functional scenarios have been included as a part of this project. These tests are designed as smoke test

**Technology/Framework Used**: 
Technology Used : Java, TestNG, Selenium, Maven
Pattern Used: Page Object Model

**Files in Project**

-basepage.java
-signup.java
-loginPage.java
-loginTest.java
-signUpTest.java
-failedTest
-browserFactory.java
-getScreenShot.java
-TestUtil.java
-Xls_Reader.java
-config.properties
-testng.xml
-pom.xml

***Excel file to test SignUp functionality***
-FbExcel.xlsx

***Test Scenarios Description**
-FB TestCases.xlsx

**Features**:
This Project uses POM based pattern.BasePage has the common methods for all tests.All the pages are in com.pages package,tests are placed in com.testscases & utilities are in com.utility folder.Extent reports has been generated to represent the execution status and is placed under Reports folder with logs of the failed Tests and screenshots for failed & passed ones.


