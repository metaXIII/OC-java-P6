package com.metaxiii.escalade.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table (name = "user")
public class User {
    @Getter
    @Setter
    @Id
    @Column (name = "id")
    private long id;

    @Getter
    @Setter
    @Column (name = "username")
    private String username;

    @Getter
    @Setter
    @Column (name = "email")
    private String email;

    @Getter
    @Setter
    @Column (name = "password")
    private String password;

    @Getter
    @Setter
    @Column (name = "role_id")
    private String role;
}
