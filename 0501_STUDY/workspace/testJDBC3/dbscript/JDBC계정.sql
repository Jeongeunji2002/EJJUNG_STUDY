--�����ڰ�������
delete user c##cdbc;
CREATE USER c##jdbc IDENTIFIED BY jdbc;
GRANT resource, connect to c##jdbc;

ALTER USER C##JDBC QUOTA 1024M ON USERS;

--��� �ڵ� �߻� ������ ����
create SEQUENCE SEQ_EMPID
START WITH 211
INCREMENT by 1
MAXVALUE 999
NOCYCLE
NOCACHE;
