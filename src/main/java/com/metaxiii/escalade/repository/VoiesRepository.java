package com.metaxiii.escalade.repository;

import com.metaxiii.escalade.model.Voie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VoiesRepository extends JpaRepository<Voie, Long> {
	List<Voie> findAllByLongueurId(int id);
}
