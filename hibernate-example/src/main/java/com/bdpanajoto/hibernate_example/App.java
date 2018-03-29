package com.bdpanajoto.hibernate_example;

import java.util.ArrayList;
import java.util.List;

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

		Repository<User> userRepo = new UserRepositoryImpl(entityManager);
		Repository<Group> groupRepo = new GroupRepositoryImpl(entityManager);

		try {
			tr.begin();
			User user = createUser();
			user = userRepo.create(user);

			Group group = createGroup(user);
			groupRepo.create(group);

			addGroupToUser(user, group);
			userRepo.update(user.getId(), user);
			tr.commit();

			tr.begin();
			userRepo.printAll();
			groupRepo.printAll();
			tr.commit();
		} finally {
			entityManager.close();
			HibernateUtil.closeSessionFactory();
		}
	}

	private static void addGroupToUser(User user, Group group) {
		List<Group> userGroups = new ArrayList<>();
		userGroups.add(group);
		user.setGroups(userGroups);
	}

	private static Group createGroup(User user) {
		Group group = new Group();
		group.setName("Administrators");
		group.getUsers().add(user);
		return group;
	}

	private static User createUser() {
		User user = new User();
		user.setName("Test User");
		user.setAge(18);
		user.setEmail("test@email.com");
		user.setUsername("testuser");
		user.setPassword("password".toCharArray());
		return user;
	}
}
