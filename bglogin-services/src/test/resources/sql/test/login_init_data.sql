DELETE FROM role;
INSERT INTO role (role_id, role) VALUES
	(1, 'ROLE_ADMIN'),
	(2, 'ROLE_USER');
DELETE FROM user;
INSERT INTO user (user_id, username, password, creation_date, last_login, enabled) VALUES
	(1, 'admin', 'admin', '2016-02-17 16:24:51', NULL, 1),
	(2, 'gvincenzi', 'gvincenzi', '2016-02-17 18:40:07', NULL, 1);
DELETE FROM user_roles;
INSERT INTO user_roles (user_roles_id, user_id, role_id) VALUES
	(1, 1, 1),
	(2, 2, 1),
	(3, 2, 2);