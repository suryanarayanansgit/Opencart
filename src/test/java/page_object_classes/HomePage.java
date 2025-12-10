package page_object_classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

public 	HomePage(WebDriver driver)
{
	super(driver);	
	}
	
//locator
@FindBy(xpath="//a[@title='My Account']//span[text()='My Account']")
WebElement drp_acc;
@FindBy(xpath="//a[normalize-space()='Register']")
WebElement drp_reg;
@FindBy(xpath="//li//a[contains(.,'Login')]")
WebElement drp_logn;

//ActionMethod

public void My_Acc_slct()
{
	drp_acc.click();
	drp_reg.click();

}

public void login_slct() {
	drp_acc.click();
	drp_logn.click();
}
}
