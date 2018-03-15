package com.bdpanajoto.hibernate_example;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.bdpanajoto.hibernate_example.domain.Group;
import com.bdpanajoto.hibernate_example.domain.User;
import com.bdpanajoto.hibernate_example.repository.Repository;
import com.bdpanajoto.hibernate_example.repository.impl.GroupRepositoryImpl;
import com.bdpanajoto.hibernate_example.repository.impl.UserRepositoryImpl;

public class App {
	public static void main(String[] args) throws InterruptedException {
		EntityManager entityManager = HibernateUtil.getSessionFactory().openSession();

		EntityTransaction tr = entityManager.getTransaction();
		tr.begin();
		Repository<User> userRepo = new UserRepositoryImpl(entityManager);
		Repository<Group> groupRepo = new GroupRepositoryImpl(entityManager);

		User user = new User();
		user.setName("Test User");
		user.setAge(18);
		user.setEmail("test@email.com");
		user.setUsername("testuser");
		user.setPassword("password".toCharArray());
		user = userRepo.create(user);
		tr.commit();
		tr.begin();
		Group group = new Group();
		group.setName("Administrators");
		group.getUsers().add(user);
		groupRepo.create(group);
		tr.commit();
		tr.begin();
		List<Group> userGroups = new ArrayList<>();
		userGroups.add(group);
		user.setGroups(userGroups);

		userRepo.update(user.getId(), user);
		tr.commit();

		tr.begin();
		System.out.println("PRINT ALL USERS");
		List<User> users = userRepo.findAll();
		users.forEach(System.out::println);
		System.out.println("PRINT ALL GROUPS");
		List<Group> groups = groupRepo.findAll();
		groups.forEach(System.out::println);

		System.out.println("PRINT ALL USER GROUPS");
		users.forEach(x -> x.getGroups().forEach(System.out::println));

		tr.commit();
		entityManager.close();
		HibernateUtil.closeSessionFactory();
	}
}
