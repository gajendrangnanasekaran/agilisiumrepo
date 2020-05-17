DROP TABLE IF EXISTS User;
 
CREATE TABLE User (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  user_Name VARCHAR(250),
  password VARCHAR(250),
  roles VARCHAR(250),
  active boolean DEFAULT true
);
 
INSERT INTO User (user_Name, password, roles,active) VALUES
  ('user', 'user', 'ROLE_USER',true),
 ('ram', 'ram', 'ROLE_USER',true),
  ('agilisium', 'agilisium', 'ROLE_USER',true),
  ('admin', 'admin', 'ROLE_USER,ROLE_ADMIN',true);