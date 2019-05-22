package allTests;

import java.lang.reflect.Method;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;


public abstract class BaseTest extends FrameworkUtility {

	@BeforeSuite
	public void initilizeDriver() throws NoSuchFieldException {
		URL = readConfigurationFile("URL");
		if(URL.trim().length() > 0){
			String browserName = readConfigurationFile("BrowserName");
				if (browserName.trim().equalsIgnoreCase("firefox")) {
					System.setProperty(FrameworkConstants.FIREFOX_DRIVER_KEY,FrameworkConstants.FIREFOX_DRIVER_PATH);
					driver = new FirefoxDriver();
					driver.manage().window().maximize();
					initObjects();
				}else if (browserName.trim().equalsIgnoreCase("chrome")) {
					System.setProperty(FrameworkConstants.CHROME_DRIVER_KEY,FrameworkConstants.CHROME_DRIVER_PATH);
					driver = new ChromeDriver();
					driver.manage().window().maximize();
					initObjects();
				}else {
					System.out.println("Invalid BrowserName");
					throw new IllegalStateException("Failed to invoke WebBrowser.Invalid BrowserName..");
				}
			}
		driver.get(URL);
		}

	/*****************************************************************************************************************/
	@AfterSuite
	public void quitDrivers() {
		driver.quit();

	}
	/************************************************************************************************************************/
	/*
	 * method.getName() returns the name of the current test method during run time.
	 * */
	@BeforeMethod
	public void beforeMethod(Method method) {
		

	}
	
	/****************************************************************************************************************/
	
	@AfterMethod
	public void afterMethod(Method method) {
		

	}

	/****************************************************************************************************************/
	
	@BeforeClass
	public void beforeClass() {
		
	}

	
/****************************************************************************************************************/	
	@AfterClass
	public void closeApplication(){
		

	}
/****************************************************************************************************************/	
	/*Initialize objects of JS, jsActions, Actions and WindowActions classes*/
	public void initObjects() {
		js = (JavascriptExecutor) driver;
		jsActions = new JavaScriptActions();
		action = new Actions(driver);
		Wait = new CustomWait();
		WindowHandler = new WindowActions();
		AlertHandler = new AlertActions();
		KeyboardHandler = new KeyboardActions();
	}
}
/*****************************************************************************************************************/