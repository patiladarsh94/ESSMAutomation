package ssms.SSMS_Automation.modules;

import org.apache.xmlbeans.impl.jam.internal.elements.VoidClassImpl;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import ssms.SSMS_Automation.Base;

public class Login extends Base {
	public final String loginLink_xpath="(//span[text()='Login/Register'])[1]";
	public final String userName_id="mat-input-0";
	public final String passWord_xpath="//input[@formcontrolname='Password']";
	public final String signIn_xpath="//span[text()='Sign In']";
	public final String homePage_xpath="//*[contains(@class,'sidenav-content')]";
	public final String loginErrorMsg_xpath="//*[text()='Login Failed, Reason : Bad credentials']";
	public final String forgotPassword_class="forget-password";
	
	public void logIn(String username,String password) {
		try {         
			driver.findElement(By.xpath(loginLink_xpath)).click();
			WebElement e= driver.findElement(By.id(userName_id));
			e.sendKeys(username);
			driver.findElement(By.xpath(passWord_xpath)).sendKeys(password);
			driver.findElement(By.xpath(signIn_xpath)).click();
		}catch(Exception e) {
			System.out.println(e);
			Assert.fail("Fail due to exception "+e.getMessage());
		}
	}
	
	public void validateHomePage() {
		try {         
			Assert.assertTrue(driver.findElement(By.xpath(homePage_xpath)).isDisplayed(),"Home page not displayed");
		}catch(Exception e) {
			System.out.println(e);
			Assert.fail("Fail due to exception "+e.getMessage());
		}
	}
	
	public void validateLoginErrorMsg() {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loginErrorMsg_xpath)));
			Assert.assertTrue(driver.findElement(By.xpath(loginErrorMsg_xpath)).isDisplayed(),"Login Error Message is not displaying properly");
		}catch(Exception e) {
			System.out.println(e);
			Assert.fail("Fail due to exception "+e.getMessage());
		}
	}
	
	public void validateLoginPageElements() {
		try {
			driver.findElement(By.xpath(loginLink_xpath)).click();
			driver.findElement(By.id(userName_id));
			driver.findElement(By.xpath(passWord_xpath));
			driver.findElement(By.xpath(signIn_xpath));
			driver.findElement(By.className(forgotPassword_class));
		}catch(Exception e) {
			System.out.println(e);
			Assert.fail("Fail due to exception "+e.getMessage());
		}
	}
	
	
//	@Test(priority=0, description="Verify Login with Valid Username and Valid Password")
//	public void Tc_Login_001() {
//		logIn("pawan", "punshegde");
//		validateHomePage();
//	}
}
