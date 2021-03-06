DROP DATABASE if exists Training_application2;

CREATE DATABASE Training_application2;
USE Training_application2;

# ---- Drop all tables ----
#General
DROP TABLE if exists User;
DROP TABLE if exists Structure;
DROP TABLE if exists Training ;
DROP TABLE if exists TrainingType;
DROP TABLE if exists ExerciceType;
DROP TABLE if exists Exercice;
DROP TABLE if exists Serie;
DROP TABLE if exists Role;
DROP TABLE if exists Disponibility;

#Config

#Goal
DROP TABLE if exists Goal;
DROP TABLE if exists GoalNbRep;
DROP TABLE if exists GoalWeight;

#Params
DROP TABLE if exists BodyLimb;
DROP TABLE if exists Morphology;
DROP TABLE if exists Equipment;

#Training - Training type
DROP TABLE if exists ComposeTraining;

#Exercice
DROP TABLE if exists CompatibleLimb;
DROP TABLE if exists CompatibleMorph;
DROP TABLE if exists CompatibleEquipment;
DROP TABLE if exists UserExerciceData;
DROP TABLE if exists ExerciceTyping;

#User
DROP TABLE if exists HasEquipment;
DROP TABLE if exists UseLimb;
DROP TABLE if exists CanTrainOn;

#Structure
DROP TABLE if exists CompatibleDisponibility;

# ---- Create all tables ----

CREATE TABLE Role(
	id_role int PRIMARY KEY  auto_increment,
    name VARCHAR(30));

CREATE TABLE Morphology(
	id_morphology int PRIMARY KEY  auto_increment,
    name VARCHAR(30),
    description VARCHAR(400));

CREATE TABLE Goal(
	id_goal int PRIMARY KEY  auto_increment,
    duration int default 0,
    rest_duration int default 0,
    velocity VARCHAR(10));
    
CREATE TABLE User(
	id_user int PRIMARY KEY  auto_increment,
    pseudonym VARCHAR(30),
    password VARCHAR(100),
    email VARCHAR(40),
    size float default 0,
    weight float default 0,
    gender int,
    body_fat float default 0,
    muscle_mass float default 0,
    id_role int,
    id_morphology int,
    id_goal int,
    FOREIGN KEY fkRole(id_role) REFERENCES Role(id_role) ON DELETE CASCADE,
    FOREIGN KEY fkMorphologyUser(id_morphology) REFERENCES Morphology(id_morphology),
    FOREIGN KEY fkGoalUser(id_goal) REFERENCES Goal(id_goal)
    );
    
CREATE TABLE Structure(
	id_structure int PRIMARY KEY  auto_increment,
    name VARCHAR(30),
    id_goal int,
    FOREIGN KEY fkGoalStructure(id_goal) REFERENCES Goal(id_goal)
    );
    
CREATE TABLE TrainingType(
	id_training_type int PRIMARY KEY  auto_increment,
    name VARCHAR(30),
    description VARCHAR(400));
    
CREATE TABLE Training(
	id_training int PRIMARY KEY  auto_increment,
    name VARCHAR(30),
    description VARCHAR(400),
    id_structure int,
    id_training_type int,
    layout int default 0, 
    duration int default 0,
    FOREIGN KEY fkStructureTraining(id_structure) REFERENCES Structure(id_structure) ON DELETE CASCADE,
    FOREIGN KEY fkTrainingTypeTraining(id_training_type) REFERENCES TrainingType(id_training_type) ON DELETE CASCADE
    );

CREATE TABLE TrainingMethod(
	id_training_method int PRIMARY KEY  auto_increment,
    name VARCHAR(30),
    math_function VARCHAR(30),
    rep_max int default 0,
    rep_min int default 0,
    weight_max int default 0,
    weight_min int default 0);
    
CREATE TABLE ExerciceType(
	id_exercice_type int PRIMARY KEY  auto_increment,
    name VARCHAR(30),
    description VARCHAR(400));

CREATE TABLE Exercice(
	id_exercice int PRIMARY KEY  auto_increment,
    name VARCHAR(30),
    description VARCHAR(400),
    met float default 0);

CREATE TABLE ComposeTraining(
	id_training int,
    id_type int,
    id_training_method int,
    layout int default 0,
    is_super_set bool,
    CONSTRAINT id_compose_training PRIMARY KEY (id_training, id_type, id_training_method, layout),
    FOREIGN KEY fkTrainingType(id_training) REFERENCES Training(id_training) ON DELETE CASCADE,
    FOREIGN KEY fkTypeTraining(id_type) REFERENCES ExerciceType(id_exercice_type) ON DELETE CASCADE,
    FOREIGN KEY fkTrainingMethod(id_training_method) REFERENCES TrainingMethod(id_training_method) ON DELETE CASCADE);
    
CREATE TABLE Serie(
	id_serie int PRIMARY KEY  auto_increment,
	date date,
    weight float default 0,
    repetitions int default 0,
    rpe int default 0,
    expected_repetitions int default 0,
    expected_weight int default 0,
    id_compose_training_training int,
    id_compose_training_type int,
    id_compose_training_method int,
    id_user int,
    id_exercice int,
    FOREIGN KEY fkComposeTraining(id_compose_training_training, id_compose_training_type, id_compose_training_method) REFERENCES ComposeTraining(id_training, id_type, id_training_method) ON DELETE CASCADE,
    FOREIGN KEY fkUserSerie(id_user) REFERENCES User(id_user) ON DELETE CASCADE,
    FOREIGN KEY fkExercice(id_exercice) REFERENCES Exercice(id_exercice) ON DELETE CASCADE);
    
CREATE TABLE Disponibility(
	id_disponibility int PRIMARY KEY  auto_increment,
    duration int default 0,
    layout int default 0);
    
CREATE TABLE GoalNbRep(
	id_GoalNbRep int PRIMARY KEY  auto_increment,
    min int default 0,
    max int default 0,
    id_goal int,
    FOREIGN KEY fkGoalNbRep(id_goal) REFERENCES Goal(id_goal) ON DELETE CASCADE);

CREATE TABLE GoalWeight(
	id_GoalWeight int PRIMARY KEY  auto_increment,
    min int default 0,
    max int default 0,
    id_goal int,
    FOREIGN KEY fkGoalWeight(id_goal) REFERENCES Goal(id_goal) ON DELETE CASCADE);
    
CREATE TABLE GoalNbSerie(
	id_GoalNbSerie int PRIMARY KEY  auto_increment,
    min int default 0,
    max int default 0,
    id_goal int,
    FOREIGN KEY fkGoalNbSerie(id_goal) REFERENCES Goal(id_goal) ON DELETE CASCADE);
    
CREATE TABLE BodyLimb(
	id_BodyLimb int PRIMARY KEY  auto_increment,
    name VARCHAR(30)); 
    
CREATE TABLE Equipment (
	id_equipment int PRIMARY KEY  auto_increment,
    name VARCHAR(30));



CREATE TABLE CompatibleLimb(
	id_exercice int,
    id_BodyLimb int,
    CONSTRAINT compatible_limb_pk PRIMARY KEY (id_exercice, id_BodyLimb),
    FOREIGN KEY fkExerciceBodyLimb(id_exercice) REFERENCES Exercice(id_exercice) ON DELETE CASCADE,
    FOREIGN KEY fkBodyLimbExercice(id_BodyLimb) REFERENCES BodyLimb(id_BodyLimb) ON DELETE CASCADE);
    
CREATE TABLE CompatibleMorph (
	id_exercice int,
    id_morphology int,
    CONSTRAINT compatible_limb_pk PRIMARY KEY (id_exercice, id_morphology),
    FOREIGN KEY fkExerciceMorphology(id_exercice) REFERENCES Exercice(id_exercice),
    FOREIGN KEY fkMorphologyExercice(id_morphology) REFERENCES Morphology(id_morphology));
    
CREATE TABLE CompatibleEquipment(
	id_exercice int,
    id_equipment int,
    CONSTRAINT compatible_equipment_pk PRIMARY KEY (id_exercice, id_equipment),
    FOREIGN KEY fkExerciceEquipment(id_exercice) REFERENCES Exercice(id_exercice) ON DELETE CASCADE,
    FOREIGN KEY fkEquipmentExercice(id_equipment) REFERENCES Equipment(id_equipment) ON DELETE CASCADE);
    
CREATE TABLE UserExerciceData(
	id_exercice int,
    id_user int,
    weight float default 0,
    mark int default 5,
    CONSTRAINT user_exercice_data PRIMARY KEY  (id_exercice, id_user),
    FOREIGN KEY fkExerciceUser(id_exercice) REFERENCES Exercice(id_exercice) ON DELETE CASCADE,
    FOREIGN KEY fkUserExercice(id_user) REFERENCES User(id_user) ON DELETE CASCADE);
    
CREATE TABLE ExerciceTyping(
	id_exercice int,
    id_exercice_type int,
    CONSTRAINT exercice_type_pk PRIMARY KEY (id_exercice, id_exercice_type),
    FOREIGN KEY fkExerciceExerciceType(id_exercice) REFERENCES Exercice(id_exercice) ON DELETE CASCADE,
    FOREIGN KEY fkExerciceTypeExercice(id_exercice_type) REFERENCES ExerciceType(id_exercice_type) ON DELETE CASCADE);
    
CREATE TABLE HasEquipment(
	id_user int,
    id_equipment int,
    CONSTRAINT has_equipment_pk PRIMARY KEY (id_user, id_equipment),
    FOREIGN KEY fkUserEquipment(id_user) REFERENCES User(id_user) ON DELETE CASCADE,
    FOREIGN KEY fkEquipmentUser(id_equipment) REFERENCES Equipment(id_equipment) ON DELETE CASCADE);
    
CREATE TABLE UseLimb(
	id_user int,
    id_BodyLimb int,
    CONSTRAINT use_limb_pk PRIMARY KEY (id_user, id_BodyLimb),
    FOREIGN KEY fkUserLimb(id_user) REFERENCES User(id_user) ON DELETE CASCADE,
    FOREIGN KEY fkBodyLimbUser(id_BodyLimb) REFERENCES BodyLimb(id_BodyLimb) ON DELETE CASCADE);

CREATE TABLE CanTrainOn(
	id_user int,
    id_disponibility int,
    CONSTRAINT can_train_on_pk PRIMARY KEY (id_user, id_disponibility),
    FOREIGN KEY fkUserDisponibility(id_user) REFERENCES User(id_user) ON DELETE CASCADE,
    FOREIGN KEY fkDisponibilityUser(id_disponibility) REFERENCES Disponibility(id_disponibility) ON DELETE CASCADE);
    
CREATE TABLE CompatibleDisponibility(
	id_structure int,
    id_disponibility int,
    CONSTRAINT compatible_disponibility_pk PRIMARY KEY (id_structure, id_disponibility),
    FOREIGN KEY fkStructureDisponibility(id_structure) REFERENCES Structure(id_structure) ON DELETE CASCADE,
    FOREIGN KEY fkDisponibilityStructure(id_disponibility) REFERENCES Disponibility(id_disponibility) ON DELETE CASCADE);





CREATE TABLE BiomecanicFunctionList(
	id_biomecanic_function_list int PRIMARY KEY auto_increment
);

CREATE TABLE BiomecanicFunction(
	id_biomecanic_function int PRIMARY KEY auto_increment,
    name VARCHAR(30) );



CREATE TABLE BiomecanicFunctionUseLimb(
	id_biomecanic_function int ,
	id_BodyLimb int,
    FOREIGN KEY fkBiomecanicFunctionLimb(id_biomecanic_function) REFERENCES BiomecanicFunction(id_biomecanic_function),
    FOREIGN KEY fkBodyLimb(id_BodyLimb) REFERENCES BodyLimb(id_BodyLimb),
    PRIMARY KEY (id_biomecanic_function, id_BodyLimb)
);


CREATE TABLE UseBiomecanicFunction(
	id_biomecanic_function int,
	id_biomecanic_function_list int,
    FOREIGN KEY fkUseBiomecanicFunction(id_biomecanic_function) REFERENCES BiomecanicFunction(id_biomecanic_function),
    FOREIGN KEY fkBiomecanicFunctionList(id_biomecanic_function_list) REFERENCES BiomecanicFunctionList(id_biomecanic_function_list),
    PRIMARY KEY (id_biomecanic_function, id_biomecanic_function_list)
);








