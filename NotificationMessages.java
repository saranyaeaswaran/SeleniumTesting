package allTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utility.FrameworkConstants;

public class NotificationMessages {
	
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty(FrameworkConstants.CHROME_DRIVER_KEY,FrameworkConstants.CHROME_DRIVER_PATH);
		WebDriver driver = new ChromeDriver();		
		driver.get("http://the-internet.herokuapp.com/");
		driver.findElement(By.xpath("//a[contains(text(),'Notification Messages')]")).click();
		System.out.println(driver.findElement(By.xpath("//div[@id='flash-messages']/div")).getText());
		
		boolean flag = true;
		while(flag==true) {
			driver.findElement(By.linkText("Click here")).click();
			System.out.println(driver.findElement(By.xpath("//div[@id='flash-messages']/div")).getText());
			if(driver.findElement(By.xpath("//div[@id='flash-messages']/div")).getText().contains("successful")){
				flag=false;
			}	
		}
		
		Thread.sleep(3000);
		driver.quit();
	}
}