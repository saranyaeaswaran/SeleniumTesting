package allTests;


import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import utility.BaseTest;
import utility.FrameworkConstants;

public class BasicAuth {
	
	@Test
	public void test() throws InterruptedException {
		System.setProperty(FrameworkConstants.CHROME_DRIVER_KEY,FrameworkConstants.CHROME_DRIVER_PATH);
		WebDriver driver = new ChromeDriver();		
		driver.get("http://admin:admin@the-internet.herokuapp.com/basic_auth/");
		driver.get("http://the-internet.herokuapp.com/basic_auth");
		String pageMessage = driver.findElement(By.cssSelector("p")).getText();
		assertEquals(pageMessage, "Congratulations!");
	}
}
