CREATE TABLE Role (
                      id INT AUTO_INCREMENT NOT NULL,
                      role VARCHAR(30) NOT NULL,
                      PRIMARY KEY (id)
);


CREATE TABLE Reservation (
                             id INT AUTO_INCREMENT NOT NULL,
                             topo_id INT NOT NULL,
                             request_user_id INT NOT NULL,
                             PRIMARY KEY (id)
);


CREATE TABLE Topo (
                      id INT NOT NULL,
                      nom VARCHAR(255) NOT NULL,
                      description TEXT NOT NULL,
                      lieu VARCHAR(255) NOT NULL,
                      date_parution DATE NOT NULL,
                      user_id INT NOT NULL,
                      available BOOLEAN DEFAULT true NOT NULL,
                      PRIMARY KEY (id)
);


CREATE TABLE Commentaire (
                             id INT AUTO_INCREMENT NOT NULL,
                             content TEXT NOT NULL,
                             date DATE NOT NULL,
                             user_id INT NOT NULL,
                             site_id INT NOT NULL,
                             PRIMARY KEY (id)
);


CREATE TABLE Code_postal (
                             id INT NOT NULL,
                             departement VARCHAR(255) NOT NULL,
                             PRIMARY KEY (id)
);


CREATE TABLE User (
                      id INT NOT NULL,
                      username VARCHAR(30) NOT NULL,
                      email VARCHAR(255) NOT NULL,
                      password TEXT NOT NULL,
                      role_id INT DEFAULT 0 NOT NULL,
                      PRIMARY KEY (id)
);


CREATE TABLE Site (
                      id INT NOT NULL,
                      pays VARCHAR(255) DEFAULT 'FRANCE' NOT NULL,
                      code_postal_id VARCHAR(3) NOT NULL,
                      nom_site VARCHAR(255) NOT NULL,
                      voies INT NOT NULL,
                      cotation VARCHAR(2) NOT NULL,
                      secteurs INT NOT NULL,
                      officiel BOOLEAN DEFAULT false NOT NULL,
                      PRIMARY KEY (id)
);


ALTER TABLE User ADD CONSTRAINT role_user_fk
    FOREIGN KEY (id)
        REFERENCES Role (id)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION;

ALTER TABLE Topo ADD CONSTRAINT reservation_topo_fk
    FOREIGN KEY (id)
        REFERENCES Reservation (id)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION;

ALTER TABLE User ADD CONSTRAINT topo_user_fk
    FOREIGN KEY (id)
        REFERENCES Topo (id)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION;

ALTER TABLE Site ADD CONSTRAINT commentaire_site_fk
    FOREIGN KEY (id)
        REFERENCES Commentaire (id)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION;

ALTER TABLE Site ADD CONSTRAINT code_postal_site_fk
    FOREIGN KEY (id)
        REFERENCES Code_postal (id)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION;

ALTER TABLE Site ADD CONSTRAINT user_site_fk
    FOREIGN KEY (id)
        REFERENCES User (id)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION;