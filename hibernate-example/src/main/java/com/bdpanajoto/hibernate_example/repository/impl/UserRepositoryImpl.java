package com.bdpanajoto.hibernate_example.repository.impl;

import javax.persistence.EntityManager;

import com.bdpanajoto.hibernate_example.domain.User;

public class UserRepositoryImpl extends AbstractRepository<User> {

	public UserRepositoryImpl(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	Class<User> getClassType() {
		return User.class;
	}
}
