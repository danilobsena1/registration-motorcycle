create database lojaMoto; 
use lojaMoto;

create table Motos(idMoto int not null auto_increment, primary key(idMoto),
		 marca varchar(20) not null,
		 modelo varchar(20) not null,
		 valor double not null,
		 ano int(4) not null );
		 		 