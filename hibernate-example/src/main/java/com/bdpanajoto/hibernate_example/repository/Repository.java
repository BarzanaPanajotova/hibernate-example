package com.bdpanajoto.hibernate_example.repository;

public interface Repository<T> {
	
	T save(T element);

	void delete(T element);
}
