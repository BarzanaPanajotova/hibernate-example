package com.bdpanajoto.hibernate_example.repository.impl;

import javax.persistence.EntityManager;

import com.bdpanajoto.hibernate_example.domain.Group;

public class GroupRepositoryImpl extends AbstractHibernateRepository<Group> {

	public GroupRepositoryImpl(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	protected void updateIfExists(Group original, Group desired) {
		// TODO Auto-generated method stub
		
	}

	@Override
	Class<Group> getClassType() {
		return Group.class;
	}


}
