package com.metaxiii.escalade.repository;

import com.metaxiii.escalade.model.Commentaire;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentaireRepository extends JpaRepository<Commentaire, Long> {
    List<Commentaire> findAllBySiteIdOrderByDateDesc(int id);
}
