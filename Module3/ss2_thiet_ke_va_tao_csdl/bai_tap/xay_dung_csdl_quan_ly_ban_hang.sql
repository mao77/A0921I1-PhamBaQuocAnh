create database if not exists quanlybanhang;
use quanlybanhang;
create table customer(
id int auto_increment primary key,
`name` varchar(50),
age int
);
create table product(
id int auto_increment primary key,
`name` varchar(50),
price float
);
create table `order`(
id int auto_increment primary key,
customer_id int,
`date` date,
totalPrice float,
foreign key fk_id(customer_id) references customer(id)
);
create table orderdetail(
orderId int,
productId int,
orderQTY int,
primary key(orderId,productId),
foreign key fk_oId(orderId) references `order`(id),
foreign key fk_pId(productId) references product(id)
);
select * from customer;
select * from product;
select * from `order`;
select * from orderdetail;