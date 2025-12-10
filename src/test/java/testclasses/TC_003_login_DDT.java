package testclasses;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import page_object_classes.AccountPage;
import page_object_classes.HomePage;
import page_object_classes.LoginPage;
import testbase.BaseClass;
import utillities.DataProviders;

public class TC_003_login_DDT extends BaseClass{
	
	@Test(dataProvider="loginData",dataProviderClass=DataProviders.class)
	public void Login_DDT(String email,String password,String exp) throws IOException {
		try{
		logger.info("****--------log started---------****");
		//Homepage
		HomePage hp= new HomePage(driver);
		
		hp.login_slct();
		
		//login page
		LoginPage lp= new LoginPage(driver);
		lp.Enter_logn_creds(email,password);
		logger.info("***--entering email and password as a credential----***");

		//Account page
		AccountPage ap= new AccountPage(driver);
		
		logger.info("**---login button clicked--**");
		lp.clck_login_btn();

		
		
		logger.info("***---MY Account page opened----**");
		boolean target=ap.is_MyAccountpage();
	
		
		
		/*
		 * 
		 * valid cred ----- login successfull --- pass --- logout
		 * valid cred ------ login fail  ---- fail
		 * in valid cred --- login fali ----- pass
		 * invalid cred ---  login success ---- fail - log out
		 * 
		 */
		
		if(exp.equalsIgnoreCase("Valid")) {
			if(target==true) {
				logger.info("***-----------log out performed--------------**");
				ap.log_outMthd();
				Assert.assertTrue(true);
			}
			else if(target==false) {
				Assert.assertTrue(false);
			}
		}
		if(exp.equalsIgnoreCase("Invalid")) {
			if(target==true) {
				ap.log_outMthd();
				Assert.assertTrue(false);
				
			}else {
				Assert.assertTrue(true);
			}
		}
		}
		catch(Exception e){
			Assert.fail();
			logger.debug("Testfail");
		}
}
}
