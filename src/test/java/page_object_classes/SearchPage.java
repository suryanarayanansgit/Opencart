package page_object_classes;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SearchPage extends BasePage{

	public SearchPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	//list view
	@FindBy(xpath="//button[@id='list-view']")
	WebElement list_view;
	
	//compond view 
	@FindBy(xpath="//div/button[@id='grid-view']")
	WebElement compound_view;	
	
	//list of products
/*	@FindBy(xpath="//*[@id='content']/div//img")
	List <WebElement> ls_ele;
	
 */
	 List <WebElement> ls_ele =driver.findElements(By.xpath("//*[@id='content']/div//img"));

	//compare the product
	@FindBy(xpath="//div[@class='button-group']/child::button[contains(@data-original-title,'Compare this Product')]")
	WebElement com_prod;
	
	//sucess when comparation prompt
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	
	//@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']/child::i")
//	WebElement alert_prod_comp;
	
	
	@FindBy(xpath="//h2/following::p[1]")
	WebElement product_num;
	
	public void search_element_listview() {
		list_view.click();
		//div[@class='product-thumb']
	}
	
	public void search_element_compond_view() {
		compound_view.click();
	}
	
	Actions act = new Actions(driver);
	
	//String sb;
	
	
	public String compare_theProduct(String product) {
		if(ls_ele.size()>0) {
		for(WebElement ls:ls_ele) {
		String prodls=ls.getAttribute("title");
		System.out.println(prodls);
		if(prodls.equalsIgnoreCase(product)){
		com_prod.click();
		//*[@class='alert alert-success alert-dismissible']
		WebElement alert=driver.findElement(By.xpath("//*[@class='alert alert-success alert-dismissible']"));
		wait.until(ExpectedConditions.visibilityOf(alert));
		act.moveToElement(alert).perform();
        String success_msg=alert.getText();
        System.out.println(success_msg);
		return success_msg;
		}
		}
		}
		return product;
		
		//System.out.println(product_num.getText());
		//return product_num.getText();

		
			
	}
	
	
	
	
	
	public void List_of_srch() throws Throwable {
		
	//	if(ls_ele.size()>0) {
		Thread.sleep(4000);
			for(WebElement ls:ls_ele) {
			String actual_srchls=ls.getAttribute("title");
			System.out.println(actual_srchls);
			}
		//}
		//else {
		//	System.out.println("there is no product for your search");
		//}
		
	}
	

}
