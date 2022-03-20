@login
  Feature: Webdriver University - Login page
    Scenario: Validate successful login alert message - with created user account
      Given Access the webdriver login page
      When I enter a specific login name webdriver
      When I enter a specific password webdriver123
      When I click on Login button
      Then Alert pop up should be presented with a successful valid message - Validation succeeded

      Scenario: Validate unsuccessful login alert message - with incorrect user account
        Given Access the webdriver login page
        When I enter random login name
        When I enter random password
        When I click on Login button
        Then Alert pop up should be presented with a unsuccessful invalid message - Validation failed