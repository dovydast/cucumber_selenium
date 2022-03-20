@login
  Feature: Webdriver University - Login page
    Scenario: Validate successful login
      Given Access the webdriver login page
      When enter a specific login name webdriver
      And enter a specific password webdriver123
      And click on Login button
      Then Alert pop up should be presented with a successful valid message - Validation succeeded

    Scenario: Validate unsuccessful login
      Given Access the webdriver login page
      When enter random login name
      And enter random password
      And click on Login button
      Then Alert pop up should be presented with a unsuccessful invalid message - Validation failed