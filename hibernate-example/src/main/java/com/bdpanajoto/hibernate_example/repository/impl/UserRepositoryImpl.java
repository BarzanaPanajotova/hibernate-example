package com.bdpanajoto.hibernate_example.repository.impl;

import javax.persistence.EntityManager;

import com.bdpanajoto.hibernate_example.domain.User;

public class UserRepositoryImpl extends AbstractHibernateRepository<User> {

	public UserRepositoryImpl(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	protected void updateIfExists(User original, User desired) {
		// TODO Auto-generated method stub

	}

	@Override
	String getClassType() {
		return User.class.getName();
	}

}
