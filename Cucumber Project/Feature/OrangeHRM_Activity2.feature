@activity2_2
Feature: Adding a candidate for recruitment

  Scenario:  Add information about a candidate for recruitment
    Given Open the OrangeHRM page
    And Login with credentials provided
    And Navigate to "Recruitment" page
    And Click on the Add button to add candidate
    When User fills out "Timmy","Thomas", "SamThomas@gmail.com","Automation Test Engineer" candidate details
    And Upload resume "C:\\Users\\ibmadmin\\Documents\\Resume\\Sharmistha_AutomationSpecialist_Profile.doc" to the form 
    And Click Save
    Then Navigate back to the Recruitments page to confirm candidate entry with "Timmy Thomas", "Automation Test Engineer"
    And Close the Orange HRM Browser