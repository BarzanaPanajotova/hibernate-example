package com.bdpanajoto.hibernate_example.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "plots")
public class Plot implements Identifiable {

	@Id
	@SequenceGenerator(name = "plot_seq", sequenceName = "plot_seq", allocationSize = 1)
	@GeneratedValue(generator = "plot_seq", strategy = GenerationType.SEQUENCE)
	private Long id;

	@Column
	private String name;

	@Column
	private String coordinates;

	@Column
	private String culture;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(String coordinates) {
		this.coordinates = coordinates;
	}

	public String getCulture() {
		return culture;
	}

	public void setCulture(String culture) {
		this.culture = culture;
	}

	@Override
	public String toString() {
		return "Plot [id=" + id + ", name=" + name + ", coordinates=" + coordinates + ", culture=" + culture + ", user="
				+ user + "]";
	}

}
