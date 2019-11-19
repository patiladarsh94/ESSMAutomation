package ssms.SSMS_Automation.testCase;

import org.testng.annotations.Test;

import ssms.SSMS_Automation.Base;
import ssms.SSMS_Automation.modules.HomePage;
import ssms.SSMS_Automation.modules.Login;



public class LoginRegistration extends Base {

	static Login login = new Login();
	static HomePage homePage = new HomePage();
	@Test(priority=0, description="Verify Login with Valid Username and Valid Password")
	public void Tc_Login_001() {
		login.logIn("pawan", "punshegde");
		login.validateHomePage();
		//homePage.logOut();
	}
	
	@Test(priority=1, description="Verify Login with Valid Username and Invalid Password")
	public void Tc_Login_002() {
		login.logIn("pawan", "hgjhjkhjjn");
		login.validateLoginErrorMsg();
	}
	
	@Test(priority=2, description="Verify Login with Invalid Username and Valid Password")
	public void Tc_Login_003() {
		login.logIn("gvghjh", "punshegde");
		login.validateLoginErrorMsg();
	}
	
	@Test(priority=3, description="Verify Login with Invalid Username and invalid Password")
	public void Tc_Login_004() {
		login.logIn("gvghjh", "jhsdg@123");
		login.validateLoginErrorMsg();
	}
	
	@Test(priority=4, description="Verify that the login screen contains elements such as Username, Password, Sign in button,Forgot password link")
	public void Tc_Login_005() {
		login.validateLoginPageElements();
	}
	
	@Test(priority=5, description="Verify that the Registration form contains Fullname, Email Id, Mobile number, Username,Password,Conform Password ,Register Button,Forgot Password Link")
	public void Tc_Login_006() {
		login.validateRegisterFormElements();
	}
}
