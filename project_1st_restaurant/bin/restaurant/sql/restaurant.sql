create sequence rst_seq;
create table restaurant
(
	rstid         number(2) primary key, 
	foodtype      number(1),    
	storename     varchar2(30) not null unique,
	openhour      varchar2(5),  
	closehour     varchar2(5),  
	phonenum      varchar2(13), 
	minorder      number(5),    
	requiredtime  number(2)
);
   
insert into restaurant values (rst_seq.nextval, 1, '네네치킨', '11:30', '23:30', '050-4826-1145', 16000, 33);
insert into restaurant values (rst_seq.nextval, 1, '굽네치킨', '12:00', '23:30', '050-6381-6290', 15000, 42);
insert into restaurant values (rst_seq.nextval, 1, '교촌치킨', '11:00', '24:30', '050-4831-2726', 15000, 38);

insert into restaurant values (rst_seq.nextval, 2, '피자헛', '11:00', '20:30', '050-7996-1831', 12000, 34);
insert into restaurant values (rst_seq.nextval, 2, '파파존스', '11:00', '22:00', '050-4823-3155', 15000, 37);
insert into restaurant values (rst_seq.nextval, 2, '미스터피자', '10:00', '25:00', '050-6115-3616', 12000, 45);

insert into restaurant values (rst_seq.nextval, 3, '최고집족발', '00:00', '24:00', '050-4823-9832', 10000, 60);
insert into restaurant values (rst_seq.nextval, 3, '장충동족발', '00:00', '24:00', '050-6469-3094', 10000, 55);
insert into restaurant values (rst_seq.nextval, 3, '족발의나라', '00:00', '24:00', '050-4994-3697', 25000, 70);

insert into restaurant values (rst_seq.nextval, 4, '미스터보쌈', '11:30', '24:00', '050-6403-0907', 18900, 45);
insert into restaurant values (rst_seq.nextval, 4, '원할매보쌈', '00:00', '24:00', '050-4824-1053', 10000, 50);
insert into restaurant values (rst_seq.nextval, 4, '서가네보쌈', '00:00', '24:00', '050-4994-3610', 25000, 58);

