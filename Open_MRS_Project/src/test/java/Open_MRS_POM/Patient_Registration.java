package Open_MRS_POM;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Patient_Registration {

	WebDriver driver;
	Actions act;
	WebDriverWait wait;

	public Patient_Registration(WebDriver driver) {
		this.driver = driver;
	}

	// Defining Repository for Patient_Registration

	@FindBy(xpath = "//*[contains(@class,'icon-user')]//parent::a")
	WebElement Click_Register_a_Patient;
	@FindBy(xpath = "//*[text()='Name']//parent::li")
	WebElement Click_Name;
	@FindBy(name = "givenName")
	WebElement Enter_Given;
	@FindBy(name = "middleName")
	WebElement Enter_MiddleName;
	@FindBy(name = "familyName")
	WebElement Enter_FamilyName;
	@FindBy(xpath = "//*[contains(text(),'Gender')]")
	WebElement Click_Gender;
	@FindBy(id = "gender-field")
	WebElement Listbox_Gender;
	@FindBy(xpath = "//*[text()='Male']")
	WebElement Click_Male;
	@FindBy(xpath = "//*[text()='Female']")
	WebElement Click_Female;
	@FindBy(xpath = "//*[contains(text(),'Birthdate')]")
	WebElement Click_Birthdate;
	@FindBy(xpath = "//*[contains(@id,'birthdateDay-field')]")
	WebElement Input_Day;
	@FindBy(xpath = "//*[contains(@id,'birthdateMonth-field')]")
	WebElement Select_Month;
	@FindBy(xpath = "//*[contains(@id,'birthdateYear-field')]")
	WebElement Select_Year;
	@FindBy(xpath = "//*[contains(@id,'birthdateYears-field')]")
	WebElement Input_EstimatedYears;
	@FindBy(xpath = "//*[contains(@id,'birthdateMonths-field')]")
	WebElement Input_EstimatedMonths;
	@FindBy(xpath = "//*[contains(text(),'Address')]")
	WebElement Click_Address;
	@FindBy(xpath = "//*[contains(@id,'address1')]")
	WebElement Input_Address1;
	@FindBy(xpath = "//*[contains(@id,'address2')]")
	WebElement Input_Address2;
	@FindBy(xpath = "//*[contains(@id,'cityVillage')]")
	WebElement Input_City_Village;
	@FindBy(xpath = "//*[contains(@id,'stateProvince')]")
	WebElement Input_State_Province;
	@FindBy(xpath = "//*[contains(@id,'country')]")
	WebElement Input_Country;
	@FindBy(xpath = "//*[contains(@id,'postalCode')]")
	WebElement Input_PostalCode;
	@FindBy(xpath = "//*[contains(text(),'Phone Number')]")
	WebElement Click_PhoneNumber;
	@FindBy(name = "phoneNumber")
	WebElement Enter_PhoneNumber;
	@FindBy(xpath = "//*[contains(text(),'Relatives')]")
	WebElement Click_Relatives;
	@FindBy(xpath = "//*[contains(@id,'relationship_type')]")
	WebElement Select_RelationshipType;
	@FindBy(xpath = "//*[contains(@class,'person-typeahead ')]")
	WebElement Enter_PersonName;
	@FindBy(xpath = "//*[text()='Confirm']")
	WebElement Click_Confirm;
	@FindBy(xpath = "//*[contains(@id,'cancelSubmission')]")
	WebElement Click_Cancel;
	@FindBy(xpath = "//*[contains(@id,'submit')]")
	WebElement Click_Submit;

	// Develop Method

	public void Register_Patient(String F_Name, String M_Name, String Family_Name, int Gender, String Day, int Month,
			String Year, String Address1, String Address2, String City, String State, String Country, String P_Code,
			String Ph_Number, int Rel_Type, String Person_Name) throws Exception {
		act = new Actions(driver);
		act.moveToElement(Click_Register_a_Patient).click().perform();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		act.moveToElement(Enter_Given).sendKeys(F_Name).perform();
		// this.Enter_Given.sendKeys(F_Name);
		// act.moveToElement(Enter_MiddleName).sendKeys(M_Name).perform();
		this.Enter_MiddleName.sendKeys(M_Name);
		// act.moveToElement(Enter_FamilyName).sendKeys(Family_Name).perform();
		this.Enter_FamilyName.sendKeys(Family_Name);
		// act.moveToElement(Click_Gender).click().perform();
		this.Click_Gender.click();
		Select listbox = new Select(Listbox_Gender);
		listbox.selectByIndex(Gender);

		// new Select(Click_Gender).selectByIndex(Gender);
		this.Click_Birthdate.click();
		this.Input_Day.sendKeys(Day);
		new Select(Select_Month).selectByIndex(Month);
		this.Select_Year.sendKeys(Year);
		this.Click_Address.click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		this.Input_Address1.sendKeys(Address1);
		this.Input_Address2.sendKeys(Address2);
		this.Input_City_Village.sendKeys(City);
		this.Input_State_Province.sendKeys(State);
		this.Input_Country.sendKeys(Country);
		this.Input_PostalCode.sendKeys(P_Code);
		this.Click_PhoneNumber.click();
		this.Enter_PhoneNumber.sendKeys(Ph_Number);
		this.Click_Relatives.click();
		new Select(Select_RelationshipType).selectByIndex(Rel_Type);
		this.Enter_PersonName.sendKeys(Person_Name);
		this.Click_Confirm.click();
		act.moveToElement(Click_Submit).click().perform();
		

	}

}
