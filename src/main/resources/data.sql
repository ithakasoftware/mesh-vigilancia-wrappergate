INSERT INTO cameras   (id, description, owner, latitude, longitude,uri) VALUES (1, 'Camera 0', 'breno.soares', 0.00005,1.2345,'http://localhost:8080/0');
INSERT INTO cameras   (id, description, owner, latitude, longitude,uri) VALUES (2, 'Camera 1', 'user.01', 1.00005,3.2345,'http://localhost:8080/1');
INSERT INTO cameras   (id, description, owner, latitude, longitude,uri) VALUES (3, 'Camera 2', 'user.01', 1.00005,3.2345,'http://localhost:8080/2');

INSERT INTO users   (id, name, login) VALUES (1, 'Breno Matos Carvalho Soares', 'breno.soares');
INSERT INTO users   (id, name, login) VALUES (2, 'Usuario One', 'user.01');
INSERT INTO users   (id, name, login) VALUES (3, 'Usuario Two', 'user.02');

INSERT INTO users_cameras (login, idcam) VALUES ('user.02',3);