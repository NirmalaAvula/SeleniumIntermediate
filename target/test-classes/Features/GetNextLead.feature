Feature: GetNextLead disposition functionality
Scenario:Successful login with valid credentials
Given User launch Chrome browser
When User opens URL "https://enabledplusqa-anbbf9dyhef4dehg.z01.azurefd.net/Login?ReturnUrl=%2f"
Then the user enters username as "support-945" and password as "Nirmala@888"
And Click on Login

Scenario:Taking action on the different dispositions on the GNL page 
 Given the user navigates to the Get Next Lead details page after taking action on the "Answering Machine" disposition
 Given the user navigates to the Get Next Lead details page after taking action on the "Busy" disposition
 Given the user navigates to the Get Next Lead details page after taking action on the "Left Message" disposition
 Given the user navigates to the Get Next Lead details page after taking action on the "No Answer" disposition
 Given the user navigates to the Get Next Lead details page after taking action on the "Wrong Number" disposition
 Given the user navigates to the Get Next Lead details page after taking action on the "Next Lead" disposition
    Given the user navigates to the Get Next Lead details page after taking action on the Delete/Duplicate disposition
   #Given the user navigates to the Get Next Lead details page after taking action on the Not Interested disposition
  Given the user navigates to the Get Next Lead details page after taking action on the PostNotes disposition
   #Given the user navigates to the Get Next Lead details page after taking action on the RequestingInformation disposition
   #Given the user navigates to the Get Next Lead details page after taking action on the Quarantine This Lead disposition
  #Given the user navigates to the Get Next Lead details page after taking action on the CallBack disposition
 #Given the user navigates to the Get Next Lead details page after taking action on the Do Not Call disposition










