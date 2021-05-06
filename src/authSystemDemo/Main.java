package authSystemDemo;

import authSystemDemo.business.abstracts.AuthService;
import authSystemDemo.business.abstracts.UserService;
import authSystemDemo.business.concretes.AuthManager;
import authSystemDemo.business.concretes.UserManager;
import authSystemDemo.core.GoogleAuthSystemAdapter;
import authSystemDemo.dataAccess.concretes.HibernateUserDao;
import authSystemDemo.entities.concretes.User;
import authSystemDemo.entities.concretes.UserForLogin;
import authSystemDemo.entities.concretes.UserForRegister;

public class Main {

	public static void main(String[] args) {

		UserService userService = new UserManager(new HibernateUserDao());
		User user = new User(1,"Arda Cenker", "Karagöz", "arda@arda.com", "123456");
		userService.add(user);
	
		
		UserForRegister userForRegister = new UserForRegister("Arda Cenker","Karagöz", "arda@arda.com", "123456");
		UserForLogin userForLogin = new UserForLogin("arda@arda.com", "123456");
		
		AuthService authService = new AuthManager(new UserManager(new HibernateUserDao()));
		authService.register(userForRegister);
		authService.login(userForLogin);
		
		
		AuthService googleAuthService = new GoogleAuthSystemAdapter();
		googleAuthService.register(userForRegister);		
		googleAuthService.login(userForLogin);

	}

}
