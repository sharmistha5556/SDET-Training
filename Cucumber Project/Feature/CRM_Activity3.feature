@activity3_3
Feature: Schedule a meeting and invite members

  Scenario Outline: To schedule a meeting and include at least 3 invitees
    Given Open the CRM page
    And Login with CRM credentials,"admin" and "pa$$w0rd"
    And Navigate to Schedule a Meeting
    When User enters the details of the meeting with subject "Code Review Meeting1"
    And Search for members and add them to the meeting and save the invite  
      | Sam      	| Das     |
      | John      | Bicks	  |
      | Dave      | Berzezinski     |                
   	Then Navigate to View Meetings page and confirm creation of the "Code Review Meeting1" 
    And Close the Browser