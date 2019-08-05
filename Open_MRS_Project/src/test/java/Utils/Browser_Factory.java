package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Browser_Factory {

	static WebDriver driver;

	public static WebDriver Start_Browser(String Browser_Name, String url) {
		
		if (Browser_Name.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "E:\\Selenium_Automation\\Drivers\\geckodriver.exe");

			driver = new FirefoxDriver();

		}

		else if (Browser_Name.equalsIgnoreCase("chrome")) {

			System.setProperty("webdriver.chrome.driver", "E:\\Selenium_Automation\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}

		else if (Browser_Name.equalsIgnoreCase("IE")) {
			driver = new InternetExplorerDriver();
		}

		else if (Browser_Name.equalsIgnoreCase("safari")) {
			driver = new SafariDriver();
		}

		driver.manage().window().maximize();
		driver.get(url);
		return driver;
	}

}
