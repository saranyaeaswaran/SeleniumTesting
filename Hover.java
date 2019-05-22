package allTests;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import utility.FrameworkConstants;

public class Hover {
	
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty(FrameworkConstants.CHROME_DRIVER_KEY,FrameworkConstants.CHROME_DRIVER_PATH);
		WebDriver driver = new ChromeDriver();		
		driver.get("http://the-internet.herokuapp.com/");
		driver.findElement(By.xpath("//a[contains(text(),'Infinite Scroll')]")).click();
		List<WebElement> images = driver.findElements(By.cssSelector(".figure"));
		Actions action = new Actions(driver);
		for(WebElement image:images) {
			action.moveToElement(image).perform();
			System.out.println(image.findElement(By.cssSelector(".figcaption")).isDisplayed());
			
		}		
		Thread.sleep(3000);
		driver.quit();
	}
}