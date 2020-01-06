package com.metaxiii.escalade.service;

import com.metaxiii.escalade.dto.CommentaireDto;
import com.metaxiii.escalade.model.Commentaire;

public interface ICommentaireService {
    Commentaire save(CommentaireDto commentaireDto, int id);
}
