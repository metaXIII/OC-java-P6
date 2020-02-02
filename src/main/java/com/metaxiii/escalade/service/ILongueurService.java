package com.metaxiii.escalade.service;

import com.metaxiii.escalade.dto.LongueurDto;
import com.metaxiii.escalade.model.Longueur;

import java.util.List;

public interface ILongueurService {
	List<Longueur> findAllBySiteId(int id);

	void saveLongueur(LongueurDto longueurDto, int id);
}
