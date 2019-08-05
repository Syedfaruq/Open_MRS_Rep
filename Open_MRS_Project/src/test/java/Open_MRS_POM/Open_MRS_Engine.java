package Open_MRS_POM;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Object_ReUsable.TestNGException;
import Utils.ReadExcel;
import Utils.Take_ScreenShot;

public class Open_MRS_Engine {

	WebDriver driver;
	WebDriverWait wait;
	FileInputStream fi;
	FileOutputStream fo;
	XSSFWorkbook wb;
	XSSFSheet sh;
	XSSFRow r;

	ReadExcel reobj = new ReadExcel("Patient_Details");
	String inputpath = "E:\\Selenium_Automation\\Open_MRS_Project\\src\\test\\java\\Input\\OpenMRS_TestData.IP.xlsx";
	String outputpath = "E:\\Selenium_Automation\\Open_MRS_Project\\src\\test\\java\\Output\\OpenMRS_TestData.OP.xlsx";

	@Test(priority = 0)
	public void User_Login() throws Throwable {
		Login login = PageFactory.initElements(driver, Login.class);
		login.Verify_Login("Admin", "Admin123");

	}

	@Test(priority = 1, enabled = false)
	public void Verify_Patient_Reg() throws Exception {
		// Patient_Registration preg = PageFactory.initElements(driver,
		// Patient_Registration.class);

		// Calling TestNG Exception Method to handle Exception
		TestNGException teobj = new TestNGException();
		teobj.TestException();

		// calling screenshot method from the utils package
		Take_ScreenShot tsobj = new Take_ScreenShot();

		// Calling method from the page class
		Patient_Registration pareg = PageFactory.initElements(driver, Patient_Registration.class);

		pareg.Register_Patient("Steve", "A", "Richards", 0, "10", 6, "1998", "Sample Street", "Test Avenue",
				"Test City", "Sample State", "Sample Country", "531901", "7046609145", 4, "Mark Mero");

		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		// wait.until(ExpectedConditions.urlToBe("https://demo.openmrs.org/openmrs/coreapps/clinicianfacing/patient.page?patientId"));
		// Thread.sleep(5000);
		String Acval = "patientId=";
		String Expval = driver.getCurrentUrl();

		if (Acval.toLowerCase().contains(Expval.toLowerCase())) {
			System.out.println("Patient Registration Successful");
		} else {
			System.out.println("Patient Registration Failed");
			tsobj.takescreenshot(driver, "Patientreg");

		}

	}

	// Data Driven
	@Test(enabled = false)
	public void Verify_Patient_Registration() throws Exception {
		// Patient_Registration preg = PageFactory.initElements(driver,
		// Patient_Registration.class);
		fi = new FileInputStream(inputpath);
		wb = new XSSFWorkbook(fi);
		sh = wb.getSheet("Patient_Details");
		r = sh.getRow(0);

		// Calling method from the page class
		Patient_Registration pareg = PageFactory.initElements(driver, Patient_Registration.class);

		String F_Name = null, M_Name = null, Family_Name = null, Day = null, Year = null, Address1 = null,
				Address2 = null, City = null, State = null, Country = null, P_Code = null, Ph_Number = null,
				Person_Name = null;
		int Gender = 0, Month = 0, Rel_Type = 0;

		pareg.Register_Patient(F_Name, M_Name, Family_Name, Gender, Day, Month, Year, Address1, Address2, City, State,
				Country, P_Code, Ph_Number, Rel_Type, Person_Name);

		// count no of rows in sheet
		reobj.Getrowcount("Patient_Details");

		// get data from a cell
		reobj.Getcelldata("Patient_Details", 0, 16);

		/*
		 * pareg.Register_Patient("Steven", "A", "Robinson", 0, "10", 6, "2001",
		 * "Sample Street", "Test Avenue", "Test City", "Sample State",
		 * "Sample Country", "526901", "7056609145", 4, "Mark Henry");
		 */
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		// Thread.sleep(5000);
		String Expval = "patientId=";
		String Acval = driver.getCurrentUrl();

		if (Acval.toLowerCase().contains(Expval.toLowerCase())) {
			System.out.println("Patient Registration Successful");
		} else {
			System.out.println("Patient Registration Failed");
		}

		fi.close();
		fo = new FileOutputStream(outputpath);
		wb.write(fo);
		fo.close();
		wb.close();
	}

	@Test(enabled = false)
	public void Find_Patient_Record() throws Throwable {
		Find_PatientRecord Fpr = PageFactory.initElements(driver, Find_PatientRecord.class);
		Fpr.Verify_PatientRecord("100J6Y");

	}

	@Test(enabled = false)
	public void User_Logout() {
		Logout logout = PageFactory.initElements(driver, Logout.class);
		logout.Verify_Logout();
	}

	@BeforeTest

	public void Browser_Launch() throws Exception {
		System.setProperty("webdriver.chrome.driver", "E:\\\\Selenium_Automation\\\\Drivers\\\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://demo.openmrs.org/openmrs/login.htm");
		driver.manage().window().maximize();
		Thread.sleep(4000);

	}

	@AfterTest()

	public void Browser_Close() {
		driver.close();
	}

}
