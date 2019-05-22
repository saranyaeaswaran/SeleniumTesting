package allTests;


import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.FrameworkConstants;


public class AutoComplete {
	public static void main(String[] args) {

		System.setProperty(FrameworkConstants.CHROME_DRIVER_KEY,FrameworkConstants.CHROME_DRIVER_PATH);
		WebDriver driver = new ChromeDriver();		
		driver.get("https://in.yahoo.com/?p=us");
		System.out.println(driver.getTitle());
		WebElement searchBox = driver.findElement(By.xpath("//input[@id='uh-search-box']"));
		searchBox.sendKeys("selenium");
		WebDriverWait wait = new WebDriverWait(driver, 4);
		List<WebElement> resultList = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//input[@id='uh-search-box']/following-sibling::div//ul/li")));
		
		System.out.println("Result no are : "+resultList.size());
		if(resultList.size()>0) {
			
			for(WebElement result:resultList) {
				System.out.println(result.getText());
				if(result.getText().equalsIgnoreCase("selenium download")) {
					System.out.println("To click the result page");
					result.click();
					break;
				}
			}
		}
		else {
			System.out.println("Nothing to select");
		}
		
//		driver.quit();
	}

	
}
