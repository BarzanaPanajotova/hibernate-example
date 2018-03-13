package com.bdpanajoto.hibernate_example.repository;

import com.bdpanajoto.hibernate_example.domain.Group;

public interface GroupRepository {
	Group save(Group user);

	void delete(Group user);
}
