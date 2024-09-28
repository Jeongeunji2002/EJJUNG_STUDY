--관리자계정에서
delete user c##cdbc;
CREATE USER c##jdbc IDENTIFIED BY jdbc;
GRANT resource, connect to c##jdbc;

ALTER USER C##JDBC QUOTA 1024M ON USERS;

--사번 자동 발생 시퀀스 생성
create SEQUENCE SEQ_EMPID
START WITH 211
INCREMENT by 1
MAXVALUE 999
NOCYCLE
NOCACHE;
