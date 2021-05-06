package authSystemDemo.core;

import authSystemDemo.entities.concretes.User;

public class EmailSender {
	
	public static boolean sendEmail(User user) {
		System.out.println(user.getFirstName() + " adlý kiþiye e-mail gönderildi.");
		return true;
	}
}
