package allTests;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import utility.BaseTest;
import utility.FrameworkConstants;

public class BasicAuth extends BaseTest{
	
	@Test
	public void test() throws InterruptedException {
		System.setProperty(FrameworkConstants.CHROME_DRIVER_KEY,FrameworkConstants.CHROME_DRIVER_PATH);
		WebDriver driver = new ChromeDriver();		
		driver.get("http://admin:admin@the-internet.herokuapp.com/basic_auth/");				
	}
}
