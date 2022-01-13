drop table basket CASCADE CONSTRAINTS;

create table basket(

    id               VARCHAR2(20),
    
    productno        NUMBER(10),
   
    option1          VARCHAR2(100) not null,
    option2          VARCHAR2(100),
    amount number(3) not null,
    delivery number(5));