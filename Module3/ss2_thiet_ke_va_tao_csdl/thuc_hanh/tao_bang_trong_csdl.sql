create database if not exists quanlydiemthi;
use quanlydiemthi;
create table hocsinh(
maHS varchar(20) primary key,
tenHS varchar(50),
ngaysinh datetime,
lop varchar(20),
gt varchar(20)
);
create table monhoc(
maMH varchar(20) primary key,
tenMH varchar(50)
);
create table bangdiem(
maHS varchar(20),
maMH varchar(20),
diemThi int,
ngayKT datetime,
primary key(maHS,maMH),
foreign key(maHS) references hocsinh(mahs),
foreign key(maMH) references monhoc(maMH)
);
create table giaovien(
maGV varchar(20) primary key,
tenGV varchar(20),
sdt varchar(10)
);
alter table monhoc add maGV varchar(20);
alter table monhoc add constraint fk_maGV foreign key(maGV) references giaovien(maGV);