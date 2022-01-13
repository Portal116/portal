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
    '후기가 워낙 좋았던 모델이라 믿고 샀는데 역시나 이쁘고 너무 마음에 들어요 늦게알아서 정가보다 비싸게주고샀지먼 그래도 만족합니다',
    'garu****'
);

INSERT INTO review VALUES (
    review_seq.NEXTVAL,
    1,
    'review02.jpg',
    '평소 255~260신는데 발볼조금있어서 260 구매했고 잘 맞아요. 굿굿 입니다',
    'naca****'
);

INSERT INTO review VALUES (
    review_seq.NEXTVAL,
    1,
    'review03.jpg',
    '일단 이뻐서 마음에 들어요! 신발이 가볍고 약간 크게 나온건지 제 신발 사이즈가 257인데 255 넉넉하게 들어가요 ㅎㅎ 나일론 재질 같은 느낌이라 모양이 잘 안잡힐까 걱정했는데 괜한 걱정이었네요 ㅎㅎ 전 너무 만족합니당!!',
    'noll****'
);

INSERT INTO review VALUES (
    review_seq.NEXTVAL,
    1,
    'review04.jpg',
    '마감이 깔끔하지 못해요 정품인거 맞나요?;; 훔 사이즈 택표시도 흐릿해서 조금 그래요..',
    'bkhl****'
);

INSERT INTO review VALUES (
    review_seq.NEXTVAL,
    1,
    'review05.jpg',
    '신발 혀 뒷편에 잉크가 지워져있네요 신발끈은 이물질 묻어있구요',
    'dksd****'
);

INSERT INTO review VALUES (
    review_seq.NEXTVAL,
    2,
    '사진6',
    '후기6',
    '닉네임6'
);

INSERT INTO review VALUES (
    review_seq.NEXTVAL,
    2,
    '사진7',
    '후기7',
    '닉네임7'
);

INSERT INTO review VALUES (
    review_seq.NEXTVAL,
    2,
    '사진8',
    '후기8',
    '닉네임8'
);

INSERT INTO review VALUES (
    review_seq.NEXTVAL,
    2,
    '사진9',
    '후기9',
    '닉네임9'
);

INSERT INTO review VALUES (
    review_seq.NEXTVAL,
    2,
    '사진10',
    '후기10',
    '닉네임10'
);

COMMIT;

SELECT
    *
FROM
    review;