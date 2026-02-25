package pageObjects;

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

import utilities.AssertionUtils;

public class LoginPage extends Baseclass implements Basepage {  // need to import the Steps package because if the class is same package no need to import , if it is different need to import
	//public  WebDriver ldriver;
	//public WebDriver driver;
	public Actions action;
    public  String firstName;
    public  String lastName;
    public  int apptdate;
    public  int appttime;
    
    WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        //this.driver = driver;
    	super(driver);
        PageFactory.initElements(driver, this); 
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        this.action = new Actions(driver);
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
	
	///verifyUserIsNavigatedToHomepage
	@FindBy(xpath = "//span[@id='lblSelectedStoreName']")
	WebElement selectedStoreLabel;
	
	@FindBy(id="radcmbMenuOptions")
	WebElement menudropdown;
	
	///AccepptInboundCall page
	@FindBy(xpath = "//option[@value='/WebForms/AddLeadInbound.aspx' and contains(text(), 'Accept Inbound Call')]")
	WebElement acceptInboundCallOption;

	
	///appointmentCalendarPage
	@FindBy(xpath = "//option[contains(text(),'Appointment Calendar')]")
     WebElement appointmentCalendarPage;
	
	///Selecting appointment calendar option in the menu dropdown
	 @FindBy(xpath = "//option[contains(text(), 'Appointment Calendar') and contains(@value, 'AppointmentCalendar.aspx')]")
	   WebElement appointmentCalendarOption;
	 
	 /// Filling the details in the AcceptIboundcall page
	 @FindBy(name = "FirstName")
	     WebElement firstNameField;

	    @FindBy(name = "LastName")
	     WebElement lastNameField;

	    @FindBy(name = "Phone")
	     WebElement phoneField;

	    @FindBy(name = "Address")
	     WebElement addressField;

	    @FindBy(name = "Zip")
	     WebElement zipField;

	    @FindBy(name = "SourceID")
	     WebElement sourceDropdown;

	    @FindBy(name = "ContinueButton")
	     WebElement sellAppointmentButton;

	    
	    @FindBy(name="PhoneType")
	    WebElement PhoneTypeField;
	    
	    @FindBy(name="OverrideDNC")
	    WebElement DNCOverridecheckbox;
	    
	    @FindBy(name="SourceBreakdownID")
	    WebElement sourceBreakdownElement;
	    
	    ///sell appointment continue button
	    @FindBy(name="ContinueButton")
	    WebElement SellAppointmentContinueButton;
	    
	    ///verifyFormSubmittedSuccessfully
	    
	    @FindBy(className="greenHeader")
	    WebElement text;
	    
	    ///Filling appointment form
	    @FindBy(xpath="//textarea[@name='WindowsProblems']")
	    WebElement Windowsfieldtext;
	    
	    
	    @FindBy(name = "Windows")
	     WebElement noOfWindows;

	    @FindBy(name = "Doors")
	     WebElement noOfPatioDoors;

	    @FindBy(name = "EntryDoors")
	     WebElement noOfEntryDoors;

	    @FindBy(name = "WindowsAge")
	     WebElement windowsAge;

	    @FindBy(name = "TypeOfDwelling")
	     WebElement typeOfDwellingDropdown;

	    @FindBy(name = "ManagedByHOA")
	     WebElement HOADropdown;

	    @FindBy(name = "AppointmentDate")
	     WebElement appointmentDateDropdown;

	    @FindBy(name = "AppointmentTime")
	     WebElement appointmentTimeDropdown;

	    @FindBy(name = "DaytimePhone")
	     WebElement daytimePhoneField;

	    @FindBy(name = "DaytimePhoneType")
	     WebElement daytimePhoneTypeDropdown;

	    @FindBy(name = "Email")
	     WebElement emailField;

	    @FindBy(name = "PreApprovedOneParty")
	     WebElement preApprovedOnePartyDropdown;

	    @FindBy(name = "AppointmentType")
	     WebElement appointmentTypeDropdown;
	    
	    //// clickSetAppointmentButton
	    @FindBy(id = "SetButton")
	     WebElement setAppointmentButton;
	    
	    ////Click on Confirm button
	    @FindBy(id = "confirmButton")
	     WebElement confirmbutton;
	    
	    //// Menu options
	    @FindBy(xpath="//select[@id='radcmbMenuOptions' or @id='menuoptions']")
		WebElement menuoptions;
	    
	    @FindBy(xpath="//*[text()='Get Next Lead']")
		WebElement GNLmenuoption;
	    
	    @FindBy(xpath="//button[@value='Delete/Duplicate']")
		WebElement DeleteDuplicatebutton;
	    
	    
	    @FindBy(xpath="//button[@value='Not Interested']")
		WebElement NotInterestedbutton;
	        

	    @FindBy(xpath="//button[@value='Note']")
		WebElement PostNotesbutton;
	    
	    
	    @FindBy(xpath="//button[@value='Requested Information']")
	 		WebElement RequestedInformationbutton;
	    
	    @FindBy(xpath="//button[@value='Quarantined']")
 		WebElement QuarantineThisLeadbutton;
	    	    
	    @FindBy(xpath="//button[@value='CallBack']")
 		WebElement CallBackbutton;
	  
	    @FindBy(xpath="/button[@value='Do Not Call']")
	 		WebElement DoNotCallbutton;
	
	    		
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
    @Override
	public void verifyUserIsNavigatedToHomepage() {
		AssertionUtils.assertElementVisible(driver,selectedStoreLabel,"Store is visible on the homepage!");
		System.out.println("Login successful");
	}
    @Override
	public void navigateToHomepage() {
		AssertionUtils.assertElementVisible(driver,selectedStoreLabel,"Store is visible on the homepage!");
		System.out.println("Login successful");
	}

	public void navigateToAcceptInboundCallPage() {
		System.out.println("Navigate to AcceptInbound Call");
		wait.until(ExpectedConditions.visibilityOf(menudropdown)).click();
	    wait.until(ExpectedConditions.elementToBeClickable(acceptInboundCallOption)).click();
	}

	public void fillLeadFormWithRandomData() throws InterruptedException {
		Faker faker = new Faker();
		firstName = faker.name().firstName();
		lastName = faker.name().lastName();
		String address = "UnionNorhwindc" + faker.number().numberBetween(1, 99);
		wait.until(ExpectedConditions.visibilityOf(firstNameField)).sendKeys(firstName);
		 lastNameField.sendKeys(lastName);
	     phoneField.sendKeys("(770) 593-2053");
	     addressField.sendKeys("UnionNorthwind" + new Random().nextInt(100));
	     zipField.sendKeys("80223");
		Select select = new Select(PhoneTypeField);
		select.selectByVisibleText("Home");
		Select select1 = new Select(DNCOverridecheckbox);
		select1.selectByVisibleText("Yes");
		Select select2 = new Select(sourceDropdown);
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
		System.out.println("Address: " + address);

		wait.until(ExpectedConditions.visibilityOf(sourceBreakdownElement));
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
     wait.until(ExpectedConditions.elementToBeClickable(SellAppointmentContinueButton));
		Assert.assertTrue("Sell The Appointment button should be enabled before clicking",SellAppointmentContinueButton.isEnabled());
		SellAppointmentContinueButton.click();
		System.out.println("Clicked on 'Sell The Appointment' button successfully.");
	}

	public void verifyFormSubmittedSuccessfully() {
		text.isDisplayed();

	}

	public void fillAppointmentForm() {
		//wait.pollingEvery(Duration.ofMillis(500));
		wait.until(ExpectedConditions.visibilityOf(Windowsfieldtext)).sendKeys("Rhymes with guy-you\n" + "damaged frames; seal failure; warping; looking to upgrade\n" + "hail damage ");
		wait.until(ExpectedConditions.elementToBeClickable(noOfWindows)).sendKeys("12");
        wait.until(ExpectedConditions.elementToBeClickable(noOfPatioDoors)).sendKeys("13");
        wait.until(ExpectedConditions.elementToBeClickable(noOfEntryDoors)).sendKeys("14");
        wait.until(ExpectedConditions.elementToBeClickable(windowsAge)).sendKeys("15");
        wait.until(ExpectedConditions.elementToBeClickable(typeOfDwellingDropdown));
		Select select = new Select(typeOfDwellingDropdown);
		select.selectByVisibleText("House");
	    wait.until(ExpectedConditions.elementToBeClickable(HOADropdown));
		Select select1 =new Select(HOADropdown);
		select1.selectByVisibleText("No");
        wait.until(ExpectedConditions.elementToBeClickable(appointmentDateDropdown));
		Select apptdate = new Select(appointmentDateDropdown);
		apptdate.selectByVisibleText("Thursday, February 19, 2026");
		wait.until(ExpectedConditions.elementToBeClickable(appointmentTimeDropdown));
		Select appttime = new Select(appointmentTimeDropdown);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//option[text()='10:00 AM']")));
        appttime.selectByVisibleText("10:00 AM");
		wait.until(ExpectedConditions.elementToBeClickable(daytimePhoneField));
		daytimePhoneField.sendKeys("(471) 593-0056");
		wait.until(ExpectedConditions.elementToBeClickable(daytimePhoneTypeDropdown));
		Select phonetype = new Select(daytimePhoneTypeDropdown);
		phonetype.selectByVisibleText("Work");
		wait.until(ExpectedConditions.visibilityOf(emailField)).sendKeys("avula01@co.com");
		wait.until(ExpectedConditions.elementToBeClickable(preApprovedOnePartyDropdown));
		Select preapprovedonepartyoption=new Select(preApprovedOnePartyDropdown);
		preapprovedonepartyoption.selectByVisibleText("Yes");
		wait.until(ExpectedConditions.elementToBeClickable(appointmentTypeDropdown));
		Select AppointmentTypeoption=new Select(appointmentTypeDropdown);
		AppointmentTypeoption.selectByVisibleText("In Home");
	}
	
	public void  clickSetAppointmentButton() {
		//WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(30), Duration.ofMillis(500));
		wait.until(ExpectedConditions.visibilityOf(setAppointmentButton)).click();
		}
	public void navigateToAppointmentCalendarPage() {
        wait.until(ExpectedConditions.visibilityOf(menudropdown)).click();
		wait.until(ExpectedConditions.elementToBeClickable(appointmentCalendarPage)).click();
		wait.until(ExpectedConditions.elementToBeClickable(appointmentCalendarOption));
	}
	public void findScheduledAppointmentForCreatedLead() { 
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40), Duration.ofMillis(500));
		 String xpath = "//tr[td/a[contains(text(),'" + firstName + "')]]/following-sibling::tr[3]";
		  wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath))).click();
	}
	public void clickConfirmButtonOnLeadDetailsPage() {
		wait.until(ExpectedConditions.visibilityOf(confirmbutton)).click();	
	}
	
	public void navigateToNextLeadAfterDisposition(String disposition) {
	    wait.until(ExpectedConditions.visibilityOf(menuoptions)).click();
	    wait.until(ExpectedConditions.elementToBeClickable(GNLmenuoption)).click();
	    String buttonValue = disposition_buttons.get(disposition);
	    if (buttonValue == null) {
	        throw new IllegalArgumentException("Invalid disposition: " + disposition);
	    }
	    WebElement dispositionButton = wait.until(
	            ExpectedConditions.elementToBeClickable(
	                    By.xpath("//button[@value='" + buttonValue + "']")));
	    action.moveToElement(dispositionButton).click().perform();
	    String Leadname=driver.getTitle();
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
		wait.until(ExpectedConditions.visibilityOf(menuoptions));
		wait.until(ExpectedConditions.elementToBeClickable(menuoptions)).click();
		wait.until(ExpectedConditions.elementToBeClickable(GNLmenuoption)).click();
		wait.until(ExpectedConditions.elementToBeClickable(DeleteDuplicatebutton));
		action.moveToElement(DeleteDuplicatebutton).click().perform();
		String Leadname6=driver.getTitle();
		System.out.println("Delete/Duplicate button button was clicked "+ Leadname6);
	}
public void navigateToNextLeadAfterNotInterestedDispositionAction() {
	wait.until(ExpectedConditions.visibilityOf(menuoptions));
	wait.until(ExpectedConditions.elementToBeClickable(menuoptions)).click();
	wait.until(ExpectedConditions.elementToBeClickable(GNLmenuoption)).click();
	wait.until(ExpectedConditions.elementToBeClickable(NotInterestedbutton));
	action.moveToElement(NotInterestedbutton).click().perform();
	wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("dialog-body")));
	driver.findElement(By.id("party-primary")).click();
	WebElement breakdown = wait.until(
		    ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='breakdown']")));
	breakdown.click();
	WebElement NotInterestedExplanation = wait.until(
		    ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@id='explanation']")));
	NotInterestedExplanation.sendKeys("Testing the Not Interested button functionality.");
	driver.findElement(By.xpath("//button[@id='updateButton']")).click();
	//ldriver.switchTo().defaultContent();
	//String Leadname7=ldriver.getTitle();
	System.out.println("Not Interested button was clicked "+ driver.getTitle());
}
public void navigateToNextLeadAfterPostNotesDispositionAction() {
	wait.until(ExpectedConditions.visibilityOf(menuoptions));
	wait.until(ExpectedConditions.elementToBeClickable(menuoptions)).click();
	wait.until(ExpectedConditions.elementToBeClickable(GNLmenuoption)).click();
	wait.until(ExpectedConditions.elementToBeClickable(PostNotesbutton));
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
	String Leadname8=driver.getTitle();
	System.out.println("Post Notes button was clicked "+ Leadname8);
	}
public void navigateToNextLeadAfterRequestingInformationDispositionAction() {
	wait.until(ExpectedConditions.visibilityOf(menuoptions));
	wait.until(ExpectedConditions.elementToBeClickable(menuoptions)).click();
	wait.until(ExpectedConditions.elementToBeClickable(GNLmenuoption)).click();
	wait.until(ExpectedConditions.elementToBeClickable(RequestedInformationbutton));
	action.moveToElement(RequestedInformationbutton).click().perform();
	wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("dialog-body")));
	WebElement Requestedinfo = wait.until(
		    ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='breakdown']")));
	Requestedinfo.click();
	WebElement updatebutton = wait.until(ExpectedConditions.elementToBeClickable(By.id("updateButton")));
	updatebutton.click();
	//ldriver.switchTo().defaultContent();
	String Leadname9=driver.getTitle();
	System.out.println("Requested Information button was clicked "+ Leadname9);
}

public void navigateToNextLeadAfterQuarantineThisLeadDispositionAction() {
	wait.until(ExpectedConditions.visibilityOf(menuoptions));
	wait.until(ExpectedConditions.elementToBeClickable(menuoptions)).click();
	wait.until(ExpectedConditions.elementToBeClickable(GNLmenuoption)).click();
	wait.until(ExpectedConditions.elementToBeClickable(QuarantineThisLeadbutton));
	action.moveToElement(QuarantineThisLeadbutton).click().perform();
	wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("dialog-body")));
	WebElement Quarantineleadoption = wait.until(
		    ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='breakdown']")));
	Quarantineleadoption.click();
	WebElement Quarantinefield = wait.until(
		    ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@id='notes']")));
	Quarantinefield.sendKeys("Quarantinefieldtext");
	driver.findElement(By.id("updateButton")).click();
	driver.switchTo().defaultContent();
	String Leadname11=driver.getTitle();
	System.out.println("Post Notes button was clicked "+ Leadname11);	
}
public void navigateToNextLeadAfterCallBackDispositionAction() {
	wait.until(ExpectedConditions.visibilityOf(menuoptions));
	wait.until(ExpectedConditions.elementToBeClickable(menuoptions)).click();
	wait.until(ExpectedConditions.elementToBeClickable(GNLmenuoption)).click();
	wait.until(ExpectedConditions.elementToBeClickable(CallBackbutton));
	action.moveToElement(CallBackbutton).click().perform();
	wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("dialog-body")));
	WebElement contactoption = wait.until(
		    ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='party-primary']")));
	contactoption.click();
	WebElement requestedcallbackoption = wait.until(
		    ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='callback-yes']")));
	requestedcallbackoption.click();
	driver.switchTo().defaultContent();

}
public void navigateToNextLeadAfterDoNotCallDispositionAction() {
	wait.until(ExpectedConditions.visibilityOf(menuoptions));
	wait.until(ExpectedConditions.elementToBeClickable(menuoptions)).click();
	wait.until(ExpectedConditions.elementToBeClickable(GNLmenuoption)).click();
	wait.until(ExpectedConditions.elementToBeClickable(DoNotCallbutton));
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
	driver.findElement(By.id("updateButton")).click();
	try {
	    Robot robot = new Robot(); 
	    robot.setAutoDelay(500);  // it is optional: here i have added small delay between actions, its not mandatory
	    // Press Enter
	    robot.keyPress(KeyEvent.VK_ENTER);
	    robot.keyRelease(KeyEvent.VK_ENTER);

	} catch (AWTException e) {
	    e.printStackTrace();
	}
	String Leadname13=driver.getTitle();
	System.out.println("Post Notes button was clicked "+ Leadname13);	
	
}

}

	
