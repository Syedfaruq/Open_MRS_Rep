package Open_MRS_POM;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class Login {

	WebDriver driver;
	Actions act;

	public Login(WebDriver driver) {
		this.driver = driver;
	}

	// Defining Repository for Login

	@FindBy(name = "username")
	WebElement User_name;
	@FindBy(name = "password")
	WebElement Enter_Password;
	@FindBy(id = "Pharmacy")
	WebElement Location_pharmacy;
	@FindBy(id = "Inpatient Ward")
	WebElement Location_InpatientWard;
	@FindBy(id = "Isolation Ward")
	WebElement Location_IsolationWard;
	@FindBy(id = "Laboratory")
	WebElement Location_Laboratory;
	@FindBy(id = "Outpatient Clinic")
	WebElement Location_OutpatientClinic;
	@FindBy(id = "Registration Desk")
	WebElement Location_RegistrationDesk;

	@FindBy(id = "loginButton")
	WebElement Login_Button;

	// Develop Method

	public void Verify_Login(String UserName, String Pwd)  {
		act = new Actions(driver);

		try {
			act.moveToElement(User_name).click().perform();
			Thread.sleep(4000);
			this.User_name.sendKeys(UserName);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

			this.Enter_Password.sendKeys(Pwd);
			act.moveToElement(Enter_Password).click().perform();
			this.Location_InpatientWard.click();
			this.Login_Button.click();
			Thread.sleep(4000);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}

	}

}
