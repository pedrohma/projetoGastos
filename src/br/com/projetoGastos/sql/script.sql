drop database if exists projetoGastos;
create database projetoGastos;
use projetoGastos;

create table usuario(
idusuario 	integer 	auto_increment,
nome 		varchar(50) not null,
login 		varchar(50) not null unique,
senha 		varchar(50) not null,
foto 		varchar(50) not null,
primary key(idusuario));

create table gasto(
idgasto		integer		auto_increment,
titulo		varchar(50)	not null,
valor		double		not null,
data		date		not null,
idusuario	integer		not null,
primary key(idgasto),
foreign key(idusuario) references usuario(idusuario));

show tables;
desc usuario;
desc gasto;