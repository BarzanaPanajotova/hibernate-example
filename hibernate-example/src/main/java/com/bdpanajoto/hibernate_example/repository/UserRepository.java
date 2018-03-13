package com.bdpanajoto.hibernate_example.repository;

import com.bdpanajoto.hibernate_example.domain.User;

public interface UserRepository {

	User save(User user);

	void delete(User user);
}
