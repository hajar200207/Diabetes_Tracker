-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : ven. 07 juin 2024 à 16:36
-- Version du serveur : 8.3.0
-- Version de PHP : 8.2.18

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `database_diabetes_tracker`
--

-- --------------------------------------------------------

--
-- Structure de la table `conseils`
--

DROP TABLE IF EXISTS `conseils`;
CREATE TABLE IF NOT EXISTS `conseils` (
  `conseil_id` int NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `niveaux_max` float DEFAULT NULL,
  `niveaux_min` float DEFAULT NULL,
  `photo` longblob,
  PRIMARY KEY (`conseil_id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `conseils`
--

INSERT INTO `conseils` (`conseil_id`, `description`, `niveaux_max`, `niveaux_min`, `photo`) VALUES
(1, 'Description du conseil 1', 120, 80, 0x6368656d696e2f766572732f70686f746f312e6a7067),
(2, 'Description du conseil 2', 140, 100, 0x6368656d696e2f766572732f70686f746f322e6a7067);

-- --------------------------------------------------------

--
-- Structure de la table `glycemies`
--

DROP TABLE IF EXISTS `glycemies`;
CREATE TABLE IF NOT EXISTS `glycemies` (
  `glycemie_id` int NOT NULL AUTO_INCREMENT,
  `date` datetime DEFAULT NULL,
  `heure` time DEFAULT NULL,
  `niveauGlycemie` float DEFAULT NULL,
  `patient_id` int DEFAULT NULL,
  `niveau_glycemie` float DEFAULT NULL,
  `patientId` int NOT NULL,
  PRIMARY KEY (`glycemie_id`),
  KEY `FKab1bhrphaed62ey77qys4xjon` (`patient_id`)
) ENGINE=MyISAM AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `glycemies`
--

INSERT INTO `glycemies` (`glycemie_id`, `date`, `heure`, `niveauGlycemie`, `patient_id`, `niveau_glycemie`, `patientId`) VALUES
(20, '2024-06-06 00:00:00', '11:42:00', NULL, 1, 12, 0),
(24, '2024-06-08 00:00:00', '10:03:00', NULL, 1, 110.2, 0);

-- --------------------------------------------------------

--
-- Structure de la table `patients`
--

DROP TABLE IF EXISTS `patients`;
CREATE TABLE IF NOT EXISTS `patients` (
  `patient_id` int NOT NULL AUTO_INCREMENT,
  `age` int DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `poids` float DEFAULT NULL,
  `taille` int DEFAULT NULL,
  PRIMARY KEY (`patient_id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `patients`
--

INSERT INTO `patients` (`patient_id`, `age`, `nom`, `poids`, `taille`) VALUES
(1, 21, 'hajarEE', 75, 456),
(2, 21, 'HAJAROUADI', 75, 185),
(3, 21, 'HAJAROUADI', 75, 185);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
