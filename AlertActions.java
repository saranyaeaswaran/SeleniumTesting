package allTests;

//import com.relevantcodes.extentreports.LogStatus;

public class AlertActions extends BaseTest{
	
	public void isAlertPresent(){
		Wait.forAlertToBePresent();
	}
	
	public void isAlertPresent(int customTimeout){
		Wait.forAlertToBePresent(customTimeout);
	}
	
	public void acceptAlert(){
		isAlertPresent();
		alert = driver.switchTo().alert();
		alert.accept();
	}
	
	public void dismissAlert(){
		isAlertPresent();
		alert = driver.switchTo().alert();
		alert.dismiss();
	}
	
	public String getAlertText(){
		isAlertPresent();
		alert = driver.switchTo().alert();
		String tempText = alert.getText().trim();
		alert.accept();
			if(tempText.length() > 0){
				return tempText;
			}
		return null;
	}
}
