package allTests;

import java.net.http.HttpClient;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import static io.restassured.RestAssured.given; //import this

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class RestAPITesting_HttpURIRequest {

	public static void main(String[] args) {
		
		String restURL = "http://api.zippopotam.us/us/90210";
		RestAssured.baseURI = "http://api.zippopotam.us";
		RequestSpecification requestSpecification = given();
		Response response = requestSpecification.get("/us/90210");
		System.out.println(response.asString());
		
		
//		CloseableHttpClient httpclient = HttpClients.createDefault();
//		HttpPost httppost = new HttpPost("http://216.10.245.166:8080/axis2/services/EmployeeManagementService.EmployeeManagementServiceHttpSoap11Endpoint/");
//		httppost.addHeader("Content-Type", "text/xml");
//		
//        HttpEntity entity = new ByteArrayEntity(readFileAsString("C:\\Saranya-Documents\\To Study\\API Testing\\SOAPUI\\Java Automation\\HttpClient\\EmployeeRequest.xml").getBytes());
//        httppost.setEntity(entity);
//
//        CloseableHttpResponse httpResponse = httpclient.execute(httppost);
//        String result = EntityUtils.toString(httpResponse.getEntity());
//		System.out.println(result);

	}

}
