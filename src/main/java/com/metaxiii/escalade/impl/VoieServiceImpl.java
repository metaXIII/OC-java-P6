package com.metaxiii.escalade.impl;

import com.metaxiii.escalade.model.Longueur;
import com.metaxiii.escalade.model.Voie;
import com.metaxiii.escalade.repository.VoiesRepository;
import com.metaxiii.escalade.service.IVoiesService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class VoieServiceImpl implements IVoiesService {
	private final VoiesRepository voiesRepository;

	@Autowired
	private LongueurServiceImpl longueurService;

	@Override
	public List<Voie> findAllBySiteId(int id) {
		List<Voie>     voieList     = new ArrayList<>();
		List<Longueur> longueurList = longueurService.findAllBySiteId(id);
		for (Longueur longueur : longueurList) {
			voieList.addAll(voiesRepository.findAllByLongueurId(longueur.getId()));
		}
		return voieList;
	}

	@Override
	public void saveAll(List<Voie> voie) {
		voiesRepository.saveAll(voie);
	}

	@Override
	public void save(Voie voie) {
		voiesRepository.save(voie);
	}
}
