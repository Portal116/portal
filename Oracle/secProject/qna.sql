DROP TABLE qna CASCADE CONSTRAINTS;

DROP SEQUENCE qna_seq;

CREATE TABLE qna (
    qnano     NUMBER(10) PRIMARY KEY,
    productno NUMBER(10),
    state     VARCHAR2(20) DEFAULT '������',
    title     VARCHAR2(200) NOT NULL,
    answer    VARCHAR2(2100) DEFAULT '���� �亯�� �ۼ����� �ʾҽ��ϴ�',
    nickname  VARCHAR2(20) NOT NULL,
    regdate   DATE DEFAULT sysdate NOT NULL,
    CONSTRAINT fk_qnaproduct FOREIGN KEY ( productno )
        REFERENCES product ( productno )
            ON DELETE CASCADE
);

CREATE SEQUENCE qna_seq START WITH 1 INCREMENT BY 1 MAXVALUE 9999999999 NOCYCLE NOCACHE;

INSERT INTO qna VALUES (
    qna_seq.NEXTVAL,
    1,
    '�亯�Ϸ�',
    '225�� �Ŵµ� ������ ��� ���Ѿߵǳ���?',
    '�ȳ��ϼ��� ���� ���߶��� ������������ ��� �����е��� ����� �˳��ϰԳ��� 1~2ġ������ �۰������Ͻô� �е��� ��ÿ��� ������� �������� ū �κ��̹Ƿ� �Ǹ��ڰ� ������ ��Ȯ�� ������ �� Ư�̻����� Ȯ�� �� �� ���� ��ü���� ������ �亯�� ����� �� ���عٶ��ϴ�. ��ǰ�� ������ǥ�� Ÿ ������ �̿��ı� ���� �����Ͻþ� ������ �߸��� �ߺ� �ʺ�, �߱��� ���� ����ϼż� �ֹ���Ź�帮�ڽ��ϴ�. �����մϴ�.',
    'odr1****',
    '2021-12-20'
);

INSERT INTO qna VALUES (
    qna_seq.NEXTVAL,
    1,
    '�亯�Ϸ�',
    '��ǰ�� ì�ܰ��̴µ� ���� ��ǰó���� �ȵǳ׿�',
    '�ȳ��ϼ���, �ż���� ������ �Դϴ�. �����ֽ� �������� 12/28�� ������ ������ �ּ�����, ��� �������� Ȯ�� �߿� �ֽ��ϴ�. Ȯ�� �� �� �ȳ� �� ó������ �帱 �����̿��� ������ ������ �ð� ���� ��Ź�帳�ϴ�. ����ϰ� �ູ�� �Ϸ� �ǽʽÿ�.',
    'dltn****',
    '2021-12-20'
);

INSERT INTO qna VALUES (
    qna_seq.NEXTVAL,
    1,
    '�亯�Ϸ�',
    '��ۿϷ� ó���Ǿ��µ� ������ �ȿԾ��',
    '�ȳ��ϼ��� ���� 2021-11-25�� 2007 �� ��ۿϷ�Ȱ����� Ȯ�ε˴ϴ�. �ù� ���Ե��߿� ���� �������� ��Ź��ҿ� �ð� �����ô� ��찡 �ֽ��ϴ�.����, �������, ���� �ù��� �� ��Ź ������ ������ Ȯ���غ��̴µ��� ��ǰ Ȯ�ε��� �ʴ´ٸ� ��� ���� ����ó 010-0000-0000 �� ���Ǻ�Ź�帳�ϴ�. ���� ��ȭ�� �غ��ø� ��ǰ ��ġ Ȯ���� �����Ͻʴϴ�.',
    'dado****',
    '2021-12-20'
);

INSERT INTO qna VALUES (
    qna_seq.NEXTVAL,
    1,
    '�亯�Ϸ�',
    '���ھ��»�ǰ���� �����ּ���~^^',
    '�ȳ��ϼ��� ���� �ֹ��Ͻ� ��ǰ�� ���� ��� �����Դϴ�. ����� ��������� 1-2��[����������] ���� �ҿ�˴ϴ�. �������� ��� ������ ���� ���Ǵ� ����� ������ �����ù�[1588-9988] �� �����Ͻø� ��Ȯ�� �ȳ� ������ �� �ֽ��ϴ�. �������ּż� �����մϴ�.',
    'polo****',
    '2021-12-20'
);

INSERT INTO qna VALUES (
    qna_seq.NEXTVAL,
    1,
    '�亯�Ϸ�',
    '��ҽ�û�̿�. Ȯ�����ּ���',
    '�ȳ��ϼ���.���� ��ȯ��ǰ��Һ��� ���� ���Ǵ� ���� �Ͻ� �ż��� ������ 1577-3419 �� �����ֽñ� �ٶ��ϴ� �����մϴ�.',
    'zyzh****',
    '2021-12-20'
);

INSERT INTO qna (
    qnano,
    productno,
    title,
    nickname
) VALUES (
    qna_seq.NEXTVAL,
    1,
    '��ҽ�û�ߴµ�,�����ֽŴٴ��� ����������..��Һ�Ź�帳�ϴ�',
    'ahy5****'
);

INSERT INTO qna (
    qnano,
    productno,
    title,
    nickname
) VALUES (
    qna_seq.NEXTVAL,
    1,
    '���� 2���ٰ��µ� 1���� ��ǰ�Ϸ�? Ȯ�� ��Ź�帳�ϴ�.',
    'whie****'
);

INSERT INTO qna (
    qnano,
    productno,
    title,
    nickname
) VALUES (
    qna_seq.NEXTVAL,
    1,
    '��ǰ�� ����ߺ�Ź�����.',
    'lane****'
);

INSERT INTO qna (
    qnano,
    productno,
    title,
    nickname
) VALUES (
    qna_seq.NEXTVAL,
    1,
    '���� ��ǰó���� �����ʾ� ���ǳ���ϴ�!',
    'dltn****'
);

INSERT INTO qna (
    qnano,
    productno,
    title,
    nickname
) VALUES (
    qna_seq.NEXTVAL,
    1,
    '��������� �´°���!!',
    'epso****'
);

COMMIT;

SELECT
    *
FROM
    qna;