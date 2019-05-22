package allTests;

import java.io.IOException;
import java.util.List;
import org.apache.http.client.ClientProtocolException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import utility.BaseTest;
import utility.FrameworkConstants;

public class CheckBoxes extends BaseTest{
	
	@Test
	public void test() throws InterruptedException, ClientProtocolException, IOException {	
		System.setProperty(FrameworkConstants.CHROME_DRIVER_KEY,FrameworkConstants.CHROME_DRIVER_PATH);
		WebDriver driver = new ChromeDriver();		
		driver.findElement(By.xpath("//a[contains(text(),'Checkboxes')]")).click();
		List<WebElement> checkboxElements = driver.findElements(By.cssSelector("#checkboxes input[type='checkbox']"));
		//To select the checkbox which is not selected
		System.out.println("no of checkboxes are : "+checkboxElements.size());
		for(WebElement checkbox:checkboxElements) {
			System.out.println("is this selected : "+checkbox.isSelected());
			if(!checkbox.isSelected()) {
				checkbox.click();
			}
		}		
	}
}
