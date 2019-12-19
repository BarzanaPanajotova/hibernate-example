package com.bdpanajoto.hibernate_example.repository.impl;

import com.bdpanajoto.hibernate_example.domain.Group;

import javax.persistence.EntityManager;

public class GroupRepositoryImpl extends AbstractRepository<Group> {

    public GroupRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }


    @Override
    Class<Group> getClassType() {
        return Group.class;
    }

}
