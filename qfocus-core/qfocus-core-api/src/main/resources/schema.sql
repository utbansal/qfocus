DROP TABLE IF EXISTS testcase;
  
CREATE TABLE testcase (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  identifier VARCHAR(250) NOT NULL,
  name VARCHAR(250) NOT NULL
);