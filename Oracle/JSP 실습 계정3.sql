DROP TABLE t_board CASCADE CONSTRAINTS;

CREATE TABLE t_board (
    articleno     NUMBER(10) PRIMARY KEY,
    parentno      NUMBER(10) DEFAULT 0,
    title         VARCHAR2(500) NOT NULL,
    content       VARCHAR2(4000),
    imagefilename VARCHAR2(100),
    writedate     DATE DEFAULT sysdate NOT NULL,
    id            VARCHAR2(10),
    CONSTRAINT fk_id FOREIGN KEY ( id )
        REFERENCES t_member ( id )
);

INSERT INTO t_board (
    articleno,
    parentno,
    title,
    contents,
    imagefilename,
    writedate,
    id
) VALUES (
    1,
    0,
    '테스트글입니다',
    '테스트 내용',
    NULL,
    sysdate,
    'hong'
);

INSERT INTO t_board (
    articleno,
    parentno,
    title,
    content,
    imagefilename,
    writedate,
    id
) VALUES (
    1,
    0,
    '테스트글입니다',
    '테스트글입니다',
    NULL,
    sysdate,
    'hong'
);

INSERT INTO t_board (
    articleno,
    parentno,
    title,
    content,
    imagefilename,
    writedate,
    id
) VALUES (
    2,
    0,
    '테스트글입니다',
    '상품 후기입니다',
    NULL,
    sysdate,
    'hong'
);

INSERT INTO t_board (
    articleno,
    parentno,
    title,
    content,
    imagefilename,
    writedate,
    id
) VALUES (
    3,
    2,
    '답변입니다',
    '상품 후기에 대한 답변입니다',
    NULL,
    sysdate,
    'hong'
);

INSERT INTO t_board (
    articleno,
    parentno,
    title,
    content,
    imagefilename,
    writedate,
    id
) VALUES (
    5,
    3,
    '답변입니다',
    '상품 좋습니다',
    NULL,
    sysdate,
    'lee'
);

INSERT INTO t_board (
    articleno,
    parentno,
    title,
    content,
    imagefilename,
    writedate,
    id
) VALUES (
    4,
    0,
    '김유신입니다',
    '김유신 테스트글입니다',
    NULL,
    sysdate,
    'kim'
);

INSERT INTO t_board (
    articleno,
    parentno,
    title,
    content,
    imagefilename,
    writedate,
    id
) VALUES (
    6,
    2,
    '상품 후기입니다',
    '이순신씨의 상품 사용후기를 올립니다!!',
    NULL,
    sysdate,
    'lee'
);

COMMIT;

SELECT
    *
FROM
    t_board;

SELECT
    level,
    articleno,
    parentno,
    lpad(
        ' ', 4 *(level - 1)
    )
    || title title,
    content,
    writedate,
    id
FROM
    t_board
START WITH
    parentno = 0
CONNECT BY
    PRIOR articleno = parentno
ORDER SIBLINGS BY
    articleno DESC;

INSERT INTO t_board (
    articleno,
    parentno,
    title,
    content,
    imagefilename,
    writedate,
    id
) VALUES (
    7,
    4,
    '김유신답글입니다',
    '김유신답글 테스트글입니다',
    NULL,
    sysdate,
    'hong'
);

INSERT INTO t_board (
    articleno,
    parentno,
    title,
    content,
    imagefilename,
    writedate,
    id
) VALUES (
    8,
    6,
    '6번 게시글의 답글',
    '6번의 답글',
    NULL,
    sysdate,
    'kim'
);

commit;