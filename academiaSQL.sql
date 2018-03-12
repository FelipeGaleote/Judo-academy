create database academia;
use academia;
create table aluno(
	id int not null auto_increment,
	nome varchar(60) unique,
    ano_nascimento int,
    sexo char(1),
    peso decimal(5,2),
    classe varchar(10),
    categoria varchar(40),
    primary key(id)
);

