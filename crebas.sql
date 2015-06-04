/*==============================================================*/
/* Nom de SGBD :  MySQL 5.0                                     */
/* Date de création :  04/06/2015 08:47:15                      */
/*==============================================================*/


drop table if exists categorie;

drop table if exists jeureponses;

drop table if exists joueur;

drop table if exists questions;

drop table if exists score;

/*==============================================================*/
/* Table : categorie                                            */
/*==============================================================*/
create table categorie
(
   libelle              varchar(30) not null,
   primary key (libelle)
);

/*==============================================================*/
/* Table : jeureponses                                          */
/*==============================================================*/
create table jeureponses
(
   libelle              varchar(30) not null,
   idjeurep             int not null,
   rep1                 varchar(40) not null,
   rep2                 varchar(40) not null,
   primary key (libelle, idjeurep)
);

/*==============================================================*/
/* Table : joueur                                               */
/*==============================================================*/
create table joueur
(
   idpseudo             int not null auto_increment,
   pseudo               varchar(30) not null,
   primary key (idpseudo)
);

/*==============================================================*/
/* Table : questions                                            */
/*==============================================================*/
create table questions
(
   libelle              varchar(30) not null,
   idjeurep             int not null,
   idquest              int not null,
   intitule             varchar(256) not null,
   bonnerep             int not null,
   primary key (libelle, idjeurep, idquest)
);

/*==============================================================*/
/* Table : score                                                */
/*==============================================================*/
create table score
(
   idscore              int not null,
   idpseudo             int,
   score                int not null,
   tempsrepmoy          decimal not null,
   primary key (idscore)
);

alter table jeureponses add constraint fk_est_associe_a foreign key (libelle)
      references categorie (libelle) on delete restrict on update restrict;

alter table questions add constraint fk_comporte foreign key (libelle, idjeurep)
      references jeureponses (libelle, idjeurep) on delete restrict on update restrict;

alter table score add constraint fk_a_obtenu foreign key (idpseudo)
      references joueur (idpseudo) on delete restrict on update restrict;

