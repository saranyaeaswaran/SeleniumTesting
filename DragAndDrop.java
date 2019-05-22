package allTests;

import org.testng.annotations.Test;
import utility.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class DragAndDrop extends BaseTest{
	
	@Test
	public void test() throws InterruptedException {		
		driver.findElement(By.xpath("//a[contains(text(),'Drag and Drop')]")).click();
		WebElement elementA = driver.findElement(By.cssSelector("div#column-a"));
		System.out.println(elementA.getAttribute("id"));
		WebElement elementB = driver.findElement(By.cssSelector("div#column-b"));
		int x=elementB.getLocation().getX();
		int y=elementB.getLocation().getY();
		Actions actions = new Actions(driver);
//		elementA.click();
		actions.dragAndDrop(elementA, elementB).build().perform();
//		actions.dragAndDropBy(elementA, x, y).build().perform();
//		actions.clickAndHold(elementA).moveToElement(elementB).release(elementB).build().perform();
		Thread.sleep(6000);
		driver.quit();
		
	}
}
