package allTests;

import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import utility.FrameworkConstants;

public class ProgressBar {
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty(FrameworkConstants.CHROME_DRIVER_KEY,FrameworkConstants.CHROME_DRIVER_PATH);
		WebDriver driver = new ChromeDriver();		
		driver.get("http://uitestpractice.com/Students/");
		System.out.println(driver.getCurrentUrl());
		
		WebElement downloadButton= driver.findElement(By.xpath("//div[@class='container Tomato']//button"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true); window.scrollBy(0, -window.innerHeight / 4);", downloadButton);
		downloadButton.click();
		
	      FluentWait<WebDriver> fWait = new FluentWait<WebDriver>(driver)
					.withTimeout(Duration.ofSeconds(10))
					.pollingEvery(Duration.ofMillis(500))
					.ignoring(Exception.class);


			Function<WebDriver, Boolean> func = new Function<WebDriver, Boolean>() 
			{
			public Boolean apply( WebDriver driver) {
			WebElement element = driver.findElement(By.xpath("//div[starts-with(@class,'ui-dialog')]//div[@class='progress-label']"));
			System.out.println(element.getText());     
				if(element.getText().contains("Complete")){
					return true;
				}
					return false;
				}
			};

			fWait.until(func);
			
			Thread.sleep(2000);
			
			WebElement dialogClose = driver.findElement(By.xpath("//button[@class='ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only']//span[@class='ui-button-text'][contains(text(),'Close')]"));
			System.out.println(dialogClose.getText());
			dialogClose.click();		
	}
}