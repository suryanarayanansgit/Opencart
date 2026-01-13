package testbase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;//log4j
import org.apache.logging.log4j.Logger; //log4j
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import org.testng.annotations.Parameters;



public class BaseClass {
	
	public static WebDriver driver ;
	public Logger logger;
	public Properties p;
	

	@BeforeClass(groups={"Master","Sanity","Regression"})

	@Parameters({"os", "browser"})
	public void Setup(String os,String br) throws IOException {
		
		
		FileReader file = new FileReader("./src//test//resources//config.properties");
		p=new Properties();	
		p.load(file);
		logger =LogManager.getLogger(this.getClass());

		
		
		//	DesiredCapabilities cap= new DesiredCapabilities();

	/*	
		if(p.getProperty("execution_env").equalsIgnoreCase("remote")){
			
			if(os.equalsIgnoreCase("windows")) {
			cap.setPlatform(Platform.WIN11);
			}
			else if (os.equalsIgnoreCase("MAC")) {
				cap.setPlatform(Platform.MAC);
			}
			else if (os.equalsIgnoreCase("Linux")) {
				cap.setPlatform(Platform.LINUX);
			}
			else {
				System.out.println("there no matching platform");
				return;
			}
			
			switch(br.toLowerCase())
			{
			case "chrome":cap.setBrowserName("chrome") ;  break;
			case "edge": cap.setBrowserName("MicrosoftEdge");break;
			case "firefox":cap.setBrowserName("firefox");break;
			default :System.out.println("there is no browser "); break ;
			
			}
			String url_grd="http://localhost:4444/wd/hub";
			URL url=new URL(url_grd);
			 driver=new RemoteWebDriver(url,cap);
		}
		
		ChromeOptions op= new ChromeOptions();
		 op.addArguments("--headless");
		 
		 EdgeOptions ed=new EdgeOptions();
		 ed.addArguments("--headless");
		 
		 FirefoxOptions mff=new FirefoxOptions();
		 mff.addArguments("--headless");
		 
		 if(p.getProperty("execution_env").equalsIgnoreCase("local")) {

		switch(br.toLowerCase())
		{		
		case "chrome":driver = new ChromeDriver();break;
		case "firefox":driver = new FirefoxDriver();break;
		case "edge" :driver =new EdgeDriver(); break;
		default : System.out.println("Enter valid browser"); return;
		}
		}

		//driver.manage().deleteAllCookies();
		*/
		
		try {
		
		switch(br.toLowerCase())
		{
		case "chrome":
		driver=	new ChromeDriver();
			break;
		case "firefox":
			driver=new FirefoxDriver();
			break;
		case "edge":
			driver=new EdgeDriver();
			break;
			default :System.out.println("enter the valid ");
				break;
		}
		}
		catch( Exception e)
		{	System.out.println(e.getStackTrace());
		}
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get(p.getProperty("AppUrl"));

		driver.manage().window().maximize();

	
}

	//@AfterMethod(groups={"Master","Sanity","Regression"})
	public void scrnshot() throws Exception {
		int v=0;
	TakesScreenshot tc=  (TakesScreenshot)driver;	
	File Source=tc.getScreenshotAs(OutputType.FILE);
	File target = new File(System.getProperty("user.dir")+"\\Screenshots\\"+v+".png");
	FileUtils.copyFile(Source, target);
	}

	@AfterClass(groups={"Master","Sanity","Regression"})
	public void taerdown() throws Exception {
		Thread.sleep(3000);
		driver.quit();
	}



	public String captureScreen(String name) throws Exception{
		SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd-ss-mm-HH");
		Date dt=new Date();
		String timestamp=sf.format(dt);
		TakesScreenshot tc=  (TakesScreenshot)driver;	
		File Source=tc.getScreenshotAs(OutputType.FILE);
	String targetpath = (System.getProperty("user.dir")+"\\Screenshots\\"+name+"_"+timestamp+".png");
	File target=new File(targetpath);	
	FileUtils.copyFile(Source, target);
		return targetpath;
	}
	

	
	
	
	

}
