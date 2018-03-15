package com.bdpanajoto.hibernate_example.repository.impl;

import org.hibernate.Session;

import com.bdpanajoto.hibernate_example.domain.Plot;

public class PlotRepositoryImpl extends AbstractHibernateRepository<Plot> {

	public PlotRepositoryImpl(Session session) {
		super(session);
	}

	@Override
	protected void updateIfExists(Plot original, Plot desired) {
		// TODO Auto-generated method stub

	}

	@Override
	String getClassType() {
		return Plot.class.getName();
	}

}
