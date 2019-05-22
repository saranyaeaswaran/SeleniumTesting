package allTests;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.NoSuchWindowException;

public class WindowActions extends BaseTest{
	
	public void switchToParentWindow() {
		Set<String> parentWindowHandle = driver.getWindowHandles();
		List<String> windowList = new ArrayList<String>(parentWindowHandle);
		if(windowList.size() > 0) {
			driver.switchTo().window(windowList.get(0));
		}else {
			throw new NoSuchWindowException("Parent window does not exist");
		}
	}
	
	public void switchToWindow(int windowindex) {
		Set<String> windowHandle = driver.getWindowHandles();
		List<String> windowList = new ArrayList<String>(windowHandle);
		if(windowindex < windowHandle.size()) {
			driver.switchTo().window(windowList.get(windowindex));
		}else {
			throw new NoSuchWindowException("Window does not exist with index: "+windowindex);
		}
	}
	
	public void closeWindow(int windowindex) {
		Set<String> windowHandle = driver.getWindowHandles();
		List<String> windowList = new ArrayList<String>(windowHandle);
		if(windowindex < windowHandle.size()) {
			driver.switchTo().window(windowList.get(windowindex)).close();
		}else {
			throw new NoSuchWindowException("Window with index: "+windowindex+" does not exist ");
		}
	}
	
	public void closeAllChildWindows() {
		Set<String> windowHandle = driver.getWindowHandles();
		List<String> windowList = new ArrayList<String>(windowHandle);
		for(int i=1; i < windowList.size(); i++) {
			driver.switchTo().window(windowList.get(i)).close();
		} 
	}
	
	public int getWindowCount() {
		Set<String> windowHandle = driver.getWindowHandles();
		List<String> windowList = new ArrayList<String>(windowHandle);
		return windowList.size();
	}

}
