-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : ven. 16 juin 2023 à 16:05
-- Version du serveur : 10.4.28-MariaDB
-- Version de PHP : 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `hopitalbd`
--

-- --------------------------------------------------------

--
-- Structure de la table `agent_admin`
--

CREATE TABLE `agent_admin` (
  `agent_admin_id` int(30) NOT NULL,
  `nom` varchar(20) DEFAULT NULL,
  `prenom` varchar(20) DEFAULT NULL,
  `date_naissance` date DEFAULT NULL,
  `sexe` char(1) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `mdp` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `agent_admin`
--

INSERT INTO `agent_admin` (`agent_admin_id`, `nom`, `prenom`, `date_naissance`, `sexe`, `email`, `mdp`) VALUES
(1, 'GAROU', 'Bertrand', '1991-06-02', 'M', 'beber@laposte.net', '1234'),
(2, 'BELIER', 'Gwendoline', '1965-02-02', 'F', 'sfdf@kjjsdf.fd', 'motdepasse'),
(4, 'DE LA RONDE', 'Onfroi', '1987-05-14', 'M', 'onfroi@gmail.com', 'motdepasse'),
(5, 'CAOUETTE', 'Ray', '1965-02-02', 'M', 'raycaouette@gmail.fr', 'motdepasse'),
(6, 'DESRUISSEAUX', 'France', '1991-06-02', 'F', 'desruisseau@gmail.com', 'motdepasse'),
(7, 'BERARD', 'Demi', '1987-06-03', 'F', 'kjsqdf@gmail.com', 'motdepasse'),
(8, 'BARRIERE', 'Faustin', '1991-06-02', 'M', 'faustinbar@gmail.com', 'motdepasse'),
(9, 'ROYER', 'Pascaline', '1984-06-03', 'F', 'pascalineroyer@gmail.com', 'motdepasse'),
(10, 'SEVIER', 'Audrey', '1991-02-02', 'F', 'lkjqpooiusd@gmail.com', 'motdepasse');

-- --------------------------------------------------------

--
-- Structure de la table `appareil`
--

CREATE TABLE `appareil` (
  `appareil_id` int(30) UNSIGNED NOT NULL,
  `libelle` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `appareil`
--

INSERT INTO `appareil` (`appareil_id`, `libelle`) VALUES
(1, 'prothèse de hanche'),
(2, 'Pacemaker'),
(3, 'Béquille'),
(4, 'Fauteuil roulant'),
(5, 'Orthèse tubulaire adaptée'),
(6, 'Bandes de compression/contention médicale');

-- --------------------------------------------------------

--
-- Structure de la table `chambre`
--

CREATE TABLE `chambre` (
  `id` int(30) UNSIGNED NOT NULL,
  `capacite` int(30) DEFAULT NULL,
  `service_id` int(30) UNSIGNED DEFAULT NULL,
  `nb_patients` int(50) UNSIGNED DEFAULT NULL,
  `infirmier_id` int(30) UNSIGNED DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `chambre`
--

INSERT INTO `chambre` (`id`, `capacite`, `service_id`, `nb_patients`, `infirmier_id`) VALUES
(1, 1, 1, 1, 1),
(2, 2, 2, NULL, 2),
(3, 2, 3, 0, 1),
(4, 2, 2, NULL, 2),
(5, 3, 3, 0, 1),
(6, 2, 4, NULL, 3),
(7, 2, 3, 0, 3),
(8, 3, 6, 0, 1),
(9, 4, 6, 0, 3),
(10, 2, 6, 0, 2),
(11, 4, 7, 0, 1),
(12, 3, 7, 0, 3),
(13, 2, 5, 2, 1),
(14, 2, 5, 0, 3),
(15, 4, 4, 0, 3),
(16, 4, 7, 0, 3),
(17, 3, 1, 1, 11),
(18, 3, 1, 0, 8),
(19, 3, 1, 0, 7),
(20, 4, 1, 0, 6);

-- --------------------------------------------------------

--
-- Structure de la table `consultation`
--

CREATE TABLE `consultation` (
  `consultation_id` int(30) UNSIGNED NOT NULL,
  `suivi_id` int(30) UNSIGNED NOT NULL,
  `date_consultation` date DEFAULT NULL,
  `appareil_id` int(30) UNSIGNED DEFAULT NULL,
  `statut_appareil` varchar(50) DEFAULT NULL,
  `ordonnance` varchar(500) DEFAULT NULL,
  `soin` varchar(500) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `consultation`
--

INSERT INTO `consultation` (`consultation_id`, `suivi_id`, `date_consultation`, `appareil_id`, `statut_appareil`, `ordonnance`, `soin`) VALUES
(18, 18, '2023-06-16', NULL, NULL, 'Ordonnance : \n\nmédicament contre la shizophrénie pendant toute la vie', 'Soin : '),
(19, 19, '2023-06-16', NULL, NULL, 'Ordonnance : \n\nanxiolitique pendant 3 mois', 'Soin : \n\nhospitalisation 2 semaine'),
(20, 20, '2023-06-16', 6, 'octroyé', 'null', 'null'),
(21, 24, '2023-06-16', 3, 'instance', 'Ordonnance : ', 'Soin : \nhospitalisation 3 jours'),
(22, 23, '2023-06-16', 4, 'instance', 'Ordonnance : \n\nanti douleurs', 'Soin : \nhospitalisation\n2 semaines'),
(23, 20, '2023-06-16', NULL, NULL, NULL, NULL),
(24, 22, '2023-06-16', NULL, NULL, NULL, NULL),
(25, 25, '2023-06-16', 2, 'instance', 'Ordonnance : \n\nanabolisant', 'Soin : \n\nopération installation pacemaker'),
(26, 26, '2023-06-16', NULL, NULL, NULL, NULL),
(27, 27, '2023-06-16', NULL, NULL, 'Ordonnance : \n\nanti biotiques', 'Soin : \n\nquarantaine à résidence'),
(28, 28, '2023-06-16', NULL, NULL, 'Ordonnance : \n\nanti biotiques', 'Soin : \n\nhospitalisation soin intensif'),
(29, 28, '2023-06-16', NULL, NULL, 'Ordonnance : \n\nanti biotiques', 'Soin : \n\nhospitalisation soin intensif'),
(30, 32, '2023-06-16', NULL, NULL, NULL, NULL),
(31, 31, '2023-06-16', NULL, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `infirmier`
--

CREATE TABLE `infirmier` (
  `infirmier_id` int(30) UNSIGNED NOT NULL,
  `nom` varchar(50) DEFAULT NULL,
  `prenom` varchar(50) DEFAULT NULL,
  `date_naissance` date DEFAULT NULL,
  `sexe` char(1) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `mdp` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `infirmier`
--

INSERT INTO `infirmier` (`infirmier_id`, `nom`, `prenom`, `date_naissance`, `sexe`, `email`, `mdp`) VALUES
(1, 'FERDINAND', 'Claudine', '1658-01-01', 'F', 'claudine@hotmail.fr', 'motdepasse'),
(2, 'CHARRETTE', 'Yolande', '1968-07-08', 'F', 'yolande@yahoo.fr', 'motdepasse'),
(3, 'GAULIN', 'Dixie', '1987-06-03', 'M', 'dixgaud@yahoo.fr', 'motdepasse'),
(5, 'ETOILE', 'Michel', '1968-07-08', 'M', 'yuerizo@gmail.com', 'motdepasse'),
(6, 'PARISEAU', 'Adélaïde', '1965-06-02', 'F', 'adelaidepariseau@gmail.com', 'motdepasse'),
(7, 'CORBIN', 'Auriville', '2013-06-11', 'M', 'corbin@gmail.com', 'motdepasse'),
(8, 'RACICOT', 'Sybila', '1947-12-12', 'F', 'sybracicot@yahoo.com', 'motdepasse'),
(9, 'LETOURNEAU', 'Paige', '2013-06-19', 'F', 'kjsdhfzaze@hotmail.fr', 'motdepasse'),
(10, 'FECTEAU', 'Merlin', '1990-07-03', 'M', 'merlinfecteau@gmail.com', 'motdepasse'),
(11, 'LABELLE', 'Merle', '1996-11-11', 'M', 'merle@yahho.fr', 'motdepasse');

-- --------------------------------------------------------

--
-- Structure de la table `medecin`
--

CREATE TABLE `medecin` (
  `medecin_id` int(30) UNSIGNED NOT NULL,
  `nom` varchar(20) DEFAULT NULL,
  `prenom` varchar(20) DEFAULT NULL,
  `date_naissance` date DEFAULT NULL,
  `sexe` char(1) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `mdp` varchar(50) NOT NULL,
  `service_id` int(30) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `medecin`
--

INSERT INTO `medecin` (`medecin_id`, `nom`, `prenom`, `date_naissance`, `sexe`, `email`, `mdp`, `service_id`) VALUES
(3, 'LEGRAND', 'Georges', '1985-05-16', 'M', 'legranddu44@hotmail.com', 'motdepasse', 1),
(14, 'RICHARD', 'Patricia', '1965-03-12', 'F', 'kjsqdfh@jg.fr', 'motdepasse2', 3),
(16, 'GERARD', 'Charlotte', '1971-02-10', 'F', 'chacha@yahoo.fr', 'motdepasse', 1),
(18, 'PINAUD', 'Charles-Henri', '1987-09-15', 'M', 'charlypinaud@yahoo.fr', 'motdepasse', 2),
(20, 'CHARLIE', 'Tristan', '1994-10-10', 'M', 'ksjdfhjsd@yahoo.fr', 'motdepasse', 1),
(22, 'FLETAN', 'Diana', '1984-06-09', 'F', 'fletandiana@yahoo.fr', 'motdepasse', 4),
(26, 'LEBEL', 'Monique', '1989-06-09', 'F', 'koiuyuio@hotmail.fr', 'motdepasse', 5),
(27, 'DAGENAIS', 'Christine', '1965-02-01', 'F', 'dagenais@gmail.com', 'motdepasse', 7),
(28, 'JOBIN', 'Louis', '1991-08-02', 'M', 'louisjobin@gmail.com', 'motdepasse', 8),
(29, 'BUREAU', 'Vincent', '1965-04-02', 'M', 'vincentbureau@gmail.com', 'motdepasse', 6);

-- --------------------------------------------------------

--
-- Structure de la table `pathologie`
--

CREATE TABLE `pathologie` (
  `pathologie_id` int(30) UNSIGNED NOT NULL,
  `nom` varchar(50) DEFAULT NULL,
  `service` int(30) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `pathologie`
--

INSERT INTO `pathologie` (`pathologie_id`, `nom`, `service`) VALUES
(1, 'covid 19', 3),
(2, 'trouble anxieux généralisé', 1),
(4, 'trouble bipolaire', 1),
(5, 'schizophrénie', 1),
(6, 'dépression', 1),
(7, 'Sida', 3),
(8, 'Méningite', 3),
(9, 'Gastrites', 2),
(10, 'Ulcère', 2),
(11, 'Lithiases', 2),
(12, 'Pancréatite', 2),
(13, 'Coxarthrose', 4),
(14, 'Grippe', 3),
(15, 'Embolie pulmonaire', 5),
(16, 'Amylose cardiaque', 5),
(17, 'Infarctus du myocarde', 5),
(18, 'Angor', 5),
(19, 'Spondylarthrites', 6),
(20, 'Polyarthrite rhumatoïde', 6),
(21, 'lombalgie', 6),
(22, 'ostéoporose', 6);

-- --------------------------------------------------------

--
-- Structure de la table `patient`
--

CREATE TABLE `patient` (
  `patient_id` int(30) UNSIGNED NOT NULL,
  `nom` varchar(30) DEFAULT NULL,
  `prenom` varchar(30) DEFAULT NULL,
  `date_naissance` date DEFAULT NULL,
  `date_creation` date DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  `sexe` char(1) DEFAULT NULL,
  `chambre_id` int(30) UNSIGNED DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `patient`
--

INSERT INTO `patient` (`patient_id`, `nom`, `prenom`, `date_naissance`, `date_creation`, `email`, `sexe`, `chambre_id`) VALUES
(5, 'MIRA', 'Jagoda', '2016-08-17', '2023-05-01', 'mjagoda@laposte.net', 'M', NULL),
(6, 'ZIYNET', 'Fred', '2013-01-17', '2023-05-24', 'z.fred@yahoo.fr', 'M', 17),
(8, 'DURAND', 'Louise', '1968-07-08', '2023-06-20', 'lousedurand@gmail.com', 'F', NULL),
(9, 'MOREAU', 'Saville', '1974-05-02', '2023-06-19', 'moreau@gmail.com', 'F', NULL),
(10, 'DEZIEL', 'Violette', '1976-05-03', '2023-04-11', 'kljsdf@gmail.com', 'F', NULL),
(11, 'PATEL', 'Francis', '1965-12-03', '2023-01-23', 'lksdqfj@yahoo.fr', 'M', 13),
(12, 'PARMENTIER', 'Claude', '1973-11-14', '2023-10-17', 'kjsqdfyuio@gmail.fr', 'M', NULL),
(13, 'PROULX', 'Yvon', '1955-11-05', '2023-06-22', 'kjsqdhf@gmail.com', 'M', 13),
(14, 'BIRON', 'Melusina', '1996-11-11', '2022-01-03', 'ertyuiop@yahoo.fr', 'M', NULL),
(15, 'BLER', 'Emile', '1999-01-02', '2022-01-03', 'poiuazer@hotmail.fr', 'M', NULL),
(16, 'MERCURE', 'Grégoire', '1991-02-03', '2020-12-26', 'poaiuzeuiez@hotmail.fr', 'M', NULL),
(17, 'MAROIS', 'Victorine', '1990-11-11', '2022-12-24', 'zaopeixbcv@yahoo.fr', 'M', NULL),
(20, 'LABRIE', 'André', '1987-01-12', '2023-06-16', 'andre@jmail.com', 'M', 1);

-- --------------------------------------------------------

--
-- Structure de la table `service`
--

CREATE TABLE `service` (
  `service_id` int(30) UNSIGNED NOT NULL,
  `nom` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `service`
--

INSERT INTO `service` (`service_id`, `nom`) VALUES
(1, 'Psychiatrie'),
(2, 'Hépato-gastro-entérologie'),
(3, 'Maladies infectieuses'),
(4, 'Chirurgie orthopédique et traumatologique'),
(5, 'Cardiologie'),
(6, 'Rhumatologie'),
(7, 'Urgences'),
(8, 'Médecine générale');

-- --------------------------------------------------------

--
-- Structure de la table `suivi`
--

CREATE TABLE `suivi` (
  `suivi_id` int(30) UNSIGNED NOT NULL,
  `medecin_id` int(30) UNSIGNED NOT NULL,
  `patient_id` int(30) UNSIGNED NOT NULL,
  `pathologie_id` int(30) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `suivi`
--

INSERT INTO `suivi` (`suivi_id`, `medecin_id`, `patient_id`, `pathologie_id`) VALUES
(18, 3, 20, 5),
(19, 3, 6, 4),
(20, 29, 11, 21),
(21, 29, 13, 20),
(22, 29, 11, 19),
(23, 29, 15, 22),
(24, 29, 17, 21),
(25, 26, 11, 16),
(26, 26, 13, 17),
(27, 14, 6, 1),
(28, 14, 9, 1),
(29, 14, 14, 1),
(30, 14, 16, 14),
(31, 14, 15, 1),
(32, 14, 17, 8);

-- --------------------------------------------------------

--
-- Structure de la table `super_admin`
--

CREATE TABLE `super_admin` (
  `id` int(30) NOT NULL,
  `nom` varchar(50) DEFAULT NULL,
  `prenom` varchar(50) DEFAULT NULL,
  `date_naissance` date DEFAULT NULL,
  `sexe` char(1) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `mdp` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `super_admin`
--

INSERT INTO `super_admin` (`id`, `nom`, `prenom`, `date_naissance`, `sexe`, `email`, `mdp`) VALUES
(1, 'DUPOND', 'Jean', '1957-01-01', 'M', 'jean.d@hotmail.fr', 'motdepasse');

-- --------------------------------------------------------

--
-- Structure de la table `technicien`
--

CREATE TABLE `technicien` (
  `technicien_id` int(30) UNSIGNED NOT NULL,
  `nom` varchar(20) DEFAULT NULL,
  `prenom` varchar(20) DEFAULT NULL,
  `date_naissance` date DEFAULT NULL,
  `sexe` char(1) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `mdp` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `technicien`
--

INSERT INTO `technicien` (`technicien_id`, `nom`, `prenom`, `date_naissance`, `sexe`, `email`, `mdp`) VALUES
(1, 'RENOIR', 'Harry', '1948-05-05', 'M', 'renoirharry@yahoo.fr', 'motdepasse'),
(2, 'RENAUD', 'Jonathan', '1963-04-01', 'M', 'jojo@yahoo.fr', 'motdepasse'),
(3, 'TURANAU', 'Becky', '1973-04-07', 'F', 'turanaubeck@yahoo.fr', 'motdepasse');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `agent_admin`
--
ALTER TABLE `agent_admin`
  ADD PRIMARY KEY (`agent_admin_id`);

--
-- Index pour la table `appareil`
--
ALTER TABLE `appareil`
  ADD PRIMARY KEY (`appareil_id`);

--
-- Index pour la table `chambre`
--
ALTER TABLE `chambre`
  ADD PRIMARY KEY (`id`),
  ADD KEY `service_id` (`service_id`),
  ADD KEY `infirmier_id` (`infirmier_id`);

--
-- Index pour la table `consultation`
--
ALTER TABLE `consultation`
  ADD PRIMARY KEY (`consultation_id`),
  ADD KEY `fk_suivi` (`suivi_id`),
  ADD KEY `appareil_id` (`appareil_id`);

--
-- Index pour la table `infirmier`
--
ALTER TABLE `infirmier`
  ADD PRIMARY KEY (`infirmier_id`);

--
-- Index pour la table `medecin`
--
ALTER TABLE `medecin`
  ADD PRIMARY KEY (`medecin_id`),
  ADD KEY `fk_medecin_service` (`service_id`) USING BTREE;

--
-- Index pour la table `pathologie`
--
ALTER TABLE `pathologie`
  ADD PRIMARY KEY (`pathologie_id`),
  ADD KEY `fk_pathologie_service` (`service`);

--
-- Index pour la table `patient`
--
ALTER TABLE `patient`
  ADD PRIMARY KEY (`patient_id`),
  ADD KEY `chambre_id` (`chambre_id`);

--
-- Index pour la table `service`
--
ALTER TABLE `service`
  ADD PRIMARY KEY (`service_id`);

--
-- Index pour la table `suivi`
--
ALTER TABLE `suivi`
  ADD PRIMARY KEY (`suivi_id`),
  ADD KEY `medecin_id` (`medecin_id`),
  ADD KEY `patient_id` (`patient_id`),
  ADD KEY `pathologie_id` (`pathologie_id`);

--
-- Index pour la table `super_admin`
--
ALTER TABLE `super_admin`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `technicien`
--
ALTER TABLE `technicien`
  ADD PRIMARY KEY (`technicien_id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `agent_admin`
--
ALTER TABLE `agent_admin`
  MODIFY `agent_admin_id` int(30) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT pour la table `appareil`
--
ALTER TABLE `appareil`
  MODIFY `appareil_id` int(30) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT pour la table `chambre`
--
ALTER TABLE `chambre`
  MODIFY `id` int(30) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT pour la table `consultation`
--
ALTER TABLE `consultation`
  MODIFY `consultation_id` int(30) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=32;

--
-- AUTO_INCREMENT pour la table `infirmier`
--
ALTER TABLE `infirmier`
  MODIFY `infirmier_id` int(30) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT pour la table `medecin`
--
ALTER TABLE `medecin`
  MODIFY `medecin_id` int(30) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=30;

--
-- AUTO_INCREMENT pour la table `pathologie`
--
ALTER TABLE `pathologie`
  MODIFY `pathologie_id` int(30) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- AUTO_INCREMENT pour la table `patient`
--
ALTER TABLE `patient`
  MODIFY `patient_id` int(30) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT pour la table `service`
--
ALTER TABLE `service`
  MODIFY `service_id` int(30) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT pour la table `suivi`
--
ALTER TABLE `suivi`
  MODIFY `suivi_id` int(30) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=33;

--
-- AUTO_INCREMENT pour la table `super_admin`
--
ALTER TABLE `super_admin`
  MODIFY `id` int(30) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT pour la table `technicien`
--
ALTER TABLE `technicien`
  MODIFY `technicien_id` int(30) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `chambre`
--
ALTER TABLE `chambre`
  ADD CONSTRAINT `infirmier_id` FOREIGN KEY (`infirmier_id`) REFERENCES `infirmier` (`infirmier_id`),
  ADD CONSTRAINT `service_id` FOREIGN KEY (`service_id`) REFERENCES `service` (`service_id`);

--
-- Contraintes pour la table `consultation`
--
ALTER TABLE `consultation`
  ADD CONSTRAINT `appareil_id` FOREIGN KEY (`appareil_id`) REFERENCES `appareil` (`appareil_id`),
  ADD CONSTRAINT `fk_suivi` FOREIGN KEY (`suivi_id`) REFERENCES `suivi` (`suivi_id`);

--
-- Contraintes pour la table `medecin`
--
ALTER TABLE `medecin`
  ADD CONSTRAINT `fk_service` FOREIGN KEY (`service_id`) REFERENCES `service` (`service_id`);

--
-- Contraintes pour la table `pathologie`
--
ALTER TABLE `pathologie`
  ADD CONSTRAINT `fk_pathologie_service` FOREIGN KEY (`service`) REFERENCES `service` (`service_id`);

--
-- Contraintes pour la table `patient`
--
ALTER TABLE `patient`
  ADD CONSTRAINT `chambre_id` FOREIGN KEY (`chambre_id`) REFERENCES `chambre` (`id`);

--
-- Contraintes pour la table `suivi`
--
ALTER TABLE `suivi`
  ADD CONSTRAINT `suivi_ibfk_1` FOREIGN KEY (`medecin_id`) REFERENCES `medecin` (`medecin_id`),
  ADD CONSTRAINT `suivi_ibfk_2` FOREIGN KEY (`patient_id`) REFERENCES `patient` (`patient_id`),
  ADD CONSTRAINT `suivi_ibfk_3` FOREIGN KEY (`pathologie_id`) REFERENCES `pathologie` (`pathologie_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
