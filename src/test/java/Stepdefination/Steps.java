package Stepdefination;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

//import io.cucumber.java.Before;
import io.cucumber.java.en.*; //// no need to import when , then , and packages
import io.github.bonigarcia.wdm.WebDriverManager;
//import pageObjects.Baseclass;
import pageObjects.LoginPage;


public class Steps {	
	 public static WebDriver driver;
	  public static  LoginPage lp;
	@Given("User launch Chrome browser")
	public void user_launch_chrome_browser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		lp = new LoginPage(driver);
	}

	@When("User opens URL {string}")
	public void user_opens_url(String URL) {
		driver.get(URL);
	}
	@Then("the user enters username as {string} and password as {string}")
	public void the_user_enters_username_as_and_password_as(String username, String password) {
		lp.EnterUsername(username);
		lp.Enterpassword(password);
	}

	@Then("Click on Login")
	public void click_on_login() {
		lp.clicksubmit();
	}

	
	@Then("the user should be navigated to the homepage")
	public void the_user_should_be_navigated_to_the_homepage() {
		lp.verifyUserIsNavigatedToHomepage();
		}
	
	@When("the user navigates to the home page")
	public void the_user_navigates_to_the_homepage() {
		lp.navigateToHomepage();
    }

	@Then("user navigates to AcceptInboundCall page")
	public void user_navigates_to_accept_inbound_call_page() {
		lp.navigateToAcceptInboundCallPage();
	}

	@And("the user fills the form with random data")
	public void the_user_fills_the_form_with_random_data() throws InterruptedException {
		lp.fillLeadFormWithRandomData();
}                    

	@Then("clicks on the Sell The Appointment button")
	public void clicks_on_the_sell_the_appointment_button() {
		lp.clickSellAppointmentButton();
	}

	@Then("the form should be submitted successfully")
	public void the_form_should_be_submitted_successfully() {
		lp.verifyFormSubmittedSuccessfully();
	}
	@When("the user fills the appointment form")
	public void the_user_fills_the_appointment_form() {
		lp.fillAppointmentForm();
	    
	}
	@Then("user clicks on the Set the Appointment buttons")
	public void  clickSetAppointmentButton() {
		lp. clickSetAppointmentButton();

	}
	@When("the user navigates to the appointment calendar page")
	public void the_user_navigates_to_the_appointment_calendar_page() {
	    lp.navigateToAppointmentCalendarPage();
	}

	@Then("the user finds the appointment scheduled for the created lead")
	public void the_user_finds_the_appointment_scheduled_for_the_created_lead() {
	    lp.findScheduledAppointmentForCreatedLead();
	}

	@And("the user clicks on the Confirm button on the lead details page")
	public void the_user_clicks_on_the_confirm_button_on_the_lead_details_page() {
	    lp.clickConfirmButtonOnLeadDetailsPage();
	}
	
	/*@Given("the user navigates to the Get Next Lead details page after taking action on the disposition")
	public void the_user_navigates_to_the_get_next_lead_details_page_after_taking_action_on_the_disposition() {
	    lp.navigateToNextLeadAfterDispositionActions();
}
	
	@Given("the user navigates to the Get Next Lead details page after taking action on the busy disposition")
	public void the_user_navigates_to_the_get_next_lead_details_page_after_taking_action_on_the_busy_disposition() {
	   lp.navigateToNextLeadAfterbusyDispositionAction();
	}
	

	@Given("the user navigates to the Get Next Lead details page after taking action on the LeftMessage disposition")
	public void the_user_navigates_to_the_get_next_lead_details_page_after_taking_action_on_the_left_message_disposition() {
	  lp.navigateToNextLeadAfterLeftMessageDispositionAction();
	}
	
	@Given("the user navigates to the Get Next Lead details page after taking action on the No Answer disposition")
	public void the_user_navigates_to_the_get_next_lead_details_page_after_taking_action_on_the_no_answer_disposition() {
		lp.navigateToNextLeadAfterNoAnswerDispositionAction(); 
	}
	
	@Given("the user navigates to the Get Next Lead details page after taking action on the WrongNumber disposition")
	public void the_user_navigates_to_the_get_next_lead_details_page_after_taking_action_on_the_wrong_number_disposition() {
	    lp.navigateToNextLeadAfterWrongNumberDispositionAction();
	}
@Given("the user navigates to the Get Next Lead details page after taking action on the NextLead disposition")
public void the_user_navigates_to_the_get_next_lead_details_page_after_taking_action_on_the_next_lead_disposition() {
   lp.navigateToNextLeadAfterNextLeadDispositionAction();
}*/
	@Given("the user navigates to the Get Next Lead details page after taking action on the Not Interested disposition")
	public void the_user_navigates_to_the_get_next_lead_details_page_after_taking_action_on_the_not_interested_disposition() {
	  lp.navigateToNextLeadAfterNotInterestedDispositionAction();
	}
	@Given("the user navigates to the Get Next Lead details page after taking action on the Delete\\/Duplicate disposition")
	public void the_user_navigates_to_the_get_next_lead_details_page_after_taking_action_on_the_delete_duplicate_disposition() {
	lp.navigateToNextLeadAfterDeleteDuplicateDispositionAction();
	}

	@Given("the user navigates to the Get Next Lead details page after taking action on the PostNotes disposition")
	public void the_user_navigates_to_the_get_next_lead_details_page_after_taking_action_on_the_post_notes_disposition() {
      lp.navigateToNextLeadAfterPostNotesDispositionAction();
	}

	@Given("the user navigates to the Get Next Lead details page after taking action on the RequestingInformation disposition")
	public void the_user_navigates_to_the_get_next_lead_details_page_after_taking_action_on_the_requesting_information_disposition() {
	    lp.navigateToNextLeadAfterRequestingInformationDispositionAction();
	}
	@Given("the user navigates to the Get Next Lead details page after taking action on the {string} disposition")
	public void user_takes_disposition(String disposition) {
	    lp.navigateToNextLeadAfterDisposition(disposition);
	}

	@Given("the user navigates to the Get Next Lead details page after taking action on the Quarantine This Lead disposition")
	public void the_user_navigates_to_the_get_next_lead_details_page_after_taking_action_on_the_quarantine_this_lead_disposition() {
		lp.navigateToNextLeadAfterQuarantineThisLeadDispositionAction();
	}

	@Given("the user navigates to the Get Next Lead details page after taking action on the CallBack disposition")
	public void the_user_navigates_to_the_get_next_lead_details_page_after_taking_action_on_the_call_back_disposition() {
		lp.navigateToNextLeadAfterCallBackDispositionAction();
	}

	@Given("the user navigates to the Get Next Lead details page after taking action on the Do Not Call disposition")
	public void the_user_navigates_to_the_get_next_lead_details_page_after_taking_action_on_the_do_not_call_disposition() {
		lp.navigateToNextLeadAfterDoNotCallDispositionAction();
	}


}
