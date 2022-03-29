@All @login @regression
Feature: Webdriver University - Login page

  Background:
    Given Access the webdriver login page


  Scenario: Validate successful login
    When enter a login name webdriver
    And enter a password webdriver123
    And click on Login button

  Scenario: Validate unsuccessful login
    When enter a login name webdriver
    And enter a password webdriver1
    And click on Login button

  @smoke
  Scenario Outline: Validate - successful and unsuccessful login
    When enter a login name <loginName>
    And  enter a password <password>
    And click on Login button
    Then Alert should be presented with the following validation message <loginValidationMessage>

    Examples:
      | loginName | password     | loginValidationMessage |
      | webdriver | webdriver123 | validation succeeded   |
      | webdriver | webdriver1   | validation failed      |
      | dovis     | dovist       | validation failed      |