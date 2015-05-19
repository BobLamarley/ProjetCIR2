/*==============================================================*/
/* Nom de SGBD :  MySQL 5.0                                     */
/* Date de création :  19/05/2015 15:30:42                      */
/*==============================================================*/


drop table if exists CATEGORIE;

drop table if exists JEU_DE_QUESTIONS;

drop table if exists JEU_DE_REPONSES;

drop table if exists JOUEUR;

drop table if exists QUESTIONS;

drop table if exists SCORE;

/*==============================================================*/
/* Table : CATEGORIE                                            */
/*==============================================================*/
create table CATEGORIE
(
   CATEGORIE            longtext not null,
   primary key (CATEGORIE)
);

/*==============================================================*/
/* Table : JEU_DE_QUESTIONS                                     */
/*==============================================================*/
create table JEU_DE_QUESTIONS
(
   IDJEUQUEST           int not null,
   CATEGORIE            longtext not null,
   IDJEUREP             int not null,
   primary key (IDJEUQUEST)
);

/*==============================================================*/
/* Table : JEU_DE_REPONSES                                      */
/*==============================================================*/
create table JEU_DE_REPONSES
(
   IDJEUREP             int not null,
   REP1                 longtext not null,
   REP2                 longtext not null,
   REP3                 longtext not null,
   primary key (IDJEUREP)
);

/*==============================================================*/
/* Table : JOUEUR                                               */
/*==============================================================*/
create table JOUEUR
(
   IDPSEUDO             int not null,
   PSEUDO               longtext not null,
   MAIL                 longtext,
   primary key (IDPSEUDO)
);

/*==============================================================*/
/* Table : QUESTIONS                                            */
/*==============================================================*/
create table QUESTIONS
(
   IDQUEST              int not null,
   IDJEUQUEST           int not null,
   INTITULE             longtext not null,
   BONNEREP             longtext not null,
   primary key (IDQUEST)
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

alter table JEU_DE_QUESTIONS add constraint FK_COMPREND foreign key (CATEGORIE)
      references CATEGORIE (CATEGORIE) on delete restrict on update restrict;

alter table JEU_DE_QUESTIONS add constraint FK_EST_ASSOCIE_A foreign key (IDJEUREP)
      references JEU_DE_REPONSES (IDJEUREP) on delete restrict on update restrict;

alter table QUESTIONS add constraint FK_EST_COMPOSE_DE foreign key (IDJEUQUEST)
      references JEU_DE_QUESTIONS (IDJEUQUEST) on delete restrict on update restrict;

alter table SCORE add constraint FK_A_OBTENU foreign key (IDPSEUDO)
      references JOUEUR (IDPSEUDO) on delete restrict on update restrict;

