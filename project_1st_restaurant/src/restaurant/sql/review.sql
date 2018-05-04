drop sequence rv_seq;
create sequence rv_seq;
create table review
(
	id        number(2) primary key,
	nickname  varchar(15),
	storename varchar(30),
	grade     number(1),
	text      varchar(90) not null
);

insert into review values (rv_seq.nextval, '��ξ�', '����ġŲ', 1, '���� ����ġŲ�� �����ϴ�.');
insert into review values (rv_seq.nextval, '����', '����ġŲ', 5, '��û ���־�� ¯¯');
insert into review values (rv_seq.nextval, '������', '����ġŲ', 3, '�����̾� �� �׻� ��������');
insert into review values (rv_seq.nextval, '����', '����ġŲ', 3, '���� �� ������ ���� ���ƿ�');
insert into review values (rv_seq.nextval, 'sci***', '����ġŲ', 5, '�����̳�� ���');
insert into review values (rv_seq.nextval, '��������', '����ġŲ', 4'���־��');
insert into review values (rv_seq.nextval, '����', '����ġŲ', 4, '�����̳�� �� �弼�� ����');
insert into review values (rv_seq.nextval, 'buf***', '�׳�ġŲ', 3, '�⸧ �����ϰ� ���ֳ׿�');
insert into review values (rv_seq.nextval, 'ddy***', '�׳�ġŲ', 4, '�絵 ���� ���ƿ� �������� ��ų�Կ�');
insert into review values (rv_seq.nextval, '�ױ�', '�׳�ġŲ', 5, '���� ������ ġŲ ');
insert into review values (rv_seq.nextval, '���߾�', '�׳�ġŲ', 4, 'Ƣ����� �ٻ�ٻ��ؼ� ����');
insert into review values (rv_seq.nextval, '�����ǿ�', '�׳�ġŲ', 4, '���ְ� ��޿��� ģ�� �Ͻʴϴ�');
insert into review values (rv_seq.nextval, '�ູ��', '������', 4, 'ġ� ���� �þ�� �� �Ծ����');
insert into review values (rv_seq.nextval, 'ppp***', '������', 1, '���̴� ���״µ� �ս÷� �Ծ��');
insert into review values (rv_seq.nextval, 'scn***', '��������', 3, '�� �԰ڽ��ϴ�');
insert into review values (rv_seq.nextval, 'zzi***', '��������', 5, '����� �ʹ� �ϽŰ� �ƴմϱ� ����');
insert into review values (rv_seq.nextval, '����', '��������', 1, '�������μҽ� �߰� �ش޶�� �ߴµ� �ȿԾ��');
insert into review values (rv_seq.nextval, 'ioo***', '��������', 5, '���ֳ׿� ������ ���ֹ� �ҵ��');
insert into review values (rv_seq.nextval, 'zar***', '��������', 4, '���õ� ���־��');
insert into review values (rv_seq.nextval, 'ooo***', '��������', 4, '�Ͽ����� ��������');
insert into review values (rv_seq.nextval, 'mzm***', '�̽�������', 4, '������');
insert into review values (rv_seq.nextval, 'sid***', '�̽�������', 4, '�����길 ���ѸԴٺ��� �ɽ��� �������� ��������');
insert into review values (rv_seq.nextval, '����', '�̽�������', 4, '������ �� ��ų�Կ�');
insert into review values (rv_seq.nextval, 'raa***', '�̽�������', 5, '�Ͽ����� ���� �̽�������');
insert into review values (rv_seq.nextval, '����', '�ְ�������', 4, '�� ���ƿ�');
insert into review values (rv_seq.nextval, '����', '�ְ�������', 5, '�ܰ� �ɰ� ���ƿ� ������');
insert into review values (rv_seq.nextval, 'mil***', '���浿����', 5, '��û �������� �Ծ��׿�');
insert into review values (rv_seq.nextval, 'zzn***', '���浿����', 5, '�ְ��� ���� ������ ���ݵ� ����');
insert into review values (rv_seq.nextval, '������', '���浿����', 5, '���亸�� ���״µ� ������');
insert into review values (rv_seq.nextval, 'cut***', '���浿����', 5, '���� ���ֳ׿�');
insert into review values (rv_seq.nextval, 'gar***', '�����ǳ���', 5, '���� ��� �� �ƴ� ���� �������� �Ծ ����');
insert into review values (rv_seq.nextval, 'pri***', '�����ǳ���', 3, '����ä�� �⺻���� �־��ּ�����');
insert into review values (rv_seq.nextval, 'kak***', '�����ǳ���', 5, '�׻� ���� ��ų�� ����� ��ŵ�ϴ�');
insert into review values (rv_seq.nextval, 'hoh***', '�����ǳ���', 3, '������ ���־ �ֹ� �ߴµ� ���� �� �������׿�');
insert into review values (rv_seq.nextval, '����', '�����ǳ���', 3, '�����մϴ�');
insert into review values (rv_seq.nextval, 'Ǫ�쾾', '�̽��ͺ���', 4, '������ �ȳ��� �ε巴�� ������');
insert into review values (rv_seq.nextval, 'bab***', '�̽��ͺ���', 4, '�������ؿ� ������ �� �ָ� ������ ����');
insert into review values (rv_seq.nextval, '�����', '�̽��ͺ���', 5, '�����ݶ� �� ���̽��ϴ�');
insert into review values (rv_seq.nextval, 'guu***', '�̽��ͺ���', 4, '����߾��');
insert into review values (rv_seq.nextval, 'fff***', '���Ҹź���', 4, '�����ؼ� ���־��');
insert into review values (rv_seq.nextval, 'rui***', '���Ҹź���', 1, 'ó�� ���Ѻôµ� ����');
insert into review values (rv_seq.nextval, 'lin***', '���Ҹź���', 3, '���ְ� �� �Ծ����');
insert into review values (rv_seq.nextval, 'bik***', '�����׺���', 4, '�ǰ��ߴµ� �԰� �ǰ��� Ǯ��');
insert into review values (rv_seq.nextval, '���ƿ�', '�����׺���', 4, '�㿡�� �� ��ų�Կ�');
