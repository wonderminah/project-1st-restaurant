create sequence odl_seq;
create table orderlist
(
	id		  number(2) primary key,
	orderdate varchar2(10),
	storename varchar2(30) not null,
	menuname  varchar2(30),
	price     number(5) not null,
	amount    number(2) not null,
	mileage   number(7) not null
);