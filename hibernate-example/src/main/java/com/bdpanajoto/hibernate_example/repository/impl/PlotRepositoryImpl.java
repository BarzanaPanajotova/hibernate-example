package com.bdpanajoto.hibernate_example.repository.impl;

import javax.persistence.EntityManager;

import com.bdpanajoto.hibernate_example.domain.Plot;

public class PlotRepositoryImpl extends AbstractHibernateRepository<Plot> {

	public PlotRepositoryImpl(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	protected void updateIfExists(Plot original, Plot desired) {
		// TODO Auto-generated method stub

	}

	@Override
	Class<Plot> getClassType() {
		return Plot.class;
	}

}
