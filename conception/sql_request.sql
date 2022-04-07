USE Training_application;

# get structure from training (structure)
SELECT s.* FROM Structure s, Training t
WHERE s.id_structure = t.id_structure
AND t.name = "full-2A-2h-force";

# get training list of structure (structure)
SELECT t.* FROM Structure s, Training t
WHERE s.id_structure = t.id_structure
AND s.name = "2-2h";



SELECT d.* From Disponibility d, CompatibleDisponibility cd
WHERE d.id_disponibility = cd.id_disponibility
AND cd.id_structure = 1;

SELECT s.* FROM Structure s, User u, CompatibleDisponibility cd, CanTrainOn cto
WHERE s.id_goal = u.id_goal
AND cd.id_disponibility = cto.id_disponibility
AND cd.id_structure = s.id_structure
AND cto.id_user = u.id_user
AND u.id_user = 16;

SELECT t.* FROM Structure s, Training t 
WHERE s.id_structure = t.id_structure
AND s.id_structure = 1;

SELECT tc.* FROM Training t, ComposeTraining tc
WHERE tc.id_training = t.id_training
AND t.id_training = 1;

SELECT bf.* From BiomecanicFunctionList bfl, UseBiomecanicFunction ubf, BiomecanicFunction bf
WHERE bfl.id_biomecanic_function_list = ubf.id_biomecanic_function_list
AND bf.id_biomecanic_function = ubf.id_biomecanic_function
AND bfl.id_biomecanic_function_list = 1;

SELECT e.* FROM Exercice e, ExerciceType et, ExerciceTyping etg
WHERE e.id_exercice = etg.id_exercice
AND et.id_exercice_type = etg.id_exercice_type
AND et.id_exercice_type = 1
AND 1 in (select id_morphology FROM CompatibleMorph cm
		WHERE e.id_exercice = cm.id_exercice)
AND  0 = (SELECT count(ul.id_BodyLimb) FROM CompatibleBiomecanicFunction cbf, BiomecanicFunctionUseLimb bfu, UseLimb ul 
        WHERE cbf.id_biomecanic_function = bfu.id_biomecanic_function
        AND bfu.id_BodyLimb = ul.id_BodyLimb
        AND cbf.id_exercice = e.id_exercice
        AND ul.id_user = 16) ;

SELECT e.* FROM Exercice e, ExerciceType et, ExerciceTyping etg, CompatibleEquipment ce
WHERE e.id_exercice = etg.id_exercice
AND et.id_exercice_type = etg.id_exercice_type
AND et.id_exercice_type = 1
AND ce.id_exercice = e.id_exercice
AND 1 in (select id_morphology FROM CompatibleMorph cm
		WHERE e.id_exercice = cm.id_exercice)
AND ce.id_equipment in (SELECT eq.id_equipment FROM HasEquipment he, Equipment eq
    WHERE he.id_equipment = eq.id_equipment
    AND he.id_user = 16)
GROUP BY e.id_exercice;

        
SELECT e.* FROM Exercice e, ExerciceType et, ExerciceTyping etg
WHERE e.id_exercice = etg.id_exercice
AND et.id_exercice_type = etg.id_exercice_type
AND et.id_exercice_type = 1
AND 1 in (select id_morphology FROM CompatibleMorph cm
		WHERE e.id_exercice = cm.id_exercice);
	



        
        
SELECT ul.id_BodyLimb FROM CompatibleBiomecanicFunction cbf, BiomecanicFunctionUseLimb bfu, UseLimb ul 
        WHERE cbf.id_biomecanic_function = bfu.id_biomecanic_function
        AND bfu.id_BodyLimb = ul.id_BodyLimb
        AND cbf.id_exercice = 12
        AND ul.id_user = 16;        
        

SELECT bf.* FROM BiomecanicFunction bf, CompatibleBiomecanicFunction cbf, Exercice e
WHERE e.id_exercice = cbf.id_exercice
AND bf.id_biomecanic_function = cbf.id_biomecanic_function
AND e.id_exercice = 7;USE Training_application;

# get structure from training (structure)
SELECT s.* FROM Structure s, Training t
WHERE s.id_structure = t.id_structure
AND t.name = "full-2A-2h-force";

# get training list of structure (structure)
SELECT t.* FROM Structure s, Training t
WHERE s.id_structure = t.id_structure
AND s.name = "2-2h";



SELECT d.* From Disponibility d, CompatibleDisponibility cd
WHERE d.id_disponibility = cd.id_disponibility
AND cd.id_structure = 1;

SELECT s.* FROM Structure s, User u, CompatibleDisponibility cd, CanTrainOn cto
WHERE s.id_goal = u.id_goal
AND cd.id_disponibility = cto.id_disponibility
AND cd.id_structure = s.id_structure
AND cto.id_user = u.id_user
AND u.id_user = 16;

SELECT t.* FROM Structure s, Training t 
WHERE s.id_structure = t.id_structure
AND s.id_structure = 1;

SELECT tc.* FROM Training t, ComposeTraining tc
WHERE tc.id_training = t.id_training
AND t.id_training = 1;

SELECT bf.* From BiomecanicFunctionList bfl, UseBiomecanicFunction ubf, BiomecanicFunction bf
WHERE bfl.id_biomecanic_function_list = ubf.id_biomecanic_function_list
AND bf.id_biomecanic_function = ubf.id_biomecanic_function
AND bfl.id_biomecanic_function_list = 1;

SELECT e.* FROM Exercice e, ExerciceType et, ExerciceTyping etg
WHERE e.id_exercice = etg.id_exercice
AND et.id_exercice_type = etg.id_exercice_type
AND et.id_exercice_type = 1
AND 1 in (select id_morphology FROM CompatibleMorph cm
		WHERE e.id_exercice = cm.id_exercice)
AND NULL = (SELECT ul.id_BodyLimb FROM CompatibleBiomecanicFunction cbf, BiomecanicFunctionUseLimb bfu, UseLimb ul 
        WHERE cbf.id_biomecanic_function = bfu.id_biomecanic_function
        AND bfu.id_BodyLimb = ul.id_BodyLimb
        
        AND ul.id_user = 16);
        
        
        

SELECT bf.* FROM BiomecanicFunction bf, CompatibleBiomecanicFunction cbf, Exercice e
WHERE e.id_exercice = cbf.id_exercice
AND bf.id_biomecanic_function = cbf.id_biomecanic_function
AND e.id_exercice = 7;


SELECT ued.* FROM UserExerciceData ued
WHERE ued.id_exercice = 7
AND ued.id_user = 16;

SELECT tm.* FROM TrainingMethod tm, ComposeTraining ct
WHERE ct.id_training_method = tm.id_training_method
AND ct.id_training = 1 
AND ct.layout = 1;

# Get all user nb of exercice done
SELECT sum(nb_done) total FROM UserExerciceData ued
WHERE id_user = 16;