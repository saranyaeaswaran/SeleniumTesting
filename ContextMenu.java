//This program works in in firefox browser so change the browser name in the configuration file before triggering this
package allTests;

import java.io.IOException;
import org.apache.http.client.ClientProtocolException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utility.BaseTest;
import utility.FrameworkConstants;

public class ContextMenu extends BaseTest{
	
	@Test
	public void test() throws InterruptedException, ClientProtocolException, IOException {	
		System.setProperty(FrameworkConstants.CHROME_DRIVER_KEY,FrameworkConstants.CHROME_DRIVER_PATH);
		WebDriver driver = new ChromeDriver();		
		driver.findElement(By.xpath("//a[contains(text(),'Drag and Drop')]")).click();
		WebElement contextBox = driver.findElement(By.cssSelector("div[contextmenu='menu']"));
		Actions actions = new Actions(driver);
		actions.moveToElement(contextBox);
		actions.contextClick(contextBox).build().perform();
		Thread.sleep(2000);
		WebElement menuItem = driver.findElement(By.cssSelector("menuitem[label='the-internet']"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", menuItem);
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
	}
}
