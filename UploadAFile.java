package allTests;

import org.testng.annotations.Test;
import utility.BaseTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class UploadAFile extends BaseTest{
	
//	@FindBy(xpath="//a[contains(text(),'File Upload')]") 
//	WebElement UploadFileLink;
	
	@Test	
	public void uploadFileTest() {		
		System.out.println("Upload file test");
		WebElement pageLink = driver.findElement(By.xpath("//a[contains(text(),'File Upload')]"));
		pageLink.click();
		WebElement uploadFileLink = driver.findElement(By.cssSelector("input#file-upload"));
		uploadFileLink.sendKeys("C:\\My docs - Official\\Resume\\New\\PowerBI\\ToUpload.txt");
		WebElement uploadSubmit = driver.findElement(By.cssSelector("input[type='submit']"));
		uploadSubmit.click();				
	}

}
