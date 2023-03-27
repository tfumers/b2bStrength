--Inserción de datos de dificultades
INSERT INTO training_difficulty (name, description) VALUES ('Inicial', 'Para iniciados. De uno a tres meses de entrenamiento');
INSERT INTO training_difficulty (name, description) VALUES ('Avanzado', 'Para personas que tengan buen control muscular.');
INSERT INTO training_difficulty (name, description) VALUES ('Dificl', 'Para personas que busquen un alto rendimiento deportivo.');

--Inserción de categorías de entrenamientos
INSERT INTO training_category (name, description) VALUES ('Brazos', 'Entrenamientos específicos de brazos');
INSERT INTO training_category (name, description) VALUES ('Core', 'Entrenamientos de la zona centrica del cuerpo. El torso.');
INSERT INTO training_category (name, description) VALUES ('Piernas', 'Entrenamientos que se centran en el tren inferior,');
INSERT INTO training_category (name, description) VALUES ('Cuerpo Completo', 'Entrenamientos generales corporales');
INSERT INTO training_category (name, description) VALUES ('CrossFit', 'Entrenamientos basados en CrossFit o que vengan de esa disciplina');
INSERT INTO training_category (name, description) VALUES ('Calistenia', 'Entrenamientos que utilizan el peso corporal para su realizacion');

--Inserción de entrenamientos
INSERT INTO training (name, description, difficulty_id, est_time_per_rep, est_calories_per_rep, image_url, video_url,created_at, updated_at, is_enabled) VALUES ('Flexiones de brazos', 'description description description', 1L, 10, 10, 'image_url', 'video_url', '2022-09-08', '2022-09-08', 'true');
INSERT INTO training (name, description, difficulty_id, est_time_per_rep, est_calories_per_rep, image_url, video_url,created_at, updated_at, is_enabled) VALUES ('Burpee', 'description description description', 2L, 10, 10, 'image_url', 'video_url', '2022-09-08', '2022-09-08', 'true');
INSERT INTO training (name, description, difficulty_id, est_time_per_rep, est_calories_per_rep, image_url, video_url,created_at, updated_at, is_enabled) VALUES ('Plancha Lateral', 'description description description', 3L, 10, 10, 'image_url', 'video_url', '2022-09-08', '2022-09-08', 'true');
INSERT INTO training (name, description, difficulty_id, est_time_per_rep, est_calories_per_rep, image_url, video_url,created_at, updated_at, is_enabled) VALUES ('Plancha Frontal', 'description description description', 1L, 10, 10, 'image_url', 'video_url', '2022-09-08', '2022-09-08', 'true');
INSERT INTO training (name, description, difficulty_id, est_time_per_rep, est_calories_per_rep, image_url, video_url,created_at, updated_at, is_enabled) VALUES ('Sentadillas', 'description description description', 2L, 10, 10, 'image_url', 'video_url', '2022-09-08', '2022-09-08', 'true');

--Inserción de relacion entre entrenamientos y sus categorías
INSERT INTO training_category_relation (training_id, category_id, created_at, updated_at) VALUES (1L, 1L, '2022-09-08','2022-09-08');
INSERT INTO training_category_relation (training_id, category_id, created_at, updated_at) VALUES (1L, 6L, '2022-09-08','2022-09-08');
INSERT INTO training_category_relation (training_id, category_id, created_at, updated_at) VALUES (2L, 4L, '2022-09-08','2022-09-08');
INSERT INTO training_category_relation (training_id, category_id, created_at, updated_at) VALUES (2L, 5L, '2022-09-08','2022-09-08');
INSERT INTO training_category_relation (training_id, category_id, created_at, updated_at) VALUES (3L, 2L, '2022-09-08','2022-09-08');
INSERT INTO training_category_relation (training_id, category_id, created_at, updated_at) VALUES (3L, 6L, '2022-09-08','2022-09-08');
INSERT INTO training_category_relation (training_id, category_id, created_at, updated_at) VALUES (4L, 2L, '2022-09-08','2022-09-08');
INSERT INTO training_category_relation (training_id, category_id, created_at, updated_at) VALUES (4L, 6L, '2022-09-08','2022-09-08');
INSERT INTO training_category_relation (training_id, category_id, created_at, updated_at) VALUES (5L, 2L, '2022-09-08','2022-09-08');
INSERT INTO training_category_relation (training_id, category_id, created_at, updated_at) VALUES (5L, 3L, '2022-09-08','2022-09-08');
INSERT INTO training_category_relation (training_id, category_id, created_at, updated_at) VALUES (5L, 6L, '2022-09-08','2022-09-08');
