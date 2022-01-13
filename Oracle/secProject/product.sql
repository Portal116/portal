DROP TABLE product CASCADE CONSTRAINTS;

CREATE TABLE product (
    productno        NUMBER(10) PRIMARY KEY,
    productname      VARCHAR2(200) NOT NULL,
    imagename        VARCHAR2(50) NOT NULL,
    price            NUMBER(10) NOT NULL,
    option1          VARCHAR2(2000) NOT NULL,
    option2          VARCHAR2(2000),
    regdate          VARCHAR2(30),
    id               VARCHAR2(20) NOT NULL,
    detailimagename VARCHAR2(50),
    CONSTRAINT fk_prodmem FOREIGN KEY ( id )
        REFERENCES member ( id )
        on delete cascade
);

insert into product values (
1,'[뉴발란스] 남여공용 574/327/530 운동화 씨쏠트 문빔','product01.jpg',
73800,'01.NB_CM997HCA;02.NB_CM997HCC;03.NB_ML574RC2;04.NB_MR530SG;05.NB_MR530KA;06.NB_MS327FE;07.NB_MS327LAB;08.NB_MS327CPG;09.NB_MS327LH1;10.NB_WS327KC;11.NB_MS327WE;12.NB_MS327BD;13.NB_MR530SH;14.NB_WS327LW;15.NB_MS327CLA;16.NB_ML574EVB;17.NB_ML574EVG;18.NB_ML574EVW;19.NB_ML574EVE',
'225;230;235;240;245;250;255;260;265;270;275;280;285;290',to_char(sysdate,'yyyy.mm.dd hh24:mi'),'seller0001','productDetail01.jpg');

insert into product values(
2, '상품명2','상품사진2',10000,'옵션1','옵션2',to_char(sysdate,'yyyy.mm.dd hh24:mi'),'seller0002','상세사진2');

commit;

select * from product;