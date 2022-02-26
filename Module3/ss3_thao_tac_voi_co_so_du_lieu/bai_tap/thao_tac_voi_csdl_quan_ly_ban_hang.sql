use quanlybanhang;
select * from customer;
select * from `order`;
select * from orderdetail;
select * from product;

insert into customer(id,name,age) values (1,'Minh Quan',10);
insert into customer(id,name,age) values (2,'Ngoc Oanh',20);
insert into customer(id,name,age) values (3,'Hong Ha',50);

insert into `order`(id,customer_id,date,totalPrice) values (1,1,'2006/03/21',null);
insert into `order`(id,customer_id,date,totalPrice) values (2,2,'2006/03/23',null);
insert into `order`(id,customer_id,date,totalPrice) values (3,1,'2006/03/16',null);

insert into product (id,name,price) values (1,'May Giat',3);
insert into product (id,name,price) values (2,'Tu Lanh',5);
insert into product (id,name,price) values (3,'Dieu Hoa',7);
insert into product (id,name,price) values (4,'Quat',1);
insert into product (id,name,price) values (5,'Bep Dien',2);

insert into orderdetail (orderID,productID,orderQTY) values (1,1,3);
insert into orderdetail (orderID,productID,orderQTY) values (1,3,7);
insert into orderdetail (orderID,productID,orderQTY) values (1,4,2);
insert into orderdetail (orderID,productID,orderQTY) values (2,1,1);
insert into orderdetail (orderID,productID,orderQTY) values (3,1,8);
insert into orderdetail (orderID,productID,orderQTY) values (2,5,4);
insert into orderdetail (orderID,productID,orderQTY) values (2,3,3);

/*Hiển thị các thông tin  gồm oID, oDate, oPrice của tất cả các hóa đơn trong bảng Order*/
select o.id,o.date,o.totalPrice from `order` as o;

/*Hiển thị danh sách các khách hàng đã mua hàng, và danh sách sản phẩm được mua bởi các khách*/

select c.id customer_id, o.id order_id, c.`name` customer_name,p.`name` product_name,od.orderQTY
from customer as c join `order` as o on c.id = o.customer_id join orderdetail as od
on o.id = od.orderID join product as p on od.productID = p.id
order by o.id;
/*Hiển thị tên những khách hàng không mua bất kỳ một sản phẩm nào*/
select * from customer as c 
where c.id not in (select c.id from customer as c join `order` as o on c.id = o.customer_id );

/*Hiển thị mã hóa đơn, ngày bán và giá tiền của từng hóa đơn
 (giá một hóa đơn được tính bằng tổng giá bán của từng loại mặt hàng xuất hiện trong hóa đơn.
 Giá bán của từng loại được tính = odQTY*pPrice)*/
 
 select o.id,o.`date`,sum(p.price*od.orderQTY) total
 from `order` as o join orderdetail as od on o.id = od.orderId
 join product as p on od.productID = p.id group by o.id;
