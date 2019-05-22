package allTests;

import org.testng.annotations.Test;
import utility.BaseTest;
import utility.FrameworkConstants;

import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;

public class DynamicContent extends BaseTest{
	
	@Test
	public void test() throws InterruptedException {
		System.setProperty(FrameworkConstants.CHROME_DRIVER_KEY,FrameworkConstants.CHROME_DRIVER_PATH);
		WebDriver driver = new ChromeDriver();		
		driver.findElement(By.xpath("//a[contains(text(),'Dynamic Loading')]")).click();
		hiddenElementCheck(driver);
		renderedElementCheck(driver);	
		driver.quit();
	}
	
	private void hiddenElementCheck(WebDriver driver) {
		driver.findElement(By.partialLinkText("Example 1")).click();
		driver.findElement(By.xpath("//button[contains(text(),'Start')]")).click();
		waitForloadingToComplete(driver);
		System.out.println(driver.findElement(By.cssSelector("div#finish>h4")).getText());		
	}
	
	private void renderedElementCheck(WebDriver driver) {
		driver.findElement(By.partialLinkText("Example 2")).click();
		driver.findElement(By.xpath("//button[contains(text(),'Start')]")).click();
		waitForloadingToComplete(driver);
		System.out.println(driver.findElement(By.cssSelector("div#finish>h4")).getText());		
	}

	private void waitForloadingToComplete(WebDriver driver) {
		System.out.println("Loading check");
		FluentWait<WebDriver> fw = new FluentWait<WebDriver>(driver)
									.withTimeout(Duration.ofSeconds(30))
									.pollingEvery(Duration.ofMillis(500))
									.ignoring(Exception.class);
		
		Function<WebDriver, Boolean> func = new Function<WebDriver, Boolean>() {
			public Boolean apply(WebDriver driver) {
				WebElement loadingIcon = driver.findElement(By.cssSelector("div#loading"));
				String displayValue = loadingIcon.getCssValue("display");
				if(displayValue.equals("none")) {
					return true;
				}
				return false;
			}
		};
		
		fw.until(func);		
	}
}

