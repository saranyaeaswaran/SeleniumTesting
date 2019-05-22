package allTests;

import java.time.Duration;
import java.util.List;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import resources.UITestPracticePage;
import utility.FrameworkConstants;


public class MouseOverMenu {
	public static void main(String[] args) {
		
		System.setProperty(FrameworkConstants.CHROME_DRIVER_KEY,FrameworkConstants.CHROME_DRIVER_PATH);
		WebDriver driver = new ChromeDriver();		
		driver.get("http://uitestpractice.com/Students/");
		System.out.println(driver.getCurrentUrl());
		List<WebElement> menuItems = (List<WebElement>) UITestPracticePage.using(driver).mouseOverMenu;
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true); window.scrollBy(0, -window.innerHeight / 4);", menuItems.get(0));
		
		for(WebElement menu:menuItems) {
			if(menu.getText().equalsIgnoreCase("Salzburg")) {
				Actions action = new Actions(driver);
				action.moveToElement(menu);
				
			      FluentWait<WebDriver> fWait = new FluentWait<WebDriver>(driver)
							.withTimeout(Duration.ofSeconds(100))
							.pollingEvery(Duration.ofMillis(200))
							.ignoring(Exception.class);


					Function<WebDriver, Boolean> func = new Function<WebDriver, Boolean>() 
					{
					public Boolean apply( WebDriver driver) {
					WebElement element = driver.findElement(By.xpath("//ul"));
					System.out.println(element.getCssValue("display"));         
						if(element.getCssValue("display").equalsIgnoreCase("block")){
							return true;
						}
							return false;
						}
					};

					fWait.until(func);
					menu.click();
					
					List<WebElement> subMenuItems = menu.findElement(By.tagName("ul")).findElements(By.tagName("li"));
					System.out.println("Sub menu items length : "+subMenuItems.size());
					for(WebElement subMenu:subMenuItems) {
						if(menu.getText().equalsIgnoreCase("Delphi")) {
							menu.click();
						}				
					}					
			}	
		
		driver.quit();
	}}}	


