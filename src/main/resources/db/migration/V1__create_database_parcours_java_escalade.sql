CREATE TABLE Longueur
(
    id      INT AUTO_INCREMENT NOT NULL,
    site_id INT                NOT NULL,
    cotation    VARCHAR(3)         NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE Voies
(
    id          INT AUTO_INCREMENT NOT NULL,
    longueur_id INT                NOT NULL,
    cotation    VARCHAR(3)         NOT NULL,
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
    id   INT AUTO_INCREMENT NOT NULL,
    nom  VARCHAR(255)       NOT NULL,
    code VARCHAR(3)         NOT NULL,
    PRIMARY KEY (id)
);


CREATE TABLE Secteur
(
    id             INT AUTO_INCREMENT NOT NULL,
    nom            VARCHAR(30)        NOT NULL,
    departement_id VARCHAR(3)         NOT NULL,
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
    id          INT AUTO_INCREMENT    NOT NULL,
    nom         VARCHAR(255)          NOT NULL,
    description TEXT,
    secteur_id  INT                   NOT NULL,
    user_id     INT                   NOT NULL,
    officiel    BOOLEAN DEFAULT false NOT NULL,
    type        VARCHAR(40),
    latitude    VARCHAR(45),
    longitude   VARCHAR(45),
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
insert into departement(id, code, nom)
VALUES (1, '01', 'AIN'),
       (2, '02', 'AISNE'),
       (3, '03', 'Allier'),
       (5, '05', 'Hautes-Alpes'),
       (4, '04', 'Alpes-de-Haute-Provence'),
       (6, '06', 'Alpes-Maritimes'),
       (7, '07', 'Ardèche'),
       (8, '08', 'Ardennes'),
       (9, '09', 'Ariège'),
       (10, '10', 'Aube'),
       (11, '11', 'Aude'),
       (12, '12', 'Aveyron'),
       (13, '13', 'Bouches-du-Rhône'),
       (14, '14', 'Calvados'),
       (15, '15', 'Cantal'),
       (16, '16', 'Charente'),
       (17, '17', 'Charente-Maritime'),
       (18, '18', 'Cher'),
       (19, '19', 'Corrèze'),
       (20, '2a', 'Corse-du-sud'),
       (21, '2b', 'Haute-corse'),
       (22, '21', 'Côte-d''or'),
       (23, '22', 'Côtes-d''armor'),
       (24, '23', 'Creuse'),
       (25, '24', 'Dordogne'),
       (26, '25', 'Doubs'),
       (27, '26', 'Drôme'),
       (28, '27', 'Eure'),
       (29, '28', 'Eure-et-Loir'),
       (30, '29', 'Finistère'),
       (31, '30', 'Gard'),
       (32, '31', 'Haute-Garonne'),
       (33, '32', 'Gers'),
       (34, '33', 'Gironde'),
       (35, '34', 'Hérault'),
       (36, '35', 'Ile-et-Vilaine'),
       (37, '36', 'Indre'),
       (38, '37', 'Indre-et-Loire'),
       (39, '38', 'Isère'),
       (40, '39', 'Jura'),
       (41, '40', 'Landes'),
       (42, '41', 'Loir-et-Cher'),
       (43, '42', 'Loire'),
       (44, '43', 'Haute-Loire'),
       (45, '44', 'Loire-Atlantique'),
       (46, '45', 'Loiret'),
       (47, '46', 'Lot'),
       (48, '47', 'Lot-et-Garonne'),
       (49, '48', 'Lozère'),
       (50, '49', 'Maine-et-Loire'),
       (51, '50', 'Manche'),
       (52, '51', 'Marne'),
       (53, '52', 'Haute-Marne'),
       (54, '53', 'Mayenne'),
       (55, '54', 'Meurthe-et-Moselle'),
       (56, '55', 'Meuse'),
       (57, '56', 'Morbihan'),
       (58, '57', 'Moselle'),
       (59, '58', 'Nièvre'),
       (60, '59', 'Nord'),
       (61, '60', 'Oise'),
       (62, '61', 'Orne'),
       (63, '62', 'Pas-de-Calais'),
       (64, '63', 'Puy-de-Dôme'),
       (65, '64', 'Pyrénées-Atlantiques'),
       (66, '65', 'Hautes-Pyrénées'),
       (67, '66', 'Pyrénées-Orientales'),
       (68, '67', 'Bas-Rhin'),
       (69, '68', 'Haut-Rhin'),
       (70, '69', 'Rhône'),
       (71, '70', 'Haute-Saône'),
       (72, '71', 'Saône-et-Loire'),
       (73, '72', 'Sarthe'),
       (74, '73', 'Savoie'),
       (75, '74', 'Haute-Savoie'),
       (76, '75', 'Paris'),
       (77, '76', 'Seine-Maritime'),
       (78, '77', 'Seine-et-Marne'),
       (79, '78', 'Yvelines'),
       (80, '79', 'Deux-Sèvres'),
       (81, '80', 'Somme'),
       (82, '81', 'Tarn'),
       (83, '82', 'Tarn-et-Garonne'),
       (84, '83', 'Var'),
       (85, '84', 'Vaucluse'),
       (86, '85', 'Vendée'),
       (87, '86', 'Vienne'),
       (88, '87', 'Haute-Vienne'),
       (89, '88', 'Vosges'),
       (90, '89', 'Yonne'),
       (91, '90', 'Territoire de Belfort'),
       (92, '91', 'Essonne'),
       (93, '92', 'Hauts-de-Seine'),
       (94, '93', 'Seine-Saint-Denis'),
       (95, '94', 'Val-de-Marne'),
       (96, '95', 'Val-d''oise'),
       (97, '976', 'Mayotte'),
       (98, '971', 'Guadeloupe'),
       (99, '973', 'Guyane'),
       (100, '972', 'Martinique'),
       (101, '974', 'Réunion');

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