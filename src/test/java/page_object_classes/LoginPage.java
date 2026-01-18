package page_object_classes;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
//	public Properties p;

	//constructor
	
	public LoginPage(WebDriver driver) {
		super(driver);
		
	}

	
	
	//locators
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement email_fld;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement pswd_fld;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement logn_btn;
	
	
	// action methods
	public void Enter_logn_creds(String email,String pass) throws IOException {
		
		email_fld.sendKeys(email);
		pswd_fld.sendKeys(pass);
		
	}
	
	
	
	
	
	
	
	
	
	public void clck_login_btn() {
	// using javascriptexecutor
		//use normal click
		//JavascriptExecutor js = (JavascriptExecutor)driver;
	//	js.executeScript("arguments[0].click()", logn_btn);
		//or
        logn_btn.click();
//or
		//logn_btn.sendKeys(Keys.ENTER);
	}
	
	
	
	
	
	
}
