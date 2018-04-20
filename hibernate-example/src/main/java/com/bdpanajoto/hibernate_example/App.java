package com.bdpanajoto.hibernate_example;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.beryx.textio.InputReader.ValueChecker;
import org.beryx.textio.TextIO;
import org.beryx.textio.TextIoFactory;

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
			
			User user = createUser();
			tr.begin();
			user = userRepo.create(user);

			Group group = createGroup(user);
			groupRepo.create(group);

			addGroupToUser(user, group);
			userRepo.update(user.getId(), user);
			tr.commit();

			
			userRepo.printAll();
			groupRepo.printAll();
			
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
		TextIO textIO = TextIoFactory.getTextIO();

		User user = new User();
		user.setName(textIO.newStringInputReader().read("Name"));
		user.setAge(textIO.newIntInputReader().withMinVal(18).read("Age"));
		ValueChecker<String> emaiChecker = (email, name) -> {
			List<String> validationErrors = new ArrayList<>();
			if (!email.contains("@"))
				validationErrors.add("This is not a valid e-mail!");
			return validationErrors;
		};
		user.setEmail(textIO.newStringInputReader().withValueChecker(emaiChecker).read("e-mail"));
		user.setUsername(textIO.newStringInputReader().read("Username"));
		user.setPassword(
				textIO.newStringInputReader().withMinLength(6).withInputMasking(true).read("Password").toCharArray());
		textIO.dispose();

		return user;
	}
}
