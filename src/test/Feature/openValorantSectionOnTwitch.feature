Feature: Twitch.tv stream
  Scenario: Open twitch.tv stream - valorant game section
    Given I have configured browser setup
    When I navigate to valorant game section
    Then I see valorant streaming section