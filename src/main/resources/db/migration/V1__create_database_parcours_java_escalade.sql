CREATE TABLE Voies
(
    id         INT AUTO_INCREMENT NOT NULL,
    cotation   VARCHAR(2)         NOT NULL,
    secteur_id INT                NOT NULL,
    PRIMARY KEY (id)
);


CREATE TABLE Secteurs
(
    id      INT AUTO_INCREMENT NOT NULL,
    voies   TEXT               NOT NULL,
    site_id INT                NOT NULL,
    PRIMARY KEY (id)
);


CREATE TABLE Role
(
    id   INT AUTO_INCREMENT NOT NULL,
    role VARCHAR(30)        NOT NULL,
    PRIMARY KEY (id)
);


CREATE TABLE Reservation
(
    id              INT AUTO_INCREMENT NOT NULL,
    topo_id         INT                NOT NULL,
    request_user_id INT                NOT NULL,
    PRIMARY KEY (id)
);


CREATE TABLE Topo
(
    id            INT AUTO_INCREMENT   NOT NULL,
    nom           VARCHAR(255)         NOT NULL,
    description   TEXT                 NOT NULL,
    lieu          VARCHAR(200)         NOT NULL,
    date_parution DATE                 NOT NULL,
    user_id       INT                  NOT NULL,
    available     BOOLEAN DEFAULT true NOT NULL,
    PRIMARY KEY (id)
);


CREATE TABLE Commentaire
(
    id      INT AUTO_INCREMENT NOT NULL,
    content TEXT               NOT NULL,
    date    DATE               NOT NULL,
    user_id INT                NOT NULL,
    site_id INT                NOT NULL,
    PRIMARY KEY (id)
);


CREATE TABLE Code_postal
(
    id          INT AUTO_INCREMENT NOT NULL,
    departement VARCHAR(255)       NOT NULL,
    PRIMARY KEY (id)
);


CREATE TABLE User
(
    id       INT AUTO_INCREMENT NOT NULL,
    username VARCHAR(30),
    email    VARCHAR(255),
    password TEXT,
    role_id  INT DEFAULT 1      NOT NULL,
    PRIMARY KEY (id)
);


CREATE TABLE Site
(
    id             INT AUTO_INCREMENT           NOT NULL,
    pays           VARCHAR(30) DEFAULT 'FRANCE' NOT NULL,
    code_postal_id INT                          NOT NULL,
    nom_site       VARCHAR(255)                 NOT NULL,
    officiel       BOOLEAN     DEFAULT false    NOT NULL,
    secteurs       TEXT                         NOT NULL,
    PRIMARY KEY (id)
);


# INSERT DATA
INSERT into Role (role)
values ('USER');
INSERT into Role (role)
values ('ADMIN');

#USER
INSERT into user (username, email, password, role_id)
values ('admin', 'admin@admin.fr', '$2a$10$5lTgw/P5j.npHHCqgP9S6O/P.rX3qIke1/4KmohqdcpPQakSJuLxa', 2);
INSERT into user (username, email, password, role_id)
values ('aze', 'aze@aze.fr', '$2a$10$5lTgw/P5j.npHHCqgP9S6O/P.rX3qIke1/4KmohqdcpPQakSJuLxa', 1);

#codePostal
insert into Code_postal (departement)
values ('departement');

#site
insert into Site (code_postal_id, nom_site, secteurs)
VALUES (1, 'narnia', 'secteur');