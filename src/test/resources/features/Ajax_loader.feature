@regression
Feature: Ajax loader
  Background:
    Given Access the webdriver alerts page

 @ajax
    Scenario: Validate ajax loader
      When Click on ajax loader
      Then Wait for green button appearance
      And Click on green button
      Then Verify modal-title is correct
      And Click to close modal
