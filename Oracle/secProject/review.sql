DROP TABLE review CASCADE CONSTRAINTS;

DROP SEQUENCE review_seq;

CREATE TABLE review (
    reviewno  NUMBER(10) PRIMARY KEY,
    productno NUMBER(10),
    image     VARCHAR(50),
    content   VARCHAR(600),
    nickname  VARCHAR(50),
    CONSTRAINT fk_qnareview FOREIGN KEY ( productno )
        REFERENCES product ( productno )
);

CREATE SEQUENCE review_seq START WITH 1 INCREMENT BY 1 MAXVALUE 9999999999 NOCYCLE NOCACHE;

INSERT INTO review VALUES (
    review_seq.NEXTVAL,
    1,
    'review01.jpg',
    '�ıⰡ ���� ���Ҵ� ���̶� �ϰ� ��µ� ���ó� �̻ڰ� �ʹ� ������ ���� �ʰԾ˾Ƽ� �������� ��ΰ��ְ������ �׷��� �����մϴ�',
    'garu****'
);

INSERT INTO review VALUES (
    review_seq.NEXTVAL,
    1,
    'review02.jpg',
    '��� 255~260�Ŵµ� �ߺ������־ 260 �����߰� �� �¾ƿ�. �±� �Դϴ�',
    'naca****'
);

INSERT INTO review VALUES (
    review_seq.NEXTVAL,
    1,
    'review03.jpg',
    '�ϴ� �̻��� ������ ����! �Ź��� ������ �ణ ũ�� ���°��� �� �Ź� ����� 257�ε� 255 �˳��ϰ� ���� ���� ���Ϸ� ���� ���� �����̶� ����� �� �������� �����ߴµ� ���� �����̾��׿� ���� �� �ʹ� �����մϴ�!!',
    'noll****'
);

INSERT INTO review VALUES (
    review_seq.NEXTVAL,
    1,
    'review04.jpg',
    '������ ������� ���ؿ� ��ǰ�ΰ� �³���?;; �� ������ ��ǥ�õ� �帴�ؼ� ���� �׷���..',
    'bkhl****'
);

INSERT INTO review VALUES (
    review_seq.NEXTVAL,
    1,
    'review05.jpg',
    '�Ź� �� ���� ��ũ�� �������ֳ׿� �Ź߲��� �̹��� �����ֱ���',
    'dksd****'
);

INSERT INTO review VALUES (
    review_seq.NEXTVAL,
    2,
    '����6',
    '�ı�6',
    '�г���6'
);

INSERT INTO review VALUES (
    review_seq.NEXTVAL,
    2,
    '����7',
    '�ı�7',
    '�г���7'
);

INSERT INTO review VALUES (
    review_seq.NEXTVAL,
    2,
    '����8',
    '�ı�8',
    '�г���8'
);

INSERT INTO review VALUES (
    review_seq.NEXTVAL,
    2,
    '����9',
    '�ı�9',
    '�г���9'
);

INSERT INTO review VALUES (
    review_seq.NEXTVAL,
    2,
    '����10',
    '�ı�10',
    '�г���10'
);

COMMIT;

SELECT
    *
FROM
    review;