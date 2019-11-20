package ssms.SSMS_Automation.modules;

import org.apache.xmlbeans.impl.jam.internal.elements.VoidClassImpl;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import ssms.SSMS_Automation.Base;

public class Register extends Base {
	public final String loginLink_xpath="(//span[text()='Login/Register'])[1]";
	public final String forgotPassword_class="forget-password";
	public final String registerForm_id="mat-tab-label-1-1";
	public final String regFullName_xpath="//input[@formcontrolname='Name']";
	public final String regEmailId_xpath="//input[@formcontrolname='EmailId']";
    public final String regMobileNumber_xpath="//input[@formcontrolname='MobileNo']";
    public final String regUserName_xpath="//input[@formcontrolname='UserName']";
    public final String regPassword_xpath="//input[@formcontrolname='Password']";
    public final String regConfirmPassword_xpath="//input[@formcontrolname='ConfirmPassword']";
    public final String register_xpath="//span[text()='Register']";
    public final String regNameErrorMsg_xpath="//*[text()='Name is Required']";
    public final String regEmailErrorMsg_xpath="//*[text()='Email Id is Required']";
    public final String regMobileNumErrorMsg_xpath="//*[text()='Mobile No is Required']";
    public final String regUserNameErrorMsg_xpath="//*[text()='User Name is Required']";
    public final String regPasswordErrorMsg_xpath="//*[text()='Password is Required']";
    public final String regConfirmPasswordErrorMsg_xpath="//*[text()='Confirm Password is Required']";
    
    static Validation validate = new Validation();
    public void register(String fullname, String emailid, String phonenum, String username,String password, String confirmpassword) {
    	try {
    		// Click on login path
    		driver.findElement(By.xpath(loginLink_xpath)).click();
    		
    		//Click on register form
    		driver.findElement(By.id(registerForm_id)).click();
    		
    		// Validate and Fill New User information
    		if (validate.validateFullName(fullname)) {
    			WebElement name = driver.findElement(By.xpath(regFullName_xpath));
        		name.clear();
        		name.sendKeys(fullname);
			}
    		
    		//Validate Email Id 
    		if (validate.validateEmailId(emailid)) {
    			WebElement email = driver.findElement(By.xpath(regEmailId_xpath));
    			email.clear();
    			email.sendKeys(emailid);
			}
			
    		//Validate Phone number
    		if (validate.validatePhone(phonenum)) {
    			WebElement phone = driver.findElement(By.xpath(regMobileNumber_xpath));
    			phone.clear();
    			phone.sendKeys(phonenum);
			}
			
    		//Validate User Name
    		if (validate.validateUserName(username)) {
    			WebElement usrname = driver.findElement(By.xpath(regUserName_xpath));
    			usrname.clear();
    			usrname.sendKeys(username);
			}
			
    		// Validate Password
    		if (validate.validatePassword(password)) {
    			WebElement pwd = driver.findElement(By.xpath(regPassword_xpath));
    			pwd.clear();
    			pwd.sendKeys(password);
			}
			
    		//Check both Password and Confir Password are equal
    		if (validate.validateConfirmPassword(confirmpassword,password)) {
    			WebElement confpwd = driver.findElement(By.xpath(regConfirmPassword_xpath));
    			confpwd.clear();
    			confpwd.sendKeys(confirmpassword);
			}
			
			
			// Click Register
			driver.findElement(By.xpath(register_xpath)).click();
			Thread.sleep(2000);
			
			//TODO Registration Success message validation
			
		} catch (Exception e) {
			System.out.println(e);
			Assert.fail("Fail due to exception "+e.getMessage());
		}
		
	}
 
    
    public void validateRegisterFormElements() {
		try {
			driver.findElement(By.xpath(loginLink_xpath)).click();
			driver.findElement(By.id(registerForm_id)).click();
			driver.findElement(By.xpath(regFullName_xpath));
			driver.findElement(By.xpath(regEmailId_xpath));
			driver.findElement(By.xpath(regMobileNumber_xpath));
			driver.findElement(By.xpath(regUserName_xpath));
			driver.findElement(By.xpath(regPassword_xpath));
			driver.findElement(By.xpath(regConfirmPassword_xpath));
			driver.findElement(By.className(forgotPassword_class));
		}catch(Exception e) {
			System.out.println(e);
			Assert.fail("Fail due to exception "+e.getMessage());
		}
		
	}
	
	public void validateRegisterErrorMsg() {
		try {
			driver.findElement(By.xpath(loginLink_xpath)).click();
			driver.findElement(By.id(registerForm_id)).click();
            driver.findElement(By.xpath(register_xpath)).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(regNameErrorMsg_xpath)));
			Assert.assertTrue(driver.findElement(By.xpath(regNameErrorMsg_xpath)).isDisplayed(),"Name is Required is not displaying properly");
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(regEmailErrorMsg_xpath)));
			Assert.assertTrue(driver.findElement(By.xpath(regEmailErrorMsg_xpath)).isDisplayed(),"Email Id is Required is not displaying properly");
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(regMobileNumErrorMsg_xpath)));
			Assert.assertTrue(driver.findElement(By.xpath(regMobileNumErrorMsg_xpath)).isDisplayed(),"Mobile No is Required is not displaying properly");
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(regUserNameErrorMsg_xpath)));
			Assert.assertTrue(driver.findElement(By.xpath(regUserNameErrorMsg_xpath)).isDisplayed(),"User Name is Required is not displaying properly");
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(regPasswordErrorMsg_xpath)));
			Assert.assertTrue(driver.findElement(By.xpath(regPasswordErrorMsg_xpath)).isDisplayed(),"Password is Required is not displaying properly");
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(regConfirmPasswordErrorMsg_xpath)));
			Assert.assertTrue(driver.findElement(By.xpath(regConfirmPasswordErrorMsg_xpath)).isDisplayed(),"Confirm Password is Required is not displaying properly");
			
		} catch (Exception e) {
			System.out.println(e);
			Assert.fail("Fail due to exception "+e.getMessage());
		}
	}

}
