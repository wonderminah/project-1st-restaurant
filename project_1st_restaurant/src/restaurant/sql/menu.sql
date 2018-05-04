create sequence mu_seq;
create table menu
(	
	id        number(2) primary key,
	storename varchar2(30) not null,
	menuname  varchar2(30) not null,
	price     number(5) not null
);

insert into menu values (mu_seq.nextval, '굽네치킨', '볼케이노' , 17000);
insert into menu values (mu_seq.nextval, '굽네치킨', '갈비천왕' , 17000);
insert into menu values (mu_seq.nextval, '굽네치킨', '오리지널' , 15000);
insert into menu values (mu_seq.nextval, '교촌치킨', '허니콤보' , 18000);
insert into menu values (mu_seq.nextval, '교촌치킨', '레드콤보' , 18000);
insert into menu values (mu_seq.nextval, '교촌치킨', '오리지널' , 15000);
insert into menu values (mu_seq.nextval, '네네치킨', '스노윙' , 17000);
insert into menu values (mu_seq.nextval, '네네치킨', '후라이드' , 15000);
insert into menu values (mu_seq.nextval, '네네치킨', '양념' , 16000);
insert into menu values (mu_seq.nextval, '피자헛', '리치골드 바비큐 치킨' , 24430);
insert into menu values (mu_seq.nextval, '피자헛', '리치골드 치즈킹' , 24430);
insert into menu values (mu_seq.nextval, '피자헛', '크런치 토핑킹' , 24430);
insert into menu values (mu_seq.nextval, '파파존스', '치킨 바베큐' , 25500);
insert into menu values (mu_seq.nextval, '파파존스', '아이리쉬 포테이토' , 25500);
insert into menu values (mu_seq.nextval, '파파존스', '수퍼 파파스' , 26500);
insert into menu values (mu_seq.nextval, '미스터피자', '갈릭쉬림프' , 19900);
insert into menu values (mu_seq.nextval, '미스터피자', '고르곤졸라' , 19900);
insert into menu values (mu_seq.nextval, '미스터피자', '포테이토피자' , 22900);
insert into menu values (mu_seq.nextval, '최고집족발', '족발' , 25000);
insert into menu values (mu_seq.nextval, '최고집족발', '냉채족발' , 30000);
insert into menu values (mu_seq.nextval, '최고집족발', '매운족발' , 25000);
insert into menu values (mu_seq.nextval, '장충동족발', '왕족발' , 20000);
insert into menu values (mu_seq.nextval, '장충동족발', '매운불족발' , 20000);
insert into menu values (mu_seq.nextval, '장충동족발', '냉채족발' , 30000);
insert into menu values (mu_seq.nextval, '족발의나라', '족발' , 28000);
insert into menu values (mu_seq.nextval, '족발의나라', '불족발' , 28000);
insert into menu values (mu_seq.nextval, '족발의나라', '보족세트' , 45000);
insert into menu values (mu_seq.nextval, '미스터보쌈', '미스터보쌈세트' , 22000);
insert into menu values (mu_seq.nextval, '미스터보쌈', '바베큐마늘보쌈세트' , 28000);
insert into menu values (mu_seq.nextval, '미스터보쌈', '미스터파보쌈세트' , 24000);
insert into menu values (mu_seq.nextval, '원할매보쌈', '보쌈' , 25000);
insert into menu values (mu_seq.nextval, '원할매보쌈', '보족' , 35000);
insert into menu values (mu_seq.nextval, '원할매보쌈', '홍어삼합' , 30000);
insert into menu values (mu_seq.nextval, '서가네보쌈', '보쌈' , 28000);
insert into menu values (mu_seq.nextval, '서가네보쌈', '보족세트' , 45000);
insert into menu values (mu_seq.nextval, '서가네보쌈', '불족발+보쌈' , 45000);