package allTests;


import java.io.IOException;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import utility.BaseTest;
import utility.FrameworkConstants;

public class BrokenImagesTest extends BaseTest{
	
	private int validImageCount=1;
	
	@Test
	public void test() throws InterruptedException, ClientProtocolException, IOException {
		System.setProperty(FrameworkConstants.CHROME_DRIVER_KEY,FrameworkConstants.CHROME_DRIVER_PATH);
		WebDriver driver = new ChromeDriver();		
		driver.findElement(By.xpath("//a[contains(text(),'Broken Images')]")).click();
		List<WebElement> imageElemenets = driver.findElements(By.cssSelector("div.example img"));
		for(WebElement image:imageElemenets) {
			validateImage(image);			
		}
		
		System.out.println("No. of broken images are : "+validImageCount);
	}

	private void validateImage(WebElement image) throws ClientProtocolException, IOException {
		
		HttpClient client = HttpClientBuilder.create().build();
		HttpGet getRequest = new HttpGet(image.getAttribute("src"));
		HttpResponse response = client.execute(getRequest);
		if(response.getStatusLine().getStatusCode()==200) {
			validImageCount++;
		}		
	}
}
