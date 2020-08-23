SELECT * FROM RENT;
SELECT * FROM BOOK;
SELECT * FROM MEMBER;

UPDATE RENT 
SET MEMBER_NO = 'M007'
WHERE IDX = 2;

/* 대여관리 */
-- 도서 대여가능 목록
SELECT *
FROM BOOK
WHERE IS_RENT = 1;

-- 테이블 클릭시
SELECT * 
FROM BOOK
WHERE BOOK_NO = '땡겨온값';

-- 회원코드 검색시
SELECT MEMBER_NAME , TEL
FROM MEMBER
WHERE MEMBER_NO = '땡겨온값';

-- 대여눌렀을 때
-- 도서테이블에 총대여횟수 1증가, 회원테이블에 총대여권수1증가 (참조키가 없어서 따로 업데이트 해야하네..)
UPDATE BOOK
SET TOTAL_COUNT = TOTAL_COUNT + 1, IS_RENT = 0
WHERE BOOK_NO = 'B002';

UPDATE MEMBER
SET TOTAL_RENT = TOTAL_RENT + 1
WHERE MEMBER_NO = 'M002';

-- 출납테이블에 대여한 목록 추가
INSERT INTO RENT VALUES(IDXNUM.NEXTVAL, '땡겨온값', '땡겨온값', SYSDATE, NULL);



/* 반납관리 */
-- 최초에 테이블에 넣을 목록
SELECT M.*, B.*, R.*
FROM MEMBER M, BOOK B, RENT R
WHERE M.MEMBER_NO = R.MEMBER_NO AND B.BOOK_NO = R.BOOK_NO
--AND R.MEMBER_NO = 'M002' AND R.BOOK_NO = 'B002';
--AND R.IDX = '3';
AND R.RETURN_DATE IS NULL;

-- 테이블 목록 클릭시 상단 텍스트필드에 뿌려줄 정보
SELECT M.*, B.*, R.*
FROM MEMBER M, BOOK B, RENT R
WHERE M.MEMBER_NO = R.MEMBER_NO AND B.BOOK_NO = R.BOOK_NO
AND R.IDX = '땡겨온값';

-- 반납
UPDATE RENT
SET RETURN_DATE = '땡겨온값'
WHERE IDX = '땡겨온값';

-- 대여가능여부 변경
UPDATE BOOK
SET IS_RENT = 1
WHERE BOOK_NO = '땡겨온값';

-- 출납테이블에 반납일 변경
UPDATE RENT 
SET RETURN_DATE = '땡겨온값'
WHERE IDX = '땡겨온값';

/* 반납관리 */
-- 반납이 필요한 도서만 조인
SELECT M.*, B.*, R.*
FROM MEMBER M, BOOK B, RENT R
WHERE M.MEMBER_NO = R.MEMBER_NO AND B.BOOK_NO = R.BOOK_NO
AND R.RETURN_DATE = ''; --빈공백
--AND R.RETURN_DATE IS NULL; --널값


/* 회원검색 */
-- 이름으로 검색(검색버튼 눌렀을때)
SELECT M.*, B.*, R.*, (
CASE WHEN R.RENT_DATE+3 < R.RETURN_DATE THEN 'Y'
WHEN R.RENT_DATE+3 >= R.RETURN_DATE THEN 'N' 
ELSE '반납하지 않음' END
) AS HI
FROM MEMBER M, BOOK B, RENT R
WHERE M.MEMBER_NO = R.MEMBER_NO AND B.BOOK_NO = R.BOOK_NO
AND R.MEMBER_NO = 'M004';
--자바부분에서 반납일이 NULL이면 반납하지 않음 이라고 적어줘야함 ㅇㅋ?
--IF (RETURN_DATE = NULL) {'반납하지 않음'}    <<-------이런식으로

/* 도서검색 */
SELECT M.*, B.*, R.*, (
CASE WHEN R.RENT_DATE+3 < R.RETURN_DATE THEN 'Y'
WHEN R.RENT_DATE+3 >= R.RETURN_DATE THEN 'N' 
ELSE '반납하지 않음' END
) AS HI
FROM MEMBER M, BOOK B, RENT R
WHERE M.MEMBER_NO = R.MEMBER_NO AND B.BOOK_NO = R.BOOK_NO;
--AND R.MEMBER_NO = '도서코드 땡겨온값';
/* 자바단 처리
IF (도서명으로 검색하면)
STRING STR = "AND B.BOOK_NAME = '땡겨온값'";
ELSE 
STRING STR = "AND B.BOOK_NO = '땡겨온값";
SQL = SQL + STR;
*/

/* 도서현황 */
/* 총 보유 권수 */
SELECT COUNT(*) FROM BOOK;
/* 총 연체 횟수 */
SELECT COUNT(*) FROM RENT WHERE RENT_DATE+3 < RETURN_DATE;
/* 총 대여 권수 */
SELECT COUNT(*) FROM RENT;
