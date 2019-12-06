package com.metaxiii.escalade.repository;

import com.metaxiii.escalade.model.Topo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TopoRepository extends JpaRepository<Topo, Long> {
    List<Topo> findAll();

    Optional<Topo> findById(Long id);

    @Modifying
    @Query(value = "update topo " +
            "set available = :available " +
            "where id = :id", nativeQuery = true)
    void updateTopo(
            @Param("id") Long id,
            @Param("available") boolean available
    );
}
