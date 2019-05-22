package allTests;

import java.io.IOException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utility.FrameworkConstants;

public class Redirection {
	
	public static void main(String[] args) throws InterruptedException, ClientProtocolException, IOException {
		
		System.setProperty(FrameworkConstants.CHROME_DRIVER_KEY,FrameworkConstants.CHROME_DRIVER_PATH);
		WebDriver driver = new ChromeDriver();		
		driver.get("http://the-internet.herokuapp.com/");
		driver.findElement(By.linkText("Redirect Link")).click();
		WebElement redirectLink = driver.findElement(By.cssSelector("a#redirect"));
		
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(redirectLink.getAttribute("href"));
		CloseableHttpResponse httpResponse=httpclient.execute(httpGet);
		System.out.println(httpResponse.getStatusLine().getStatusCode());
		redirectLink.click();
		
		
		Thread.sleep(3000);
		driver.quit();
	}
}