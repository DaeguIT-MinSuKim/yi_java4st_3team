--ERP 사용자생성하기
CREATE USER USER_LIB IDENTIFIED BY rootroot
  DEFAULT TABLESPACE users
  TEMPORARY TABLESPACE temp;

--Grant 명령으로접속, 사용권한주기
GRANT connect, resource, CREATE session, CREATE VIEW TO USER_LIB;

SELECT
  username,
  default_tablespace,
  profile,
  authentication_type
FROM
  dba_users
WHERE
  USERNAME = 'USER_LIB';