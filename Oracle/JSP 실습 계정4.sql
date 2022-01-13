drop table myuser;

create table myuser(
	id varchar2(15),
	name varchar2(30)
);

insert into myuser values('hong1', 'ȫ�浿1');

insert into myuser values('hong2', 'ȫ�浿2');
insert into myuser values('hong3', 'ȫ�浿3');
insert into myuser values('hong4', 'ȫ�浿4');
insert into myuser values('hong5', 'ȫ�浿5');

commit;

select * from myuser;