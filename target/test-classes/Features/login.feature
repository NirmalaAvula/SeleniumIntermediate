Feature: login functionality
Scenario: Successful login with valid credentials
Given User launch Chrome browser
When User opens URL "https://enabledplusqa-anbbf9dyhef4dehg.z01.azurefd.net/Login?ReturnUrl=%2f"
Then the user enters username as "support-945" and password as "Nirmala@888"
And Click on Login 
Then the user should be navigated to the homepage
Scenario: Creating lead through Accept Inbound Call Form submission
When the user navigates to the home page
Then user navigates to AcceptInboundCall page
And the user fills the form with random data 
And clicks on the Sell The Appointment button
Then the form should be submitted successfully   
Scenario:Setting the appointment for lead 
When the user fills the appointment form  
Then user clicks on the Set the Appointment buttons
Scenario:Confirming the appointment on the leaddetails page
When the user navigates to the appointment calendar page  
Then the user finds the appointment scheduled for the created lead  
And the user clicks on the Confirm button on the lead details page


 
 