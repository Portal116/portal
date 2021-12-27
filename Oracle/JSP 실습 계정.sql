CREATE TABLE t_member (
    id       VARCHAR2(10) PRIMARY KEY,
    pwd      VARCHAR2(10),
    name     VARCHAR2(50),
    email    VARCHAR2(50),
    joindate DATE DEFAULT sysdate
);

INSERT INTO t_member VALUES (
    'hong',
    '1212',
    'È«±æµ¿',
    'hong@gmail.com',
    sysdate
);

INSERT INTO t_member VALUES (
    'lee',
    '1212',
    'ÀÌ¼ø½Å',
    'lee@test.com',
    sysdate
);

INSERT INTO t_member VALUES (
    'kim',
    '1212',
    '±èÀ¯½Å',
    'kim@jweb.com',
    sysdate
);

COMMIT;

SELECT
    *
FROM
    t_member;