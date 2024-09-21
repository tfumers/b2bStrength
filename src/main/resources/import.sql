--Inserción en los status de cliente
INSERT INTO client_status (status) VALUES ('NO_SURVEY'); -- registrado, pero no completo la encuesta
INSERT INTO client_status (status) VALUES ('NO_ROUTINE'); -- completo la encuesta y no tiene una relación cliente-entrenador activa
INSERT INTO client_status (status) VALUES ('WAITING'); -- a la espera de la confirmación del entrenador, o a la espera de la habilitación de la rutina
INSERT INTO client_status (status) VALUES ('HAS_ROUTINE'); -- posee una rutina activa, a trabajarla nomás
INSERT INTO client_status (status) VALUES ('BANNED'); -- el usuario puede acceder a la aplicación, pero tiene inhabilitadas alguans opciones

--Inserción de datos de trainer_client_relation_status
INSERT INTO trainer_client_relation_status (status) VALUES ('Pending');
INSERT INTO trainer_client_relation_status (status) VALUES ('Accepted');
INSERT INTO trainer_client_relation_status (status) VALUES ('Cancelled');

--Inserción de datos de dificultades
INSERT INTO training_difficulty (name, description) VALUES ('Inicial', 'Para iniciados. De uno a tres meses de entrenamiento');
INSERT INTO training_difficulty (name, description) VALUES ('Avanzado', 'Para personas que tengan buen control muscular.');
INSERT INTO training_difficulty (name, description) VALUES ('Dificl', 'Para personas que busquen un alto rendimiento deportivo.');

--Inserción de categorías de entrenamientos
INSERT INTO training_category (name, description) VALUES ('Sin Categoria', 'Entrenamientos que no cuentan con categoria');
INSERT INTO training_category (name, description) VALUES ('Brazos', 'Entrenamientos específicos de brazos');
INSERT INTO training_category (name, description) VALUES ('Core', 'Entrenamientos de la zona centrica del cuerpo. El torso.');
INSERT INTO training_category (name, description) VALUES ('Piernas', 'Entrenamientos que se centran en el tren inferior,');
INSERT INTO training_category (name, description) VALUES ('Cuerpo Completo', 'Entrenamientos generales corporales');
INSERT INTO training_category (name, description) VALUES ('CrossFit', 'Entrenamientos basados en CrossFit o que vengan de esa disciplina');
INSERT INTO training_category (name, description) VALUES ('Calistenia', 'Entrenamientos que utilizan el peso corporal para su realizacion');

--Inserción de entrenamientos
INSERT INTO training (name, description, difficulty_id, est_time_per_rep, est_calories_per_rep, image_url, video_url,created_at, updated_at, is_enabled) VALUES ('Flexion de codos', 'Para realizar el ejercicio, se comienza estando en una posición inclinada, recostado hacia abajo, levantando el cuerpo únicamente con los brazos y bajando de nuevo al suelo.', 1L, 10, 10, 'flexiones-img', 'FlexAnimController', '2022-09-08', '2022-09-08', 'true');
INSERT INTO training (name, description, difficulty_id, est_time_per_rep, est_calories_per_rep, image_url, video_url,created_at, updated_at, is_enabled) VALUES ('Burpee', 'Éste es un ejercicio combinado. En la posicion inicial de parado, se realiza una sentadilla. Se vuelve a la posicion inicial, luego se hace una flexion de codos. Volver a la posición inicial y, desde ahí, se hace un salto vertical elevando las manos.', 2L, 10, 10, 'burpee-img', 'BurpeeAnimController', '2022-09-08', '2022-09-08', 'true');
INSERT INTO training (name, description, difficulty_id, est_time_per_rep, est_calories_per_rep, image_url, video_url,created_at, updated_at, is_enabled) VALUES ('Plancha Lateral', 'Colócate sobre uno de tus costados en una colchoneta, apoyándote en uno de los lados de tu cuerpo, con la pierna y el antebrazo.', 3L, 10, 10, 'plancha-lateral-img', 'PlanchaLatAnimController', '2022-09-08', '2022-09-08', 'true');
INSERT INTO training (name, description, difficulty_id, est_time_per_rep, est_calories_per_rep, image_url, video_url,created_at, updated_at, is_enabled) VALUES ('Plancha Frontal', 'En el suelo, apoya el peso del cuerpo sobre los antebrazos y las puntas de los pies. Mantén la zona media lo más firme posible.', 1L, 10, 10, 'plancha-frontal-img', 'PlanchaFrontAnimController', '2022-09-08', '2022-09-08', 'true');
INSERT INTO training (name, description, difficulty_id, est_time_per_rep, est_calories_per_rep, image_url, video_url,created_at, updated_at, is_enabled) VALUES ('Sentadillas', 'El ejercicio consiste en flexionar las rodillas y bajar el cuerpo manteniendo la verticalidad, para luego regresar a una posición erguida.', 2L, 10, 10, 'sentadillas-img', 'SentadillasAnimController', '2022-09-08', '2022-09-08', 'true');

--Inserciòn del tipo de actividad
INSERT INTO activity_type (type) VALUES ('Repeticiones')
INSERT INTO activity_type (type) VALUES ('Temporizado')

--Inserción de relacion entre entrenamientos y sus categorías
INSERT INTO training_category_relation (training_id, category_id, created_at, updated_at) VALUES (1L, 2L, '2022-09-08','2022-09-08');
INSERT INTO training_category_relation (training_id, category_id, created_at, updated_at) VALUES (1L, 7L, '2022-09-08','2022-09-08');
INSERT INTO training_category_relation (training_id, category_id, created_at, updated_at) VALUES (2L, 5L, '2022-09-08','2022-09-08');
INSERT INTO training_category_relation (training_id, category_id, created_at, updated_at) VALUES (2L, 6L, '2022-09-08','2022-09-08');
INSERT INTO training_category_relation (training_id, category_id, created_at, updated_at) VALUES (3L, 3L, '2022-09-08','2022-09-08');
INSERT INTO training_category_relation (training_id, category_id, created_at, updated_at) VALUES (3L, 7L, '2022-09-08','2022-09-08');
INSERT INTO training_category_relation (training_id, category_id, created_at, updated_at) VALUES (4L, 3L, '2022-09-08','2022-09-08');
INSERT INTO training_category_relation (training_id, category_id, created_at, updated_at) VALUES (4L, 7L, '2022-09-08','2022-09-08');
INSERT INTO training_category_relation (training_id, category_id, created_at, updated_at) VALUES (5L, 3L, '2022-09-08','2022-09-08');
INSERT INTO training_category_relation (training_id, category_id, created_at, updated_at) VALUES (5L, 4L, '2022-09-08','2022-09-08');
INSERT INTO training_category_relation (training_id, category_id, created_at, updated_at) VALUES (5L, 7L, '2022-09-08','2022-09-08');
