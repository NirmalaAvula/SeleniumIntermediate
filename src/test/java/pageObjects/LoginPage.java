package pageObjects;

import static org.junit.Assert.assertTrue;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
//import Stepdefination.Steps;

import com.github.javafaker.Faker;

public class LoginPage {  // need to import the Steps package because if the class is same package no need to import , if it is different need to import
	public  WebDriver ldriver;
	public Actions action;
	public WebDriver driver;
    public  String firstName;
    public  String lastName;
    public  int apptdate;
    public  int appttime;
    
    public LoginPage(WebDriver rdriver) {
        this.ldriver = rdriver;
        this.driver = rdriver;
        PageFactory.initElements(rdriver, this);
        
        // Initialize Actions
        this.action = new Actions(rdriver);
    }

	@FindBy(id = "userName")
	@CacheLookup
	WebElement username;

	@FindBy(name = "password")
	@CacheLookup
	WebElement pasword;

	@FindBy(id = "submit1")
	@CacheLookup
	WebElement submit;

	public void EnterUsername(String uname) {  //method overloading
		username.clear();
		username.sendKeys(uname);
	}
	public void EnterUsername(String uname, boolean clearField) {  //method overloading
	    if (clearField) {
	        username.clear();
	    }
	    username.sendKeys(uname);
	}	

	public void Enterpassword(String paswd) {
		pasword.clear();
		pasword.sendKeys(paswd);
	}

	public void clicksubmit() {
		submit.click();

	}
	private static final HashMap<String, String> disposition_buttons= new HashMap<>();

	static {
		disposition_buttons.put("Answering Machine", "Answering Machine");
		disposition_buttons.put("Busy", "Busy");
		disposition_buttons.put("Left Message", "Left Message");
		disposition_buttons.put("No Answer", "No Answer");
		disposition_buttons.put("Wrong Number", "Wrong Number");
		disposition_buttons.put("Delete/Duplicate", "Delete/Duplicate");
		disposition_buttons.put("Next Lead", "Next Lead");
	    
	}

	public void verifyUserIsNavigatedToHomepage() {
		WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(20), Duration.ofMillis(500));
		WebElement selectedStore = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='lblSelectedStoreName']")));
		assertTrue("Store is visible on the homepage!", selectedStore.isDisplayed());
		System.out.println("Login successful");
	}

	public void navigateToHomepage() {
		WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(20), Duration.ofMillis(500));
		WebElement selectedStore = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='lblSelectedStoreName']")));
		assertTrue("Store is visible on the homepage!", selectedStore.isDisplayed());
		System.out.println("Login successful out");
	}

	public void navigateToAcceptInboundCallPage() {
		System.out.println("Navigate to AcceptInbound Call");
		WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(20), Duration.ofMillis(500));
		WebElement dropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("radcmbMenuOptions")));
		wait.until(ExpectedConditions.elementToBeClickable(dropdown));
		dropdown.click();
		WebElement option = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"//option[@value='/WebForms/AddLeadInbound.aspx' and contains(text(), 'Accept Inbound Call')]")));
		option.click();

	}

	public void fillLeadFormWithRandomData() throws InterruptedException {
		Faker faker = new Faker();
		firstName = faker.name().firstName();
		lastName = faker.name().lastName();
		String address = "UnionNorhwindc" + faker.number().numberBetween(1, 99);

		WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(20));
		WebElement firstname = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("FirstName")));
		firstname.sendKeys(firstName);
		WebElement lastname=ldriver.findElement(By.name("LastName"));
		lastname.sendKeys(lastName);
		WebElement phone1 = ldriver.findElement(By.name("Phone"));
		phone1.sendKeys("(970) 593-2050");
		WebElement phonetypedropdown = ldriver.findElement(By.name("PhoneType"));
		Select select = new Select(phonetypedropdown);
		select.selectByVisibleText("Home");
		ldriver.findElement(By.name("Address")).sendKeys(address);
		ldriver.findElement(By.name("Zip")).sendKeys("80223");
		WebElement DNCOverride = ldriver.findElement(By.name("OverrideDNC"));
		Select select1 = new Select(DNCOverride);
		select1.selectByVisibleText("Yes");
		WebElement SelectedSourcedropdown = ldriver.findElement(By.name("SourceID"));
		Select select2 = new Select(SelectedSourcedropdown);
		ArrayList<WebElement> Sourceoptions =new ArrayList<>(select2.getOptions());
		//List<WebElement> Sourceoptions = select2.getOptions();
		int randomIndex = new Random().nextInt(3);//1, Sourceoptions.size());
		if (randomIndex == 0 && Sourceoptions.size() > 1) {
			randomIndex = 1;
		}
		select2.selectByIndex(randomIndex);
		System.out.println("Selected Source: " + Sourceoptions.get(randomIndex).getText());

		System.out.println("Filling form with:");
		System.out.println("Name: " + firstName + " " + lastName);
		System.out.println("Phone: " + phone1);
		System.out.println("Address: " + address);

		WebElement sourceBreakdownElement = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.name("SourceBreakdownID")));
		if (sourceBreakdownElement.isDisplayed()) {
			Select sourceBreakdownSelect = new Select(sourceBreakdownElement);
			List<WebElement> sourceBreakdownOptions = sourceBreakdownSelect.getOptions();
			int randomIndex1 = new Random().nextInt(1, sourceBreakdownOptions.size());

			if (randomIndex1 == 0 && sourceBreakdownOptions.size() > 1) {
				randomIndex1 = 1;
			}
			sourceBreakdownSelect.selectByIndex(randomIndex1);
			System.out.println("Selected SourceBreakdown: " + sourceBreakdownOptions.get(randomIndex1).getText());
		}
		/*WebElement AgentElement = ldriver.findElement(By.name("AgentID"));
		Select AgentElementOption = new Select(AgentElement);
		List<WebElement> agentsoptions = AgentElementOption.getOptions();
		int randomIndex2 = new Random().nextInt(agentsoptions.size());*/

	}

	public void clickSellAppointmentButton() {
		WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(20), Duration.ofMillis(500));
		WebElement sellAppointmentButton = wait
				.until(ExpectedConditions.elementToBeClickable(By.name("ContinueButton")));
		Assert.assertTrue("Sell The Appointment button should be enabled before clicking",
				sellAppointmentButton.isEnabled());
		sellAppointmentButton.click();
		System.out.println("Clicked on 'Sell The Appointment' button successfully.");
	}

	public void verifyFormSubmittedSuccessfully() {
		WebElement text = ldriver.findElement(By.className("greenHeader"));
		text.isDisplayed();

	}

	public void fillAppointmentForm() {
		WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(20));
		wait.pollingEvery(Duration.ofMillis(500));
		WebElement Windowsfieldtext = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@name='WindowsProblems']")));
		Windowsfieldtext.sendKeys("Rhymes with guy-you\n"
				+ "damaged frames; seal failure; warping; looking to upgrade\n" + "hail damage ");
		WebElement noofwindows = wait.until(ExpectedConditions.elementToBeClickable(By.name("Windows")));
		noofwindows.sendKeys("12");

		WebElement noofpatiodoors = wait.until(ExpectedConditions.elementToBeClickable(By.name("Doors")));
		noofpatiodoors.sendKeys("13");

		WebElement noofentrydoors = wait.until(ExpectedConditions.elementToBeClickable(By.name("EntryDoors")));
		noofentrydoors.sendKeys("14");

		WebElement windowsage = wait.until(ExpectedConditions.elementToBeClickable(By.name("WindowsAge")));
		windowsage.sendKeys("15");

		WebElement TypeOfDwellingdropdown = wait
				.until(ExpectedConditions.elementToBeClickable(By.name("TypeOfDwelling")));
		Select select = new Select(TypeOfDwellingdropdown);
		select.selectByVisibleText("House");
		
		WebElement HOAdropdown=wait
				.until(ExpectedConditions.elementToBeClickable(By.name("ManagedByHOA")));
		Select select1 =new Select(HOAdropdown);
		select1.selectByVisibleText("No");

		WebElement appointmentdate = wait.until(ExpectedConditions.elementToBeClickable(By.name("AppointmentDate")));
		Select apptdate = new Select(appointmentdate);
		apptdate.selectByVisibleText("Thursday, January 1, 2026");

		WebElement appointmenttime = wait.until(ExpectedConditions.elementToBeClickable(By.name("AppointmentTime")));
		Select appttime = new Select(appointmenttime);
		WebDriverWait waitForOption = new WebDriverWait(driver, Duration.ofSeconds(10));
		waitForOption.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//option[text()='10:00 AM']")));
        appttime.selectByVisibleText("10:00 AM");

		WebElement EnteringPhoneNumber = wait.until(ExpectedConditions.elementToBeClickable(By.name("DaytimePhone")));
		EnteringPhoneNumber.sendKeys("(970) 593-1055");

		WebElement DaytimePhoneType = wait.until(ExpectedConditions.elementToBeClickable(By.name("DaytimePhoneType")));
		Select phonetype = new Select(DaytimePhoneType);
		phonetype.selectByVisibleText("Work");
		
		WebElement email=wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("Email")));
		email.sendKeys("avula01@co.com");
		
		WebElement preapprovedoneparty=wait.until(ExpectedConditions.elementToBeClickable(By.name("PreApprovedOneParty")));
		Select preapprovedonepartyoption=new Select(preapprovedoneparty);
		preapprovedonepartyoption.selectByVisibleText("Yes");
		
		WebElement AppointmentType=wait.until(ExpectedConditions.elementToBeClickable(By.name("AppointmentType")));
		Select AppointmentTypeoption=new Select(AppointmentType);
		AppointmentTypeoption.selectByVisibleText("In Home");

	}
	
	public void  clickSetAppointmentButton() {
		WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(30), Duration.ofMillis(500));
		WebElement setAppointmentButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("SetButton")));
		setAppointmentButton.click();
		}
	public void navigateToAppointmentCalendarPage() {
		WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(40), Duration.ofMillis(500));
		WebElement dropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("radcmbMenuOptions")));
		wait.until(ExpectedConditions.elementToBeClickable(dropdown));
		dropdown.click();
		WebElement option = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
			    "//option[contains(text(), 'Appointment Calendar') and contains(@value, 'AppointmentCalendar.aspx')]")));
			option.click();

	}
	public void findScheduledAppointmentForCreatedLead() { 
		 WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(40), Duration.ofMillis(500));
		 String xpath = "//tr[td/a[contains(text(),'" + firstName + "')]]/following-sibling::tr[3]";

		    WebElement unconfirmedLink = wait.until(
		            ExpectedConditions.elementToBeClickable(By.xpath(xpath))
		    );

		    unconfirmedLink.click();
         /*WebElement unconfirmedLink = wait.until(
		        ExpectedConditions.elementToBeClickable(By.xpath("//tr/td/a[contains(text(),'Elenora')]//parent::td//parent::tr//following-sibling::tr[3]")));
		    unconfirmedLink.click();
		    */
	}
	public void clickConfirmButtonOnLeadDetailsPage() {
		WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(10));
		WebElement confirmbutton=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("confirmButton")));
		confirmbutton.click();
	}
	
	public void navigateToNextLeadAfterDisposition(String disposition) {
	    WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(20));
	    WebElement menuButton = wait.until(ExpectedConditions.visibilityOfElementLocated(
	            By.xpath("//select[@id='radcmbMenuOptions' or @id='menuoptions']")));
	    menuButton.click();
	    WebElement getNextLead = wait.until(
	            ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Get Next Lead']")));
	    getNextLead.click();
	    String buttonValue = disposition_buttons.get(disposition);
	    if (buttonValue == null) {
	        throw new IllegalArgumentException("Invalid disposition: " + disposition);
	    }
	    WebElement dispositionButton = wait.until(
	            ExpectedConditions.elementToBeClickable(
	                    By.xpath("//button[@value='" + buttonValue + "']")));
	    action.moveToElement(dispositionButton).click().perform();
	    String Leadname=ldriver.getTitle();
	    System.out.println(disposition + " disposition selected" + Leadname);
	}

/*public void navigateToNextLeadAfterDispositionActions() {
WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(10));
wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//select[@id='radcmbMenuOptions' or @id='menuoptions']")));
WebElement menuButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@id='radcmbMenuOptions' or @id='menuoptions']")));
menuButton.click();
WebElement GetNextLead = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Get Next Lead']")));
GetNextLead.click();
WebElement answeringbutton=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@value='Answering Machine']")));
action.moveToElement(answeringbutton).click().perform();
String Leadname=ldriver.getTitle();
System.out.println("Answering Machine button was clicked " + Leadname);
}
	
public void navigateToNextLeadAfterbusyDispositionAction() {
	WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(10));
	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//select[@id='radcmbMenuOptions' or @id='menuoptions']")));
	WebElement menuButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@id='radcmbMenuOptions' or @id='menuoptions']")));
	menuButton.click();
	WebElement GetNextLead = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Get Next Lead']")));
	GetNextLead.click();
	WebElement BusyButton=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@value='Busy']")));
	action.moveToElement(BusyButton).click().perform();
	String Leadname2=ldriver.getTitle();
	System.out.println("Busy button was clicked "+ Leadname2);
}

public void navigateToNextLeadAfterLeftMessageDispositionAction() {
	WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(10));
	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//select[@id='radcmbMenuOptions' or @id='menuoptions']")));
	WebElement menuButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@id='radcmbMenuOptions' or @id='menuoptions']")));
	menuButton.click();
	WebElement GetNextLead = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Get Next Lead']")));
	GetNextLead.click();
	WebElement LeftMessagebutton=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@value='Left Message']")));
	action.moveToElement(LeftMessagebutton).click().perform();
	String Leadname3=ldriver.getTitle();
	System.out.println("Left Message button was clicked "+ Leadname3);
	
}

public void navigateToNextLeadAfterNoAnswerDispositionAction() {
	WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(10));
	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//select[@id='radcmbMenuOptions' or @id='menuoptions']")));
	WebElement menuButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@id='radcmbMenuOptions' or @id='menuoptions']")));
	menuButton.click();
	WebElement GetNextLead = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Get Next Lead']")));
	GetNextLead.click();
	WebElement NoAnswerbutton=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@value='No Answer']")));
	action.moveToElement(NoAnswerbutton).click().perform();
	String Leadname4=ldriver.getTitle();
	System.out.println("No Answer button was clicked "+ Leadname4);

}

public void navigateToNextLeadAfterWrongNumberDispositionAction() {
	WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(10));
	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//select[@id='radcmbMenuOptions' or @id='menuoptions']")));
	WebElement menuButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@id='radcmbMenuOptions' or @id='menuoptions']")));
	menuButton.click();
	WebElement GetNextLead = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Get Next Lead']")));
	GetNextLead.click();
	WebElement WrongNumberbutton=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@value='Wrong Number']")));
	action.moveToElement(WrongNumberbutton).click().perform();
	String Leadname5=ldriver.getTitle();
	System.out.println("Wrong Number button button was clicked "+ Leadname5);
}

public void navigateToNextLeadAfterNextLeadDispositionAction() {
	WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(10));
	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//select[@id='radcmbMenuOptions' or @id='menuoptions']")));
	WebElement menuButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@id='radcmbMenuOptions' or @id='menuoptions']")));
	menuButton.click();
	WebElement GetNextLead = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Get Next Lead']")));
	GetNextLead.click();
	WebElement NextLeadbutton=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@value='Next Lead']")));
	action.moveToElement(NextLeadbutton).click().perform();
	String Leadname10=ldriver.getTitle();
	System.out.println("NextLead button was clicked "+ Leadname10);
}*/
	// Commented because all those implemented in above DISPOSITIONS
	
	public void navigateToNextLeadAfterDeleteDuplicateDispositionAction() {
		WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//select[@id='radcmbMenuOptions' or @id='menuoptions']")));
		WebElement menuButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@id='radcmbMenuOptions' or @id='menuoptions']")));
		menuButton.click();
		WebElement GetNextLead = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Get Next Lead']")));
		GetNextLead.click();
		WebElement DeleteDuplicatebutton=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@value='Delete/Duplicate']")));
		action.moveToElement(DeleteDuplicatebutton).click().perform();
		String Leadname6=ldriver.getTitle();
		System.out.println("Delete/Duplicate button button was clicked "+ Leadname6);
	}
public void navigateToNextLeadAfterNotInterestedDispositionAction() {
	WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(30));
	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//select[@id='radcmbMenuOptions' or @id='menuoptions']")));
	WebElement menuButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@id='radcmbMenuOptions' or @id='menuoptions']")));
	menuButton.click();
	WebElement GetNextLead = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Get Next Lead']")));
	GetNextLead.click();
	WebElement NotInterestedbutton=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@value='Not Interested']")));
	action.moveToElement(NotInterestedbutton).click().perform();
	wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("dialog-body")));
	ldriver.findElement(By.id("party-primary")).click();
	WebElement breakdown = wait.until(
		    ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='breakdown']")));
	breakdown.click();
	WebElement NotInterestedExplanation = wait.until(
		    ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@id='explanation']")));
	NotInterestedExplanation.sendKeys("Testing the Not Interested button functionality.");
	ldriver.findElement(By.xpath("//button[@id='updateButton']")).click();
	//ldriver.switchTo().defaultContent();
	//String Leadname7=ldriver.getTitle();
	System.out.println("Not Interested button was clicked "+ ldriver.getTitle());
}
public void navigateToNextLeadAfterPostNotesDispositionAction() {
	WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(30));
	//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//select[@id='radcmbMenuOptions' or @id='menuoptions']")));
	WebElement menuButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//select[@id='radcmbMenuOptions' or @id='menuoptions']")));
	menuButton.click();
	WebElement GetNextLead = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Get Next Lead']")));
	GetNextLead.click();
	WebElement PostNotesbutton=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@value='Note']")));
	action.moveToElement(PostNotesbutton).click().perform();
	wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("dialog-body")));
	WebElement postnotessubjectfield = wait.until(
		    ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='subject']")));
	postnotessubjectfield.sendKeys("PostNotes Subject");
	WebElement postnotesfield = wait.until(
		    ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@id='notes']")));
	postnotesfield.sendKeys("PostNotes");
	WebElement updatebutton = wait.until(ExpectedConditions.elementToBeClickable(By.id("updateButton")));
	updatebutton.click();
	String Leadname8=ldriver.getTitle();
	System.out.println("Post Notes button was clicked "+ Leadname8);
	}
public void navigateToNextLeadAfterRequestingInformationDispositionAction() {
	WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(70));
	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//select[@id='radcmbMenuOptions' or @id='menuoptions']")));
	WebElement menuButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//select[@id='radcmbMenuOptions' or @id='menuoptions']")));
	menuButton.click();
	WebElement GetNextLead = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Get Next Lead']")));
	GetNextLead.click();
	WebElement RequestedInformationbutton=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@value='Requested Information']")));
	action.moveToElement(RequestedInformationbutton).click().perform();
	wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("dialog-body")));
	WebElement Requestedinfo = wait.until(
		    ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='breakdown']")));
	Requestedinfo.click();
	WebElement updatebutton = wait.until(ExpectedConditions.elementToBeClickable(By.id("updateButton")));
	updatebutton.click();
	//ldriver.switchTo().defaultContent();
	String Leadname9=ldriver.getTitle();
	System.out.println("Requested Information button was clicked "+ Leadname9);
}

public void navigateToNextLeadAfterQuarantineThisLeadDispositionAction() {
	WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(70));
	WebElement menuButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//select[@id='radcmbMenuOptions' or @id='menuoptions']")));
	menuButton.click();
	WebElement GetNextLead = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Get Next Lead']")));
	GetNextLead.click();
	WebElement QuarantineThisLeadbutton=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@value='Quarantined']")));
	action.moveToElement(QuarantineThisLeadbutton).click().perform();
	wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("dialog-body")));
	WebElement Quarantineleadoption = wait.until(
		    ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='breakdown']")));
	Quarantineleadoption.click();
	WebElement Quarantinefield = wait.until(
		    ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@id='notes']")));
	Quarantinefield.sendKeys("Quarantinefieldtext");
	ldriver.findElement(By.id("updateButton")).click();
	ldriver.switchTo().defaultContent();
	String Leadname11=ldriver.getTitle();
	System.out.println("Post Notes button was clicked "+ Leadname11);	
}
public void navigateToNextLeadAfterCallBackDispositionAction() {
	WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(70));
	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//select[@id='radcmbMenuOptions' or @id='menuoptions']")));
	WebElement menuButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@id='radcmbMenuOptions' or @id='menuoptions']")));
	menuButton.click();
	WebElement GetNextLead = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Get Next Lead']")));
	GetNextLead.click();
	WebElement CallBackbutton=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@value='CallBack']")));
	action.moveToElement(CallBackbutton).click().perform();
	wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("dialog-body")));
	WebElement contactoption = wait.until(
		    ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='party-primary']")));
	contactoption.click();
	WebElement requestedcallbackoption = wait.until(
		    ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='callback-yes']")));
	requestedcallbackoption.click();
	ldriver.switchTo().defaultContent();

}
public void navigateToNextLeadAfterDoNotCallDispositionAction() {
	WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(30));
	//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//select[@id='radcmbMenuOptions' or @id='menuoptions']")));
	WebElement menuButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@id='radcmbMenuOptions' or @id='menuoptions']")));
	menuButton.click();
	WebElement GetNextLead = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Get Next Lead']")));
	GetNextLead.click();
	WebElement DoNotCallbutton=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@value='Do Not Call']")));
	action.moveToElement(DoNotCallbutton).click().perform();
	wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("dialog-body")));
	WebElement contactoption = wait.until(
		    ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='party-primary']")));
	contactoption.click();
	WebElement DoNotCallReasonbutton = wait.until(
		    ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='breakdown']")));
	DoNotCallReasonbutton.click();
	WebElement DoNotCallExplanation = wait.until(
		    ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@id='explanation']")));
	DoNotCallExplanation.sendKeys("DoNotCallExplanation");
	ldriver.findElement(By.id("updateButton")).click();
	try {
	    Robot robot = new Robot(); // Initialize Robot
	    robot.setAutoDelay(500);  // optional: adds small delay between actions

	    // Press Enter
	    robot.keyPress(KeyEvent.VK_ENTER);
	    robot.keyRelease(KeyEvent.VK_ENTER);

	} catch (AWTException e) {
	    e.printStackTrace();
	}
	String Leadname13=ldriver.getTitle();
	System.out.println("Post Notes button was clicked "+ Leadname13);	
	
}

}

	
