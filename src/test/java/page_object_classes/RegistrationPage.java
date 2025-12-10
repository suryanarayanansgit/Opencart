package page_object_classes;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage{

	public RegistrationPage(WebDriver driver){
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement txt_frstnam;
	@FindBy(xpath="//input[@id='input-lastname']")
	WebElement txt_lastnam;
	@FindBy(xpath="//input[@id='input-email']")
	WebElement txt_eml;
	@FindBy(xpath="//input[@id='input-telephone']")
	WebElement txt_tele;

	@FindBy(xpath="//input[@id='input-password']")
	WebElement txt_pass;
	@FindBy(xpath="//input[@id='input-confirm']")
	WebElement txt_cnfrmpass;
	@FindBy(xpath="//label[normalize-space()='Yes']")
	WebElement rad_news;
	@FindBy(xpath="//input[@name='agree']")
	WebElement chk_agr;
	@FindBy(xpath="//input[@value='Continue']")
	WebElement btn_contimue;	
	
	
	public void Registration() {

	txt_frstnam.sendKeys(RandomStringUtils.randomAlphabetic(6));
	txt_lastnam.sendKeys(RandomStringUtils.randomAlphabetic(1));
	txt_eml.sendKeys(RandomStringUtils.randomAlphabetic(5)+"@"+RandomStringUtils.randomNumeric(3)+"gmail.com");
	txt_tele.sendKeys(RandomStringUtils.randomNumeric(10));
	
	String pass=RandomStringUtils.randomNumeric(6);
	txt_pass.sendKeys(pass);
	txt_cnfrmpass.sendKeys(pass);
	rad_news.click();
	chk_agr.click();
	btn_contimue.click();
	
	
}
	@FindBy(xpath="//div[@id=\"content\"]//h1")
	WebElement confrm_txt;


	public String confirmationtxt()
	{
		try {
	String cnfrm=confrm_txt.getText();
	return cnfrm;
	}

	catch (Exception e)
	{
		return e.getMessage();
	}
	}
	
}
