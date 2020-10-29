package com.app.hro.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.app.hro.entity.Remedy;

public interface RemedyRepo extends CrudRepository<Remedy, Long> {

	public Remedy findByName(String name);

	public List<Remedy> findByCuresDisease(String diseaseName);

	public List<Remedy> findAllByNameContainingOrCuresDiseaseContaining(String name, String curesDisease);
}
