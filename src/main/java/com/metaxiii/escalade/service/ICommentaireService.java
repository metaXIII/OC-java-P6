package com.metaxiii.escalade.service;

import com.metaxiii.escalade.dto.CommentaireDto;
import com.metaxiii.escalade.model.Commentaire;

import java.util.List;
import java.util.Optional;

public interface ICommentaireService {
	Commentaire save(CommentaireDto commentaireDto, int id);

	Commentaire edit(CommentaireDto commentaireDto);

	List<Commentaire> findAllBySiteId(int id);

	Optional<Commentaire> findById(long id);

	void deleteById(long id);
}
