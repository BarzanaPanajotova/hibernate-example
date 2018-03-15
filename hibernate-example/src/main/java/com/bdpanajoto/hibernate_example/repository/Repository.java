package com.bdpanajoto.hibernate_example.repository;

import java.util.List;
import java.util.Optional;

public interface Repository<T> {

	T create(T element);

	boolean delete(Long id);

	List<T> findAll();

	Optional<T> findById(Long id);

	int getCount();

	void clear();

	boolean update(Long id, T updated);
}
