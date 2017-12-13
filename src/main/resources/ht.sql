create database ht;
use ht;

create table t_user(
	uid int primary key auto_increment,
	username varchar(20) not null,
	password varchar(18) not null,
	age int
);