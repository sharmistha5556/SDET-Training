@activity1_4
Feature: Searching for jobs

Scenario Outline: Searching for jobs and applying to them
    Given Open Alchemy JobSite
    And Navigate to Post A Job page
    When User sets "<email>", "<JobTitle>", "<websiteURL>" and "<company>"
    And Saves draft
    And Navigate to job dashboard 
    Then Confirm the job listing contains "<JobTitle>"
    And Close the Job Board Browser
    
Examples:
    | email		            | JobTitle         |  websiteURL  | company |
    | tommy@gmail.com       | System Admin     | www.ibm.com  |   IBM   |
    | adminUser123@gmail.com | Test Specialist  | www.ibm.com  |   IBM   |