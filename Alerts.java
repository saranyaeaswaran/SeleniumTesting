package allTests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.FrameworkConstants;

public class Alerts {
	
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty(FrameworkConstants.CHROME_DRIVER_KEY,FrameworkConstants.CHROME_DRIVER_PATH);
		WebDriver driver = new ChromeDriver();		
		driver.get("http://the-internet.herokuapp.com/");
		driver.findElement(By.xpath("//a[contains(text(),'JavaScript Alerts')]")).click();
		//JS Alert
		driver.findElement(By.xpath("//button[contains(text(),'Click for JS Alert')]")).click();
		waitForAlertToPresent(driver);
		acceptAlert(driver);
		
		//JS Confirm
		driver.findElement(By.xpath("//button[contains(text(),'Click for JS Confirm')]")).click();
		waitForAlertToPresent(driver);
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
		
		//JS Prompt -- when sendKeys to the alert its not visible but gets recorded, refer this -  https://bugs.chromium.org/p/chromedriver/issues/detail?id=1120
		driver.findElement(By.xpath("//button[contains(text(),'Click for JS Prompt')]")).click();
		waitForAlertToPresent(driver);
		alert = driver.switchTo().alert();
		alert.sendKeys("hello");
		alert.accept();
		System.out.println(driver.findElement(By.xpath("//p[@id='result']")).getText());
		
		Thread.sleep(3000);
		driver.quit();
	}
	
	
	public static void waitForAlertToPresent(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 2);
		wait.until(ExpectedConditions.alertIsPresent());		
	}
	
	public static void acceptAlert(WebDriver driver) {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}
	
	
}