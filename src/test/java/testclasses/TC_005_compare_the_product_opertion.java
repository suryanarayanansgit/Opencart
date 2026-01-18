package testclasses;

import org.testng.Assert;
import org.testng.annotations.Test;

import page_object_classes.HomePage;
import page_object_classes.SearchPage;
import testbase.BaseClass;

public class TC_005_compare_the_product_opertion extends BaseClass {
	
	
	@Test(groups={"Sanity","Regression"})
public void ComparetheProduct() {
	SearchPage sp= new SearchPage(driver);	
	HomePage hp= new HomePage(driver);
	//String srch_data="imac";
hp.search_fxn("imac");
/*String actual_text=sp.compare_theProduct("imac");
if(actual_text.equalsIgnoreCase("There is no product that matches the search criteria")) {
Assert.assertTrue(true);
}
else {
	Assert.assertEquals(actual_text," Success: You have added ");
}
}
*/
}
}
