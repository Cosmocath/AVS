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

delete from `produit`;
delete from `profildroit`;
delete from `droit`;
delete from `commandeproduit`;
delete from `produitvendu`;
delete from `commande`;
delete from `utilisateur`;

--
-- Déchargement des données de la table `utilisateur`
--

INSERT INTO `utilisateur` (`id_Utilisateur`, `nom`, `prenom`, `date_naissance`, `adresse`, `mail`, `password`, `actif`, `id_Profil`) VALUES(7, 'ad', 'min', '1987-05-11', '19_rue_montebello', 'utili.sateur@outlook.com', 'pass', b'1', 3);
INSERT INTO `utilisateur` (`id_Utilisateur`, `nom`, `prenom`, `date_naissance`, `adresse`, `mail`, `password`, `actif`, `id_Profil`) VALUES(8, 'cli', 'ent', '2000-09-25', '112_ave_republique', 'test.user@gmail.com', 'mdp', b'0', 2);

--
-- Déchargement des données de la table `commande`
--

INSERT INTO `commande` (`id_Commande`, `id_Utilisateur`, `nom`, `adresse_livraison`, `adresse_facturation`, `numero_commande`, `date_commande`, `montant_sans_remise`, `remise`) VALUES(1, 8, 'commande_jardin', '19_rue_montebello', '19_rue_montebello', 'jd_1546', '2016-06-17', 60, 0);

--
-- Déchargement des données de la table `produitvendu`
--

INSERT INTO `produitvendu` (`id_ProduitVendu`, `designation`, `reference`, `description`, `prix`, `image`, `numero_version`, `id_Produit_Historise`) VALUES(1, 'jadinage', 123456, 'entretien de jardin', 30, 'null', 1, 12);

--
-- Déchargement des données de la table `commandeproduit`
--

INSERT INTO `commandeproduit` (`id_CommandeProduit`, `idCommande`, `id_ProduitVendu`, `quantite`) VALUES(1, 1, 1, 2);

--
-- Déchargement des données de la table `droit`
--

INSERT INTO `droit` (`id_Droit`, `url`, `description`) VALUES(1, 'accueil.do', 'acceder_a_l_accueil ');
INSERT INTO `droit` (`id_Droit`, `url`, `description`) VALUES(2, 'voirConnecterUser.do', 'droit_de_connexion');
INSERT INTO `droit` (`id_Droit`, `url`, `description`) VALUES(3, 'TestHello.do', 'page_test');

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

--
-- Déchargement des données de la table `produit`
--

INSERT INTO `produit` (`id_Produit`, `designation`, `reference`, `description`, `prix`, `image`, `numero_version`, `actif`) VALUES(12, 'jadinage', 123456, 'entretien de jardin', 30, 'null', 1, b'1');
INSERT INTO `produit` (`id_Produit`, `designation`, `reference`, `description`, `prix`, `image`, `numero_version`, `actif`) VALUES(13, 'menage', 987654, 'entretien d_interieur', 20, 'null', 1, b'0');
INSERT INTO `produit` (`id_Produit`, `designation`, `reference`, `description`, `prix`, `image`, `numero_version`, `actif`) VALUES(14, 'demenagement', 456789, 'service_au_demenagement', 40, 'null', 1, b'1');

COMMIT;




/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
