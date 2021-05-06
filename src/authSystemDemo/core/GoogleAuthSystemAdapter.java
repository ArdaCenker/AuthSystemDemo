package authSystemDemo.core;

import authSystemDemo.business.abstracts.AuthService;
import authSystemDemo.entities.concretes.UserForLogin;
import authSystemDemo.entities.concretes.UserForRegister;
import authSystemDemo.googleAuthSystem.GoogleAuthSystemManager;

public class GoogleAuthSystemAdapter implements AuthService {
	
	private GoogleAuthSystemManager manager = new GoogleAuthSystemManager();
	
	@Override
	public void register(UserForRegister userForRegister) {
		manager.register(userForRegister.getFirstName());
		
	}

	@Override
	public void login(UserForLogin userForLogin) {
		manager.register(userForLogin.getEmail());
		
	}

}
