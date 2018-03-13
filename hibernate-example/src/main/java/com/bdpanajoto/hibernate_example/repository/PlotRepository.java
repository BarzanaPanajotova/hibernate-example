package com.bdpanajoto.hibernate_example.repository;

import com.bdpanajoto.hibernate_example.domain.Plot;

public interface PlotRepository {
	Plot save(Plot user);

	void delete(Plot user);
}
