SET SESSION FOREIGN_KEY_CHECKS=0;

/* Drop Tables */

DROP TABLE IF EXISTS modulos;
DROP TABLE IF EXISTS troca_area;
DROP TABLE IF EXISTS Formulario_resposta;
DROP TABLE IF EXISTS Formulario;
DROP TABLE IF EXISTS Aluno;
DROP TABLE IF EXISTS Coordenador;
DROP TABLE IF EXISTS Usuario;




/* Create Tables */

CREATE TABLE Aluno
(
	matricula_aluno varchar(11) NOT NULL,
	matricula_coord varchar(11) NOT NULL,
	serie int,
	PRIMARY KEY (matricula_aluno),
	UNIQUE (matricula_aluno)
);


CREATE TABLE Coordenador
(
	matricula_coord varchar(11) NOT NULL,
	PRIMARY KEY (matricula_coord),
	UNIQUE (matricula_coord)
);


CREATE TABLE Formulario
(
	id_form int NOT NULL AUTO_INCREMENT,
	matricula_aluno varchar(11) NOT NULL,
	matricula_coord varchar(11) NOT NULL,
	area_atual varchar(50),
	area_nova varchar(50),
	data date,
	data_ini date,
	obs varchar(200),
	telefone varchar(9),
	PRIMARY KEY (id_form),
	UNIQUE (id_form)
);


CREATE TABLE Formulario_resposta
(
	id_formrp int NOT NULL AUTO_INCREMENT,
	id_form int NOT NULL,
	matricula_coord varchar(11) NOT NULL,
	parecer_coord varchar(200),
	parecer_areas varchar(200),
	PRIMARY KEY (id_formrp),
	UNIQUE (id_formrp),
	UNIQUE (id_form)
);


CREATE TABLE modulos
(
	id_mod int NOT NULL AUTO_INCREMENT,
	id_formrp int NOT NULL,
	periodo varchar(50),
	area varchar(50),
	area_especifica varchar(50),
	PRIMARY KEY (id_mod),
	UNIQUE (id_mod)
);


CREATE TABLE troca_area
(
	id_troca int NOT NULL AUTO_INCREMENT,
	id_troca_area int,
	id_formrp int NOT NULL,
	area varchar(50),
	vagas int,
	n_alunos int,
	PRIMARY KEY (id_troca),
	UNIQUE (id_troca),
	UNIQUE (id_troca_area)
);


CREATE TABLE Usuario
(
	matricula varchar(11) NOT NULL,
	nome varchar(50),
	senha varchar(50),
	PRIMARY KEY (matricula),
	UNIQUE (matricula)
);



/* Create Foreign Keys */

ALTER TABLE Formulario
	ADD FOREIGN KEY (matricula_aluno)
	REFERENCES Aluno (matricula_aluno)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE Aluno
	ADD FOREIGN KEY (matricula_coord)
	REFERENCES Coordenador (matricula_coord)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE Formulario
	ADD FOREIGN KEY (matricula_coord)
	REFERENCES Coordenador (matricula_coord)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE Formulario_resposta
	ADD FOREIGN KEY (matricula_coord)
	REFERENCES Coordenador (matricula_coord)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE Formulario_resposta
	ADD FOREIGN KEY (id_form)
	REFERENCES Formulario (id_form)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE modulos
	ADD FOREIGN KEY (id_formrp)
	REFERENCES Formulario_resposta (id_formrp)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE troca_area
	ADD FOREIGN KEY (id_formrp)
	REFERENCES Formulario_resposta (id_formrp)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE troca_area
	ADD FOREIGN KEY (id_troca_area)
	REFERENCES troca_area (id_troca)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE Aluno
	ADD FOREIGN KEY (matricula_aluno)
	REFERENCES Usuario (matricula)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE Coordenador
	ADD FOREIGN KEY (matricula_coord)
	REFERENCES Usuario (matricula)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;



