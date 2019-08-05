package Open_MRS_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class Logout {

	WebDriver driver;
	Actions act;

	public	Logout(WebDriver driver) {
		this.driver = driver;
	}

	// Defining Repository for Login

	@FindBy(xpath = "//*[contains(@class,'logout')]")
	WebElement Click_Logout;

	// Develop Method

	public void Verify_Logout() {
		this.Click_Logout.click();

	}
}
