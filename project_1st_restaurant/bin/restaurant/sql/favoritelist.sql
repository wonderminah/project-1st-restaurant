create sequence+ fvl_seq;
create table favoritelist
(
	id            number(2) primary key,
	foodtype      varchar2(6),
	storename     varchar2(30) not null,
	openhour      varchar2(5),
	closehour     varchar2(5),
	phonenum      varchar2(13),
	minorder      number(5),
	requiredtime  number(2),
	grade         number(1),
	reviewnum     number(3)
);