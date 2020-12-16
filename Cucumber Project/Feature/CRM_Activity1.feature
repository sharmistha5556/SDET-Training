@activity3_1
Feature: Counting Dashlets

  Scenario:  open the homepage and count the dashlets
    Given Open the CRM page
    And Login with CRM credentials,"admin" and "pa$$w0rd"
    When Print the number and title of each Dashlet into the console
    And Close the Browser