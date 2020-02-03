package com.metaxiii.escalade.repository;

import com.metaxiii.escalade.model.Secteur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SecteurRepository extends JpaRepository<Secteur, Long> {
    List<Secteur> findAll();

    Optional<Secteur> findById(int id);

    Optional<Secteur> findByNom(String name);
}
