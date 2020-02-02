package com.metaxiii.escalade.repository;

import com.metaxiii.escalade.model.Longueur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LongueurRepository extends JpaRepository<Longueur, Long> {
	List<Longueur> findAllBySiteId(int id);
}
