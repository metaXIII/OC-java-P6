package com.metaxiii.escalade.impl;

import com.metaxiii.escalade.dto.CommentaireDto;
import com.metaxiii.escalade.model.Commentaire;
import com.metaxiii.escalade.repository.CommentaireRepository;
import com.metaxiii.escalade.service.ICommentaireService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class CommentaireServiceImpl implements ICommentaireService {
    private final CommentaireRepository commentaireRepository;

    @Override
    public Commentaire save(CommentaireDto commentaireDto, int id) {
        Commentaire commentaire = new Commentaire();
        commentaire.setSiteId(id);
        commentaire.setContent(commentaireDto.getContent());
        commentaire.setUserId(1);
        return commentaireRepository.save(commentaire);
    }
}
