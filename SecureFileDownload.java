package allTests;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import org.apache.http.client.ClientProtocolException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import utility.FrameworkConstants;

public class SecureFileDownload {
	
	public static void main(String[] args) throws InterruptedException, ClientProtocolException, IOException {
		
		System.setProperty(FrameworkConstants.CHROME_DRIVER_KEY,FrameworkConstants.CHROME_DRIVER_PATH);
			
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default_content_settings.popups", 0);
		chromePrefs.put("download.default_directory", System.getProperty("user.dir") + File.separator + "externalFiles" + File.separator + "downloadFiles");
		ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", chromePrefs);
        WebDriver driver = new ChromeDriver(options);	
        driver.get("http://admin:admin@the-internet.herokuapp.com/download_secure");
        Thread.sleep(2000);
        System.out.println("Before clicking");
        driver.findElement(By.linkText("some-file.txt")).click();
        Thread.sleep(5000);
		driver.quit();
	}
}