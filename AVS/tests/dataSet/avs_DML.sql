-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  lun. 02 sep. 2019 Ã  14:16
-- Version du serveur :  5.7.24
-- Version de PHP :  7.2.14
-- Version : 1.4

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

INSERT INTO `utilisateur` (`id_Utilisateur`, `nom`, `prenom`, `date_naissance`, `adresse`, `mail`, `password`, `actif`, `id_Profil`) VALUES(7, 'ad', 'min', '1987-05-11', '19_rue_montebello', 'utili.sateur@outlook.com', '1a1dc91c907325c69271ddf0c944bc72', b'1', 3);
INSERT INTO `utilisateur` (`id_Utilisateur`, `nom`, `prenom`, `date_naissance`, `adresse`, `mail`, `password`, `actif`, `id_Profil`) VALUES(8, 'cli', 'ent', '2000-09-25', '112_ave_republique', 'test.user@gmail.com', 'aa36dc6e81e2ac7ad03e12fedcb6a2c0', b'0', 2);
INSERT INTO `utilisateur` (`id_Utilisateur`, `nom`, `prenom`, `date_naissance`, `adresse`, `mail`, `password`, `actif`, `id_Profil`) VALUES(9, 'Dupont', 'alfred', '1991-02-15', '84_rue_JeanBatsite_Leblanc', 'dup.al@outlook.com', 'de81459305398c88048a05a620fb4717', b'1', 2);
INSERT INTO `utilisateur` (`id_Utilisateur`, `nom`, `prenom`, `date_naissance`, `adresse`, `mail`, `password`, `actif`, `id_Profil`) VALUES(10, 'Zuti', 'maria', '2004-01-02', '11_ave_Nicolas_Lebas', 'zut.ma@gmail.com', '9003d1df22eb4d3820015070385194c8', b'0', 2);
INSERT INTO `utilisateur` (`id_Utilisateur`, `nom`, `prenom`, `date_naissance`, `adresse`, `mail`, `password`, `actif`, `id_Profil`) VALUES(11, 'Belka', 'sab', '1992-01-05', '84_rue_deLommes', 'bel.sab@outlook.com', '5ebe2294ecd0e0f08eab7690d2a6ee69', b'1', 3);
INSERT INTO `utilisateur` (`id_Utilisateur`, `nom`, `prenom`, `date_naissance`, `adresse`, `mail`, `password`, `actif`, `id_Profil`) VALUES(12, 'Eg', 'emple', '1988-05-22', '11_ave_Bousbecque', 'eg.em@gmail.com', '098f6bcd4621d373cade4e832627b4f6', b'1', 2);

--
-- Déchargement des données de la table `commande`
--

INSERT INTO `commande` (`id_Commande`, `id_Utilisateur`, `nom`, `adresse_livraison`, `adresse_facturation`, `numero_commande`, `date_commande`, `montant_sans_remise`, `remise`) VALUES(1, 8, 'commande_jardin', '19_rue_montebello', '19_rue_montebello', 'jd_1546', '2016-06-17', 60, 0);
INSERT INTO `commande` (`id_Commande`, `id_Utilisateur`, `nom`, `adresse_livraison`, `adresse_facturation`, `numero_commande`, `date_commande`, `montant_sans_remise`, `remise`) VALUES(2, 9, 'commande_Dupont', '84_rue_JeanBatsite_Leblanc', '84_rue_JeanBatsite_Leblanc', 'da_1515', '2019-08-22', 20, 0);
INSERT INTO `commande` (`id_Commande`, `id_Utilisateur`, `nom`, `adresse_livraison`, `adresse_facturation`, `numero_commande`, `date_commande`, `montant_sans_remise`, `remise`) VALUES(3, 10, 'commande_Zuti', '11_ave_Nicolas_Lebas', '11_ave_Nicolas_Lebas', 'zm_1516', '2018-05-30', 100, 0);
INSERT INTO `commande` (`id_Commande`, `id_Utilisateur`, `nom`, `adresse_livraison`, `adresse_facturation`, `numero_commande`, `date_commande`, `montant_sans_remise`, `remise`) VALUES(4, 11, 'commande_Belka', '84_rue_deLommes', '84_rue_deLommes', 'bs_1517', '2017-03-15', 55, 0);
INSERT INTO `commande` (`id_Commande`, `id_Utilisateur`, `nom`, `adresse_livraison`, `adresse_facturation`, `numero_commande`, `date_commande`, `montant_sans_remise`, `remise`) VALUES(6, 9, 'commande_Dupont','84_rue_JeanBatsite_Leblanc','84_rue_JeanBatsite_Leblanc','da_1520','2016-09-30',80,0);
INSERT INTO `commande` (`id_Commande`, `id_Utilisateur`, `nom`, `adresse_livraison`, `adresse_facturation`, `numero_commande`, `date_commande`, `montant_sans_remise`, `remise`) VALUES(7, 7, 'commande_add', '19_rue_montebello', '19_rue_montebello', 'add_1570', '2017-09-30', 100, 0);

--
-- Déchargement des données de la table `produitvendu`
--

INSERT INTO `produitvendu` (`id_ProduitVendu`, `designation`, `reference`, `description`, `prix`, `image`, `numero_version`, `id_Produit_Historise`) VALUES(1, 'jardinage', 'AB3456', 'entretien de jardin', 30, 'jardinage.jpg', 1, 12);
INSERT INTO `produitvendu` (`id_ProduitVendu`, `designation`, `reference`, `description`, `prix`, `image`, `numero_version`, `id_Produit_Historise`) VALUES (2, 'demenagement', 'DE6789', 'service_au_demenagement', 40, 'demenagement.jpg', 1, 14);
INSERT INTO `produitvendu` (`id_ProduitVendu`, `designation`, `reference`, `description`, `prix`, `image`, `numero_version`, `id_Produit_Historise`) VALUES (3, 'demenagement 2', 'DE6789', 'service_au_demenagement', 50, 'demenagement.jpg', 2, 14);
INSERT INTO `produitvendu` (`id_ProduitVendu`, `designation`, `reference`, `description`, `prix`, `image`, `numero_version`, `id_Produit_Historise`) VALUES (4, 'demenagement 3', 'DE6789', 'service_au_demenagement', 60, 'demenagement.jpg', 3, 14);
INSERT INTO `produitvendu` (`id_ProduitVendu`, `designation`, `reference`, `description`, `prix`, `image`, `numero_version`, `id_Produit_Historise`) VALUES(10, 'jardinage', 'AB3456', 'entretien de jardin', 30, 'jardinage.jpg', 1, 12);
INSERT INTO `produitvendu` (`id_ProduitVendu`, `designation`, `reference`, `description`, `prix`, `image`, `numero_version`, `id_Produit_Historise`) VALUES (11, 'demenagement', 'DE6789', 'service_au_demenagement', 40, 'demenagement.jpg', 1, 14);

--
-- Déchargement des données de la table `commandeproduit`
--

INSERT INTO `commandeproduit` (`id_CommandeProduit`, `idCommande`, `id_ProduitVendu`, `quantite`) VALUES(1, 1, 1, 2);
INSERT INTO `commandeproduit` (`id_CommandeProduit`, `idCommande`, `id_ProduitVendu`, `quantite`) VALUES(2, 7, 10, 2);
INSERT INTO `commandeproduit` (`id_CommandeProduit`, `idCommande`, `id_ProduitVendu`, `quantite`) VALUES(2, 7, 11, 1);

--
-- Déchargement des données de la table `droit`
--

INSERT INTO `droit` (`id_Droit`, `url`, `description`) VALUES(2, 'voirConnecterUser.do', 'droit_de_connexion');
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
INSERT INTO `droit` (`id_Droit`, `url`, `description`) VALUES(14, 'afficherPanier.do', 'permet d''afficher le panier');
INSERT INTO `droit` (`id_Droit`, `url`, `description`) VALUES(15, 'voirCreerUser.do', 'droit de voir le formulaire de création d_un utilisateur');
INSERT INTO `droit` (`id_Droit`, `url`, `description`) VALUES(16, 'creerUser.do', 'droit de voir création d_un utilisateur');
INSERT INTO `droit` (`id_Droit`, `url`, `description`) VALUES(17, 'ajouterPanier.do', 'permet d ajouter au panier');
INSERT INTO `droit` (`id_Droit`, `url`, `description`) VALUES(18, 'voirCGU.do', 'droit de voir le CGU');
INSERT INTO `droit` (`id_Droit`, `url`, `description`) VALUES(19, 'afficherCGU.do', 'droit pour afficher le CGU');
INSERT INTO `droit` (`id_Droit`, `url`, `description`) VALUES(20, 'consulterUser.do', 'droit pour consulter le comte');
INSERT INTO `droit` (`id_Droit`, `url`, `description`) VALUES(21, 'afficherImage.do', 'droit pour afficher une image');
INSERT INTO `droit` (`id_Droit`, `url`, `description`) VALUES(22, 'editerUser.do', 'permet d_editer le compte de l_uilisateur');
INSERT INTO `droit` (`id_Droit`, `url`, `description`) VALUES(23, 'voirEditerProduit.do', 'permet d_aller sur editer produit');
INSERT INTO `droit` (`id_Droit`, `url`, `description`) VALUES(24, 'editerProduit.do', 'permet d_editer un produit');
INSERT INTO `droit` (`id_Droit`, `url`, `description`) VALUES(25, 'voirValiderPanier.do', 'permet d_aller sur le panier');
INSERT INTO `droit` (`id_Droit`, `url`, `description`) VALUES(26, 'validerPanier.do', 'permet de valider le panier');
INSERT INTO `droit` (`id_Droit`, `url`, `description`) VALUES(27, 'voirEditerUser.do', 'permet d_aller sur la page pour editer un user');
INSERT INTO `droit` (`id_Droit`, `url`, `description`) VALUES(28, 'viderPanier.do', 'permet d_aller sur la page pour vider');
INSERT INTO `droit` (`id_Droit`, `url`, `description`) VALUES(29, 'supprimerPanier.do', 'permet de supprimer le panier');

--
-- Déchargement des données de la table `profildroit`
--

INSERT INTO `profildroit` (`id_ProfilDroit`, `id_Profil`, `id_Droit`) VALUES(4, 1, 2);
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
INSERT INTO `profildroit` (`id_ProfilDroit`, `id_Profil`, `id_Droit`) VALUES(28, 3, 14);
INSERT INTO `profildroit` (`id_ProfilDroit`, `id_Profil`, `id_Droit`) VALUES(29, 2, 14);
INSERT INTO `profildroit` (`id_ProfilDroit`, `id_Profil`, `id_Droit`) VALUES(30, 1, 15);
INSERT INTO `profildroit` (`id_ProfilDroit`, `id_Profil`, `id_Droit`) VALUES(31, 1, 16);
INSERT INTO `profildroit` (`id_ProfilDroit`, `id_Profil`, `id_Droit`) VALUES(32, 3, 15);
INSERT INTO `profildroit` (`id_ProfilDroit`, `id_Profil`, `id_Droit`) VALUES(33, 3, 16);
INSERT INTO `profildroit` (`id_ProfilDroit`, `id_Profil`, `id_Droit`) VALUES(34, 2, 17);
INSERT INTO `profildroit` (`id_ProfilDroit`, `id_Profil`, `id_Droit`) VALUES(35, 3, 17);
INSERT INTO `profildroit` (`id_ProfilDroit`, `id_Profil`, `id_Droit`) VALUES(36, 1, 18);
INSERT INTO `profildroit` (`id_ProfilDroit`, `id_Profil`, `id_Droit`) VALUES(37, 2, 18);
INSERT INTO `profildroit` (`id_ProfilDroit`, `id_Profil`, `id_Droit`) VALUES(38, 3, 18);
INSERT INTO `profildroit` (`id_ProfilDroit`, `id_Profil`, `id_Droit`) VALUES(39, 1, 19);
INSERT INTO `profildroit` (`id_ProfilDroit`, `id_Profil`, `id_Droit`) VALUES(40, 2, 19);
INSERT INTO `profildroit` (`id_ProfilDroit`, `id_Profil`, `id_Droit`) VALUES(41, 3, 19);
INSERT INTO `profildroit` (`id_ProfilDroit`, `id_Profil`, `id_Droit`) VALUES(42, 2, 20);
INSERT INTO `profildroit` (`id_ProfilDroit`, `id_Profil`, `id_Droit`) VALUES(43, 3, 20);
INSERT INTO `profildroit` (`id_ProfilDroit`, `id_Profil`, `id_Droit`) VALUES(44, 1, 21);
INSERT INTO `profildroit` (`id_ProfilDroit`, `id_Profil`, `id_Droit`) VALUES(45, 2, 21);
INSERT INTO `profildroit` (`id_ProfilDroit`, `id_Profil`, `id_Droit`) VALUES(46, 3, 21);
INSERT INTO `profildroit` (`id_ProfilDroit`, `id_Profil`, `id_Droit`) VALUES(47, 2, 22);
INSERT INTO `profildroit` (`id_ProfilDroit`, `id_Profil`, `id_Droit`) VALUES(48, 3, 22);
INSERT INTO `profildroit` (`id_ProfilDroit`, `id_Profil`, `id_Droit`) VALUES(49, 3, 23);
INSERT INTO `profildroit` (`id_ProfilDroit`, `id_Profil`, `id_Droit`) VALUES(50, 3, 24);
INSERT INTO `profildroit` (`id_ProfilDroit`, `id_Profil`, `id_Droit`) VALUES(51, 2, 25);
INSERT INTO `profildroit` (`id_ProfilDroit`, `id_Profil`, `id_Droit`) VALUES(52, 3, 25);
INSERT INTO `profildroit` (`id_ProfilDroit`, `id_Profil`, `id_Droit`) VALUES(53, 2, 26);
INSERT INTO `profildroit` (`id_ProfilDroit`, `id_Profil`, `id_Droit`) VALUES(54, 3, 26);
INSERT INTO `profildroit` (`id_ProfilDroit`, `id_Profil`, `id_Droit`) VALUES(55, 2, 27);
INSERT INTO `profildroit` (`id_ProfilDroit`, `id_Profil`, `id_Droit`) VALUES(56, 3, 27);
INSERT INTO `profildroit` (`id_ProfilDroit`, `id_Profil`, `id_Droit`) VALUES(57, 2, 28);
INSERT INTO `profildroit` (`id_ProfilDroit`, `id_Profil`, `id_Droit`) VALUES(58, 3, 28);
INSERT INTO `profildroit` (`id_ProfilDroit`, `id_Profil`, `id_Droit`) VALUES(59, 2, 29);
INSERT INTO `profildroit` (`id_ProfilDroit`, `id_Profil`, `id_Droit`) VALUES(60, 3, 29);

--
-- Déchargement des données de la table `produit`
--

INSERT INTO `produit` (`id_Produit`, `designation`, `reference`, `description`, `prix`, `image`, `numero_version`, `actif`) VALUES(12, 'jardinage 2', 'AB3456', 'entretien de jardin', 40, 'jardinage.jpg', 2, b'1');
INSERT INTO `produit` (`id_Produit`, `designation`, `reference`, `description`, `prix`, `image`, `numero_version`, `actif`) VALUES(13, 'menage', 'BC7654', 'entretien d_interieur', 20, 'null', 1, b'0');
INSERT INTO `produit` (`id_Produit`, `designation`, `reference`, `description`, `prix`, `image`, `numero_version`, `actif`) VALUES(14, 'demenagement 3', 'DE6789', 'service_au_demenagement', 60, 'demenagement.jpg', 3, b'1');
INSERT INTO `produit` (`id_Produit`, `designation`, `reference`, `description`, `prix`, `image`, `numero_version`, `actif`) VALUES(15, 'bricolage', 'FG1234', 'petits travaux de reparation', 50, 'null', 1, b'0');
INSERT INTO `produit` (`id_Produit`, `designation`, `reference`, `description`, `prix`, `image`, `numero_version`, `actif`) VALUES(16, 'assistance informatique', 'HI5678', 'installation de logiciels', 25, 'null', 1, b'0');
INSERT INTO `produit` (`id_Produit`, `designation`, `reference`, `description`, `prix`, `image`, `numero_version`, `actif`) VALUES(17, 'soutien scolaire', 'JK9123', 'aide aux devoirs', 25, 'null', 1, b'0');
INSERT INTO `produit` (`id_Produit`, `designation`, `reference`, `description`, `prix`, `image`, `numero_version`, `actif`) VALUES(18, 'mecanique', 'JK9123', 'reparations mecaniques', 75, 'null', 1, b'1');

--
-- Enrichissement Produit/ProduitVendu
--
INSERT INTO `produit` (`id_Produit`, `designation`, `reference`, `description`, `prix`, `image`, `numero_version`, `actif`) VALUES(18, 'mecanique', 'JK9123', 'reparations mecaniques', 75, 'null', 1, b'1');


-- 

-- jardinage v2
update produit set designation = 'jardinage 2', numero_version = 2, prix = 40 where id_produit = 12 ;

-- demenagement v3
update produit set designation = 'demenagement 3', numero_version = 3, prix = 60 where id_produit = 14 ;
INSERT INTO `produitvendu` (`id_ProduitVendu`, `designation`, `reference`, `description`, `prix`, `image`, `numero_version`, `id_Produit_Historise`) VALUES (2, 'demenagement', 'DE6789', 'service_au_demenagement', '40', 'demenagement.jpg', '1', '14'), (3, 'demenagement 2', 'DE6789', 'service_au_demenagement', '50', 'demenagement.jpg', '2', '14');
INSERT INTO `produitvendu` (`id_ProduitVendu`, `designation`, `reference`, `description`, `prix`, `image`, `numero_version`, `id_Produit_Historise`) VALUES (4, 'demenagement 3', 'DE6789', 'service_au_demenagement', '60', 'demenagement.jpg', '3', '14');
COMMIT;




/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

