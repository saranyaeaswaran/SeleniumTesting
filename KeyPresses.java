package allTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import utility.FrameworkConstants;

public class KeyPresses {
	
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty(FrameworkConstants.CHROME_DRIVER_KEY,FrameworkConstants.CHROME_DRIVER_PATH);
		WebDriver driver = new ChromeDriver();		
		driver.get("http://the-internet.herokuapp.com/");
		driver.findElement(By.xpath("//a[contains(text(),'Key Presses')]")).click();
		Actions action = new Actions(driver);
		action.sendKeys("S").perform();;
		System.out.println(driver.findElement(By.cssSelector("p#result")).getText());
		
		Thread.sleep(3000);
		driver.quit();
	}
}