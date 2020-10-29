package com.app.hro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.hro.entity.Remedy;
import com.app.hro.repo.RemedyRepo;

@Service
public class RemedyServiceImpl implements RemedyService {

	@Autowired
	RemedyRepo remedyRepo;

	@Override
	public List<Remedy> getAllRemedies() {
		List<Remedy> _remedy = (List<Remedy>) remedyRepo.findAll();
		return _remedy;
	}

	@Override
	public Remedy getRemedyByName(String name) {
		Remedy _remedy = remedyRepo.findByName(name);
		return _remedy;
	}

	@Override
	public List<Remedy> getRemediesForDisease(String diseaseName) {
		List<Remedy> _remedy = remedyRepo.findByCuresDisease(diseaseName);
		return _remedy;
	}

	@Override
	public Remedy upsertRemedy(Remedy remedy) {
		Remedy _remedy = remedyRepo.save(remedy);
		return _remedy;
	}

	@Override
	public List<Remedy> search(String query) {
		List<Remedy> _remedies = remedyRepo.findAllByNameContainingOrCuresDiseaseContaining(query, query);
		return _remedies;
	}

}
