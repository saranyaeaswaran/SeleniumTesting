package allTests;

import org.openqa.selenium.WebElement;

public class JavaScriptActions extends BaseTest{
	public static void scrollUp() {
		js.executeScript("window.scrollBy(0,-300)");
	}
	
	public static void scrollDown() {
		js.executeScript("window.scrollBy(0,300)");
	}
	
	public static void scrollRight() {
		js.executeScript("window.scrollBy(300,0)");
	}
	
	public static void scrollLeft() {
		js.executeScript("window.scrollBy(-300,0)");
	}
	
	public static void pageUp() {
		js.executeScript("window.scrollTo(document.body.scrollHeight,0)");
	}
	
	public static void pageDown() {
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}
	
	public static void scrollToElement(WebElement webElement) {
		js.executeScript("arguments[0].scrollIntoView",webElement);
	}
	
	public void jsclickElement(WebElement webelement) {
		js.executeScript("arguments[0].click()", webelement);
	}
	
	public void jsenterText(WebElement webelement, String value) {
		webelement.clear();
		js.executeScript("arguments[0].value=arguments[1]", webelement,value);
	}
}


