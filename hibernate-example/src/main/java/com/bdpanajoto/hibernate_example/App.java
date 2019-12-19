package com.bdpanajoto.hibernate_example;

import com.bdpanajoto.hibernate_example.domain.Group;
import com.bdpanajoto.hibernate_example.domain.User;
import com.bdpanajoto.hibernate_example.repository.Repository;
import com.bdpanajoto.hibernate_example.repository.impl.GroupRepositoryImpl;
import com.bdpanajoto.hibernate_example.repository.impl.UserRepositoryImpl;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class App {
	public static void main(String[] args) throws InterruptedException {

		EntityManager entityManager = HibernateUtil.getSessionFactory().openSession();

		EntityTransaction tr = entityManager.getTransaction();

		Repository<User> userRepo = new UserRepositoryImpl(entityManager);
		Repository<Group> groupRepo = new GroupRepositoryImpl(entityManager);

		try {

			User user = createUser();
			Group group = createGroup();

			tr.begin();
			user = userRepo.create(user);
			group = groupRepo.create(group);
			tr.commit();
			tr.begin();
			/* Two way association */
			group.getUsers().add(user);
			user.getGroups().add(group);

			userRepo.update(user.getId(), user);
			tr.commit();

			userRepo.printAll();
			groupRepo.printAll();

		} finally {
			entityManager.close();
			HibernateUtil.closeSessionFactory();
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
