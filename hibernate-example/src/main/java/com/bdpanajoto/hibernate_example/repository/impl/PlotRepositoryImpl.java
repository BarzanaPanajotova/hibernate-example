package com.bdpanajoto.hibernate_example.repository.impl;

import javax.persistence.EntityManager;

import com.bdpanajoto.hibernate_example.domain.Plot;

public class PlotRepositoryImpl extends AbstractRepository<Plot> {

	public PlotRepositoryImpl(EntityManager entityManager) {
		super(entityManager);
	}


	@Override
	Class<Plot> getClassType() {
		return Plot.class;
	}

}
