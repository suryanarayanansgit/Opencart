package utillities;

import java.io.IOException;

import org.testng.annotations.DataProvider;


public class DataProviders {
	
	
	
	
	//Dataprovider 1
	@DataProvider(name="loginData")
	public String[][] logindata() throws IOException{
	
		String path =".\\testData\\opencart_testData.xlsx";
		
		ExcelUtility es=new ExcelUtility(path);
		
		
		
		int row_cont=es.getRowCount("Sheet1");
		int column_count= es.getCellCount("Sheet1", row_cont);
		
		
		
		String td[][]= new String [row_cont][column_count];
		
		for(int r=1;r<=row_cont;r++) {
			
			for(int c=0;c<column_count;c++){
				
				td[r-1][c]=es.getCellData("Sheet1", r, c);
			}
		}
		
	
		
		
		return td;
		
		
	}
	
	//dataprovider2 
	//dataprovider 3

}
