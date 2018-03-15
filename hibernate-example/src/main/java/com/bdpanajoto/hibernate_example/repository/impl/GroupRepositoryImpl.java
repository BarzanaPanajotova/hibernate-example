package com.bdpanajoto.hibernate_example.repository.impl;

import org.hibernate.Session;

import com.bdpanajoto.hibernate_example.domain.Group;

public class GroupRepositoryImpl extends AbstractHibernateRepository<Group> {

	public GroupRepositoryImpl(Session session) {
		super(session);
	}

	@Override
	protected void updateIfExists(Group original, Group desired) {
		// TODO Auto-generated method stub
		
	}

	@Override
	String getClassType() {
		return Group.class.getName();
	}


}
