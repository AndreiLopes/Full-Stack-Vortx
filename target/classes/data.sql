DROP TABLE IF EXISTS tax;

CREATE TABLE tax (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  origin INT NOT NULL,
  destiny INT NOT NULL,
  value_by_minutes DECIMAL(5,2) NOT NULL
);

INSERT INTO tax (origin, destiny, value_by_minutes) VALUES
  (011, 016, 1.90),
  (016, 011, 2.90),
  (011, 017, 1.70),
  (017, 011, 2.70),
  (011, 018, 0.90),
  (018, 011, 1.90);