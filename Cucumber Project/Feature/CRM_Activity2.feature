@activity3_2
Feature: Create leads using parameterization

  Scenario Outline:  Open the Leads page and add multiple lead accounts using values passed from Feature file
    Given Open the CRM page
    And Login with CRM credentials,"admin" and "pa$$w0rd"
    And Navigate to Create Lead
    When User fills in the necessary details, "<firstname>" and "<lastname>" to create lead accounts
    And Click Save to finish
    Then Navigate to the View Leads page to see results of "<firstname>" and "<lastname>"
    And Close the Browser 
    
   Examples:
    | firstname		            | lastname         | 
    | Sam					      			| Desilva          | 
    |John											|Berzezinski       |
    