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
    '�׽�Ʈ���Դϴ�',
    '�׽�Ʈ ����',
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
    '�׽�Ʈ���Դϴ�',
    '�׽�Ʈ���Դϴ�',
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
    '�׽�Ʈ���Դϴ�',
    '��ǰ �ı��Դϴ�',
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
    '�亯�Դϴ�',
    '��ǰ �ı⿡ ���� �亯�Դϴ�',
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
    '�亯�Դϴ�',
    '��ǰ �����ϴ�',
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
    '�������Դϴ�',
    '������ �׽�Ʈ���Դϴ�',
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
    '��ǰ �ı��Դϴ�',
    '�̼��ž��� ��ǰ ����ı⸦ �ø��ϴ�!!',
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
    '�����Ŵ���Դϴ�',
    '�����Ŵ�� �׽�Ʈ���Դϴ�',
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
    '6�� �Խñ��� ���',
    '6���� ���',
    NULL,
    sysdate,
    'kim'
);

commit;