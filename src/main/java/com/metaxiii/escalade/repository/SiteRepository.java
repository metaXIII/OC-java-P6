package com.metaxiii.escalade.repository;

import com.metaxiii.escalade.model.Site;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface SiteRepository extends JpaRepository<Site, Long> {
    List<Site> findAll();

    Set<Site> findAllBySecteur(int secteur);

    @Query(value = "SELECT * " +
            "FROM site " +
            "INNER JOIN secteur on site.secteur_id = secteur.id " +
            "WHERE secteur.departement_id LIKE ?1", nativeQuery = true)
    Set<Site> findAllByDepartement(int departement);

    Set<Site> findAllByType(String type);

    Set<Site> findAllByOfficiel(boolean officiel);

    Set<Site> findAllByPays(String pays);

    @Query(value = "select distinct Site.type from Site", nativeQuery = true)
    Set<String> findType();
}
