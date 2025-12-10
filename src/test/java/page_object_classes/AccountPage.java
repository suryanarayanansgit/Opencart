package page_object_classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPage extends BasePage{
//constructor
	public AccountPage(WebDriver driver){
		super(driver);
	}
	
	
//locator
	@FindBy(xpath="//div[@id='content']//h2[text()='My Account']")
	WebElement Acc_txt;
		
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Logout']")
	WebElement log_out;
	
	
	
	public boolean is_MyAccountpage() {
		try{
			return(Acc_txt.isDisplayed());
		}
	catch(Exception e) {
	e.printStackTrace();
	return false;
	}
		
}

	public void log_outMthd() {
		log_out.click();
	}
	
}
