package testclasses;

import org.testng.Assert;
import org.testng.annotations.Test;


import page_object_classes.AccountPage;
import page_object_classes.HomePage;
import page_object_classes.LoginPage;
import testbase.BaseClass;

public class TC_002_Login_validAccount extends BaseClass{

	@Test(groups={"Master","Sanity","Regression"})
	public void login_acc() {
	try{
		HomePage hp= new HomePage(driver);
	
	LoginPage lp= new LoginPage(driver);
	AccountPage ap= new AccountPage(driver);
	logger.info("****--------log started---------****");

	hp.login_slct();
	logger.info("***--entering email and password as a credential----***");
	
	lp.Enter_logn_creds(p.getProperty("email"),p.getProperty("password"));
	Thread.sleep(3000);
	logger.info("**---login button clicked--**");
	lp.clck_login_btn();

	logger.info("***---MY Account page opened----**");
	ap.is_MyAccountpage();
logger.info("***-----------log out performed--------------**");
	ap.log_outMthd();
	
	}catch(Exception e) {
		Assert.fail();
		logger.error("testfails");
	}
		
}
}
