package com.app.hro.service;

import java.util.List;

import com.app.hro.entity.Remedy;

public interface RemedyService {

	public List<Remedy> getAllRemedies();

	public Remedy getRemedyByName(String name);

	public List<Remedy> getRemediesForDisease(String diseaseName);
	
	public Remedy upsertRemedy(Remedy remedy);
	
	public List<Remedy> search(String query);
}
