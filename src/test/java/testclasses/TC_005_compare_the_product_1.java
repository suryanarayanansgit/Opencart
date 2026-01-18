package testclasses;



import org.testng.Assert;
import org.testng.annotations.Test;

import page_object_classes.HomePage;
import page_object_classes.SearchPage;
import testbase.BaseClass;

public class TC_005_compare_the_product_1 extends BaseClass {

	
	@Test(groups= {"Sanity","Master"})
	
public void compare_() throws Throwable {
	HomePage hp= new HomePage(driver);
	String srch_data="imac";
	hp.search_fxn(srch_data);
	
	SearchPage sp= new SearchPage(driver);

String actual_msg_after_compared=sp.compare_theProduct("imac");
Assert.assertTrue(actual_msg_after_compared.contains("Success: You have added iMac to your product comparison!"));
}





}
