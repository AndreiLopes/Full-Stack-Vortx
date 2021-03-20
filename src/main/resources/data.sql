DROP TABLE IF EXISTS tariffs;

CREATE TABLE tariffs (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  origin INT NOT NULL,
  destiny INT NOT NULL,
  value_minutes DECIMAL(5,2) NOT NULL
);

INSERT INTO tariffs (origin, destiny, value_minutes) VALUES
  (011, 016, 1.90),
  (016, 011, 2.90),
  (011, 017, 1.70),
  (017, 011, 2.70),
  (011, 018, 0.90),
  (018, 011, 1.90);