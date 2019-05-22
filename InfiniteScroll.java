package allTests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utility.FrameworkConstants;

public class InfiniteScroll {
	
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty(FrameworkConstants.CHROME_DRIVER_KEY,FrameworkConstants.CHROME_DRIVER_PATH);
		WebDriver driver = new ChromeDriver();		
		driver.get("http://the-internet.herokuapp.com/");
		driver.findElement(By.xpath("//a[contains(text(),'Infinite Scroll')]")).click();
		long lenOfPage = (Long) ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);var lenOfPage=document.body.scrollHeight;return lenOfPage;");
		boolean scrolled = true;
		long lastCount = 0;
		System.out.println(lenOfPage);
		
		while(scrolled==true) {
			Thread.sleep(1500);
			lastCount=lenOfPage;
			lenOfPage = (Long) ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);var lenOfPage=document.body.scrollHeight;return lenOfPage;");
			System.out.println(lenOfPage);
			if (lastCount==lenOfPage) {
				scrolled=false;
			}

		}
		
		Thread.sleep(3000);
		driver.quit();
	}
}