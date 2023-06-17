Feature: Login tests

  Scenario: Verify successful login to the app
    Given User is at the home page
    When User enters login id
    And User enters password
    And User click login button
    Then Home page should be displayed