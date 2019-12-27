package com.metaxiii.escalade.repository;

import com.metaxiii.escalade.model.Site;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface SiteRepository extends JpaRepository<Site, Long> {
    List<Site> findAll();

    Optional<Site> findById(int id);

    Set<Site> findAllBySecteur(int secteur);

    Set<Site> findAllByType(String type);

    Set<Site> findAllByOfficiel(boolean officiel);

    @Query(value = "select * " +
            "from Site " +
            "INNER join Secteur s on Site.secteur_id = s.id " +
            "where secteur_id like ?1 " +
            "and departement_id like ?2 " +
            "and type like ?3 " +
            "and officiel like ?4", nativeQuery = true)
    Set<Site> findAllByParam(String secteur, String departement, String type, String officiel);

    @Query(value = "SELECT * " +
            "FROM Site " +
            "INNER JOIN Secteur s on Site.secteur_id = s.id " +
            "WHERE s.departement_id LIKE ?1", nativeQuery = true)
    Set<Site> findAllByDepartement(int departement);

    @Query(value = "select distinct Site.type from Site", nativeQuery = true)
    Set<String> findType();
}
