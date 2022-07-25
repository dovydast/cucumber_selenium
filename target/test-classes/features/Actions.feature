@All @Actions @regression
Feature: Webdriveruniversity - Drag, Drop, Hover, Click and hold, double click

  Background:
    Given Access the webdriver action page
@Drag
  Scenario: Drag & Drop function
    When Move small box to targeted Box location
    Then Present with confirmation messageDropped!

  @Double-click
  Scenario: Double click function
    When Double click on yellow box
    Then The box has to be green color

  @Hover
  Scenario: Hover on third box and access second option
    When Hover the mouse on third box
    And Click on the second option
    Then The alert should be presented with confirmation messageWell done you clicked on the link!

  @Hold
  Scenario:  Hold mouse click - keep holding
    When Hold left mouse click on orange box
    Then Display confirmation messageWell done! keep holding that click now.....