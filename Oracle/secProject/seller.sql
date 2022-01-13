DROP TABLE seller CASCADE CONSTRAINTS;

CREATE TABLE seller (
    id        VARCHAR2(20),
    productno NUMBER(10),
    totalsell NUMBER(20),
    CONSTRAINT fk_sellmem FOREIGN KEY ( id )
        REFERENCES member ( id )
            ON DELETE CASCADE,
    CONSTRAINT fk_sellprod FOREIGN KEY ( productno )
        REFERENCES product ( productno )
            ON DELETE CASCADE
);

INSERT INTO seller VALUES (
    'seller0001',
    1,
    0
);

INSERT INTO seller VALUES (
    'seller0001',
    2,
    0
);

COMMIT;

SELECT
    *
FROM
    seller;