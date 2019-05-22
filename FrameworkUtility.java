package allTests;

import java.io.FileInputStream;
import java.util.Properties;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.logging.log4j.LogManager;

public class FrameworkUtility {
	
	public static Properties properties;
	public static String URL;
	public static final Logger logger = LogManager.getLogger();
	public static WebDriver driver;
	public static JavaScriptActions jsActions;
	public static JavascriptExecutor js;
	public static Actions action;
	public static WebDriverWait wait;
	public static CustomWait Wait;
	public static WindowActions WindowHandler;
	public static AlertActions AlertHandler;
	public static KeyboardActions KeyboardHandler;	
	protected Alert alert;
	
	
	public String readConfigurationFile(String configKey) {
		properties = new Properties();
		try {
			properties.load(new FileInputStream(FrameworkConstants.CONFIG_FILE_PATH));			
		} catch (Exception e) {			
			System.out.println("Error reading configuration file with exception :"+e);
		}
		return properties.getProperty(configKey).trim();
	}
}


