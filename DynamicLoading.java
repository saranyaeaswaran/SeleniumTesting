package allTests;

import org.testng.annotations.Test;
import utility.BaseTest;
import utility.FrameworkConstants;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicLoading extends BaseTest{
	
	@Test
	public void test() throws InterruptedException {	
		System.setProperty(FrameworkConstants.CHROME_DRIVER_KEY,FrameworkConstants.CHROME_DRIVER_PATH);
		WebDriver driver = new ChromeDriver();		
		driver.findElement(By.xpath("//a[contains(text(),'Dynamic Content')]")).click();
		//To get direct descendants with 'row' class of div elements
		List<WebElement> dynamicContent = driver.findElements(By.cssSelector("div#content>div.row"));
		//To get the text from the 2nd row of dynamic content
		System.out.println(dynamicContent.get(1).findElement(By.cssSelector("div:nth-child(2)")).getText());		
		Thread.sleep(6000);
		driver.quit();
		
	}
}
