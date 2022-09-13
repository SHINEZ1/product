drop table product;
create table product(
    pid         number(10),
    pname       varchar(30),
    count       number(10),
    price       number(10)
);
--기본키
alter table product add constraint product_pid_pk primary key(pid);

--시퀀스생성
drop sequence product_pid_seq;
create sequence product_pid_seq;


--생성--
insert into product(pid,pname,count,price)
     values(product_pid_seq.nextval, '컴퓨터', 2, 2000000);

insert into product(pid,pname,count,price)
     values(product_pid_seq.nextval, '모니터', 2, 1000000);

insert into product(pid,pname,count,price)
     values(product_pid_seq.nextval, '마우스', 4, 500000);

--조회--
select pid, pname, count, price
  from product
 where pid = 2;

--수정--
update product
   set pname = '키보드',
       count = 5,
       price = 800000
where pid=3;

commit;

--삭제
delete from product where pid = 3;

--전체조회-
select * from product;

