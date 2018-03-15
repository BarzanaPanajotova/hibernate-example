package com.bdpanajoto.hibernate_example;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.bdpanajoto.hibernate_example.domain.User;
import com.bdpanajoto.hibernate_example.repository.Repository;
import com.bdpanajoto.hibernate_example.repository.impl.UserRepositoryImpl;

public class App {
	public static void main(String[] args) {
		EntityManager entityManager = HibernateUtil.getSessionFactory().openSession();

		EntityTransaction tr = entityManager.getTransaction();
		tr.begin();
		Repository<User> userRepo = new UserRepositoryImpl(entityManager);

		User user = new User();
		user.setName("test");
		userRepo.create(user);

		List<User> users = userRepo.findAll();
		users.forEach(System.out::println);

		tr.commit();
		entityManager.close();
		HibernateUtil.closeSessionFactory();
	}
}
