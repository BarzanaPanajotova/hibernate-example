package com.bdpanajoto.hibernate_example;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class App {
	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction t = session.beginTransaction();

		User te = new User();
		te.setName("test");
		session.save(te);
		t.commit();

		@SuppressWarnings("unchecked")
		Query<User> query = session.createQuery("select u from User u");
		List<User> users = query.list();
		users.forEach(x -> System.out.println(x.getId() + " " + x.getName()));

		t = session.beginTransaction();
		Group group = new Group();
		group.setName("administrator");
		group.getUsers().add(te);
		session.save(group);

		@SuppressWarnings("unchecked")
		Query<Group> query2 = session.createQuery("select u from Group u");
		List<Group> groups = query2.list();
		groups.forEach(x -> System.out.println(x.getId() + " " + x.getName()));

		session.close();
		sf.close();
	}
}
