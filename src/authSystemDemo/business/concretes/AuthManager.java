package authSystemDemo.business.concretes;

import java.util.ArrayList;
import java.util.List;

import authSystemDemo.business.abstracts.AuthService;
import authSystemDemo.business.abstracts.UserService;
import authSystemDemo.core.EmailSender;
import authSystemDemo.core.EmailValidator;
import authSystemDemo.entities.concretes.User;
import authSystemDemo.entities.concretes.UserForLogin;
import authSystemDemo.entities.concretes.UserForRegister;

public class AuthManager implements AuthService{

	private UserService userService;
	
	public AuthManager(UserService userService) {
		super();
		this.userService = userService;
	}

	@Override
	public void register(UserForRegister userForRegister) {
		if (!EmailValidator.checkIfEmailValid(userForRegister.getEmail())) {
			System.out.println("Email istenen düzende yazýlmalýdýr.");
			return;
		}
		
		if(!this.checkUserExists(userForRegister.getEmail())) {
			System.out.println("Bu e-maile sahip bir hesap sistemde kayýtlý.");
		}
		
		if(!this.checkNameLength(userForRegister.getFirstName(), userForRegister.getLastName())) {
			return;
		}
		
		if(!this.checkPasswordLength(userForRegister.getPassword())) {
			return;
		}
		
		var user = new User(
				1,
				userForRegister.getFirstName(),
				userForRegister.getLastName(),
				userForRegister.getEmail(),
				userForRegister.getPassword()
				);
		
		userService.add(user);
		System.out.println("Kayýt baþarýlý.");
		
		if (EmailSender.sendEmail(user)) {
			System.out.println("Hesap doðrulamasý tamamlandý.");
		}
		
	}

	@Override
	public void login(UserForLogin userForLogin) {
		
		if (!this.checkUserExists(userForLogin.getEmail())) {
			System.out.println("Sisteme giriþ yapýldý.");			
			return;
		}
		System.out.println("E-mail sisteme kayýtlý deðil. Lütfen önce sisteme kayýt olun.");
		
	}
	
	private boolean checkNameLength(String firstName, String lastName) {
		if (firstName.length()<2 || lastName.length()<2) {
			System.out.println("Ad ve soyad en az 2 karakter uzunluðunda olmalýdýr.");
			return false;
		}
		return true;
	}
	
	private boolean checkPasswordLength(String password) {
		if (password.length()<6) {
			System.out.println("Parola minimum 6 karakter olmalýdýr.");
			return false;
		}
		return true;
	}
	
	private boolean checkUserExists(String email) {
		List<User> users = new ArrayList<User>();  
		users.add(new User(1, "Arda Cenker", "Karagöz", "arda@arda.com", "123456"));
		for(User user:users) 			
			if (user.getEmail() == email) 
				return false;
		
		return true;
	}

}
