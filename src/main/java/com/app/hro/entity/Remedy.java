package com.app.hro.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "remedy")
public class Remedy {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column
	private String name;

	@Column
	private String curesDisease;

	@Column
	private String description;

	@Column
	private long cost;

	public Remedy() {

	}

	public Remedy(String name, String curesDisease, String description, long cost) {
		this.name = name;
		this.curesDisease = curesDisease;
		this.description = description;
		this.cost = cost;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCuresDisease() {
		return curesDisease;
	}

	public void setCuresDisease(String curesDisease) {
		this.curesDisease = curesDisease;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public long getCost() {
		return cost;
	}

	public void setCost(long cost) {
		this.cost = cost;
	}

	@Override
	public String toString() {
		return "Remedy [id=" + id + ", name=" + name + ", curesDisease=" + curesDisease + ", description=" + description
				+ ", cost=" + cost + "]";
	}

}
