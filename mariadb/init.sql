CREATE DATABASE potpotpotzh_database;
GRANT ALL PRIVILEGES ON potpotpotzh_database.* to 'potpotpotzh_user';

CREATE TABLE potpotpotzh_database.uticel (
    uticel_id int NOT NULL PRIMARY KEY AUTO_INCREMENT,
    nev varchar(255),
    tipus varchar(100),
    leiras varchar(255),
    orszag varchar(100)
);


CREATE TABLE potpotpotzh_database.felhasznalo (
                      azonosito int NOT NULL PRIMARY KEY AUTO_INCREMENT,
                      felhasznalonev varchar(255) NOT NULL UNIQUE,
                      jelszo varchar(100) NOT NULL
);

CREATE TABLE potpotpotzh_database.szerepkor (
                      azonosito int NOT NULL PRIMARY KEY AUTO_INCREMENT,
                      kod varchar(255) NOT NULL UNIQUE,
                      leiras varchar(255)
);

create table potpotpotzh_database.felhasznalo_szerepkor (
                           felhasznalo_azonosito int,
                           szerepkor_azonosito int,
                           PRIMARY KEY (felhasznalo_azonosito, szerepkor_azonosito),
                           FOREIGN KEY (felhasznalo_azonosito) REFERENCES felhasznalo(azonosito),
                           FOREIGN KEY (szerepkor_azonosito) REFERENCES szerepkor(azonosito)
);

insert into potpotpotzh_database.uticel (uticel_id, nev, tipus, leiras, orszag) values (1, "Párizs", "város", "A szerelem városa, híres az Eiffel-toronyról és a Louvre-ról.", "Franciaország");
insert into potpotpotzh_database.uticel (uticel_id, nev, tipus, leiras, orszag) values (2, "Bali", "sziget", "Trópusi paradicsom, ismert strandjairól és hindu templomairól.", "Indonézia");
insert into potpotpotzh_database.uticel (uticel_id, nev, tipus, leiras, orszag) values (3, "Machu Picchu", "történelmi helyszín", "Ősi inka romváros a perui Andokban, lélegzetelállító látvánnyal.", "Peru");
insert into potpotpotzh_database.uticel (uticel_id, nev, tipus, leiras, orszag) values (4, "Tokió", "város", "Modern metropolisz tradicionális japán kultúrával és technológiával.", "Japán");
insert into potpotpotzh_database.uticel (uticel_id, nev, tipus, leiras, orszag) values (5, "Amszterdam", "város", "Festői csatornák, kerékpáros kultúra és világhírű múzeumok jellemzik.", "Hollandia");

insert into potpotpotzh_database.szerepkor (kod, leiras) values ("lister", "Use the web app.");
insert into potpotpotzh_database.szerepkor (kod, leiras) values ("saver", "Use the web app.");

insert into potpotpotzh_database.felhasznalo (felhasznalonev, jelszo) values ("user1", "$2a$06$qkg0bF5ZbgNHj/ichvlAWepmKgJjguwGq1E//xVIS5O687BxMh5T.");
insert into potpotpotzh_database.felhasznalo (felhasznalonev, jelszo) values ("user2", "$2a$06$qkg0bF5ZbgNHj/ichvlAWepmKgJjguwGq1E//xVIS5O687BxMh5T.");

insert into potpotpotzh_database.felhasznalo_szerepkor (felhasznalo_azonosito, szerepkor_azonosito) values ((select azonosito from potpotpotzh_database.felhasznalo where felhasznalonev = "user1"), (select azonosito from potpotpotzh_database.szerepkor where kod = "lister"));
insert into potpotpotzh_database.felhasznalo_szerepkor (felhasznalo_azonosito, szerepkor_azonosito) values ((select azonosito from potpotpotzh_database.felhasznalo where felhasznalonev = "user2"), (select azonosito from potpotpotzh_database.szerepkor where kod = "lister"));
insert into potpotpotzh_database.felhasznalo_szerepkor (felhasznalo_azonosito, szerepkor_azonosito) values ((select azonosito from potpotpotzh_database.felhasznalo where felhasznalonev = "user2"), (select azonosito from potpotpotzh_database.szerepkor where kod = "saver"));
