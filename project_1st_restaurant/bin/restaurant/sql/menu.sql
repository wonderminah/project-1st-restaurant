create sequence mu_seq;
create table menu
(	
	id        number(2) primary key,
	storename varchar2(30) not null,
	menuname  varchar2(30) not null,
	price     number(5) not null
);

insert into menu values (mu_seq.nextval, '����ġŲ', '�����̳�' , 17000);
insert into menu values (mu_seq.nextval, '����ġŲ', '����õ��' , 17000);
insert into menu values (mu_seq.nextval, '����ġŲ', '��������' , 15000);
insert into menu values (mu_seq.nextval, '����ġŲ', '����޺�' , 18000);
insert into menu values (mu_seq.nextval, '����ġŲ', '�����޺�' , 18000);
insert into menu values (mu_seq.nextval, '����ġŲ', '��������' , 15000);
insert into menu values (mu_seq.nextval, '�׳�ġŲ', '������' , 17000);
insert into menu values (mu_seq.nextval, '�׳�ġŲ', '�Ķ��̵�' , 15000);
insert into menu values (mu_seq.nextval, '�׳�ġŲ', '���' , 16000);
insert into menu values (mu_seq.nextval, '������', '��ġ��� �ٺ�ť ġŲ' , 24430);
insert into menu values (mu_seq.nextval, '������', '��ġ��� ġ��ŷ' , 24430);
insert into menu values (mu_seq.nextval, '������', 'ũ��ġ ����ŷ' , 24430);
insert into menu values (mu_seq.nextval, '��������', 'ġŲ �ٺ�ť' , 25500);
insert into menu values (mu_seq.nextval, '��������', '���̸��� ��������' , 25500);
insert into menu values (mu_seq.nextval, '��������', '���� ���Ľ�' , 26500);
insert into menu values (mu_seq.nextval, '�̽�������', '����������' , 19900);
insert into menu values (mu_seq.nextval, '�̽�������', '��������' , 19900);
insert into menu values (mu_seq.nextval, '�̽�������', '������������' , 22900);
insert into menu values (mu_seq.nextval, '�ְ�������', '����' , 25000);
insert into menu values (mu_seq.nextval, '�ְ�������', '��ä����' , 30000);
insert into menu values (mu_seq.nextval, '�ְ�������', '�ſ�����' , 25000);
insert into menu values (mu_seq.nextval, '���浿����', '������' , 20000);
insert into menu values (mu_seq.nextval, '���浿����', '�ſ������' , 20000);
insert into menu values (mu_seq.nextval, '���浿����', '��ä����' , 30000);
insert into menu values (mu_seq.nextval, '�����ǳ���', '����' , 28000);
insert into menu values (mu_seq.nextval, '�����ǳ���', '������' , 28000);
insert into menu values (mu_seq.nextval, '�����ǳ���', '������Ʈ' , 45000);
insert into menu values (mu_seq.nextval, '�̽��ͺ���', '�̽��ͺ��Ӽ�Ʈ' , 22000);
insert into menu values (mu_seq.nextval, '�̽��ͺ���', '�ٺ�ť���ú��Ӽ�Ʈ' , 28000);
insert into menu values (mu_seq.nextval, '�̽��ͺ���', '�̽����ĺ��Ӽ�Ʈ' , 24000);
insert into menu values (mu_seq.nextval, '���Ҹź���', '����' , 25000);
insert into menu values (mu_seq.nextval, '���Ҹź���', '����' , 35000);
insert into menu values (mu_seq.nextval, '���Ҹź���', 'ȫ�����' , 30000);
insert into menu values (mu_seq.nextval, '�����׺���', '����' , 28000);
insert into menu values (mu_seq.nextval, '�����׺���', '������Ʈ' , 45000);
insert into menu values (mu_seq.nextval, '�����׺���', '������+����' , 45000);