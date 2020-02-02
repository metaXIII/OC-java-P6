package com.metaxiii.escalade.controller;

import com.metaxiii.escalade.enums.Message;
import com.metaxiii.escalade.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;

import java.io.Serializable;

@Slf4j
public abstract class AbstractController implements Serializable {
    private static final long serialVersionUID = -7825179903556660950L;

    protected User getUser() {
        User user;
        try {
            user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        } catch (Exception e) {
            log.error(Message.UTILISATEUR_NOT_CONNECTED.getMsg());
            user = null;
        }
        return user;
    }
}
