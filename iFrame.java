package allTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import resources.UITestPracticePage;
import utility.FrameworkConstants;


public class iFrame {
	public static void main(String[] args) {
		
		System.setProperty(FrameworkConstants.CHROME_DRIVER_KEY,FrameworkConstants.CHROME_DRIVER_PATH);
		WebDriver driver = new ChromeDriver();		
		driver.get("http://uitestpractice.com/Students/");
		System.out.println(driver.getCurrentUrl());
		
		UITestPracticePage
			.using(driver)
			.getFrameElement(driver)
			.enterIFrameText("checked iFrame");
		driver.quit();
		
	}	
}
