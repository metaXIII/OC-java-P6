package com.metaxiii.escalade.service;

import com.metaxiii.escalade.dto.CommentaireDto;
import com.metaxiii.escalade.model.Commentaire;

import java.util.List;

public interface ICommentaireService {
    Commentaire save(CommentaireDto commentaireDto, int id);

    List<Commentaire> findAllBySiteId(int id);
}
