package allTests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import resources.UITestPracticePage;
import utility.FrameworkConstants;


public class AccordianControl {
	public static void main(String[] args) {
		
		System.setProperty(FrameworkConstants.CHROME_DRIVER_KEY,FrameworkConstants.CHROME_DRIVER_PATH);
		WebDriver driver = new ChromeDriver();		
		driver.get("http://uitestpractice.com/Students/");
		System.out.println(driver.getCurrentUrl());
		List<WebElement> accordionLinks = UITestPracticePage.using(driver).accordianLinks;
		System.out.println(accordionLinks.size());
		for(WebElement element:accordionLinks) {
			if(element.getText().equals("Coded UI")){
				element.findElement(By.tagName("span")).click();
			}
		}		
		
//		driver.quit();
	}	
}
