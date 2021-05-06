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
			System.out.println("Email istenen d�zende yaz�lmal�d�r.");
			return;
		}
		
		if(!this.checkUserExists(userForRegister.getEmail())) {
			System.out.println("Bu e-maile sahip bir hesap sistemde kay�tl�.");
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
		System.out.println("Kay�t ba�ar�l�.");
		
		if (EmailSender.sendEmail(user)) {
			System.out.println("Hesap do�rulamas� tamamland�.");
		}
		
	}

	@Override
	public void login(UserForLogin userForLogin) {
		
		if (!this.checkUserExists(userForLogin.getEmail())) {
			System.out.println("Sisteme giri� yap�ld�.");			
			return;
		}
		System.out.println("E-mail sisteme kay�tl� de�il. L�tfen �nce sisteme kay�t olun.");
		
	}
	
	private boolean checkNameLength(String firstName, String lastName) {
		if (firstName.length()<2 || lastName.length()<2) {
			System.out.println("Ad ve soyad en az 2 karakter uzunlu�unda olmal�d�r.");
			return false;
		}
		return true;
	}
	
	private boolean checkPasswordLength(String password) {
		if (password.length()<6) {
			System.out.println("Parola minimum 6 karakter olmal�d�r.");
			return false;
		}
		return true;
	}
	
	private boolean checkUserExists(String email) {
		List<User> users = new ArrayList<User>();  
		users.add(new User(1, "Arda Cenker", "Karag�z", "arda@arda.com", "123456"));
		for(User user:users) 			
			if (user.getEmail() == email) 
				return false;
		
		return true;
	}

}
