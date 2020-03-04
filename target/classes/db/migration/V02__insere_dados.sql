INSERT INTO Telefone(id,numero, ramal, disponivel) VALUES (1,'98987400', '7400', 0);
INSERT INTO Telefone(id,numero, ramal,disponivel) VALUES (2,'98987181', '7181',0);
INSERT INTO Telefone(id,numero, ramal, disponivel) VALUES (3,'98987304', '7304',0);
INSERT INTO Telefone(id,numero, ramal,disponivel) VALUES (4,'98987102', '7102',0);
INSERT INTO Telefone(id,numero, ramal,disponivel) VALUES (5,'98987401', '7401',0);


INSERT INTO Setor(id,nome, numero, id_telefone) VALUES (1,'ctic',123,1);
INSERT INTO Setor(id,nome, numero, id_telefone) VALUES (2,'cojud',125,3);


INSERT INTO Contato(id, nome, id_telefone, id_setor) VALUES(1,"Walber",2,1);
INSERT INTO Contato(id, nome, id_telefone, id_setor) VALUES(2,"Danilo",4,2);
INSERT INTO Contato(id, nome, id_telefone,id_setor) VALUES(3,"Raimundo",5,1);
