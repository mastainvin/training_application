-- phpMyAdmin SQL Dump
-- version 4.9.5deb2
-- https://www.phpmyadmin.net/
--
-- Hôte : localhost:3306
-- Généré le : mer. 30 mars 2022 à 11:11
-- Version du serveur :  8.0.28-0ubuntu0.20.04.3
-- Version de PHP : 7.4.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `Training_application`
--

-- --------------------------------------------------------

--
-- Structure de la table `BodyLimb`
--

CREATE TABLE `BodyLimb` (
  `id_BodyLimb` int NOT NULL,
  `name` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `CanTrainOn`
--

CREATE TABLE `CanTrainOn` (
  `id_user` int NOT NULL,
  `id_disponibility` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `CompatibleDisponibility`
--

CREATE TABLE `CompatibleDisponibility` (
  `id_structure` int NOT NULL,
  `id_disponibility` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `CompatibleEquipment`
--

CREATE TABLE `CompatibleEquipment` (
  `id_exercice` int NOT NULL,
  `id_equipment` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `CompatibleLimb`
--

CREATE TABLE `CompatibleLimb` (
  `id_exercice` int NOT NULL,
  `id_BodyLimb` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `CompatibleMorph`
--

CREATE TABLE `CompatibleMorph` (
  `id_exercice` int NOT NULL,
  `id_morphology` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `ComposeTraining`
--

CREATE TABLE `ComposeTraining` (
  `id_training` int NOT NULL,
  `id_type` int NOT NULL,
  `id_training_method` int NOT NULL,
  `layout` int DEFAULT '0',
  `is_super_set` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `Disponibility`
--

CREATE TABLE `Disponibility` (
  `id_disponibility` int NOT NULL,
  `duration` int DEFAULT '0',
  `layout` int DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `Equipment`
--

CREATE TABLE `Equipment` (
  `id_equipment` int NOT NULL,
  `name` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `Exercice`
--

CREATE TABLE `Exercice` (
  `id_exercice` int NOT NULL,
  `name` varchar(30) DEFAULT NULL,
  `description` varchar(400) DEFAULT NULL,
  `met` float DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `ExerciceType`
--

CREATE TABLE `ExerciceType` (
  `id_exercice_type` int NOT NULL,
  `name` varchar(30) DEFAULT NULL,
  `description` varchar(400) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `ExerciceTyping`
--

CREATE TABLE `ExerciceTyping` (
  `id_exercice` int NOT NULL,
  `id_exercice_type` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `Goal`
--

CREATE TABLE `Goal` (
  `id_goal` int NOT NULL,
  `duration` int DEFAULT '0',
  `rest_duration` int DEFAULT '0',
  `velocity` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `GoalNbRep`
--

CREATE TABLE `GoalNbRep` (
  `id_GoalNbRep` int NOT NULL,
  `min` int DEFAULT '0',
  `max` int DEFAULT '0',
  `id_goal` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `GoalNbSerie`
--

CREATE TABLE `GoalNbSerie` (
  `id_GoalNbSerie` int NOT NULL,
  `min` int DEFAULT '0',
  `max` int DEFAULT '0',
  `id_goal` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `GoalWeight`
--

CREATE TABLE `GoalWeight` (
  `id_GoalWeight` int NOT NULL,
  `min` int DEFAULT '0',
  `max` int DEFAULT '0',
  `id_goal` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `HasEquipment`
--

CREATE TABLE `HasEquipment` (
  `id_user` int NOT NULL,
  `id_equipment` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `Morphology`
--

CREATE TABLE `Morphology` (
  `id_morphology` int NOT NULL,
  `name` varchar(30) DEFAULT NULL,
  `description` varchar(400) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `Role`
--

CREATE TABLE `Role` (
  `id_role` int NOT NULL,
  `name` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `Serie`
--

CREATE TABLE `Serie` (
  `id_serie` int NOT NULL,
  `date` date DEFAULT NULL,
  `weight` float DEFAULT '0',
  `repetitions` int DEFAULT '0',
  `rpe` int DEFAULT '0',
  `expected_repetitions` int DEFAULT '0',
  `expected_weight` int DEFAULT '0',
  `id_compose_training_training` int DEFAULT NULL,
  `id_compose_training_type` int DEFAULT NULL,
  `id_compose_training_method` int DEFAULT NULL,
  `id_user` int DEFAULT NULL,
  `id_exercice` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `Structure`
--

CREATE TABLE `Structure` (
  `id_structure` int NOT NULL,
  `name` varchar(30) DEFAULT NULL,
  `id_goal` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `Training`
--

CREATE TABLE `Training` (
  `id_training` int NOT NULL,
  `name` varchar(30) DEFAULT NULL,
  `description` varchar(400) DEFAULT NULL,
  `id_structure` int DEFAULT NULL,
  `id_training_type` int DEFAULT NULL,
  `layout` int DEFAULT '0',
  `duration` int DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `TrainingMethod`
--

CREATE TABLE `TrainingMethod` (
  `id_training_method` int NOT NULL,
  `name` varchar(30) DEFAULT NULL,
  `math_function` varchar(30) DEFAULT NULL,
  `rep_max` int DEFAULT '0',
  `rep_min` int DEFAULT '0',
  `weight_max` int DEFAULT '0',
  `weight_min` int DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `TrainingType`
--

CREATE TABLE `TrainingType` (
  `id_training_type` int NOT NULL,
  `name` varchar(30) DEFAULT NULL,
  `description` varchar(400) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `UseLimb`
--

CREATE TABLE `UseLimb` (
  `id_user` int NOT NULL,
  `id_BodyLimb` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `User`
--

CREATE TABLE `User` (
  `id_user` int NOT NULL,
  `pseudonym` varchar(30) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `email` varchar(40) DEFAULT NULL,
  `size` float DEFAULT '0',
  `weight` float DEFAULT '0',
  `gender` int DEFAULT NULL,
  `body_fat` float DEFAULT '0',
  `muscle_mass` float DEFAULT '0',
  `id_role` int DEFAULT NULL,
  `id_morphology` int DEFAULT NULL,
  `id_goal` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `UserExerciceData`
--

CREATE TABLE `UserExerciceData` (
  `id_exercice` int NOT NULL,
  `id_user` int NOT NULL,
  `weigth` float DEFAULT '0',
  `mark` int DEFAULT '5'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `BodyLimb`
--
ALTER TABLE `BodyLimb`
  ADD PRIMARY KEY (`id_BodyLimb`);

--
-- Index pour la table `CanTrainOn`
--
ALTER TABLE `CanTrainOn`
  ADD PRIMARY KEY (`id_user`,`id_disponibility`),
  ADD KEY `fkDisponibilityUser` (`id_disponibility`);

--
-- Index pour la table `CompatibleDisponibility`
--
ALTER TABLE `CompatibleDisponibility`
  ADD PRIMARY KEY (`id_structure`,`id_disponibility`),
  ADD KEY `fkDisponibilityStructure` (`id_disponibility`);

--
-- Index pour la table `CompatibleEquipment`
--
ALTER TABLE `CompatibleEquipment`
  ADD PRIMARY KEY (`id_exercice`,`id_equipment`),
  ADD KEY `fkEquipmentExercice` (`id_equipment`);

--
-- Index pour la table `CompatibleLimb`
--
ALTER TABLE `CompatibleLimb`
  ADD PRIMARY KEY (`id_exercice`,`id_BodyLimb`),
  ADD KEY `fkBodyLimbExercice` (`id_BodyLimb`);

--
-- Index pour la table `CompatibleMorph`
--
ALTER TABLE `CompatibleMorph`
  ADD PRIMARY KEY (`id_exercice`,`id_morphology`),
  ADD KEY `fkMorphologyExercice` (`id_morphology`);

--
-- Index pour la table `ComposeTraining`
--
ALTER TABLE `ComposeTraining`
  ADD PRIMARY KEY (`id_training`,`id_type`,`id_training_method`),
  ADD KEY `fkTypeTraining` (`id_type`),
  ADD KEY `fkTrainingMethod` (`id_training_method`);

--
-- Index pour la table `Disponibility`
--
ALTER TABLE `Disponibility`
  ADD PRIMARY KEY (`id_disponibility`);

--
-- Index pour la table `Equipment`
--
ALTER TABLE `Equipment`
  ADD PRIMARY KEY (`id_equipment`);

--
-- Index pour la table `Exercice`
--
ALTER TABLE `Exercice`
  ADD PRIMARY KEY (`id_exercice`);

--
-- Index pour la table `ExerciceType`
--
ALTER TABLE `ExerciceType`
  ADD PRIMARY KEY (`id_exercice_type`);

--
-- Index pour la table `ExerciceTyping`
--
ALTER TABLE `ExerciceTyping`
  ADD PRIMARY KEY (`id_exercice`,`id_exercice_type`),
  ADD KEY `fkExerciceTypeExercice` (`id_exercice_type`);

--
-- Index pour la table `Goal`
--
ALTER TABLE `Goal`
  ADD PRIMARY KEY (`id_goal`);

--
-- Index pour la table `GoalNbRep`
--
ALTER TABLE `GoalNbRep`
  ADD PRIMARY KEY (`id_GoalNbRep`),
  ADD KEY `fkGoalNbRep` (`id_goal`);

--
-- Index pour la table `GoalNbSerie`
--
ALTER TABLE `GoalNbSerie`
  ADD PRIMARY KEY (`id_GoalNbSerie`),
  ADD KEY `fkGoalNbSerie` (`id_goal`);

--
-- Index pour la table `GoalWeight`
--
ALTER TABLE `GoalWeight`
  ADD PRIMARY KEY (`id_GoalWeight`),
  ADD KEY `fkGoalWeight` (`id_goal`);

--
-- Index pour la table `HasEquipment`
--
ALTER TABLE `HasEquipment`
  ADD PRIMARY KEY (`id_user`,`id_equipment`),
  ADD KEY `fkEquipmentUser` (`id_equipment`);

--
-- Index pour la table `Morphology`
--
ALTER TABLE `Morphology`
  ADD PRIMARY KEY (`id_morphology`);

--
-- Index pour la table `Role`
--
ALTER TABLE `Role`
  ADD PRIMARY KEY (`id_role`);

--
-- Index pour la table `Serie`
--
ALTER TABLE `Serie`
  ADD PRIMARY KEY (`id_serie`),
  ADD KEY `fkComposeTraining` (`id_compose_training_training`,`id_compose_training_type`,`id_compose_training_method`),
  ADD KEY `fkUserSerie` (`id_user`),
  ADD KEY `fkExercice` (`id_exercice`);

--
-- Index pour la table `Structure`
--
ALTER TABLE `Structure`
  ADD PRIMARY KEY (`id_structure`),
  ADD KEY `fkGoalStructure` (`id_goal`);

--
-- Index pour la table `Training`
--
ALTER TABLE `Training`
  ADD PRIMARY KEY (`id_training`),
  ADD KEY `fkStructureTraining` (`id_structure`),
  ADD KEY `fkTrainingTypeTraining` (`id_training_type`);

--
-- Index pour la table `TrainingMethod`
--
ALTER TABLE `TrainingMethod`
  ADD PRIMARY KEY (`id_training_method`);

--
-- Index pour la table `TrainingType`
--
ALTER TABLE `TrainingType`
  ADD PRIMARY KEY (`id_training_type`);

--
-- Index pour la table `UseLimb`
--
ALTER TABLE `UseLimb`
  ADD PRIMARY KEY (`id_user`,`id_BodyLimb`),
  ADD KEY `fkBodyLimbUser` (`id_BodyLimb`);

--
-- Index pour la table `User`
--
ALTER TABLE `User`
  ADD PRIMARY KEY (`id_user`),
  ADD KEY `fkRole` (`id_role`),
  ADD KEY `fkMorphologyUser` (`id_morphology`),
  ADD KEY `fkGoalUser` (`id_goal`);

--
-- Index pour la table `UserExerciceData`
--
ALTER TABLE `UserExerciceData`
  ADD PRIMARY KEY (`id_exercice`,`id_user`),
  ADD KEY `fkUserExercice` (`id_user`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `BodyLimb`
--
ALTER TABLE `BodyLimb`
  MODIFY `id_BodyLimb` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `Disponibility`
--
ALTER TABLE `Disponibility`
  MODIFY `id_disponibility` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `Equipment`
--
ALTER TABLE `Equipment`
  MODIFY `id_equipment` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `Exercice`
--
ALTER TABLE `Exercice`
  MODIFY `id_exercice` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `ExerciceType`
--
ALTER TABLE `ExerciceType`
  MODIFY `id_exercice_type` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `Goal`
--
ALTER TABLE `Goal`
  MODIFY `id_goal` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `GoalNbRep`
--
ALTER TABLE `GoalNbRep`
  MODIFY `id_GoalNbRep` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `GoalNbSerie`
--
ALTER TABLE `GoalNbSerie`
  MODIFY `id_GoalNbSerie` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `GoalWeight`
--
ALTER TABLE `GoalWeight`
  MODIFY `id_GoalWeight` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `Morphology`
--
ALTER TABLE `Morphology`
  MODIFY `id_morphology` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `Role`
--
ALTER TABLE `Role`
  MODIFY `id_role` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `Serie`
--
ALTER TABLE `Serie`
  MODIFY `id_serie` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `Structure`
--
ALTER TABLE `Structure`
  MODIFY `id_structure` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `Training`
--
ALTER TABLE `Training`
  MODIFY `id_training` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `TrainingMethod`
--
ALTER TABLE `TrainingMethod`
  MODIFY `id_training_method` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `TrainingType`
--
ALTER TABLE `TrainingType`
  MODIFY `id_training_type` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `User`
--
ALTER TABLE `User`
  MODIFY `id_user` int NOT NULL AUTO_INCREMENT;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `CanTrainOn`
--
ALTER TABLE `CanTrainOn`
  ADD CONSTRAINT `CanTrainOn_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `User` (`id_user`) ON DELETE CASCADE,
  ADD CONSTRAINT `CanTrainOn_ibfk_2` FOREIGN KEY (`id_disponibility`) REFERENCES `Disponibility` (`id_disponibility`) ON DELETE CASCADE;

--
-- Contraintes pour la table `CompatibleDisponibility`
--
ALTER TABLE `CompatibleDisponibility`
  ADD CONSTRAINT `CompatibleDisponibility_ibfk_1` FOREIGN KEY (`id_structure`) REFERENCES `Structure` (`id_structure`) ON DELETE CASCADE,
  ADD CONSTRAINT `CompatibleDisponibility_ibfk_2` FOREIGN KEY (`id_disponibility`) REFERENCES `Disponibility` (`id_disponibility`) ON DELETE CASCADE;

--
-- Contraintes pour la table `CompatibleEquipment`
--
ALTER TABLE `CompatibleEquipment`
  ADD CONSTRAINT `CompatibleEquipment_ibfk_1` FOREIGN KEY (`id_exercice`) REFERENCES `Exercice` (`id_exercice`) ON DELETE CASCADE,
  ADD CONSTRAINT `CompatibleEquipment_ibfk_2` FOREIGN KEY (`id_equipment`) REFERENCES `Equipment` (`id_equipment`) ON DELETE CASCADE;

--
-- Contraintes pour la table `CompatibleLimb`
--
ALTER TABLE `CompatibleLimb`
  ADD CONSTRAINT `CompatibleLimb_ibfk_1` FOREIGN KEY (`id_exercice`) REFERENCES `Exercice` (`id_exercice`) ON DELETE CASCADE,
  ADD CONSTRAINT `CompatibleLimb_ibfk_2` FOREIGN KEY (`id_BodyLimb`) REFERENCES `BodyLimb` (`id_BodyLimb`) ON DELETE CASCADE;

--
-- Contraintes pour la table `CompatibleMorph`
--
ALTER TABLE `CompatibleMorph`
  ADD CONSTRAINT `CompatibleMorph_ibfk_1` FOREIGN KEY (`id_exercice`) REFERENCES `Exercice` (`id_exercice`),
  ADD CONSTRAINT `CompatibleMorph_ibfk_2` FOREIGN KEY (`id_morphology`) REFERENCES `Morphology` (`id_morphology`);

--
-- Contraintes pour la table `ComposeTraining`
--
ALTER TABLE `ComposeTraining`
  ADD CONSTRAINT `ComposeTraining_ibfk_1` FOREIGN KEY (`id_training`) REFERENCES `Training` (`id_training`) ON DELETE CASCADE,
  ADD CONSTRAINT `ComposeTraining_ibfk_2` FOREIGN KEY (`id_type`) REFERENCES `ExerciceType` (`id_exercice_type`) ON DELETE CASCADE,
  ADD CONSTRAINT `ComposeTraining_ibfk_3` FOREIGN KEY (`id_training_method`) REFERENCES `TrainingMethod` (`id_training_method`) ON DELETE CASCADE;

--
-- Contraintes pour la table `ExerciceTyping`
--
ALTER TABLE `ExerciceTyping`
  ADD CONSTRAINT `ExerciceTyping_ibfk_1` FOREIGN KEY (`id_exercice`) REFERENCES `Exercice` (`id_exercice`) ON DELETE CASCADE,
  ADD CONSTRAINT `ExerciceTyping_ibfk_2` FOREIGN KEY (`id_exercice_type`) REFERENCES `ExerciceType` (`id_exercice_type`) ON DELETE CASCADE;

--
-- Contraintes pour la table `GoalNbRep`
--
ALTER TABLE `GoalNbRep`
  ADD CONSTRAINT `GoalNbRep_ibfk_1` FOREIGN KEY (`id_goal`) REFERENCES `Goal` (`id_goal`) ON DELETE CASCADE;

--
-- Contraintes pour la table `GoalNbSerie`
--
ALTER TABLE `GoalNbSerie`
  ADD CONSTRAINT `GoalNbSerie_ibfk_1` FOREIGN KEY (`id_goal`) REFERENCES `Goal` (`id_goal`) ON DELETE CASCADE;

--
-- Contraintes pour la table `GoalWeight`
--
ALTER TABLE `GoalWeight`
  ADD CONSTRAINT `GoalWeight_ibfk_1` FOREIGN KEY (`id_goal`) REFERENCES `Goal` (`id_goal`) ON DELETE CASCADE;

--
-- Contraintes pour la table `HasEquipment`
--
ALTER TABLE `HasEquipment`
  ADD CONSTRAINT `HasEquipment_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `User` (`id_user`) ON DELETE CASCADE,
  ADD CONSTRAINT `HasEquipment_ibfk_2` FOREIGN KEY (`id_equipment`) REFERENCES `Equipment` (`id_equipment`) ON DELETE CASCADE;

--
-- Contraintes pour la table `Serie`
--
ALTER TABLE `Serie`
  ADD CONSTRAINT `Serie_ibfk_1` FOREIGN KEY (`id_compose_training_training`,`id_compose_training_type`,`id_compose_training_method`) REFERENCES `ComposeTraining` (`id_training`, `id_type`, `id_training_method`) ON DELETE CASCADE,
  ADD CONSTRAINT `Serie_ibfk_2` FOREIGN KEY (`id_user`) REFERENCES `User` (`id_user`) ON DELETE CASCADE,
  ADD CONSTRAINT `Serie_ibfk_3` FOREIGN KEY (`id_exercice`) REFERENCES `Exercice` (`id_exercice`) ON DELETE CASCADE;

--
-- Contraintes pour la table `Structure`
--
ALTER TABLE `Structure`
  ADD CONSTRAINT `Structure_ibfk_1` FOREIGN KEY (`id_goal`) REFERENCES `Goal` (`id_goal`);

--
-- Contraintes pour la table `Training`
--
ALTER TABLE `Training`
  ADD CONSTRAINT `Training_ibfk_1` FOREIGN KEY (`id_structure`) REFERENCES `Structure` (`id_structure`) ON DELETE CASCADE,
  ADD CONSTRAINT `Training_ibfk_2` FOREIGN KEY (`id_training_type`) REFERENCES `TrainingType` (`id_training_type`) ON DELETE CASCADE;

--
-- Contraintes pour la table `UseLimb`
--
ALTER TABLE `UseLimb`
  ADD CONSTRAINT `UseLimb_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `User` (`id_user`) ON DELETE CASCADE,
  ADD CONSTRAINT `UseLimb_ibfk_2` FOREIGN KEY (`id_BodyLimb`) REFERENCES `BodyLimb` (`id_BodyLimb`) ON DELETE CASCADE;

--
-- Contraintes pour la table `User`
--
ALTER TABLE `User`
  ADD CONSTRAINT `User_ibfk_1` FOREIGN KEY (`id_role`) REFERENCES `Role` (`id_role`) ON DELETE CASCADE,
  ADD CONSTRAINT `User_ibfk_2` FOREIGN KEY (`id_morphology`) REFERENCES `Morphology` (`id_morphology`),
  ADD CONSTRAINT `User_ibfk_3` FOREIGN KEY (`id_goal`) REFERENCES `Goal` (`id_goal`);

--
-- Contraintes pour la table `UserExerciceData`
--
ALTER TABLE `UserExerciceData`
  ADD CONSTRAINT `UserExerciceData_ibfk_1` FOREIGN KEY (`id_exercice`) REFERENCES `Exercice` (`id_exercice`) ON DELETE CASCADE,
  ADD CONSTRAINT `UserExerciceData_ibfk_2` FOREIGN KEY (`id_user`) REFERENCES `User` (`id_user`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
