@contact-us
Feature: WebDriver University - Contact Us Page

  Background:
    Given access the webdriver university contact us page

  Scenario: Validate Successful Submission - Unique Data
    When Enter a unique first name
    And Enter a unique last name
    And  Enter unique email address
    And Enter a unique comment
    And click on the submit button
    Then It has to be presented successful confirmation

    Scenario: Validate Successful Submission - Specific Data
      When enter a specific first name Dovydas
      And enter a specific last name Tamulisgt
      And  enter a specific email address dovydastt@gmail.com
      And enter a specific comment "Hello sir/madam how are you?"
      And click on the submit button
      Then It has to be presented successful confirmation
