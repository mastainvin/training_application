USE Training_application;

# get structure from training (structure)
SELECT s.* FROM Structure s, Training t
WHERE s.id_structure = t.id_structure
AND t.name = "full-2A-2h-force";

# get training list of structure (structure)
SELECT t.* FROM Structure s, Training t
WHERE s.id_structure = t.id_structure
AND s.name = "2-2h";

CREATE TABLE BiomecanicFunctionUseLimb(
	id_biomecanic_function int,
	id_BodyLimb int,
    FOREIGN KEY fkBiomecanicFunction(id_biomecanic_function) REFERENCES BiomecanicFunction(id_biomecanic_function),
    FOREIGN KEY fkBodyLimb(id_BodyLimb) REFERENCES BodyLimb(id_BodyLimb),
    PRIMARY KEY (id_biomecanic_function, id_BodyLimb)
);


CREATE TABLE UseBiomecanicFunction(
	id_biomecanic_function int,
	id_biomecanic_function_list int,
    FOREIGN KEY fkBiomecanicFunction(id_biomecanic_function) REFERENCES BiomecanicFunction(id_biomecanic_function),
    FOREIGN KEY fkBiomecanicFunctionList(id_biomecanic_function_list) REFERENCES BiomecanicFunctionList(id_biomecanic_function_list),
    PRIMARY KEY (id_biomecanic_function, id_biomecanic_function_list)
);

CREATE TABLE BiomecanicFunctionList(
	id_biomecanic_function_list int PRIMARY KEY
);

CREATE TABLE BiomecanicFunction(
	id_biomecanic_function int PRIMARY KEY,
    name VARCHAR(30) );
