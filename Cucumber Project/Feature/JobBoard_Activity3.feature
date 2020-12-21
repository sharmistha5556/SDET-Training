@activity1_3
Feature: Searching for jobs

  Scenario: Searching for jobs and applying to them
    Given Open Alchemy JobSite
    And Navigate to Post A Job page
    When User sets "tim@jobs.com", "API Tester", "www.ibm.com" and "IBM Pvt Ltd"
    And Saves draft
    And Navigate to job dashboard 
    Then Confirm the job listing contains "API Tester"
    And Close the Job Board Browser