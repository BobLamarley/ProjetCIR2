/*==============================================================*/
/* Nom de SGBD :  Sybase SQL Anywhere 12                        */
/* Date de création :  19/05/2015 14:59:40                      */
/*==============================================================*/


if exists(select 1 from sys.sysforeignkey where role='FK_JEU_DE_Q_COMPREND_CATEGORI') then
    alter table JEU_DE_QUESTIONS
       delete foreign key FK_JEU_DE_Q_COMPREND_CATEGORI
end if;

if exists(select 1 from sys.sysforeignkey where role='FK_JEU_DE_Q_EST_ASSOC_JEU_DE_R') then
    alter table JEU_DE_QUESTIONS
       delete foreign key FK_JEU_DE_Q_EST_ASSOC_JEU_DE_R
end if;

if exists(select 1 from sys.sysforeignkey where role='FK_QUESTION_EST_COMPO_JEU_DE_Q') then
    alter table QUESTIONS
       delete foreign key FK_QUESTION_EST_COMPO_JEU_DE_Q
end if;

if exists(select 1 from sys.sysforeignkey where role='FK_SCORE_A_OBTENU_JOUEUR') then
    alter table SCORE
       delete foreign key FK_SCORE_A_OBTENU_JOUEUR
end if;

drop index if exists CATEGORIE.CATEGORIE_PK;

drop table if exists CATEGORIE;

drop index if exists JEU_DE_QUESTIONS.EST_ASSOCIE_A_FK;

drop index if exists JEU_DE_QUESTIONS.COMPREND_FK;

drop index if exists JEU_DE_QUESTIONS.JEU_DE_QUESTIONS_PK;

drop table if exists JEU_DE_QUESTIONS;

drop index if exists JEU_DE_REPONSES.JEU_DE_REPONSES_PK;

drop table if exists JEU_DE_REPONSES;

drop index if exists JOUEUR.JOUEUR_PK;

drop table if exists JOUEUR;

drop index if exists QUESTIONS.EST_COMPOSE_DE_FK;

drop index if exists QUESTIONS.QUESTIONS_PK;

drop table if exists QUESTIONS;

drop index if exists SCORE.A_OBTENU_FK;

drop index if exists SCORE.SCORE_PK;

drop table if exists SCORE;

/*==============================================================*/
/* Table : CATEGORIE                                            */
/*==============================================================*/
create table CATEGORIE 
(
   CATEGORIE            long varchar                   not null,
   constraint PK_CATEGORIE primary key (CATEGORIE)
);

/*==============================================================*/
/* Index : CATEGORIE_PK                                         */
/*==============================================================*/
create unique index CATEGORIE_PK on CATEGORIE (
CATEGORIE ASC
);

/*==============================================================*/
/* Table : JEU_DE_QUESTIONS                                     */
/*==============================================================*/
create table JEU_DE_QUESTIONS 
(
   IDJEUQUEST           integer                        not null,
   CATEGORIE            long varchar                   not null,
   IDJEUREP             integer                        not null,
   constraint PK_JEU_DE_QUESTIONS primary key (IDJEUQUEST)
);

/*==============================================================*/
/* Index : JEU_DE_QUESTIONS_PK                                  */
/*==============================================================*/
create unique index JEU_DE_QUESTIONS_PK on JEU_DE_QUESTIONS (
IDJEUQUEST ASC
);

/*==============================================================*/
/* Index : COMPREND_FK                                          */
/*==============================================================*/
create index COMPREND_FK on JEU_DE_QUESTIONS (
CATEGORIE ASC
);

/*==============================================================*/
/* Index : EST_ASSOCIE_A_FK                                     */
/*==============================================================*/
create index EST_ASSOCIE_A_FK on JEU_DE_QUESTIONS (
IDJEUREP ASC
);

/*==============================================================*/
/* Table : JEU_DE_REPONSES                                      */
/*==============================================================*/
create table JEU_DE_REPONSES 
(
   IDJEUREP             integer                        not null,
   REP1                 long varchar                   not null,
   REP2                 long varchar                   not null,
   REP3                 long varchar                   not null,
   constraint PK_JEU_DE_REPONSES primary key (IDJEUREP)
);

/*==============================================================*/
/* Index : JEU_DE_REPONSES_PK                                   */
/*==============================================================*/
create unique index JEU_DE_REPONSES_PK on JEU_DE_REPONSES (
IDJEUREP ASC
);

/*==============================================================*/
/* Table : JOUEUR                                               */
/*==============================================================*/
create table JOUEUR 
(
   IDPSEUDO             integer                        not null,
   PSEUDO               long varchar                   not null,
   MAIL                 long varchar                   null,
   constraint PK_JOUEUR primary key (IDPSEUDO)
);

/*==============================================================*/
/* Index : JOUEUR_PK                                            */
/*==============================================================*/
create unique index JOUEUR_PK on JOUEUR (
IDPSEUDO ASC
);

/*==============================================================*/
/* Table : QUESTIONS                                            */
/*==============================================================*/
create table QUESTIONS 
(
   IDQUEST              integer                        not null,
   IDJEUQUEST           integer                        not null,
   INTITULE             long varchar                   not null,
   BONNEREP             long varchar                   not null,
   constraint PK_QUESTIONS primary key (IDQUEST)
);

/*==============================================================*/
/* Index : QUESTIONS_PK                                         */
/*==============================================================*/
create unique index QUESTIONS_PK on QUESTIONS (
IDQUEST ASC
);

/*==============================================================*/
/* Index : EST_COMPOSE_DE_FK                                    */
/*==============================================================*/
create index EST_COMPOSE_DE_FK on QUESTIONS (
IDJEUQUEST ASC
);

/*==============================================================*/
/* Table : SCORE                                                */
/*==============================================================*/
create table SCORE 
(
   IDSCORE              integer                        not null,
   IDPSEUDO             integer                        null,
   SCORE                integer                        not null,
   TEMPSREPMOY          decimal                        not null,
   constraint PK_SCORE primary key (IDSCORE)
);

/*==============================================================*/
/* Index : SCORE_PK                                             */
/*==============================================================*/
create unique index SCORE_PK on SCORE (
IDSCORE ASC
);

/*==============================================================*/
/* Index : A_OBTENU_FK                                          */
/*==============================================================*/
create index A_OBTENU_FK on SCORE (
IDPSEUDO ASC
);

alter table JEU_DE_QUESTIONS
   add constraint FK_JEU_DE_Q_COMPREND_CATEGORI foreign key (CATEGORIE)
      references CATEGORIE (CATEGORIE)
      on update restrict
      on delete restrict;

alter table JEU_DE_QUESTIONS
   add constraint FK_JEU_DE_Q_EST_ASSOC_JEU_DE_R foreign key (IDJEUREP)
      references JEU_DE_REPONSES (IDJEUREP)
      on update restrict
      on delete restrict;

alter table QUESTIONS
   add constraint FK_QUESTION_EST_COMPO_JEU_DE_Q foreign key (IDJEUQUEST)
      references JEU_DE_QUESTIONS (IDJEUQUEST)
      on update restrict
      on delete restrict;

alter table SCORE
   add constraint FK_SCORE_A_OBTENU_JOUEUR foreign key (IDPSEUDO)
      references JOUEUR (IDPSEUDO)
      on update restrict
      on delete restrict;

