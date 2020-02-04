CREATE TABLE IF NOT EXISTS telefone
  (
     id primary key,
     numero   VARCHAR(50) NOT NULL,
     ramal   VARCHAR(50) NOT NULL,
  ),
CREATE TABLE IF NOT EXISTS setor
  (
     id primary key,
     nome   VARCHAR(50) NOT NULL,
     FOREIGN Ke
     id_telefone   VARCHAR(50) NOT NULL,
     safra  integer NOT NULL,
     volume integer NOT NULL,
     valor  NUMERIC (10, 2) NOT NULL
  ),
CREATE TABLE vinho
  (
     codigo serial primary key,
     nome   VARCHAR(50) NOT NULL,
     tipo   VARCHAR(50) NOT NULL,
     safra  integer NOT NULL,
     volume integer NOT NULL,
     valor  NUMERIC (10, 2) NOT NULL
  )