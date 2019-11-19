package ssms.SSMS_Automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;


public class Base {

	public static WebDriver driver;
	public static WebDriverWait wait;
	//public Login login=new Login();
	
	@BeforeMethod
	public void setup() {
		try {
			  // System Property for Chrome Driver   
	        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") +"\\Driver\\chromedriver.exe");  
	          
	             // Instantiate a ChromeDriver class.     
	         driver=new ChromeDriver();  
	         
	         //Instantiate wait
	         wait=new WebDriverWait(driver, 45);
	         
	         //Maximize the browser  
	          driver.manage().window().maximize();
	          
	           // Launch Website  
	        driver.navigate().to("http://demo.horolab.in/#/ecommerce/home");  
	          
  
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
