package allTests;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import utility.FrameworkConstants;


public class HeadlessDriverTest {
	public static void main(String[] args) {
//		usingHtmlUnitDriver();
//		usingChromeHeadless();
		usingFireFoxHeadless();
	}	

	
	public static void usingChromeHeadless() {
		
		System.setProperty(FrameworkConstants.CHROME_DRIVER_KEY,FrameworkConstants.CHROME_DRIVER_PATH);
		ChromeOptions options = new ChromeOptions();
		options.setHeadless(true);
		WebDriver driver = new ChromeDriver(options);		
		driver.get("https://www.google.co.in");
		System.out.println(driver.getCurrentUrl());
		driver.quit();
	}
	
	public static void usingFireFoxHeadless() {
		
		System.setProperty(FrameworkConstants.FIREFOX_DRIVER_KEY,FrameworkConstants.FIREFOX_DRIVER_PATH);
		FirefoxOptions options = new FirefoxOptions();
//		options.addArguments("--headless");
		options.setHeadless(true);
		WebDriver driver = new FirefoxDriver(options);		
		driver.get("https://www.google.co.in");
		System.out.println(driver.getCurrentUrl());
		driver.quit();
	}
	
}
