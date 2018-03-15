package com.bdpanajoto.hibernate_example;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.bdpanajoto.hibernate_example.domain.User;
import com.bdpanajoto.hibernate_example.repository.Repository;
import com.bdpanajoto.hibernate_example.repository.impl.UserRepositoryImpl;

public class App {
	public static void main(String[] args) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();

		Repository<User> userRepo = new UserRepositoryImpl(session);

		User user = new User();
		user.setName("test");
		userRepo.create(user);

		List<User> users = userRepo.findAll();
		users.forEach(System.out::println);

		session.close();
		sf.close();
	}
}
