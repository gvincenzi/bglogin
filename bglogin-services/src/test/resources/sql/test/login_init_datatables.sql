-- -----------------------------------------------------
-- Table bglogin.user
-- -----------------------------------------------------
CREATE TABLE user (
  user_id INTEGER NOT NULL,
  username VARCHAR(45) NOT NULL,
  password VARCHAR(60) NOT NULL,
  creation_date TIMESTAMP,
  last_login TIMESTAMP,
  PRIMARY KEY (user_id));


-- -----------------------------------------------------
-- Table bglogin.role
-- -----------------------------------------------------
CREATE TABLE role (
  role_id INTEGER NOT NULL,
  role VARCHAR(45) NOT NULL,
  PRIMARY KEY (role_id));


-- -----------------------------------------------------
-- Table bglogin.user_roles
-- -----------------------------------------------------
CREATE TABLE user_roles (
  user_roles_id INTEGER NOT NULL,
  user_id INTEGER NOT NULL,
  role_id INTEGER NOT NULL,
  PRIMARY KEY (user_roles_id),
  CONSTRAINT fk_user
    FOREIGN KEY (user_id)
    REFERENCES user (user_id)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT fk_role
    FOREIGN KEY (role_id)
    REFERENCES role (role_id)
    ON DELETE CASCADE
    ON UPDATE CASCADE);
