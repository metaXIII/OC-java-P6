package com.metaxiii.escalade.controller;

import com.metaxiii.escalade.enums.Message;
import com.metaxiii.escalade.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;

import java.io.Serializable;

abstract class AbstractController implements Serializable {
    private static final long   serialVersionUID = -7825179903556660950L;
    private transient    Logger logger           = LoggerFactory.getLogger(AbstractController.class);

    protected User getUser() {
        User user;
        try {
            user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        } catch (Exception e) {
            logger.error(Message.UTILISATEUR_NOT_CONNECTED.getMsg());
            return null;
        }
        return user;
    }
}
