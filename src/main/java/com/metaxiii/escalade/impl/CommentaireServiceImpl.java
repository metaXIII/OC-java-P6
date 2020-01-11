package com.metaxiii.escalade.impl;

import com.metaxiii.escalade.dto.CommentaireDto;
import com.metaxiii.escalade.model.Commentaire;
import com.metaxiii.escalade.model.User;
import com.metaxiii.escalade.repository.CommentaireRepository;
import com.metaxiii.escalade.service.ICommentaireService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class CommentaireServiceImpl implements ICommentaireService {
    private final CommentaireRepository commentaireRepository;

    @Override
    public Commentaire save(CommentaireDto commentaireDto, int id) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Commentaire commentaire = new Commentaire();
        commentaire.setSiteId(id);
        commentaire.setContent(commentaireDto.getContent());
        commentaire.setDate(new Date());
        commentaire.setUsername(user.getUsername());
        commentaire.setUserId(user.getId());
        return commentaireRepository.save(commentaire);
    }

    @Override
    public List<Commentaire> findAllBySiteId(int id) {
        return commentaireRepository.findAllBySiteIdOrderByDateDesc(id);
    }

    @Override
    public Commentaire edit(CommentaireDto commentaireDto) {
        Optional<Commentaire> commentaire = commentaireRepository.findById((long) commentaireDto.getId());
        if (commentaire.isPresent()) {
            if (commentaire.get().getContent().equals(commentaireDto.getContent())) {
                return commentaire.get();
            } else {
                commentaire.get().setDate(new Date());
                commentaire.get().setContent(commentaireDto.getContent());
            }
            return commentaireRepository.save(commentaire.get());
        }
        return null;
    }

    @Override
    public Optional<Commentaire> findById(long id) {
        return commentaireRepository.findById(id);
    }

    @Override
    public void deleteById(long id) {
        commentaireRepository.deleteById(id);
    }
}
