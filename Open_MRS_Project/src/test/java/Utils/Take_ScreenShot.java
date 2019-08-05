package Utils;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Take_ScreenShot {

	DateFormat df;
	String datef;
	Date d;

	// File src;
	public void takescreenshot(WebDriver driver, String sname) throws IOException {
		df = new SimpleDateFormat("dd_MM_YYYY hh_mm_ss");
		d = new Date();
		datef = df.format(d);
		String spath = "E:\\Selenium_Automation\\Open_MRS_Project\\Screenshots\\Failed" + datef + " " + sname + ".png";
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(src, new File(spath));
	}

}
