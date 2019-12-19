package com.bdpanajoto.hibernate_example.repository;

import java.util.List;
import java.util.Optional;

public interface Repository<T> {

	T create(T element);

	List<T> findAll();

	Optional<T> findById(Long id);

	boolean update(Long id, T updated);

	void printAll();
}
