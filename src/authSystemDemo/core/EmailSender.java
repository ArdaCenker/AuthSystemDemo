package authSystemDemo.core;

import authSystemDemo.entities.concretes.User;

public class EmailSender {
	
	public static boolean sendEmail(User user) {
		System.out.println(user.getFirstName() + " adl� ki�iye e-mail g�nderildi.");
		return true;
	}
}
