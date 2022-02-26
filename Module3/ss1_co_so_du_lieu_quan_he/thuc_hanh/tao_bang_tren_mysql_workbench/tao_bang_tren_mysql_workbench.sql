create database if not exists `student-management`;
use `student-management`;
create table student(
id int,
name varchar(50),
birthday date
);
insert into student values(1,'mao','1989-06-11');
insert into student values(2,'duong','1980-04-09');
delete from student;
select * from student;
drop database `student-management`;
drop table student;