package authSystemDemo.business.abstracts;

import authSystemDemo.entities.concretes.UserForLogin;
import authSystemDemo.entities.concretes.UserForRegister;

public interface AuthService {
	
	void register(UserForRegister userForRegister);
	
	void login(UserForLogin userForLogin);
}
