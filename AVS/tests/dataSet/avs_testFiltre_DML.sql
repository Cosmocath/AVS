-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  lun. 02 sep. 2019 Ã  14:16
-- Version du serveur :  5.7.24
-- Version de PHP :  7.2.14
-- Version : 1.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `avs`
--

--
-- Suppression des tables
--

delete from `profildroit`;
delete from `droit`;
delete from `profil`;

--
-- Déchargement des données de la table `profil`
--

INSERT INTO `profil` (`id_Profil`, `nom`) VALUES(1, 'visiteur');
INSERT INTO `profil` (`id_Profil`, `nom`) VALUES(2, 'client');
INSERT INTO `profil` (`id_Profil`, `nom`) VALUES(3, 'admin');

--
-- Déchargement des données de la table `droit`
--

INSERT INTO `droit` (`id_Droit`, `url`, `description`) VALUES(1, 'accueil.do', 'acceder_a_l_accueil ');
INSERT INTO `droit` (`id_Droit`, `url`, `description`) VALUES(2, 'voirConnecterUser.do', 'droit_de_connexion');
INSERT INTO `droit` (`id_Droit`, `url`, `description`) VALUES(3, 'TestHello.do', 'droit_d_ajout_de_produit');

--
-- Déchargement des données de la table `profildroit`
--

INSERT INTO `profildroit` (`id_ProfilDroit`, `id_Profil`, `id_Droit`) VALUES(1, 1, 1);
INSERT INTO `profildroit` (`id_ProfilDroit`, `id_Profil`, `id_Droit`) VALUES(2, 2, 1);
INSERT INTO `profildroit` (`id_ProfilDroit`, `id_Profil`, `id_Droit`) VALUES(3, 3, 1);
INSERT INTO `profildroit` (`id_ProfilDroit`, `id_Profil`, `id_Droit`) VALUES(4, 1, 2);
INSERT INTO `profildroit` (`id_ProfilDroit`, `id_Profil`, `id_Droit`) VALUES(5, 1, 3);
INSERT INTO `profildroit` (`id_ProfilDroit`, `id_Profil`, `id_Droit`) VALUES(6, 2, 2);
INSERT INTO `profildroit` (`id_ProfilDroit`, `id_Profil`, `id_Droit`) VALUES(7, 3, 2);

COMMIT;


/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
