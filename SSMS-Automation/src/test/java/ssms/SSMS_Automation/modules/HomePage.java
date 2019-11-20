package ssms.SSMS_Automation.modules;

import org.openqa.selenium.By;
import org.testng.Assert;

import ssms.SSMS_Automation.Base;

public class HomePage extends Base{
	
	public final String account_xpath="//*[contains(text(),' Hello ')]";
	public final String signOut_xpath="//*[contains(text(),'Sign Out')]";
	
	
	public void logOut() {
		try {
			driver.findElement(By.xpath(account_xpath)).click();
			driver.findElement(By.xpath(signOut_xpath)).click();
		} catch (Exception e) {
			Assert.fail("Fail due to exception "+e.getMessage());
		}
	}

}
