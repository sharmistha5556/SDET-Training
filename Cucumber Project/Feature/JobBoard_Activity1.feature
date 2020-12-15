@activity1_1
Feature: Create a new user for JobBoard

  Scenario: Testing user creation
    Given User is on Job Board Login page
    When User enters "root" and "pa$$w0rd"
    And Click on users
    And Click the Add New button
    And Create a new user
    Then Validate the user has been created
    And Close the Browser

