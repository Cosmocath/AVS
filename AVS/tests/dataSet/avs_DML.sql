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
delete from `profil`;

--
-- Déchargement des données de la table `profil`
--

INSERT INTO `profil` (`id_Profil`, `nom`) VALUES(1, 'visiteur');
INSERT INTO `profil` (`id_Profil`, `nom`) VALUES(2, 'client');
INSERT INTO `profil` (`id_Profil`, `nom`) VALUES(3, 'admin');


--
-- Déchargement des données de la table `utilisateur`
--

INSERT INTO `utilisateur` (`id_Utilisateur`, `nom`, `prenom`, `date_naissance`, `adresse`, `mail`, `password`, `actif`, `id_Profil`) VALUES(7, 'ad', 'min', '1987-05-11', '19_rue_montebello', 'utili.sateur@outlook.com', 'pass', b'1', 3);
INSERT INTO `utilisateur` (`id_Utilisateur`, `nom`, `prenom`, `date_naissance`, `adresse`, `mail`, `password`, `actif`, `id_Profil`) VALUES(8, 'cli', 'ent', '2000-09-25', '112_ave_republique', 'test.user@gmail.com', 'mdp', b'0', 2);
INSERT INTO `utilisateur` (`id_Utilisateur`, `nom`, `prenom`, `date_naissance`, `adresse`, `mail`, `password`, `actif`, `id_Profil`) VALUES(9, 'Dupont', 'alfred', '1991-02-15', '84_rue_JeanBatsite_Leblanc', 'dup.al@outlook.com', 'mot', b'1', 2);
INSERT INTO `utilisateur` (`id_Utilisateur`, `nom`, `prenom`, `date_naissance`, `adresse`, `mail`, `password`, `actif`, `id_Profil`) VALUES(10, 'Zuti', 'maria', '2004-01-02', '11_ave_Nicolas_Lebas', 'zut.ma@gmail.com', 'pwd', b'0', 2);
INSERT INTO `utilisateur` (`id_Utilisateur`, `nom`, `prenom`, `date_naissance`, `adresse`, `mail`, `password`, `actif`, `id_Profil`) VALUES(11, 'Belka', 'sab', '1992-01-05', '84_rue_deLommes', 'bel.sab@outlook.com', 'secret', b'1', 3);
INSERT INTO `utilisateur` (`id_Utilisateur`, `nom`, `prenom`, `date_naissance`, `adresse`, `mail`, `password`, `actif`, `id_Profil`) VALUES(12, 'Eg', 'emple', '1988-05-22', '11_ave_Bousbecque', 'eg.em@gmail.com', 'test', b'1', 2);

--
-- Déchargement des données de la table `commande`
--

INSERT INTO `commande` (`id_Commande`, `id_Utilisateur`, `nom`, `adresse_livraison`, `adresse_facturation`, `numero_commande`, `date_commande`, `montant_sans_remise`, `remise`) VALUES(1, 8, 'commande_jardin', '19_rue_montebello', '19_rue_montebello', 'jd_1546', '2016-06-17', 60, 0);

--
-- Déchargement des données de la table `produitvendu`
--

INSERT INTO `produitvendu` (`id_ProduitVendu`, `designation`, `reference`, `description`, `prix`, `image`, `numero_version`, `id_Produit_Historise`) VALUES(1, 'jadinage', 'AB3456', 'entretien de jardin', 30, 'null', 1, 12);

--
-- Déchargement des données de la table `commandeproduit`
--

INSERT INTO `commandeproduit` (`id_CommandeProduit`, `idCommande`, `id_ProduitVendu`, `quantite`) VALUES(1, 1, 1, 2);

--
-- Déchargement des données de la table `droit`
--

INSERT INTO `droit` (`id_Droit`, `url`, `description`) VALUES(2, 'voirConnecterUser.do', 'droit_de_connexion');
INSERT INTO `droit` (`id_Droit`, `url`, `description`) VALUES(3, 'TestHello.do', 'droit_d_ajout_de_produit');
INSERT INTO `droit` (`id_Droit`, `url`, `description`) VALUES(4, 'connecterUser.do', 'connexion au site');
INSERT INTO `droit` (`id_Droit`, `url`, `description`) VALUES(5, 'listerProduitClient.do', 'liste de produits appartenant à un client');
INSERT INTO `droit` (`id_Droit`, `url`, `description`) VALUES(6, 'consulterProduit.do', 'consulter le détail du produit');
INSERT INTO `droit` (`id_Droit`, `url`, `description`) VALUES(7, 'listerCommande.do', 'liste de commande');
INSERT INTO `droit` (`id_Droit`, `url`, `description`) VALUES(8, 'changerLangue.do', 'changer de langue');
INSERT INTO `droit` (`id_Droit`, `url`, `description`) VALUES(9, 'voirCreerProduit.do', 'voirCreerProduit');
INSERT INTO `droit` (`id_Droit`, `url`, `description`) VALUES(10, 'creerProduit.do', 'creerProduit');
INSERT INTO `droit` (`id_Droit`, `url`, `description`) VALUES(11, 'listerUser.do', 'permet de voir la liste des users');
INSERT INTO `droit` (`id_Droit`, `url`, `description`) VALUES(12, 'listerProduitAdmin.do', 'permet de voir la liste des produits Admin');
INSERT INTO `droit` (`id_Droit`, `url`, `description`) VALUES(13, 'deconnecterUser.do', 'permet la deconnection');

--
-- Déchargement des données de la table `profildroit`
--

INSERT INTO `profildroit` (`id_ProfilDroit`, `id_Profil`, `id_Droit`) VALUES(4, 1, 2);
INSERT INTO `profildroit` (`id_ProfilDroit`, `id_Profil`, `id_Droit`) VALUES(5, 2, 3);
INSERT INTO `profildroit` (`id_ProfilDroit`, `id_Profil`, `id_Droit`) VALUES(6, 2, 2);
INSERT INTO `profildroit` (`id_ProfilDroit`, `id_Profil`, `id_Droit`) VALUES(7, 3, 2);
INSERT INTO `profildroit` (`id_ProfilDroit`, `id_Profil`, `id_Droit`) VALUES(8, 3, 4);
INSERT INTO `profildroit` (`id_ProfilDroit`, `id_Profil`, `id_Droit`) VALUES(9, 2, 4);
INSERT INTO `profildroit` (`id_ProfilDroit`, `id_Profil`, `id_Droit`) VALUES(10, 1, 4);
INSERT INTO `profildroit` (`id_ProfilDroit`, `id_Profil`, `id_Droit`) VALUES(11, 3, 5);
INSERT INTO `profildroit` (`id_ProfilDroit`, `id_Profil`, `id_Droit`) VALUES(12, 1, 6);
INSERT INTO `profildroit` (`id_ProfilDroit`, `id_Profil`, `id_Droit`) VALUES(13, 2, 6);
INSERT INTO `profildroit` (`id_ProfilDroit`, `id_Profil`, `id_Droit`) VALUES(14, 3, 6);
INSERT INTO `profildroit` (`id_ProfilDroit`, `id_Profil`, `id_Droit`) VALUES(15, 2, 7);
INSERT INTO `profildroit` (`id_ProfilDroit`, `id_Profil`, `id_Droit`) VALUES(16, 3, 7);
INSERT INTO `profildroit` (`id_ProfilDroit`, `id_Profil`, `id_Droit`) VALUES(17, 1, 8);
INSERT INTO `profildroit` (`id_ProfilDroit`, `id_Profil`, `id_Droit`) VALUES(18, 2, 8);
INSERT INTO `profildroit` (`id_ProfilDroit`, `id_Profil`, `id_Droit`) VALUES(19, 3, 8);
INSERT INTO `profildroit` (`id_ProfilDroit`, `id_Profil`, `id_Droit`) VALUES(20, 2, 5);
INSERT INTO `profildroit` (`id_ProfilDroit`, `id_Profil`, `id_Droit`) VALUES(21, 1, 5);
INSERT INTO `profildroit` (`id_ProfilDroit`, `id_Profil`, `id_Droit`) VALUES(22, 3, 9);
INSERT INTO `profildroit` (`id_ProfilDroit`, `id_Profil`, `id_Droit`) VALUES(23, 3, 10);
INSERT INTO `profildroit` (`id_ProfilDroit`, `id_Profil`, `id_Droit`) VALUES(24, 3, 11);
INSERT INTO `profildroit` (`id_ProfilDroit`, `id_Profil`, `id_Droit`) VALUES(25, 3, 12);
INSERT INTO `profildroit` (`id_ProfilDroit`, `id_Profil`, `id_Droit`) VALUES(26, 3, 13);
INSERT INTO `profildroit` (`id_ProfilDroit`, `id_Profil`, `id_Droit`) VALUES(27, 2, 13);

--
-- Déchargement des données de la table `produit`
--

INSERT INTO `produit` (`id_Produit`, `designation`, `reference`, `description`, `prix`, `image`, `numero_version`, `actif`) VALUES(12, 'jadinage', 'AB3456', 'entretien de jardin', 30, 'null', 1, b'1');
INSERT INTO `produit` (`id_Produit`, `designation`, `reference`, `description`, `prix`, `image`, `numero_version`, `actif`) VALUES(13, 'menage', 'BC7654', 'entretien d_interieur', 20, 'null', 1, b'0');
INSERT INTO `produit` (`id_Produit`, `designation`, `reference`, `description`, `prix`, `image`, `numero_version`, `actif`) VALUES(14, 'demenagement', 'DE6789', 'service_au_demenagement', 40, 'null', 1, b'1');
INSERT INTO `produit` (`id_Produit`, `designation`, `reference`, `description`, `prix`, `image`, `numero_version`, `actif`) VALUES(15, 'bricolage', 'FG1234', 'petits travaux de reparation', 50, 'null', 1, b'0');
INSERT INTO `produit` (`id_Produit`, `designation`, `reference`, `description`, `prix`, `image`, `numero_version`, `actif`) VALUES(16, 'assistance informatique', 'HI5678', 'installation de logiciels', 25, 'null', 1, b'0');
INSERT INTO `produit` (`id_Produit`, `designation`, `reference`, `description`, `prix`, `image`, `numero_version`, `actif`) VALUES(17, 'soutien scolaire', 'JK9123', 'aide aux devoirs', 25, 'null', 1, b'0');

COMMIT;




/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
