@activity3_4
Feature: Creating a Product

  Scenario Outline: To use an Examples table to add products
    Given Open the CRM page
    And Login with CRM credentials,"admin" and "pa$$w0rd"
    And Navigate to Create Product
    When User enters the details of the product like "<productname>" and "<price>"
    And save the product created               
   	Then Navigate to View Products page and confirm creation of the product named "<productname>"
    And Close the Browser 
    
    Examples:
    |productname       		|  price
    |Levo4								|   30.00   	 
    |Camlin4							|		27.00							
    |Lexi4						  	|   16.00  