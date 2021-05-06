package authSystemDemo.dataAccess.concretes;

import authSystemDemo.dataAccess.abstracts.UserDao;
import authSystemDemo.entities.concretes.User;

public class HibernateUserDao implements UserDao {

	@Override
	public void add(User user) {
		System.out.println("Þu kullanýcý veritabanýna kayýt edildi : " + user.getFirstName() + " " + user.getLastName());
		
	}

	@Override
	public void delete(User user) {
		System.out.println("Þu kullanýcýnýn bilgileri güncellendi : " + user.getFirstName() + " " + user.getLastName());
		
	}

	@Override
	public void update(User user) {
		System.out.println("Þu kullanýcý sistemden sillindi : " + user.getFirstName() + " " + user.getLastName());
		
	}

}
