create database if not exists trees; 

use trees; 

drop table if exists trees;

create table trees(
	id int(10) not null auto_increment,
	name varchar(50) not null, 
	fruit_bearing char(1) not null,
	family varchar(50),
	lifespan int(6),
	primary key(id)
); 