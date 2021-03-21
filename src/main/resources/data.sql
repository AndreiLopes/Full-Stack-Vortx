DROP TABLE IF EXISTS tariffs;

CREATE TABLE tariffs (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  origin INT NOT NULL,
  destiny INT NOT NULL,
  value_by_minutes DECIMAL(5,2) NOT NULL
);

INSERT INTO tariffs (origin, destiny, value_by_minutes) VALUES
  (11, 16, 1.90),
  (16, 11, 2.90),
  (11, 17, 1.70),
  (17, 11, 2.70),
  (11, 18, 0.90),
  (18, 11, 1.90);