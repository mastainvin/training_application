-- phpMyAdmin SQL Dump
-- version 4.9.5deb2
-- https://www.phpmyadmin.net/
--
-- Hôte : localhost:3306
-- Généré le : Dim 22 mai 2022 à 10:57
-- Version du serveur :  8.0.29-0ubuntu0.20.04.3
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
-- Structure de la table `BiomecanicFunction`
--

CREATE TABLE `BiomecanicFunction` (
  `id_biomecanic_function` int NOT NULL,
  `name` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `BiomecanicFunction`
--

INSERT INTO `BiomecanicFunction` (`id_biomecanic_function`, `name`) VALUES
(1, 'cheville(extension/flexion)'),
(4, 'hanches(extension)'),
(5, 'hanches(flexion)'),
(6, 'bras(adduction)'),
(7, 'bras(abduction)'),
(8, 'bras(antépulsion)'),
(9, 'bras(rétropulsion)'),
(10, 'coude(flexion)'),
(11, 'coude(extension)'),
(12, 'jambe(flexion)'),
(13, 'jambe(extension)'),
(14, 'jambe(adduction)'),
(15, 'jambe(abduction)');

-- --------------------------------------------------------

--
-- Structure de la table `BiomecanicFunctionList`
--

CREATE TABLE `BiomecanicFunctionList` (
  `id_biomecanic_function_list` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `BiomecanicFunctionList`
--

INSERT INTO `BiomecanicFunctionList` (`id_biomecanic_function_list`) VALUES
(1),
(2),
(3),
(4),
(5),
(6),
(7),
(8),
(9),
(10),
(11),
(12),
(13),
(14),
(15),
(16),
(17),
(18),
(19);

-- --------------------------------------------------------

--
-- Structure de la table `BiomecanicFunctionUseLimb`
--

CREATE TABLE `BiomecanicFunctionUseLimb` (
  `id_biomecanic_function` int NOT NULL,
  `id_BodyLimb` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `BiomecanicFunctionUseLimb`
--

INSERT INTO `BiomecanicFunctionUseLimb` (`id_biomecanic_function`, `id_BodyLimb`) VALUES
(6, 3),
(9, 3),
(7, 5),
(9, 5),
(10, 6),
(9, 8),
(11, 8),
(6, 9),
(7, 9),
(8, 9),
(9, 9),
(7, 10),
(4, 11),
(5, 12),
(13, 12),
(4, 13),
(12, 13),
(14, 14),
(15, 15),
(1, 16),
(4, 24),
(12, 24),
(15, 24),
(5, 25);

-- --------------------------------------------------------

--
-- Structure de la table `BodyLimb`
--

CREATE TABLE `BodyLimb` (
  `id_BodyLimb` int NOT NULL,
  `name` varchar(30) DEFAULT NULL,
  `upper` tinyint(1) DEFAULT NULL,
  `lower` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `BodyLimb`
--

INSERT INTO `BodyLimb` (`id_BodyLimb`, `name`, `upper`, `lower`) VALUES
(3, 'pectoraux', 1, 0),
(5, 'dos', NULL, NULL),
(6, 'biceps', NULL, NULL),
(8, 'triceps', NULL, NULL),
(9, 'épaules', NULL, NULL),
(10, 'trapèzes', NULL, NULL),
(11, 'lombaires', NULL, NULL),
(12, 'quadriceps', NULL, NULL),
(13, 'ischio-jambiers', NULL, NULL),
(14, 'adducteurs', NULL, NULL),
(15, 'abducteurs', NULL, NULL),
(16, 'mollets', NULL, NULL),
(17, 'clavicule', NULL, NULL),
(18, 'poignets', NULL, NULL),
(19, 'coudes', NULL, NULL),
(20, 'cou', NULL, NULL),
(21, 'chevilles', NULL, NULL),
(22, 'genoux', NULL, NULL),
(23, 'hanches', NULL, NULL),
(24, 'fessier', 0, 1),
(25, 'abdominaux', 1, 0);

-- --------------------------------------------------------

--
-- Structure de la table `CanTrainOn`
--

CREATE TABLE `CanTrainOn` (
  `id_user` int NOT NULL,
  `id_disponibility` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `CanTrainOn`
--

INSERT INTO `CanTrainOn` (`id_user`, `id_disponibility`) VALUES
(212, 1),
(212, 2),
(213, 2),
(213, 3);

-- --------------------------------------------------------

--
-- Structure de la table `CompatibleBiomecanicFunction`
--

CREATE TABLE `CompatibleBiomecanicFunction` (
  `id_exercise` int NOT NULL,
  `id_biomecanic_function` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `CompatibleBiomecanicFunction`
--

INSERT INTO `CompatibleBiomecanicFunction` (`id_exercise`, `id_biomecanic_function`) VALUES
(13, 1),
(10, 4),
(11, 4),
(12, 4),
(13, 4),
(14, 4),
(12, 5),
(13, 5),
(14, 5),
(27, 5),
(28, 5),
(7, 6),
(8, 6),
(9, 6),
(29, 6),
(30, 6),
(31, 6),
(32, 6),
(16, 7),
(17, 7),
(18, 7),
(19, 7),
(20, 7),
(21, 7),
(22, 7),
(23, 7),
(24, 7),
(25, 7),
(26, 7),
(13, 8),
(16, 10),
(17, 10),
(18, 10),
(19, 10),
(20, 10),
(21, 10),
(22, 10),
(23, 10),
(24, 10),
(25, 10),
(26, 10),
(7, 11),
(8, 11),
(9, 11),
(29, 11),
(30, 11),
(31, 11),
(32, 11),
(12, 12),
(13, 12),
(14, 12),
(12, 13),
(13, 13),
(14, 13),
(12, 14),
(13, 14),
(14, 14),
(12, 15),
(13, 15),
(14, 15);

-- --------------------------------------------------------

--
-- Structure de la table `CompatibleDisponibility`
--

CREATE TABLE `CompatibleDisponibility` (
  `id_structure` int NOT NULL,
  `id_disponibility` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `CompatibleDisponibility`
--

INSERT INTO `CompatibleDisponibility` (`id_structure`, `id_disponibility`) VALUES
(1, 1),
(1, 2),
(2, 3),
(2, 4);

-- --------------------------------------------------------

--
-- Structure de la table `CompatibleEquipment`
--

CREATE TABLE `CompatibleEquipment` (
  `id_exercise` int NOT NULL,
  `id_equipment` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `CompatibleEquipment`
--

INSERT INTO `CompatibleEquipment` (`id_exercise`, `id_equipment`) VALUES
(10, 1),
(11, 1),
(13, 1),
(7, 2),
(8, 2),
(10, 2),
(11, 2),
(12, 2),
(13, 2),
(14, 2),
(22, 2),
(23, 2),
(29, 2),
(30, 2),
(31, 2),
(32, 2),
(20, 3),
(21, 3),
(16, 4),
(17, 4),
(18, 4),
(19, 4),
(20, 4),
(21, 4),
(24, 4),
(25, 4),
(26, 4),
(16, 5),
(17, 5),
(20, 5),
(21, 5),
(9, 6),
(27, 6),
(28, 6);

-- --------------------------------------------------------

--
-- Structure de la table `CompatibleMorph`
--

CREATE TABLE `CompatibleMorph` (
  `id_exercise` int NOT NULL,
  `id_morphology` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `CompatibleMorph`
--

INSERT INTO `CompatibleMorph` (`id_exercise`, `id_morphology`) VALUES
(8, 1),
(9, 1),
(11, 1),
(12, 1),
(14, 1),
(18, 1),
(19, 1),
(20, 1),
(21, 1),
(24, 1),
(25, 1),
(26, 1),
(27, 1),
(28, 1),
(30, 1),
(32, 1),
(7, 2),
(9, 2),
(10, 2),
(12, 2),
(13, 2),
(16, 2),
(17, 2),
(18, 2),
(19, 2),
(20, 2),
(21, 2),
(22, 2),
(23, 2),
(24, 2),
(25, 2),
(26, 2),
(27, 2),
(28, 2),
(29, 2),
(31, 2);

-- --------------------------------------------------------

--
-- Structure de la table `ComposeTraining`
--

CREATE TABLE `ComposeTraining` (
  `id_training` int NOT NULL,
  `id_type` int NOT NULL,
  `id_training_method` int NOT NULL,
  `layout` int NOT NULL DEFAULT '0',
  `is_super_set` tinyint(1) DEFAULT NULL,
  `id_biomecanic_function_list` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `ComposeTraining`
--

INSERT INTO `ComposeTraining` (`id_training`, `id_type`, `id_training_method`, `layout`, `is_super_set`, `id_biomecanic_function_list`) VALUES
(1, 1, 6, 3, 0, 1),
(1, 1, 6, 4, 0, 2),
(1, 2, 6, 5, 0, 3),
(1, 3, 3, 1, 1, 4),
(1, 4, 3, 2, 1, 5),
(2, 1, 6, 4, 0, 6),
(2, 3, 1, 1, 0, 7),
(2, 3, 1, 2, 0, 8),
(2, 3, 1, 3, 0, 9),
(3, 1, 6, 3, 0, 10),
(3, 2, 6, 4, 0, 11),
(3, 3, 3, 1, 0, 12),
(3, 4, 7, 2, 0, 13),
(4, 1, 6, 3, 0, 14),
(4, 3, 1, 1, 0, 15),
(4, 3, 1, 2, 0, 16);

-- --------------------------------------------------------

--
-- Structure de la table `Disponibility`
--

CREATE TABLE `Disponibility` (
  `id_disponibility` int NOT NULL,
  `duration` int DEFAULT '0',
  `layout` int DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `Disponibility`
--

INSERT INTO `Disponibility` (`id_disponibility`, `duration`, `layout`) VALUES
(1, 120, 1),
(2, 120, 2),
(3, 90, 1),
(4, 90, 2);

-- --------------------------------------------------------

--
-- Structure de la table `Equipment`
--

CREATE TABLE `Equipment` (
  `id_equipment` int NOT NULL,
  `name` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `Equipment`
--

INSERT INTO `Equipment` (`id_equipment`, `name`) VALUES
(1, 'haltères seules'),
(2, 'poids libres'),
(3, 'élastiques'),
(4, 'machines'),
(5, 'parc de street workout'),
(6, 'sans matériel');

-- --------------------------------------------------------

--
-- Structure de la table `Exercise`
--

CREATE TABLE `Exercise` (
  `id_exercise` int NOT NULL,
  `name` varchar(30) DEFAULT NULL,
  `description` varchar(400) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `Exercise`
--

INSERT INTO `Exercise` (`id_exercise`, `name`, `description`) VALUES
(7, 'développer couché barre', 'test1'),
(8, 'développer couché haltère', 'test11'),
(9, 'pompes', 'test'),
(10, 'soulevé de terre traditionnel', 'test'),
(11, 'soulevé de terre sumo', 'test10'),
(12, 'squat traditionnel', 'test1'),
(13, 'front squat', 'test'),
(14, 'squat sumo', 'test'),
(16, 'traction pronation', 'test'),
(17, 'traction supination', 'test'),
(18, 'tirage vertical pronation', 'test'),
(19, 'tirage vertical supination', 'test'),
(20, 'traction élastique supination', 'test'),
(21, 'traction élactique pronation', 'test'),
(22, 'rowing barre pronation', 'test'),
(23, 'rowing barre supination', 'test'),
(24, 'rowing machine pronation', 'test12'),
(25, 'rowing machine supination', 'test4'),
(26, 'rowing machine neutre', 'test3'),
(27, 'abdominaux levé de jambes', 'test'),
(28, 'abdominaux crunch', 'test5'),
(29, 'larsen press barre', 'test'),
(30, 'larsen press haltères', 'test'),
(31, 'bench posé barre', 'test'),
(32, 'bench posé haltères', 'test2');

-- --------------------------------------------------------

--
-- Structure de la table `ExerciseType`
--

CREATE TABLE `ExerciseType` (
  `id_exercise_type` int NOT NULL,
  `name` varchar(30) DEFAULT NULL,
  `description` varchar(400) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `ExerciseType`
--

INSERT INTO `ExerciseType` (`id_exercise_type`, `name`, `description`) VALUES
(1, 'polyarticulaire (standart)', 'polyarticulaire (standart)'),
(2, 'monoarticulaire (standart)', 'monoarticulaire (standart)'),
(3, 'polyarticulaire (force)', 'polyarticulaire (force)'),
(4, 'polyarticulaire (technique)', 'polyarticulaire (technique)'),
(5, 'pdc/machine/libre (circuit1)', 'pdc/machine/libre (circuit1)'),
(6, 'complèxe (circuit2)', 'complèxe (circuit2)'),
(7, 'cardio', 'cardio');

-- --------------------------------------------------------

--
-- Structure de la table `ExerciseTyping`
--

CREATE TABLE `ExerciseTyping` (
  `id_exercise` int NOT NULL,
  `id_exercise_type` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `ExerciseTyping`
--

INSERT INTO `ExerciseTyping` (`id_exercise`, `id_exercise_type`) VALUES
(7, 1),
(8, 1),
(9, 1),
(10, 1),
(11, 1),
(12, 1),
(13, 1),
(14, 1),
(16, 1),
(17, 1),
(18, 1),
(19, 1),
(20, 1),
(21, 1),
(22, 1),
(23, 1),
(24, 1),
(25, 1),
(26, 1),
(27, 2),
(28, 2),
(7, 3),
(8, 3),
(10, 3),
(11, 3),
(12, 3),
(14, 3),
(13, 4),
(29, 4),
(30, 4),
(31, 4),
(32, 4),
(9, 5),
(16, 5),
(17, 5),
(18, 5),
(19, 5),
(20, 5),
(21, 5),
(24, 5),
(25, 5),
(26, 5),
(27, 5),
(28, 5),
(7, 6),
(8, 6),
(9, 6),
(10, 6),
(11, 6),
(12, 6),
(14, 6),
(16, 6),
(17, 6),
(20, 6),
(21, 6),
(22, 6),
(23, 6);

-- --------------------------------------------------------

--
-- Structure de la table `Goal`
--

CREATE TABLE `Goal` (
  `id_goal` int NOT NULL,
  `duration` int DEFAULT '0',
  `rest_duration` int DEFAULT '0',
  `velocity` varchar(10) DEFAULT NULL,
  `name` varchar(30) DEFAULT NULL,
  `id_GoalNbSerie` int DEFAULT NULL,
  `id_GoalNbRep` int DEFAULT NULL,
  `id_GoalWeight` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `Goal`
--

INSERT INTO `Goal` (`id_goal`, `duration`, `rest_duration`, `velocity`, `name`, `id_GoalNbSerie`, `id_GoalNbRep`, `id_GoalWeight`) VALUES
(8, 10, 150, 'QUICK', 'force', 1, 1, 1),
(9, 1, 120, 'LOW', 'esthétisme', 2, 2, 2),
(10, 1, 60, 'MEDIUM', 'remise en forme', 3, 3, 3);

-- --------------------------------------------------------

--
-- Structure de la table `GoalNbRep`
--

CREATE TABLE `GoalNbRep` (
  `id_GoalNbRep` int NOT NULL,
  `min` int DEFAULT '0',
  `max` int DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `GoalNbRep`
--

INSERT INTO `GoalNbRep` (`id_GoalNbRep`, `min`, `max`) VALUES
(1, 3, 6),
(2, 8, 10),
(3, 15, 20);

-- --------------------------------------------------------

--
-- Structure de la table `GoalNbSerie`
--

CREATE TABLE `GoalNbSerie` (
  `id_GoalNbSerie` int NOT NULL,
  `min` int DEFAULT '0',
  `max` int DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `GoalNbSerie`
--

INSERT INTO `GoalNbSerie` (`id_GoalNbSerie`, `min`, `max`) VALUES
(1, 3, 6),
(2, 3, 10),
(3, 3, 10);

-- --------------------------------------------------------

--
-- Structure de la table `GoalWeight`
--

CREATE TABLE `GoalWeight` (
  `id_GoalWeight` int NOT NULL,
  `min` int DEFAULT '0',
  `max` int DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `GoalWeight`
--

INSERT INTO `GoalWeight` (`id_GoalWeight`, `min`, `max`) VALUES
(1, 80, 90),
(2, 65, 75),
(3, 40, 60);

-- --------------------------------------------------------

--
-- Structure de la table `HasEquipment`
--

CREATE TABLE `HasEquipment` (
  `id_user` int NOT NULL,
  `id_equipment` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `HasEquipment`
--

INSERT INTO `HasEquipment` (`id_user`, `id_equipment`) VALUES
(212, 1),
(213, 1),
(212, 2),
(213, 2),
(212, 3),
(213, 3),
(212, 4),
(213, 4),
(212, 5),
(213, 5),
(212, 6),
(213, 6);

-- --------------------------------------------------------

--
-- Structure de la table `Morphology`
--

CREATE TABLE `Morphology` (
  `id_morphology` int NOT NULL,
  `name` varchar(30) DEFAULT NULL,
  `description` varchar(400) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `Morphology`
--

INSERT INTO `Morphology` (`id_morphology`, `name`, `description`) VALUES
(1, 'longiligne', 'test desc'),
(2, 'bréviligne', 'test desc');

-- --------------------------------------------------------

--
-- Structure de la table `Role`
--

CREATE TABLE `Role` (
  `id_role` int NOT NULL,
  `name` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `Role`
--

INSERT INTO `Role` (`id_role`, `name`) VALUES
(2, 'admin'),
(2347, 'user');

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
  `id_exercise` int DEFAULT NULL,
  `compose_training_layout` int DEFAULT NULL,
  `layout` int DEFAULT NULL,
  `in_actual_week` tinyint(1) DEFAULT '0',
  `rest_duration` int NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `Serie`
--

INSERT INTO `Serie` (`id_serie`, `date`, `weight`, `repetitions`, `rpe`, `expected_repetitions`, `expected_weight`, `id_compose_training_training`, `id_compose_training_type`, `id_compose_training_method`, `id_user`, `id_exercise`, `compose_training_layout`, `layout`, `in_actual_week`, `rest_duration`) VALUES
(30969, '2022-05-20', 140, 5, 0, 5, 0, 1, 3, 3, 212, 14, 1, 1, 0, 180),
(30970, '2022-05-20', 30, 5, 0, 5, 0, 1, 4, 3, 212, 32, 2, 2, 0, 180),
(30971, '2022-05-20', 140, 5, 0, 5, 0, 1, 3, 3, 212, 14, 1, 3, 0, 180),
(30972, '2022-05-20', 30, 5, 0, 5, 0, 1, 4, 3, 212, 32, 2, 4, 0, 180),
(30973, '2022-05-20', 140, 5, 0, 5, 0, 1, 3, 3, 212, 14, 1, 5, 0, 120),
(30974, '2022-05-20', 0, 15, 0, 15, 0, 1, 1, 6, 212, 21, 3, 1, 0, 120),
(30975, '2022-05-20', 0, 0, 0, 15, 0, 1, 1, 6, 212, 21, 3, 2, 0, 120),
(30976, '2022-05-20', 0, 0, 0, 15, 0, 1, 1, 6, 212, 21, 3, 3, 0, 120),
(30977, '2022-05-20', 0, 0, 0, 15, 0, 1, 1, 6, 212, 21, 3, 4, 0, 120),
(30978, '2022-05-20', 60, 15, 0, 15, 0, 1, 1, 6, 212, 26, 4, 1, 0, 120),
(30979, '2022-05-20', 60, 15, 0, 15, 0, 1, 1, 6, 212, 26, 4, 2, 0, 120),
(30980, '2022-05-20', 60, 15, 0, 15, 0, 1, 1, 6, 212, 26, 4, 3, 0, 120),
(30981, '2022-05-20', 60, 15, 0, 15, 0, 1, 1, 6, 212, 26, 4, 4, 0, 120),
(30982, '2022-05-20', 0, 15, 0, 15, 0, 1, 2, 6, 212, 28, 5, 1, 0, 120),
(30983, '2022-05-20', 0, 0, 0, 15, 0, 1, 2, 6, 212, 28, 5, 2, 0, 120),
(30984, '2022-05-20', 0, 0, 0, 15, 0, 1, 2, 6, 212, 28, 5, 3, 0, 120),
(30985, '2022-05-20', 0, 0, 0, 15, 0, 1, 2, 6, 212, 28, 5, 4, 0, 120),
(31022, NULL, 0, 0, 0, 3, 146, 2, 3, 1, 212, 14, 1, 1, 0, 180),
(31023, NULL, 0, 0, 0, 3, 146, 2, 3, 1, 212, 14, 1, 2, 0, 180),
(31024, NULL, 0, 0, 0, 3, 146, 2, 3, 1, 212, 14, 1, 3, 0, 120),
(31025, NULL, 0, 0, 0, 3, 0, 2, 3, 1, 212, 8, 2, 1, 0, 180),
(31026, NULL, 0, 0, 0, 3, 0, 2, 3, 1, 212, 8, 2, 2, 0, 180),
(31027, NULL, 0, 0, 0, 3, 0, 2, 3, 1, 212, 8, 2, 3, 0, 120),
(31028, NULL, 0, 0, 0, 3, 0, 2, 3, 1, 212, 11, 3, 1, 0, 180),
(31029, NULL, 0, 0, 0, 3, 0, 2, 3, 1, 212, 11, 3, 2, 0, 180),
(31030, NULL, 0, 0, 0, 3, 0, 2, 3, 1, 212, 11, 3, 3, 0, 120),
(31031, NULL, 0, 0, 0, 15, 0, 2, 1, 6, 212, 24, 4, 1, 0, 120),
(31032, NULL, 0, 0, 0, 15, 0, 2, 1, 6, 212, 24, 4, 2, 0, 120),
(31033, NULL, 0, 0, 0, 15, 0, 2, 1, 6, 212, 24, 4, 3, 0, 120),
(31034, NULL, 0, 0, 0, 15, 0, 2, 1, 6, 212, 24, 4, 4, 0, 120),
(31035, '2022-05-22', 60, 5, 0, 5, 0, 1, 3, 3, 212, 12, 1, 1, 1, 180),
(31036, '2022-05-22', 20, 5, 0, 5, 0, 1, 4, 3, 212, 31, 2, 2, 1, 180),
(31037, '2022-05-22', 60, 5, 0, 5, 0, 1, 3, 3, 212, 12, 1, 3, 1, 180),
(31038, '2022-05-22', 22, 5, 0, 5, 0, 1, 4, 3, 212, 31, 2, 4, 1, 180),
(31039, '2022-05-22', 65, 5, 0, 5, 0, 1, 3, 3, 212, 12, 1, 5, 1, 120),
(31040, '2022-05-22', 30, 15, 0, 15, 0, 1, 1, 6, 212, 24, 3, 1, 1, 120),
(31041, '2022-05-22', 30, 15, 0, 15, 0, 1, 1, 6, 212, 24, 3, 2, 1, 120),
(31042, '2022-05-22', 30, 15, 0, 15, 0, 1, 1, 6, 212, 24, 3, 3, 1, 120),
(31043, '2022-05-22', 30, 15, 0, 15, 0, 1, 1, 6, 212, 24, 3, 4, 1, 120),
(31044, '2022-05-22', 0, 15, 0, 15, 0, 1, 1, 6, 212, 20, 4, 1, 1, 120),
(31045, '2022-05-22', 0, 0, 0, 15, 0, 1, 1, 6, 212, 20, 4, 2, 1, 120),
(31046, '2022-05-22', 0, 0, 0, 15, 0, 1, 1, 6, 212, 20, 4, 3, 1, 120),
(31047, '2022-05-22', 0, 0, 0, 15, 0, 1, 1, 6, 212, 20, 4, 4, 1, 120),
(31048, '2022-05-22', 0, 0, 0, 15, 0, 1, 2, 6, 212, 27, 5, 1, 1, 120),
(31049, '2022-05-22', 0, 0, 0, 15, 0, 1, 2, 6, 212, 27, 5, 2, 1, 120),
(31050, '2022-05-22', 0, 0, 0, 15, 0, 1, 2, 6, 212, 27, 5, 3, 1, 120),
(31051, '2022-05-22', 0, 0, 0, 15, 0, 1, 2, 6, 212, 27, 5, 4, 1, 120),
(31052, NULL, 0, 0, 0, 3, 146, 2, 3, 1, 212, 14, 1, 1, 1, 180),
(31053, NULL, 0, 0, 0, 3, 146, 2, 3, 1, 212, 14, 1, 2, 1, 180),
(31054, NULL, 0, 0, 0, 3, 146, 2, 3, 1, 212, 14, 1, 3, 1, 120),
(31055, NULL, 0, 0, 0, 3, 0, 2, 3, 1, 212, 8, 2, 1, 1, 180),
(31056, NULL, 0, 0, 0, 3, 0, 2, 3, 1, 212, 8, 2, 2, 1, 180),
(31057, NULL, 0, 0, 0, 3, 0, 2, 3, 1, 212, 8, 2, 3, 1, 120),
(31058, NULL, 0, 0, 0, 3, 0, 2, 3, 1, 212, 11, 3, 1, 1, 180),
(31059, NULL, 0, 0, 0, 3, 0, 2, 3, 1, 212, 11, 3, 2, 1, 180),
(31060, NULL, 0, 0, 0, 3, 0, 2, 3, 1, 212, 11, 3, 3, 1, 120),
(31061, NULL, 0, 0, 0, 15, 0, 2, 1, 6, 212, 19, 4, 1, 1, 120),
(31062, NULL, 0, 0, 0, 15, 0, 2, 1, 6, 212, 19, 4, 2, 1, 120),
(31063, NULL, 0, 0, 0, 15, 0, 2, 1, 6, 212, 19, 4, 3, 1, 120),
(31064, NULL, 0, 0, 0, 15, 0, 2, 1, 6, 212, 19, 4, 4, 1, 120),
(31335, NULL, 0, 0, 0, 5, 0, 1, 3, 3, 213, 10, 1, 1, 0, 180),
(31336, NULL, 0, 0, 0, 5, 0, 1, 4, 3, 213, 32, 2, 2, 0, 180),
(31337, NULL, 0, 0, 0, 5, 0, 1, 3, 3, 213, 10, 1, 3, 0, 180),
(31338, NULL, 0, 0, 0, 5, 0, 1, 4, 3, 213, 32, 2, 4, 0, 180),
(31339, NULL, 0, 0, 0, 5, 0, 1, 3, 3, 213, 10, 1, 5, 0, 120),
(31340, NULL, 0, 0, 0, 15, 0, 1, 1, 6, 213, 26, 3, 1, 0, 120),
(31341, NULL, 0, 0, 0, 15, 0, 1, 1, 6, 213, 26, 3, 2, 0, 120),
(31342, NULL, 0, 0, 0, 15, 0, 1, 1, 6, 213, 26, 3, 3, 0, 120),
(31343, NULL, 0, 0, 0, 15, 0, 1, 1, 6, 213, 26, 3, 4, 0, 120),
(31344, NULL, 0, 0, 0, 15, 0, 1, 1, 6, 213, 25, 4, 1, 0, 120),
(31345, NULL, 0, 0, 0, 15, 0, 1, 1, 6, 213, 25, 4, 2, 0, 120),
(31346, NULL, 0, 0, 0, 15, 0, 1, 1, 6, 213, 25, 4, 3, 0, 120),
(31347, NULL, 0, 0, 0, 15, 0, 1, 1, 6, 213, 25, 4, 4, 0, 120),
(31348, NULL, 0, 0, 0, 15, 0, 1, 2, 6, 213, 28, 5, 1, 0, 120),
(31349, NULL, 0, 0, 0, 15, 0, 1, 2, 6, 213, 28, 5, 2, 0, 120),
(31350, NULL, 0, 0, 0, 15, 0, 1, 2, 6, 213, 28, 5, 3, 0, 120),
(31351, NULL, 0, 0, 0, 15, 0, 1, 2, 6, 213, 28, 5, 4, 0, 120),
(31352, NULL, 0, 0, 0, 3, 0, 4, 3, 1, 213, 11, 1, 1, 0, 180),
(31353, NULL, 0, 0, 0, 3, 0, 4, 3, 1, 213, 11, 1, 2, 0, 180),
(31354, NULL, 0, 0, 0, 3, 0, 4, 3, 1, 213, 11, 1, 3, 0, 120),
(31355, NULL, 0, 0, 0, 3, 0, 4, 3, 1, 213, 8, 2, 1, 0, 180),
(31356, NULL, 0, 0, 0, 3, 0, 4, 3, 1, 213, 8, 2, 2, 0, 180),
(31357, NULL, 0, 0, 0, 3, 0, 4, 3, 1, 213, 8, 2, 3, 0, 120),
(31358, NULL, 0, 0, 0, 15, 0, 4, 1, 6, 213, 24, 3, 1, 0, 120),
(31359, NULL, 0, 0, 0, 15, 0, 4, 1, 6, 213, 24, 3, 2, 0, 120),
(31360, NULL, 0, 0, 0, 15, 0, 4, 1, 6, 213, 24, 3, 3, 0, 120),
(31361, NULL, 0, 0, 0, 15, 0, 4, 1, 6, 213, 24, 3, 4, 0, 120),
(31362, NULL, 0, 0, 0, 5, 0, 1, 3, 3, 213, 11, 1, 1, 0, 180),
(31363, NULL, 0, 0, 0, 5, 0, 1, 4, 3, 213, 32, 2, 2, 0, 180),
(31364, NULL, 0, 0, 0, 5, 0, 1, 3, 3, 213, 11, 1, 3, 0, 180),
(31365, NULL, 0, 0, 0, 5, 0, 1, 4, 3, 213, 32, 2, 4, 0, 180),
(31366, NULL, 0, 0, 0, 5, 0, 1, 3, 3, 213, 11, 1, 5, 0, 120),
(31367, NULL, 0, 0, 0, 15, 0, 1, 1, 6, 213, 26, 3, 1, 0, 120),
(31368, NULL, 0, 0, 0, 15, 0, 1, 1, 6, 213, 26, 3, 2, 0, 120),
(31369, NULL, 0, 0, 0, 15, 0, 1, 1, 6, 213, 26, 3, 3, 0, 120),
(31370, NULL, 0, 0, 0, 15, 0, 1, 1, 6, 213, 26, 3, 4, 0, 120),
(31371, NULL, 0, 0, 0, 15, 0, 1, 1, 6, 213, 25, 4, 1, 0, 120),
(31372, NULL, 0, 0, 0, 15, 0, 1, 1, 6, 213, 25, 4, 2, 0, 120),
(31373, NULL, 0, 0, 0, 15, 0, 1, 1, 6, 213, 25, 4, 3, 0, 120),
(31374, NULL, 0, 0, 0, 15, 0, 1, 1, 6, 213, 25, 4, 4, 0, 120),
(31375, NULL, 0, 0, 0, 15, 0, 1, 2, 6, 213, 28, 5, 1, 0, 120),
(31376, NULL, 0, 0, 0, 15, 0, 1, 2, 6, 213, 28, 5, 2, 0, 120),
(31377, NULL, 0, 0, 0, 15, 0, 1, 2, 6, 213, 28, 5, 3, 0, 120),
(31378, NULL, 0, 0, 0, 15, 0, 1, 2, 6, 213, 28, 5, 4, 0, 120),
(31379, NULL, 0, 0, 0, 3, 0, 4, 3, 1, 213, 10, 1, 1, 0, 180),
(31380, NULL, 0, 0, 0, 3, 0, 4, 3, 1, 213, 10, 1, 2, 0, 180),
(31381, NULL, 0, 0, 0, 3, 0, 4, 3, 1, 213, 10, 1, 3, 0, 120),
(31382, NULL, 0, 0, 0, 3, 0, 4, 3, 1, 213, 8, 2, 1, 0, 180),
(31383, NULL, 0, 0, 0, 3, 0, 4, 3, 1, 213, 8, 2, 2, 0, 180),
(31384, NULL, 0, 0, 0, 3, 0, 4, 3, 1, 213, 8, 2, 3, 0, 120),
(31385, NULL, 0, 0, 0, 15, 0, 4, 1, 6, 213, 24, 3, 1, 0, 120),
(31386, NULL, 0, 0, 0, 15, 0, 4, 1, 6, 213, 24, 3, 2, 0, 120),
(31387, NULL, 0, 0, 0, 15, 0, 4, 1, 6, 213, 24, 3, 3, 0, 120),
(31388, NULL, 0, 0, 0, 15, 0, 4, 1, 6, 213, 24, 3, 4, 0, 120),
(31446, '2022-05-22', 60, 5, 0, 5, 0, 3, 3, 3, 213, 11, 1, 1, 1, 180),
(31447, '2022-05-22', 60, 5, 0, 5, 0, 3, 3, 3, 213, 11, 1, 2, 1, 180),
(31448, '2022-05-22', 55, 5, 0, 5, 0, 3, 3, 3, 213, 11, 1, 3, 1, 180),
(31449, '2022-05-22', 65, 5, 0, 5, 0, 3, 3, 3, 213, 11, 1, 4, 1, 180),
(31450, '2022-05-22', 50, 5, 0, 5, 0, 3, 3, 3, 213, 11, 1, 5, 1, 120),
(31451, '2022-05-22', 30, 10, 0, 10, 0, 3, 4, 7, 213, 32, 2, 1, 1, 150),
(31452, '2022-05-22', 32, 10, 0, 10, 0, 3, 4, 7, 213, 32, 2, 2, 1, 150),
(31453, '2022-05-22', 30, 10, 0, 10, 0, 3, 4, 7, 213, 32, 2, 3, 1, 150),
(31454, '2022-05-22', 30, 10, 0, 10, 0, 3, 4, 7, 213, 32, 2, 4, 1, 120),
(31455, '2022-05-22', 20, 15, 0, 15, 0, 3, 1, 6, 213, 26, 3, 1, 1, 120),
(31456, '2022-05-22', 20, 15, 0, 15, 0, 3, 1, 6, 213, 26, 3, 2, 1, 120),
(31457, '2022-05-22', 20, 15, 0, 15, 0, 3, 1, 6, 213, 26, 3, 3, 1, 120),
(31458, '2022-05-22', 20, 15, 0, 15, 0, 3, 1, 6, 213, 26, 3, 4, 1, 120),
(31459, '2022-05-22', 0, 15, 0, 15, 0, 3, 2, 6, 213, 28, 4, 1, 1, 120),
(31460, '2022-05-22', 0, 0, 0, 15, 0, 3, 2, 6, 213, 28, 4, 2, 1, 120),
(31461, '2022-05-22', 0, 0, 0, 15, 0, 3, 2, 6, 213, 28, 4, 3, 1, 120),
(31462, '2022-05-22', 0, 0, 0, 15, 0, 3, 2, 6, 213, 28, 4, 4, 1, 120),
(31463, NULL, 0, 0, 0, 3, 0, 2, 3, 1, 213, 12, 1, 1, 1, 180),
(31464, NULL, 0, 0, 0, 3, 0, 2, 3, 1, 213, 12, 1, 2, 1, 180),
(31465, NULL, 0, 0, 0, 3, 0, 2, 3, 1, 213, 12, 1, 3, 1, 120),
(31466, NULL, 0, 0, 0, 3, 0, 2, 3, 1, 213, 8, 2, 1, 1, 180),
(31467, NULL, 0, 0, 0, 3, 0, 2, 3, 1, 213, 8, 2, 2, 1, 180),
(31468, NULL, 0, 0, 0, 3, 0, 2, 3, 1, 213, 8, 2, 3, 1, 120),
(31469, NULL, 0, 0, 0, 3, 0, 2, 3, 1, 213, 10, 3, 1, 1, 180),
(31470, NULL, 0, 0, 0, 3, 0, 2, 3, 1, 213, 10, 3, 2, 1, 180),
(31471, NULL, 0, 0, 0, 3, 0, 2, 3, 1, 213, 10, 3, 3, 1, 120),
(31472, NULL, 0, 0, 0, 15, 0, 2, 1, 6, 213, 25, 4, 1, 1, 120),
(31473, NULL, 0, 0, 0, 15, 0, 2, 1, 6, 213, 25, 4, 2, 1, 120),
(31474, NULL, 0, 0, 0, 15, 0, 2, 1, 6, 213, 25, 4, 3, 1, 120),
(31475, NULL, 0, 0, 0, 15, 0, 2, 1, 6, 213, 25, 4, 4, 1, 120);

-- --------------------------------------------------------

--
-- Structure de la table `SerieRepartition`
--

CREATE TABLE `SerieRepartition` (
  `id_serie_repartition` int NOT NULL,
  `nb_rep` int NOT NULL DEFAULT '0',
  `weight` int NOT NULL DEFAULT '0',
  `layout` int NOT NULL DEFAULT '0',
  `id_training_method` int DEFAULT NULL,
  `rest_duration` int DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `SerieRepartition`
--

INSERT INTO `SerieRepartition` (`id_serie_repartition`, `nb_rep`, `weight`, `layout`, `id_training_method`, `rest_duration`) VALUES
(1, 3, 90, 1, 1, 180),
(2, 3, 90, 2, 1, 180),
(3, 3, 90, 3, 1, 120),
(4, 4, 87, 1, 2, 3),
(5, 4, 87, 2, 2, 180),
(6, 4, 87, 3, 2, 180),
(7, 4, 87, 4, 2, 120),
(8, 5, 85, 1, 3, 180),
(9, 5, 85, 2, 3, 180),
(10, 5, 85, 3, 3, 180),
(11, 5, 85, 4, 3, 180),
(12, 5, 85, 5, 3, 120),
(13, 6, 85, 1, 4, 0),
(14, 10, 50, 2, 4, 150),
(15, 6, 85, 3, 4, 0),
(16, 10, 50, 4, 4, 150),
(17, 6, 85, 5, 4, 0),
(18, 10, 50, 6, 4, 150),
(19, 6, 85, 7, 4, 0),
(20, 10, 50, 8, 4, 120),
(21, 10, 75, 1, 5, 120),
(22, 10, 75, 2, 5, 120),
(23, 10, 75, 3, 5, 120),
(24, 10, 75, 4, 5, 120),
(25, 10, 75, 1, 7, 150),
(26, 10, 75, 2, 7, 150),
(27, 10, 75, 3, 7, 150),
(28, 10, 75, 4, 7, 120),
(29, 15, 60, 1, 6, 120),
(30, 15, 60, 2, 6, 120),
(31, 15, 60, 3, 6, 120),
(32, 15, 60, 4, 6, 120);

-- --------------------------------------------------------

--
-- Structure de la table `Structure`
--

CREATE TABLE `Structure` (
  `id_structure` int NOT NULL,
  `name` varchar(30) DEFAULT NULL,
  `id_goal` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `Structure`
--

INSERT INTO `Structure` (`id_structure`, `name`, `id_goal`) VALUES
(1, '2-2h', 8),
(2, '2-1h30', 8);

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

--
-- Déchargement des données de la table `Training`
--

INSERT INTO `Training` (`id_training`, `name`, `description`, `id_structure`, `id_training_type`, `layout`, `duration`) VALUES
(1, 'full-2A-2h-force', 'test1', 1, 1, 1, 120),
(2, 'full-2B-2h-force', 'test2', 1, 1, 2, 120),
(3, 'full-2A-1h30-force', 'test3', 2, 1, 1, 90),
(4, 'full-2B-1h30-force', 'test4', 2, 1, 2, 90);

-- --------------------------------------------------------

--
-- Structure de la table `TrainingMethod`
--

CREATE TABLE `TrainingMethod` (
  `id_training_method` int NOT NULL,
  `name` varchar(30) DEFAULT NULL,
  `rep_max` int DEFAULT '0',
  `rep_min` int DEFAULT '0',
  `weight_max` int DEFAULT '0',
  `weight_min` int DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `TrainingMethod`
--

INSERT INTO `TrainingMethod` (`id_training_method`, `name`, `rep_max`, `rep_min`, `weight_max`, `weight_min`) VALUES
(1, '3x3', 3, 3, 90, 90),
(2, '4x4', 4, 4, 87, 87),
(3, '5x5', 5, 5, 85, 85),
(4, 'bulgare 4', 10, 6, 50, 85),
(5, 'charge constante', 10, 10, 75, 75),
(6, '4x15', 15, 15, 60, 60),
(7, '4x10', 10, 10, 70, 70);

-- --------------------------------------------------------

--
-- Structure de la table `TrainingType`
--

CREATE TABLE `TrainingType` (
  `id_training_type` int NOT NULL,
  `name` varchar(30) DEFAULT NULL,
  `description` varchar(400) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `TrainingType`
--

INSERT INTO `TrainingType` (`id_training_type`, `name`, `description`) VALUES
(1, 'full', 'test');

-- --------------------------------------------------------

--
-- Structure de la table `UseBiomecanicFunction`
--

CREATE TABLE `UseBiomecanicFunction` (
  `id_biomecanic_function` int NOT NULL,
  `id_biomecanic_function_list` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `UseBiomecanicFunction`
--

INSERT INTO `UseBiomecanicFunction` (`id_biomecanic_function`, `id_biomecanic_function_list`) VALUES
(7, 1),
(10, 1),
(7, 2),
(10, 2),
(5, 3),
(1, 4),
(4, 4),
(5, 4),
(12, 4),
(13, 4),
(14, 4),
(15, 4),
(6, 5),
(11, 5),
(7, 6),
(10, 6),
(1, 7),
(4, 7),
(5, 7),
(12, 7),
(13, 7),
(14, 7),
(15, 7),
(6, 8),
(11, 8),
(4, 9),
(7, 10),
(10, 10),
(5, 11),
(13, 11),
(1, 12),
(4, 12),
(5, 12),
(12, 12),
(14, 12),
(15, 12),
(6, 13),
(11, 13),
(7, 14),
(10, 14),
(4, 15),
(6, 16),
(11, 16);

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
  `size` int DEFAULT '0',
  `weight` int DEFAULT '0',
  `gender` int DEFAULT NULL,
  `body_fat` int DEFAULT '0',
  `muscle_mass` int DEFAULT '0',
  `id_role` int DEFAULT '2',
  `id_morphology` int DEFAULT NULL,
  `id_goal` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `User`
--

INSERT INTO `User` (`id_user`, `pseudonym`, `password`, `email`, `size`, `weight`, `gender`, `body_fat`, `muscle_mass`, `id_role`, `id_morphology`, `id_goal`) VALUES
(212, 'vincent', '5f4dcc3b5aa765d61d8327deb882cf99', 'vincent@vincent', 0, 0, 0, 0, 0, 2347, 1, 8),
(213, 'vincentest1', '202cb962ac59075b964b07152d234b70', 'vincentest1@vincentest1', 0, 0, 0, 0, 0, 2347, 1, 8);

-- --------------------------------------------------------

--
-- Structure de la table `UserExerciseData`
--

CREATE TABLE `UserExerciseData` (
  `id_exercise` int NOT NULL,
  `id_user` int NOT NULL,
  `weight` float DEFAULT '0',
  `mark` float DEFAULT '5',
  `nb_done` int NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `UserExerciseData`
--

INSERT INTO `UserExerciseData` (`id_exercise`, `id_user`, `weight`, `mark`, `nb_done`) VALUES
(7, 212, 0, 5, 0),
(7, 213, 0, 5, 0),
(8, 212, 0, 5, 0),
(8, 213, 0, 5, 0),
(9, 212, 0, 10, 0),
(9, 213, 0, 5, 0),
(10, 212, 0, 5, 0),
(10, 213, 0, 5, 0),
(11, 212, 0, 5, 0),
(11, 213, 75.8333, 7.5, 1),
(12, 212, 70, 7.5, 1),
(12, 213, 0, 0.25, 0),
(13, 212, 0, 5, 0),
(13, 213, 0, 5, 0),
(14, 212, 163.333, 7.5, 1),
(14, 213, 0, 0.25, 0),
(16, 212, 0, 5, 0),
(16, 213, 0, 5, 0),
(17, 212, 0, 5, 0),
(17, 213, 0, 5, 0),
(18, 212, 0, 5, 0),
(18, 213, 0, 5, 0),
(19, 212, 0, 5, 0),
(19, 213, 0, 5, 0),
(20, 212, 0, 7.5, 1),
(20, 213, 0, 5, 0),
(21, 212, 0, 2.5, 1),
(21, 213, 0, 5, 0),
(22, 212, 0, 5, 0),
(22, 213, 0, 5, 0),
(23, 212, 0, 5, 0),
(23, 213, 0, 5, 0),
(24, 212, 45, 2.5, 1),
(24, 213, 0, 5, 0),
(25, 212, 0, 0.25, 0),
(25, 213, 0, 5, 0),
(26, 212, 90, 7.5, 1),
(26, 213, 30, 7.5, 1),
(27, 212, 0, 2.5, 1),
(27, 213, 0, 5, 0),
(28, 212, 0, 2.5, 1),
(28, 213, 0, 2.5, 1),
(29, 212, 0, 5, 0),
(29, 213, 0, 5, 0),
(30, 212, 0, 5, 0),
(30, 213, 0, 5, 0),
(31, 212, 25.6667, 7.5, 1),
(31, 213, 0, 5, 0),
(32, 212, 35, 7.5, 1),
(32, 213, 42.6667, 2.5, 1);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `BiomecanicFunction`
--
ALTER TABLE `BiomecanicFunction`
  ADD PRIMARY KEY (`id_biomecanic_function`);

--
-- Index pour la table `BiomecanicFunctionList`
--
ALTER TABLE `BiomecanicFunctionList`
  ADD PRIMARY KEY (`id_biomecanic_function_list`);

--
-- Index pour la table `BiomecanicFunctionUseLimb`
--
ALTER TABLE `BiomecanicFunctionUseLimb`
  ADD PRIMARY KEY (`id_biomecanic_function`,`id_BodyLimb`),
  ADD KEY `BiomecanicFunctionUseLimb_ibfk_2` (`id_BodyLimb`);

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
-- Index pour la table `CompatibleBiomecanicFunction`
--
ALTER TABLE `CompatibleBiomecanicFunction`
  ADD PRIMARY KEY (`id_exercise`,`id_biomecanic_function`),
  ADD KEY `CompatibleBiomecanicFunction_ibfk_2` (`id_biomecanic_function`);

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
  ADD PRIMARY KEY (`id_exercise`,`id_equipment`),
  ADD KEY `fkEquipmentExercice` (`id_equipment`);

--
-- Index pour la table `CompatibleMorph`
--
ALTER TABLE `CompatibleMorph`
  ADD PRIMARY KEY (`id_exercise`,`id_morphology`),
  ADD KEY `fkMorphologyExercice` (`id_morphology`);

--
-- Index pour la table `ComposeTraining`
--
ALTER TABLE `ComposeTraining`
  ADD PRIMARY KEY (`id_training`,`id_type`,`id_training_method`,`layout`,`id_biomecanic_function_list`) USING BTREE,
  ADD KEY `fkTypeTraining` (`id_type`),
  ADD KEY `fkTrainingMethod` (`id_training_method`),
  ADD KEY `id_training` (`id_training`) USING BTREE,
  ADD KEY `fkBiomecanicFunctionList` (`id_biomecanic_function_list`);

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
-- Index pour la table `Exercise`
--
ALTER TABLE `Exercise`
  ADD PRIMARY KEY (`id_exercise`);

--
-- Index pour la table `ExerciseType`
--
ALTER TABLE `ExerciseType`
  ADD PRIMARY KEY (`id_exercise_type`);

--
-- Index pour la table `ExerciseTyping`
--
ALTER TABLE `ExerciseTyping`
  ADD PRIMARY KEY (`id_exercise`,`id_exercise_type`),
  ADD KEY `fkExerciceTypeExercice` (`id_exercise_type`);

--
-- Index pour la table `Goal`
--
ALTER TABLE `Goal`
  ADD PRIMARY KEY (`id_goal`),
  ADD KEY `fkGoalNbRep` (`id_GoalNbRep`),
  ADD KEY `fkGoalNbSerie` (`id_GoalNbSerie`),
  ADD KEY `fkGoalWeight` (`id_GoalWeight`);

--
-- Index pour la table `GoalNbRep`
--
ALTER TABLE `GoalNbRep`
  ADD PRIMARY KEY (`id_GoalNbRep`);

--
-- Index pour la table `GoalNbSerie`
--
ALTER TABLE `GoalNbSerie`
  ADD PRIMARY KEY (`id_GoalNbSerie`);

--
-- Index pour la table `GoalWeight`
--
ALTER TABLE `GoalWeight`
  ADD PRIMARY KEY (`id_GoalWeight`);

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
  ADD KEY `Serie_ibfk_1` (`id_compose_training_method`,`id_compose_training_training`,`id_compose_training_type`,`compose_training_layout`),
  ADD KEY `Serie_ibfk_2` (`id_user`),
  ADD KEY `Serie_ibfk_3` (`id_exercise`);

--
-- Index pour la table `SerieRepartition`
--
ALTER TABLE `SerieRepartition`
  ADD PRIMARY KEY (`id_serie_repartition`),
  ADD KEY `SerieRepartition_ibfk_1` (`id_training_method`);

--
-- Index pour la table `Structure`
--
ALTER TABLE `Structure`
  ADD PRIMARY KEY (`id_structure`),
  ADD KEY `Structure_ibfk_1` (`id_goal`);

--
-- Index pour la table `Training`
--
ALTER TABLE `Training`
  ADD PRIMARY KEY (`id_training`),
  ADD KEY `Training_ibfk_1` (`id_structure`),
  ADD KEY `Training_ibfk_2` (`id_training_type`);

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
-- Index pour la table `UseBiomecanicFunction`
--
ALTER TABLE `UseBiomecanicFunction`
  ADD PRIMARY KEY (`id_biomecanic_function`,`id_biomecanic_function_list`),
  ADD KEY `fkBiomecanicFunctionList` (`id_biomecanic_function_list`);

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
  ADD UNIQUE KEY `pseudonym` (`pseudonym`),
  ADD UNIQUE KEY `email` (`email`),
  ADD KEY `User_ibfk_1` (`id_role`),
  ADD KEY `User_ibfk_2` (`id_morphology`),
  ADD KEY `User_ibfk_3` (`id_goal`);

--
-- Index pour la table `UserExerciseData`
--
ALTER TABLE `UserExerciseData`
  ADD PRIMARY KEY (`id_exercise`,`id_user`),
  ADD KEY `fkUserExercice` (`id_user`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `BiomecanicFunction`
--
ALTER TABLE `BiomecanicFunction`
  MODIFY `id_biomecanic_function` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT pour la table `BiomecanicFunctionList`
--
ALTER TABLE `BiomecanicFunctionList`
  MODIFY `id_biomecanic_function_list` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT pour la table `BodyLimb`
--
ALTER TABLE `BodyLimb`
  MODIFY `id_BodyLimb` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;

--
-- AUTO_INCREMENT pour la table `Disponibility`
--
ALTER TABLE `Disponibility`
  MODIFY `id_disponibility` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT pour la table `Equipment`
--
ALTER TABLE `Equipment`
  MODIFY `id_equipment` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT pour la table `Exercise`
--
ALTER TABLE `Exercise`
  MODIFY `id_exercise` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=33;

--
-- AUTO_INCREMENT pour la table `ExerciseType`
--
ALTER TABLE `ExerciseType`
  MODIFY `id_exercise_type` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT pour la table `Goal`
--
ALTER TABLE `Goal`
  MODIFY `id_goal` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT pour la table `GoalNbRep`
--
ALTER TABLE `GoalNbRep`
  MODIFY `id_GoalNbRep` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT pour la table `GoalNbSerie`
--
ALTER TABLE `GoalNbSerie`
  MODIFY `id_GoalNbSerie` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT pour la table `GoalWeight`
--
ALTER TABLE `GoalWeight`
  MODIFY `id_GoalWeight` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT pour la table `Morphology`
--
ALTER TABLE `Morphology`
  MODIFY `id_morphology` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT pour la table `Role`
--
ALTER TABLE `Role`
  MODIFY `id_role` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2348;

--
-- AUTO_INCREMENT pour la table `Serie`
--
ALTER TABLE `Serie`
  MODIFY `id_serie` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31476;

--
-- AUTO_INCREMENT pour la table `SerieRepartition`
--
ALTER TABLE `SerieRepartition`
  MODIFY `id_serie_repartition` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=33;

--
-- AUTO_INCREMENT pour la table `Structure`
--
ALTER TABLE `Structure`
  MODIFY `id_structure` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT pour la table `Training`
--
ALTER TABLE `Training`
  MODIFY `id_training` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT pour la table `TrainingMethod`
--
ALTER TABLE `TrainingMethod`
  MODIFY `id_training_method` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT pour la table `TrainingType`
--
ALTER TABLE `TrainingType`
  MODIFY `id_training_type` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT pour la table `User`
--
ALTER TABLE `User`
  MODIFY `id_user` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=214;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `BiomecanicFunctionUseLimb`
--
ALTER TABLE `BiomecanicFunctionUseLimb`
  ADD CONSTRAINT `BiomecanicFunctionUseLimb_ibfk_1` FOREIGN KEY (`id_biomecanic_function`) REFERENCES `BiomecanicFunction` (`id_biomecanic_function`) ON DELETE CASCADE ON UPDATE RESTRICT,
  ADD CONSTRAINT `BiomecanicFunctionUseLimb_ibfk_2` FOREIGN KEY (`id_BodyLimb`) REFERENCES `BodyLimb` (`id_BodyLimb`) ON DELETE CASCADE ON UPDATE RESTRICT;

--
-- Contraintes pour la table `CanTrainOn`
--
ALTER TABLE `CanTrainOn`
  ADD CONSTRAINT `CanTrainOn_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `User` (`id_user`) ON DELETE CASCADE,
  ADD CONSTRAINT `CanTrainOn_ibfk_2` FOREIGN KEY (`id_disponibility`) REFERENCES `Disponibility` (`id_disponibility`) ON DELETE CASCADE;

--
-- Contraintes pour la table `CompatibleBiomecanicFunction`
--
ALTER TABLE `CompatibleBiomecanicFunction`
  ADD CONSTRAINT `CompatibleBiomecanicFunction_ibfk_1` FOREIGN KEY (`id_exercise`) REFERENCES `Exercise` (`id_exercise`) ON DELETE CASCADE,
  ADD CONSTRAINT `CompatibleBiomecanicFunction_ibfk_2` FOREIGN KEY (`id_biomecanic_function`) REFERENCES `BiomecanicFunction` (`id_biomecanic_function`) ON DELETE CASCADE ON UPDATE RESTRICT;

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
  ADD CONSTRAINT `CompatibleEquipment_ibfk_1` FOREIGN KEY (`id_exercise`) REFERENCES `Exercise` (`id_exercise`) ON DELETE CASCADE,
  ADD CONSTRAINT `CompatibleEquipment_ibfk_2` FOREIGN KEY (`id_equipment`) REFERENCES `Equipment` (`id_equipment`) ON DELETE CASCADE;

--
-- Contraintes pour la table `CompatibleMorph`
--
ALTER TABLE `CompatibleMorph`
  ADD CONSTRAINT `CompatibleMorph_ibfk_1` FOREIGN KEY (`id_exercise`) REFERENCES `Exercise` (`id_exercise`),
  ADD CONSTRAINT `CompatibleMorph_ibfk_2` FOREIGN KEY (`id_morphology`) REFERENCES `Morphology` (`id_morphology`);

--
-- Contraintes pour la table `ComposeTraining`
--
ALTER TABLE `ComposeTraining`
  ADD CONSTRAINT `ComposeTraining_ibfk_1` FOREIGN KEY (`id_training`) REFERENCES `Training` (`id_training`) ON DELETE CASCADE,
  ADD CONSTRAINT `ComposeTraining_ibfk_2` FOREIGN KEY (`id_type`) REFERENCES `ExerciseType` (`id_exercise_type`) ON DELETE CASCADE,
  ADD CONSTRAINT `ComposeTraining_ibfk_3` FOREIGN KEY (`id_training_method`) REFERENCES `TrainingMethod` (`id_training_method`) ON DELETE CASCADE,
  ADD CONSTRAINT `ComposeTraining_ibfk_4` FOREIGN KEY (`id_biomecanic_function_list`) REFERENCES `BiomecanicFunctionList` (`id_biomecanic_function_list`) ON DELETE CASCADE;

--
-- Contraintes pour la table `ExerciseTyping`
--
ALTER TABLE `ExerciseTyping`
  ADD CONSTRAINT `ExerciseTyping_ibfk_1` FOREIGN KEY (`id_exercise`) REFERENCES `Exercise` (`id_exercise`) ON DELETE CASCADE,
  ADD CONSTRAINT `ExerciseTyping_ibfk_2` FOREIGN KEY (`id_exercise_type`) REFERENCES `ExerciseType` (`id_exercise_type`) ON DELETE CASCADE;

--
-- Contraintes pour la table `Goal`
--
ALTER TABLE `Goal`
  ADD CONSTRAINT `fkGoalNbRep` FOREIGN KEY (`id_GoalNbRep`) REFERENCES `GoalNbRep` (`id_GoalNbRep`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fkGoalNbSerie` FOREIGN KEY (`id_GoalNbSerie`) REFERENCES `GoalNbSerie` (`id_GoalNbSerie`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fkGoalWeight` FOREIGN KEY (`id_GoalWeight`) REFERENCES `GoalWeight` (`id_GoalWeight`) ON DELETE CASCADE ON UPDATE CASCADE;

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
  ADD CONSTRAINT `Serie_ibfk_1` FOREIGN KEY (`id_compose_training_method`,`id_compose_training_training`,`id_compose_training_type`,`compose_training_layout`) REFERENCES `ComposeTraining` (`id_training_method`, `id_training`, `id_type`, `layout`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `Serie_ibfk_2` FOREIGN KEY (`id_user`) REFERENCES `User` (`id_user`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `Serie_ibfk_3` FOREIGN KEY (`id_exercise`) REFERENCES `Exercise` (`id_exercise`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `SerieRepartition`
--
ALTER TABLE `SerieRepartition`
  ADD CONSTRAINT `SerieRepartition_ibfk_1` FOREIGN KEY (`id_training_method`) REFERENCES `TrainingMethod` (`id_training_method`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `Structure`
--
ALTER TABLE `Structure`
  ADD CONSTRAINT `Structure_ibfk_1` FOREIGN KEY (`id_goal`) REFERENCES `Goal` (`id_goal`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `Training`
--
ALTER TABLE `Training`
  ADD CONSTRAINT `Training_ibfk_1` FOREIGN KEY (`id_structure`) REFERENCES `Structure` (`id_structure`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `Training_ibfk_2` FOREIGN KEY (`id_training_type`) REFERENCES `TrainingType` (`id_training_type`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `UseBiomecanicFunction`
--
ALTER TABLE `UseBiomecanicFunction`
  ADD CONSTRAINT `UseBiomecanicFunction_ibfk_1` FOREIGN KEY (`id_biomecanic_function`) REFERENCES `BiomecanicFunction` (`id_biomecanic_function`),
  ADD CONSTRAINT `UseBiomecanicFunction_ibfk_2` FOREIGN KEY (`id_biomecanic_function_list`) REFERENCES `BiomecanicFunctionList` (`id_biomecanic_function_list`);

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
  ADD CONSTRAINT `User_ibfk_1` FOREIGN KEY (`id_role`) REFERENCES `Role` (`id_role`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `User_ibfk_2` FOREIGN KEY (`id_morphology`) REFERENCES `Morphology` (`id_morphology`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `User_ibfk_3` FOREIGN KEY (`id_goal`) REFERENCES `Goal` (`id_goal`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `UserExerciseData`
--
ALTER TABLE `UserExerciseData`
  ADD CONSTRAINT `UserExerciseData_ibfk_1` FOREIGN KEY (`id_exercise`) REFERENCES `Exercise` (`id_exercise`) ON DELETE CASCADE,
  ADD CONSTRAINT `UserExerciseData_ibfk_2` FOREIGN KEY (`id_user`) REFERENCES `User` (`id_user`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
