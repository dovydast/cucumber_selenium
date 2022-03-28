@All @Actions
Feature: Webdriveruniversity - Drag, Drop, Hover, Click and hold, double click

  Background:
    Given Access the webdriver action page

  Scenario: Drag & Drop function
    When Move small box to targeted Box location
    Then Present with confirmation message

@Double-click
  Scenario: Double click function
    When Double click on yellow box
    Then The box has to be green color
