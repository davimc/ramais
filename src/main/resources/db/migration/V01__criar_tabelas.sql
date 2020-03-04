CREATE TABLE IF NOT EXISTS telefone
  (
     id integer NOT NULL AUTO_INCREMENT,
     numero   VARCHAR(50) NOT NULL,
     ramal   VARCHAR(50) NOT NULL,
     disponivel BOOLEAN not null,
     primary key(id)
  );
CREATE TABLE IF NOT EXISTS setor
  (
     id integer not null AUTO_INCREMENT primary key ,
     nome   VARCHAR(50) NOT NULL,
     numero int,
     id_telefone   int,
     FOREIGN KEY (id_telefone) REFERENCES telefone(id)
  );
CREATE TABLE contato
  (
     id integer not null AUTO_INCREMENT primary key,
     nome   VARCHAR(50) NOT NULL,
     id_telefone  integer NOT NULL,
     id_setor integer NOT NULL,
     FOREIGN KEY (id_setor) REFERENCES setor(id),
     FOREIGN KEY (id_telefone) REFERENCES telefone(id)
  );