package com.metaxiii.escalade.repository;

import com.metaxiii.escalade.model.Topo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TopoRepository extends JpaRepository<Topo, Long> {
    List<Topo> findAll();

    Optional<Topo> findById(long id);

    List<Topo> findAllByUserId(long id);
}
