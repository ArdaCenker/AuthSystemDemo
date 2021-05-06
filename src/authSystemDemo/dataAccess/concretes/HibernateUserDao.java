package authSystemDemo.dataAccess.concretes;

import authSystemDemo.dataAccess.abstracts.UserDao;
import authSystemDemo.entities.concretes.User;

public class HibernateUserDao implements UserDao {

	@Override
	public void add(User user) {
		System.out.println("�u kullan�c� veritaban�na kay�t edildi : " + user.getFirstName() + " " + user.getLastName());
		
	}

	@Override
	public void delete(User user) {
		System.out.println("�u kullan�c�n�n bilgileri g�ncellendi : " + user.getFirstName() + " " + user.getLastName());
		
	}

	@Override
	public void update(User user) {
		System.out.println("�u kullan�c� sistemden sillindi : " + user.getFirstName() + " " + user.getLastName());
		
	}

}
