create database if not exists `student-management`;
use qlsv;
create table class(
id int,
name varchar(50)
);
create table teacher(
id int,
name varchar(50),
age int,
country varchar(100)
);