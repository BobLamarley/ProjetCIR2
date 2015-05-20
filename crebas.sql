/*==============================================================*/
/* Nom de SGBD :  MySQL 5.0                                     */
/* Date de création :  20/05/2015 16:37:03                      */
/*==============================================================*/


drop table if exists CATEGORIE;

drop table if exists JEUREPONSES;

drop table if exists JOUEUR;

drop table if exists QUESTIONS;

drop table if exists SCORE;

/*==============================================================*/
/* Table : CATEGORIE                                            */
/*==============================================================*/
create table CATEGORIE
(
   LIBELLE              varchar(30) not null,
   primary key (LIBELLE)
);

/*==============================================================*/
/* Table : JEUREPONSES                                          */
/*==============================================================*/
create table JEUREPONSES
(
   LIBELLE              varchar(30) not null,
   IDJEUREP             int not null,
   REP1                 varchar(40) not null,
   REP2                 varchar(40) not null,
   primary key (LIBELLE, IDJEUREP)
);

/*==============================================================*/
/* Table : JOUEUR                                               */
/*==============================================================*/
create table JOUEUR
(
   IDPSEUDO             int not null,
   PSEUDO               varchar(30) not null,
   primary key (IDPSEUDO)
);

/*==============================================================*/
/* Table : QUESTIONS                                            */
/*==============================================================*/
create table QUESTIONS
(
   LIBELLE              varchar(30) not null,
   IDJEUREP             int not null,
   IDQUEST              int not null,
   INTITULE             varchar(256) not null,
   BONNEREP             int not null,
   primary key (LIBELLE, IDJEUREP, IDQUEST)
);

/*==============================================================*/
/* Table : SCORE                                                */
/*==============================================================*/
create table SCORE
(
   IDSCORE              int not null,
   IDPSEUDO             int,
   SCORE                int not null,
   TEMPSREPMOY          decimal not null,
   primary key (IDSCORE)
);

alter table JEUREPONSES add constraint FK_EST_ASSOCIE_A foreign key (LIBELLE)
      references CATEGORIE (LIBELLE) on delete restrict on update restrict;

alter table QUESTIONS add constraint FK_COMPORTE foreign key (LIBELLE, IDJEUREP)
      references JEUREPONSES (LIBELLE, IDJEUREP) on delete restrict on update restrict;

alter table SCORE add constraint FK_A_OBTENU foreign key (IDPSEUDO)
      references JOUEUR (IDPSEUDO) on delete restrict on update restrict;

