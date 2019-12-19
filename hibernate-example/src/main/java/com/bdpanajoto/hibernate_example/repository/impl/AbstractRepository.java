package com.bdpanajoto.hibernate_example.repository.impl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.bdpanajoto.hibernate_example.domain.Identifiable;
import com.bdpanajoto.hibernate_example.repository.Repository;

public abstract class AbstractRepository<T extends Identifiable> implements Repository<T> {

	private EntityManager entityManager;

	AbstractRepository(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public T create(T element) {
		return entityManager.merge(element);
	}

	@Override
	public List<T> findAll() {
		Query query = entityManager.createQuery("select u from " + getClassType().getName() + " u");
		return query.getResultList();
	}

	abstract Class<T> getClassType();

	@Override
	public Optional<T> findById(Long id) {
		return Optional.ofNullable(entityManager.find(getClassType(), id));
	}

	@Override
	public boolean update(Long id, T updated) {
		entityManager.merge(updated);
		return false;
	}

	@Override
	public void printAll() {
		findAll().forEach(System.out::println);
	}
}
