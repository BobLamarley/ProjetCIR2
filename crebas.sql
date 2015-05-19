/*==============================================================*/
/* Nom de SGBD :  MySQL 5.0                                     */
/* Date de création :  19/05/2015 16:36:21                      */
/*==============================================================*/


drop table if exists CATEGORIE;

drop table if exists JEU_DE_REPONSES;

drop table if exists JOUEUR;

drop table if exists QUESTIONS;

drop table if exists SCORE;

/*==============================================================*/
/* Table : CATEGORIE                                            */
/*==============================================================*/
create table CATEGORIE
(
   IDCAT                int not null,
   LIBELLE              longtext not null,
   primary key (IDCAT)
);

/*==============================================================*/
/* Table : JEU_DE_REPONSES                                      */
/*==============================================================*/
create table JEU_DE_REPONSES
(
   IDCAT                int not null,
   IDJEUREP             int not null,
   REP1                 longtext not null,
   REP2                 longtext not null,
   REP3                 longtext not null,
   primary key (IDCAT, IDJEUREP)
);

/*==============================================================*/
/* Table : JOUEUR                                               */
/*==============================================================*/
create table JOUEUR
(
   IDPSEUDO             int not null,
   PSEUDO               longtext not null,
   primary key (IDPSEUDO)
);

/*==============================================================*/
/* Table : QUESTIONS                                            */
/*==============================================================*/
create table QUESTIONS
(
   IDCAT                int not null,
   IDJEUREP             int not null,
   IDQUEST              int not null,
   INTITULE             text not null,
   BONNEREP             longtext not null,
   primary key (IDCAT, IDJEUREP, IDQUEST)
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

alter table JEU_DE_REPONSES add constraint FK_EST_ASSOCIE_A foreign key (IDCAT)
      references CATEGORIE (IDCAT) on delete restrict on update restrict;

alter table QUESTIONS add constraint FK_COMPORTE foreign key (IDCAT, IDJEUREP)
      references JEU_DE_REPONSES (IDCAT, IDJEUREP) on delete restrict on update restrict;

alter table SCORE add constraint FK_A_OBTENU foreign key (IDPSEUDO)
      references JOUEUR (IDPSEUDO) on delete restrict on update restrict;

