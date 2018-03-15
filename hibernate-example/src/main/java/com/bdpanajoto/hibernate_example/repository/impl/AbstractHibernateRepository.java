package com.bdpanajoto.hibernate_example.repository.impl;

import java.util.List;
import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.bdpanajoto.hibernate_example.domain.Identifiable;
import com.bdpanajoto.hibernate_example.repository.Repository;

public abstract class AbstractHibernateRepository<T extends Identifiable> implements Repository<T> {

	private Session session;

	public AbstractHibernateRepository(Session session) {
		this.session = session;
	}

	@Override
	public T create(T element) {
		Transaction transaction = session.beginTransaction();
		session.save(element);
		transaction.commit();
		return element;
	}

	@Override
	public boolean delete(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<T> findAll() {
		@SuppressWarnings("unchecked")
		Query<T> query2 = session.createQuery("select u from " + getClassType() + " u");
		
		List<T> list = query2.list();
		return list;
	}

	abstract String getClassType();

	@Override
	public Optional<T> findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean update(Long id, T updated) {
		// TODO Auto-generated method stub
		return false;
	}

	protected abstract void updateIfExists(T original, T desired);
}
