package allTests;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import resources.UITestPracticePage;
import utility.FrameworkConstants;


public class DialogControl {
	public static void main(String[] args) {
		
		System.setProperty(FrameworkConstants.CHROME_DRIVER_KEY,FrameworkConstants.CHROME_DRIVER_PATH);
		WebDriver driver = new ChromeDriver();		
		driver.get("http://uitestpractice.com/Students/");
		System.out.println(driver.getCurrentUrl());
		
		UITestPracticePage.using(driver).dialogControl_createNewUser.click();
		UITestPracticePage.using(driver).dialogControl_createNewUser_name.clear();
		UITestPracticePage.using(driver).dialogControl_createNewUser_name.sendKeys("Jon Snow");
		UITestPracticePage.using(driver).dialogControl_createNewUser_createAccount.click();	
		WebElement userTable = UITestPracticePage.using(driver).dialogControl_userTable;
		List<WebElement> userRows = userTable.findElements(By.tagName("tr"));
		for(WebElement userRow:userRows) {
			List<WebElement> userData = userRow.findElements(By.tagName("td"));
			for(WebElement user:userData) {
				System.out.println(user.getText());
			
			}
			System.out.println("=============================");
		}
		
		driver.quit();
	}	
}

