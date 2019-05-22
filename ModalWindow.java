package allTests;

import org.testng.annotations.Test;
import utility.BaseTest;
import java.time.Duration;
import java.util.function.Function;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;

public class ModalWindow extends BaseTest{
	
	@Test
	public void test() throws InterruptedException {		
		driver.findElement(By.xpath("//a[contains(text(),'Entry Ad')]")).click();
		waitForModalWindow(driver);
		WebElement modalBody = driver.findElement(By.cssSelector("div.modal-body p"));
		System.out.println(modalBody.getText());
		driver.findElement(By.cssSelector("div.modal-footer p")).click();
		Thread.sleep(6000);
		
	}
	
	private void waitForModalWindow(WebDriver driver) {
		System.out.println("Loading check");
		FluentWait<WebDriver> fw = new FluentWait<WebDriver>(driver)
									.withTimeout(Duration.ofSeconds(30))
									.pollingEvery(Duration.ofMillis(500))
									.ignoring(Exception.class);
		
		Function<WebDriver, Boolean> func = new Function<WebDriver, Boolean>() {
			public Boolean apply(WebDriver driver) {
				WebElement loadingIcon = driver.findElement(By.cssSelector("div#modal"));
				String displayValue = loadingIcon.getCssValue("display");
				if(displayValue.equals("block")) {
					return true;
				}
				return false;
			}
		};
		
		fw.until(func);		
	}
}
