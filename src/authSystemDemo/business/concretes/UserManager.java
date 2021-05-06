package authSystemDemo.business.concretes;

import authSystemDemo.business.abstracts.UserService;
import authSystemDemo.dataAccess.abstracts.UserDao;
import authSystemDemo.entities.concretes.User;

public class UserManager implements UserService {

	private UserDao userDao;
	
	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public void add(User user) {
		this.userDao.add(user);
		
	}

	@Override
	public void update(User user) {
		this.userDao.update(user);
		
	}

	@Override
	public void delete(User user) {
		this.userDao.delete(user);
		
	}
}
