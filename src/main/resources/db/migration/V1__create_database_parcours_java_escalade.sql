CREATE TABLE Voies
(
    id          INT AUTO_INCREMENT NOT NULL,
    cotation    VARCHAR(2)         NOT NULL,
    longueur_id INT                NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE Longueur
(
    id       INT AUTO_INCREMENT NOT NULL,
    site_id  INT                NOT NULL,
    cotation VARCHAR(3)         NOT NULL,
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
    id            INT AUTO_INCREMENT                 NOT NULL,
    nom           VARCHAR(255)                       NOT NULL,
    description   TEXT                               NOT NULL,
    lieu          VARCHAR(255)                       NOT NULL,
    date_parution DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL,
    user_id       INT                                NOT NULL,
    available     BOOLEAN  DEFAULT true              NOT NULL,
    PRIMARY KEY (id)
);


CREATE TABLE Commentaire
(
    id      INT AUTO_INCREMENT                 NOT NULL,
    content TEXT                               NOT NULL,
    date    DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL,
    user_id INT                                NOT NULL,
    site_id INT                                NOT NULL,
    PRIMARY KEY (id)
);


CREATE TABLE Departement
(
    id  INT          NOT NULL,
    nom VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);


CREATE TABLE Secteur
(
    id             INT AUTO_INCREMENT NOT NULL,
    nom            VARCHAR(30)        NOT NULL,
    departement_id INT                NOT NULL,
    PRIMARY KEY (id)
);


CREATE TABLE User
(
    id       INT AUTO_INCREMENT NOT NULL,
    username VARCHAR(30)        NOT NULL,
    email    VARCHAR(255)       NOT NULL,
    password TEXT               NOT NULL,
    role_id  INT DEFAULT 0      NOT NULL,
    PRIMARY KEY (id)
);


CREATE TABLE Site
(
    id         INT AUTO_INCREMENT            NOT NULL,
    pays       VARCHAR(255) DEFAULT 'FRANCE' NOT NULL,
    nom        VARCHAR(255)                  NOT NULL,
    secteur_id INT                           NOT NULL,
    user_id    INT                           NOT NULL,
    officiel   BOOLEAN      DEFAULT false    NOT NULL,
    type       VARCHAR(40),
    latitude   VARCHAR(45),
    longitude  VARCHAR(45),
    PRIMARY KEY (id)
);


# INSERT DATA
INSERT into Role (role)
values ('USER');
INSERT into Role (role)
values ('ADMIN');

# USER
INSERT into user (username, email, password, role_id)
values ('admin', 'admin@admin.fr', '$2a$10$5lTgw/P5j.npHHCqgP9S6O/P.rX3qIke1/4KmohqdcpPQakSJuLxa', 2);
INSERT into user (username, email, password, role_id)
values ('aze', 'aze@aze.fr', '$2a$10$5lTgw/P5j.npHHCqgP9S6O/P.rX3qIke1/4KmohqdcpPQakSJuLxa', 1);

# #site
insert into site(nom, secteur_id, type, user_id)
values ('Narnia', 1, 'Falaise', 1);

insert into Site(nom, secteur_id, type, officiel, user_id)
values ('Poudlard', 2, 'bloc', 1, 1);

insert into site (nom, secteur_id, type, officiel, user_id)
values ('DisneyLand', 1, 'Magic', 1, 1);

# Departement
insert into departement(id, nom)
values (77, 'Seine et marne');

insert into departement(id, nom)
values (56, 'Morbihan');

#secteur
insert into secteur(nom, departement_id)
VALUES ('DC Universe', 77);

insert into secteur(nom, departement_id)
VALUES ('Other', 56);

#topo
insert into topo(`id`, `nom`, `description`, `lieu`, `date_parution`, `user_id`, `available`)
VALUES (null, 'nom', 'description', 'lieu', '2019-12-05 15:25:37', 1, DEFAULT);

insert into topo(`id`, `nom`, `description`, `lieu`, `date_parution`, `user_id`, `available`)
VALUES (null, 'nom2', 'description', 'lieu', '2019-12-06 15:25:37', 1, false);

insert into topo(`id`, `nom`, `description`, `lieu`, `date_parution`, `user_id`, `available`)
VALUES (null, 'nom3', 'description', 'lieu', '2019-12-07 15:25:37', 1, false);