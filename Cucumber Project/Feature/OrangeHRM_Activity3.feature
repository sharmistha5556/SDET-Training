@activity2_3
Feature: Add multiple employees

  Scenario Outline:  Add multiple employees using an the Examples table
    Given Open the OrangeHRM page
    And Login with credentials provided
    And Click the PIM option
    And Click on the add employee button
    And Check the "Create Login Details" checkbox
    When User creates employee with "<firstname>", "<lastname>" 
    Then Verify that the employee details has been created
    And Close the Browser
    
    Examples:
    | firstname		        | lastname         | 
    | Tim                 | Thomas           | 
    | Sam                 | George           |  