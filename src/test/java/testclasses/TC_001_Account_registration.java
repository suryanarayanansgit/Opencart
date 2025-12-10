package testclasses;

import org.testng.Assert;
import org.testng.annotations.Test;

import page_object_classes.HomePage;
import page_object_classes.RegistrationPage;
import testbase.BaseClass;

public class TC_001_Account_registration extends BaseClass{
	
	@Test(groups={"Sanity","Master"},priority=1)
	public void register_Acct()
	{
try {
		HomePage hp = new HomePage(driver);
		RegistrationPage rg = new RegistrationPage(driver);
		logger.info("****--------log started---------****");
		hp.My_Acc_slct();
		logger.info("****--------My_Account_slct---------****");

		rg.Registration();
		logger.info("****--------Register performed---------****");
		String con=rg.confirmationtxt();
		
	Assert.assertEquals(con, "Your Account Has Been Created!");
		
	/*	if(con.equals(" Account Has Been Created!"))
		{
			
			logger.debug("Testfailed");
			logger.error("Testfailed");
			Assert.assertTrue(true);
		}
		else {
			
			logger.debug("Testfailed");
			logger.error("Testfailed");
			Assert.assertTrue(false);
			
*/
		//	Assert.fail();
		}
		
		//}
	catch(Exception e) {
				logger.debug("Testfailed"+e.getMessage());
				logger.error("Testfailed"+e.getMessage());
			}
		finally {
logger.info("****-------registration is finished -------****");
		}
	
		
	}	
}
