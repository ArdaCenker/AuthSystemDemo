package authSystemDemo.core;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidator {
	
	public static boolean checkIfEmailValid(String email) {
		
		String form = "^(.+)@(.+)$";
		Pattern pattern = Pattern.compile(form);
		Matcher matcher = pattern.matcher(email);
		
		return matcher.matches();
	}
}
