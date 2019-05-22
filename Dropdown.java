package allTests;

import org.testng.annotations.Test;
import utility.BaseTest;
import utility.FrameworkConstants;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Dropdown extends BaseTest{
	
	@Test
	public void test() throws InterruptedException {	
		System.setProperty(FrameworkConstants.CHROME_DRIVER_KEY,FrameworkConstants.CHROME_DRIVER_PATH);
		WebDriver driver = new ChromeDriver();		
		driver.findElement(By.xpath("//a[contains(text(),'Dropdown')]")).click();
		WebElement dropdown = driver.findElement(By.id("dropdown"));
		Select select = new Select(dropdown);
		select.selectByValue("2");
		Thread.sleep(6000);
		
	}
}
