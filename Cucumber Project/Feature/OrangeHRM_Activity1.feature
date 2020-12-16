@activity2_1
Feature: Creating a job vacancy

  Scenario:  To create a job vacancy for “DevOps Engineer”
    Given Open the OrangeHRM page
    And Login with credentials provided
    And Navigate to "Recruitment" page
    And Navigate to Vacancies menu item
    And Click on "Add Job Vacancy"
    When User fills out "Rust Engineer", "Test Rust Engineer101", "Astin" details
    And Click on save button 
    Then Verify that the vacancy was created with "Rust Engineer", "Test Rust Engineer101", "Astin" details
    And Close the Browser