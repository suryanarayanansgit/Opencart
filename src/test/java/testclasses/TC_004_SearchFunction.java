package testclasses;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import page_object_classes.HomePage;
import page_object_classes.SearchPage;
import testbase.BaseClass;

public class TC_004_SearchFunction extends BaseClass{
	
	@Test(groups={"Sanity","Master","Regression"})
	public void SearchData() throws Exception {
	HomePage hp= new HomePage(driver);
	SearchPage sp=new SearchPage(driver);
	
	hp.search_fxn("imac");  
	// positive case
	List <WebElement> lst_srch=driver.findElements(By.xpath("//*[@id='content']/div//img"));
	if(lst_srch.size()>0)
	{
	//Assert.assertTrue(true);
	for(int i=0;i<lst_srch.size();i++) {
	String str_ele_srch=lst_srch.get(i).getAttribute("title");
	sp.search_element_listview();
	System.out.println(str_ele_srch);
	}
	}
	else {
		Assert.assertTrue(false);
		scrnshot();
	}
	}
	
	

}
