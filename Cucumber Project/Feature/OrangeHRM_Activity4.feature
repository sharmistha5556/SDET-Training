@activity2_4
Feature: Creating a job vacancy

  Scenario Outline:  To create a job vacancy for “DevOps Engineer”
    Given Open the OrangeHRM page
    And Login with credentials provided
    And Navigate to "Recruitment" page
    And Navigate to Vacancies menu item
    And Click on "Add Job Vacancy"
    When User fills out "<JobName>", "<VacancyName>", "<HiringMgr>" details
    And Click on save button 
    Then Verify that the vacancy was created with "<JobName>", "<VacancyName>", "<HiringMgr>" details
    And Close the Orange HRM Browser
    
    Examples:
    |JobName           |  VacancyName             | HiringMgr   |
    |Rust Engineer	   |Test Rust Engineer102     | Astin				|
    |Android Developer |Java Backend Developer102	|Amy Russo    |