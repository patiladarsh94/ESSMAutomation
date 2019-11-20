package ssms.SSMS_Automation.modules;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {
	
	public boolean validateFullName(String fullname) {
		String patternString = ".*$%^#:.*";

	    Pattern pattern = Pattern.compile(patternString, Pattern.CASE_INSENSITIVE);
	    Matcher matcher = pattern.matcher(fullname);
	    if(matcher.find()){
	        return false;
	    }
	    
		return true;
	}
	

	public boolean validateEmailId(String emailid) {
		String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
	    return emailid.matches(regex);
	}
	
	public boolean validatePhone(String phonenum) {
		String regex = "(0/91)?[7-9][0-9]{9}";
		return phonenum.matches(regex);	
	}
	
	public boolean validateUserName(String username) {
		boolean valid = (username != null) && username.matches("[A-Za-z0-9_]+");
		return valid;	
	}


	public boolean validatePassword(String password) {
		return password.matches("[A-Za-z0-9_]+");
	}


	public boolean validateConfirmPassword(String confirmpassword, String password) {
		boolean result = (confirmpassword != null) && (confirmpassword == password) ;
		return result;	
	}

}
