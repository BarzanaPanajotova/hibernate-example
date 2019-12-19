package com.bdpanajoto.hibernate_example;

import com.bdpanajoto.hibernate_example.domain.Group;
import com.bdpanajoto.hibernate_example.domain.User;
import com.bdpanajoto.hibernate_example.repository.Repository;
import com.bdpanajoto.hibernate_example.repository.impl.GroupRepositoryImpl;
import com.bdpanajoto.hibernate_example.repository.impl.UserRepositoryImpl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.transaction.UserTransaction;

public class App {
	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("com.bdpanajoto.hibernate_example.JPAPersistence");

		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Repository<User> userRepo = new UserRepositoryImpl(entityManager);
		Repository<Group> groupRepo = new GroupRepositoryImpl(entityManager);

		try {

			User user = createUser();
			Group group = createGroup();

			entityTransaction.begin();
			user = userRepo.create(user);
			group = groupRepo.create(group);
			/* Two way association */
			group.getUsers().add(user);
			user.getGroups().add(group);

			entityTransaction.commit();

			userRepo.printAll();
			groupRepo.printAll();

		} finally {
			entityManager.close();
			entityManagerFactory.close();
		}
	}

	private static Group createGroup() {
		Group group = new Group();
		group.setName("Administrators");
		return group;
	}

	private static User createUser() {
		User user = new User();
		user.setName("Name");
		user.setAge(18);
		user.setEmail("e-mail");
		user.setUsername("Username");
		user.setPassword("Password".toCharArray());
		return user;
	}
}
