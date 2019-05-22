package allTests;

import java.util.NoSuchElementException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class KeyboardActions extends BaseTest{
	
	public void sendKeyEnter() {
		action.sendKeys(Keys.ENTER).build().perform();
	}
	
	public void sendKeyEscape() {
		action.sendKeys(Keys.ESCAPE).build().perform();
	}
	
	public void sendKeyTab() {
		action.sendKeys(Keys.TAB).build().perform();
	}
	
	public void sendKeyArrowDown() {
		action.sendKeys(Keys.ARROW_DOWN).build().perform();
	}
	
	public void sendKeyArrowUp() {
		action.sendKeys(Keys.ARROW_UP).build().perform();
	}
	
	public void mouseHover(WebElement webelement) {
		try {
			action.moveToElement(webelement).build().perform();	
		}catch (NoSuchElementException e) {
			e.printStackTrace();
		}
		
	}
}
