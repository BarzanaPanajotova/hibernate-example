package com.bdpanajoto.hibernate_example.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "groups")
public class Group implements Identifiable {

	@Id
	@SequenceGenerator(name = "group_seq", sequenceName = "group_seq", allocationSize = 1)
	@GeneratedValue(generator = "group_seq", strategy = GenerationType.SEQUENCE)
	private Long id;

	@Column
	private String name;

	@ManyToMany(mappedBy="groups", cascade = CascadeType.ALL)
	private List<User> users = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "Group [id=" + id + ", name=" + name + ", users=" + users + "]";
	}

}
