package com.metaxiii.escalade.repository;

import com.metaxiii.escalade.model.Voies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VoiesRepository extends JpaRepository<Voies, Long> {
    List<Voies> findAll();
}
