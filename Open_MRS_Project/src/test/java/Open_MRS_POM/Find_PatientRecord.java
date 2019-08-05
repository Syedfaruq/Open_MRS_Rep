package Open_MRS_POM;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class Find_PatientRecord {
	WebDriver driver;
	Actions act;

	public Find_PatientRecord(WebDriver driver) {
		this.driver = driver;
	}

	// Defining Repository for Login

	@FindBy(xpath = "//*[@id=\"coreapps-activeVisitsHomepageLink-coreapps-activeVisitsHomepageLink-extension\"]")
	WebElement Click_FindPatientRecord;
	@FindBy(xpath = "//*[@id='patient-search']")
	WebElement Enter_PatientIdorName;
	@FindBy(xpath = "//*[contains(@class,'odd')]")
	WebElement Click_PatientId;

	// Develop Method

	public void Verify_PatientRecord(String PatientIdName) throws Throwable {

		act = new Actions(driver);
		act.moveToElement(Click_FindPatientRecord).click().perform();
		Thread.sleep(4000);
		this.Enter_PatientIdorName.sendKeys(PatientIdName);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		this.Click_PatientId.click();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);

	}

}
