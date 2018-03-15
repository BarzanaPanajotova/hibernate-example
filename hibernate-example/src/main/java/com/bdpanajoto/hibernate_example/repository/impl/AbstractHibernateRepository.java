package com.bdpanajoto.hibernate_example.repository.impl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import com.bdpanajoto.hibernate_example.domain.Identifiable;
import com.bdpanajoto.hibernate_example.repository.Repository;

public abstract class AbstractHibernateRepository<T extends Identifiable> implements Repository<T> {

	private EntityManager entityManager;

	public AbstractHibernateRepository(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public T create(T element) {
		entityManager.persist(element);
		return element;
	}

	@Override
	public boolean delete(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<T> findAll() {
		javax.persistence.Query query2 = entityManager.createQuery("select u from " + getClassType() + " u");

		@SuppressWarnings("unchecked")
		List<T> list = query2.getResultList();
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
