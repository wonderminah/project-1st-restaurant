create table administrator
(
	id		   varchar2(20) primary key,
	pw		   varchar2(20) not null
);

insert into administrator values ('system', 'system');