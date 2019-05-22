package allTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import utility.BaseTest;
import utility.FrameworkConstants;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class AddRemoveElements extends BaseTest{
	
	@Test
	public void test() throws InterruptedException {
		System.setProperty(FrameworkConstants.CHROME_DRIVER_KEY,FrameworkConstants.CHROME_DRIVER_PATH);
		WebDriver driver = new ChromeDriver();		
		WebElement pageLink = driver.findElement(By.xpath("//a[contains(text(),'Add/Remove Elements')]"));
		pageLink.click();
		validateAddElements(5, driver);
		validateRemoveElements(5, driver);
		
	}

	public void validateRemoveElements(int noOfClicks, WebDriver driver) throws InterruptedException {
		
		List<WebElement> removeElementBtns = driver.findElements(By.cssSelector("button.added-manually"));
		for(int i=0;i<removeElementBtns.size();i++) {
			removeElementBtns.get(i).click();
			Thread.sleep(2000);
		}		
	}

	public void validateAddElements(int noOfClicks, WebDriver driver) {
		WebElement addElementBtn = driver.findElement(By.xpath("//button[contains(text(),'Add Element')]"));
		for(int i=0;i<noOfClicks;i++) {
			addElementBtn.click();			
		}		
		List<WebElement> elements = driver.findElements(By.xpath("//div[@id='elements']/button"));
		Assert.assertEquals(noOfClicks, elements.size());
	}

}
