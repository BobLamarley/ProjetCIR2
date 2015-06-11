-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Jeu 11 Juin 2015 à 10:44
-- Version du serveur :  5.6.17
-- Version de PHP :  5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données :  `example`
--

-- --------------------------------------------------------

--
-- Structure de la table `categorie`
--

CREATE TABLE IF NOT EXISTS `categorie` (
  `libelle` varchar(30) NOT NULL,
  PRIMARY KEY (`libelle`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `categorie`
--

INSERT INTO `categorie` (`libelle`) VALUES
('cinema'),
('cuisine'),
('culture générale'),
('histoire'),
('littérature'),
('sport');

-- --------------------------------------------------------

--
-- Structure de la table `jeureponses`
--

CREATE TABLE IF NOT EXISTS `jeureponses` (
  `libelle` varchar(30) NOT NULL,
  `idjeurep` int(11) NOT NULL,
  `rep1` varchar(40) NOT NULL,
  `rep2` varchar(40) NOT NULL,
  PRIMARY KEY (`libelle`,`idjeurep`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `jeureponses`
--

INSERT INTO `jeureponses` (`libelle`, `idjeurep`, `rep1`, `rep2`) VALUES
('cinema', 1, 'George Clooney', 'Brad Pitt'),
('cinema', 10, 'Un réalisateur ', 'Un technicien'),
('cuisine', 7, 'Pavarotti', 'Poulet rôti'),
('cuisine', 11, 'Pomme de terre', 'Pomme'),
('culture générale', 2, 'Pikachu', 'Le Yéti'),
('culture générale', 3, 'Sissi', 'Oui-Oui'),
('culture générale', 4, 'Franck Leboeuf', 'Frankenstein'),
('culture générale', 5, 'Nicolas Sarkozy', 'Un clou'),
('histoire', 8, 'Brahim Asloum', 'Atchoum'),
('histoire', 14, 'Les dinosaures', 'Un lamasticot'),
('littérature', 9, 'Raymond Barre', 'un Ornithorynque'),
('littérature', 12, 'Bob Marley', 'Jesus'),
('sport', 6, 'Carton jaune', 'Carton rouge'),
('sport', 13, 'Tennis', 'Handball');

-- --------------------------------------------------------

--
-- Structure de la table `joueur`
--

CREATE TABLE IF NOT EXISTS `joueur` (
  `idpseudo` int(11) NOT NULL AUTO_INCREMENT,
  `pseudo` varchar(30) NOT NULL,
  PRIMARY KEY (`idpseudo`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Contenu de la table `joueur`
--

INSERT INTO `joueur` (`idpseudo`, `pseudo`) VALUES
(4, 'lama');

-- --------------------------------------------------------

--
-- Structure de la table `questions`
--

CREATE TABLE IF NOT EXISTS `questions` (
  `libelle` varchar(30) NOT NULL,
  `idjeurep` int(11) NOT NULL,
  `idquest` int(11) NOT NULL,
  `intitule` varchar(256) NOT NULL,
  `bonnerep` int(11) NOT NULL,
  PRIMARY KEY (`libelle`,`idjeurep`,`idquest`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `questions`
--

INSERT INTO `questions` (`libelle`, `idjeurep`, `idquest`, `intitule`, `bonnerep`) VALUES
('cinema', 1, 51, 'A jouer dans la pub Expresso ?', 1),
('cinema', 1, 52, 'Est maintenant vieux', 2),
('cinema', 1, 53, 'Est riche', 3),
('cinema', 1, 54, 'Danse la macarena en cachette ', 2),
('cinema', 10, 55, 'Ne fait pas grand chose', 1),
('cinema', 10, 56, 'Donne des ordres', 1),
('cinema', 10, 57, 'est une sorte d''esclave', 2),
('cinema', 10, 58, 'Aime les chips au bacon', 3),
('cuisine', 7, 30, 'Ne chante pas', 2),
('cuisine', 7, 31, 'Il n''y a aucune raison de le ficeler', 1),
('cuisine', 7, 32, 'Fait ses tournées sur une broche', 2),
('cuisine', 7, 33, 'Il s''exprime comme ça "ahhhhhhhhhhhhhhhhhhhhh"', 1),
('cuisine', 7, 34, 'A des bonnes cuisses', 3),
('cuisine', 7, 35, 'Chargé de cholestérol', 3),
('cuisine', 7, 36, 'Tu peux en avoir la moitié si tu veux ', 2),
('cuisine', 11, 59, 'On fait des tartes aux pommes avec ', 2),
('cuisine', 11, 60, 'On en fait des frites ', 1),
('cuisine', 11, 61, 'est comestible', 3),
('cuisine', 11, 62, 'n''est pas bon quand c''est cru', 1),
('culture générale', 2, 1, 'Qui est poilu ?', 3),
('culture générale', 2, 2, 'Qui est jaune ?', 1),
('culture générale', 2, 3, 'Qui habite l''himalaya ?', 2),
('culture générale', 2, 4, 'Qui ne dit que son nom ?', 1),
('culture générale', 2, 5, 'Qui joue George dans la pub Tic Tac ?', 2),
('culture générale', 3, 6, '... Impératrice ', 1),
('culture générale', 3, 7, 'Vit dans un monde merveilleux', 3),
('culture générale', 3, 8, 'Qui a vraiment existé ?', 1),
('culture générale', 3, 9, 'qui est marié ?', 1),
('culture générale', 3, 10, 'Potiron ', 1),
('culture générale', 3, 11, 'Romy Schneider', 1),
('culture générale', 3, 12, 'Vous fait perdre à ni oui , ni non ', 3),
('culture générale', 4, 13, 'Qui joue au foot ?', 1),
('culture générale', 4, 14, 'Qui a une fermeture éclair sur la tête ?', 2),
('culture générale', 4, 15, 'Qui a le crâne rasé ?', 1),
('culture générale', 4, 16, 'C''est pas un beau gosse ', 2),
('culture générale', 4, 17, 'Qui est champion du monde ?', 1),
('culture générale', 4, 18, 'Qui a fait du cinéma ?', 2),
('culture générale', 5, 19, 'On peut taper dessus ?', 2),
('culture générale', 5, 20, 'Qui a été maire de Neuilly', 1),
('culture générale', 5, 21, 'Il a une tête plate ', 3),
('culture générale', 5, 22, 'Il vaut mieux éviter de marcher dessus ?', 3),
('histoire', 8, 37, 'Qui est petit ', 2),
('histoire', 8, 38, 'Médaille d''or', 1),
('histoire', 8, 39, 'Fait rire les enfants', 2),
('histoire', 8, 40, 'A fait fort boyard ', 1),
('histoire', 8, 41, 'Sort tout droit d''un Walt Disney', 2),
('histoire', 8, 42, 'Nique l''autre à la bagarre', 1),
('histoire', 14, 71, 'Qui n''a pas de pattes ?', 2),
('histoire', 14, 72, 'Qui n''existe plus ?', 3),
('histoire', 14, 73, 'Qui mange des arbres ?', 1),
('histoire', 14, 74, 'Qui dort a l''envers ?', 2),
('littérature', 9, 43, 'A un corps de loutre ', 2),
('littérature', 9, 44, ' originaire de St Denis de la Réunion? ', 1),
('littérature', 9, 45, 'Il creuse des terriers', 2),
('littérature', 9, 46, 'titre de meilleur économiste de France ?', 1),
('littérature', 9, 47, 'il pése entre 2 et 100 kilos ?', 3),
('littérature', 9, 48, 'il pond 2 à 3 oeufs ?', 2),
('littérature', 9, 49, 's''accouple au printemps', 3),
('littérature', 9, 50, 'Paradoxus fut son premier nom?', 2),
('littérature', 12, 63, 'On en parle dans la bible', 2),
('littérature', 12, 64, 'Fait parti du mouvement rasta', 1),
('littérature', 12, 65, 'n''a pas vraiment de père', 2),
('littérature', 12, 66, 'A été aimé pour sa musique', 1),
('sport', 6, 23, 'Tacle par-derrière', 2),
('sport', 6, 24, 'Se battre à la mi-temps', 2),
('sport', 6, 25, 'Voler un carton jaune à l''arbitre et le lui donner ', 2),
('sport', 6, 26, 'Cracher sur son son partenaire', 1),
('sport', 6, 27, 'Enlever son maillot après un but', 1),
('sport', 6, 28, 'Deux cartons jaunes', 1),
('sport', 6, 29, 'Main volontaire pour empêcher le but', 2),
('sport', 13, 67, 'On y joue qu''avec les mains', 2),
('sport', 13, 68, 'Il faut marquer des buts', 2),
('sport', 13, 69, 'Roland Grarros', 1),
('sport', 13, 70, 'Est physique', 3);

-- --------------------------------------------------------

--
-- Structure de la table `score`
--

CREATE TABLE IF NOT EXISTS `score` (
  `idscore` int(11) NOT NULL AUTO_INCREMENT,
  `idpseudo` int(11) DEFAULT NULL,
  `score` int(11) NOT NULL,
  `tempsrepmoy` decimal(10,0) NOT NULL,
  PRIMARY KEY (`idscore`),
  KEY `fk_a_obtenu` (`idpseudo`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Contenu de la table `score`
--

INSERT INTO `score` (`idscore`, `idpseudo`, `score`, `tempsrepmoy`) VALUES
(1, 4, 48, '1');

--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `jeureponses`
--
ALTER TABLE `jeureponses`
  ADD CONSTRAINT `fk_est_associe_a` FOREIGN KEY (`libelle`) REFERENCES `categorie` (`libelle`);

--
-- Contraintes pour la table `questions`
--
ALTER TABLE `questions`
  ADD CONSTRAINT `fk_comporte` FOREIGN KEY (`libelle`, `idjeurep`) REFERENCES `jeureponses` (`libelle`, `idjeurep`);

--
-- Contraintes pour la table `score`
--
ALTER TABLE `score`
  ADD CONSTRAINT `fk_a_obtenu` FOREIGN KEY (`idpseudo`) REFERENCES `joueur` (`idpseudo`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
