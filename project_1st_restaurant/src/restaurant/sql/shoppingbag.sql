create sequence sb_seq;
create table shoppingbag
(
	sbid      number(2) primary key,
	storename varchar2(30),
	menuname  varchar2(30),
	price     number(5),
	amount    number(2)
);