@activity1_2
Feature: Searching for jobs

  Scenario: Searching for jobs and applying to them
    Given Open Alchemy JobSite
    And Navigate to jobs page
    When User searches for "SDET Tester" jobs through keyword field
    And Filter job types to show "Full Time" jobs
    And Find the job listing
    And Find the job title and print on console
    Then Click and Apply for the job
    And Close the Browser