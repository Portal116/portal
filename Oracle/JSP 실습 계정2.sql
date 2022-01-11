DROP TABLE cust_account;

CREATE TABLE cust_account (
    accountno VARCHAR2(20) PRIMARY KEY,
    custname  VARCHAR2(50),
    balance   NUMBER(20, 4)
);

INSERT INTO cust_account (
    accountno,
    custname,
    balance
) VALUES (
    '70-490-930',
    'È«±æµ¿',
    10000000
);

INSERT INTO cust_account (
    accountno,
    custname,
    balance
) VALUES (
    '70-490-911',
    '±èÀ¯½Å',
    10000000
);

COMMIT;

SELECT
    *
FROM
    cust_account;