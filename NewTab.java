package allTests;


import java.util.Set;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import resources.UITestPracticePage;
import utility.FrameworkConstants;

public class NewTab {
	public static void main(String[] args) {
		
		System.setProperty(FrameworkConstants.CHROME_DRIVER_KEY,FrameworkConstants.CHROME_DRIVER_PATH);
		WebDriver driver = new ChromeDriver();		
		driver.get("http://uitestpractice.com/Students/");
		System.out.println(driver.getCurrentUrl());
		
		String parentHandle = driver.getWindowHandle();
		System.out.println("Parent handle id : "+parentHandle);
		UITestPracticePage.using(driver).clickNewTabLink(driver);
		waitForPageLoadComplete(driver);
		Set<String> handles = driver.getWindowHandles();
		System.out.println("no of tabs : "+handles.size());
		
		for(String handleStr:handles) {
			if(!handleStr.equals(parentHandle)) {
				System.out.println(handleStr);
				driver.switchTo().window(handleStr);
			}
		}
		
		String childHandle = driver.getWindowHandle();
		System.out.println("Child handle id : "+childHandle);
		driver.switchTo().window(parentHandle);
		
//		WebDriverWait wait = new WebDriverWait(driver, 5);
//		wait.until(ExpectedConditions.visibilityOf(UITestPracticePage.using(driver).containerBlue));		
//		UITestPracticePage.using(driver).body.sendKeys(Keys.CONTROL + "\t");
//		
		driver.quit();
	}
	
    public static void waitForPageLoadComplete(WebDriver driver){
    	
        ExpectedCondition<Boolean> pageLoadCondition = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
                    }
                };
        try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(pageLoadCondition);
    }
}
