CREATE TABLE STUDENT(
USN VARCHAR(10) PRIMARY KEY,
STUDENT_NAME VARCHAR(20),
STUDENT_PHONE VARCHAR(10) CHECK(  LENGTH(STUDENT_PHONE)=10  ),
STUDENT_EMAIL VARCHAR(30) CHECK(STUDENT_EMAIL LIKE '%@gmail.com') ,
STUDENT_CITY VARCHAR(20),
STUDENT_DOB DATE CHECK( STUDENT_DOB BETWEEN TO_DATE('01-01-2000', 'DD-MM-YYYY') AND TO_DATE('01-01-2005', 'DD-MM-YYYY'))
);
DROP TABLE STUDENT;
--INSERT INTO STUDENT VALUES('4SF20CI002','ABHI',123,'A@GMAIL','CITY','01-02-2002')
INSERT INTO STUDENT VALUES('4SF20CI002','ABHI',123,'A@GMAIL','CITY',TO_DATE('01/05/2002',DD/MM/YYYY));

SELECT USN,STUDENT_NAME,STUDENT_PHONE,STUDENT_EMAIL,STUDENT_CITY,TO_CHAR(STUDENT_DOB,'dd/MM/yyyy') AS STUDENT_DOB FROM STUDENT;
SELECT * FROM STUDENT;  
DELETE FROM STUDENT;
DESC STUDENT; 

SELECT CONSTRAINT_NAME,CONSTRAINT_TYPE,TABLE_NAME,SEARCH_CONDITION FROM USER_CONSTRAINTS WHERE TABLE_NAME='STUDENT';
SELECT CURRENT_DATE from DUAL ; --DUAL is dummy table
SELECT CURRENT_TIMESTAMP from DUAL ;

--1. display students name who are born in october;]
SELECT STUDENT_NAME FROM STUDENT WHERE ;

SELECT TO_CHAR(SYSDATE,'DD/MM/YYYY HH:MM PM') FROM DUAL;

--2. display students who are bron in 2003
--3. display students who are bron in MONDAY
--4. Display student name who are 21 years age

CREATE TABLE HOSTEL
(HOSTEL_ID VARCHAR(10) PRIMARY KEY,
HOSTEL_NAME VARCHAR(30),
HOSTEL_LOCATION VARCHAR(30));

CREATE TABLE STUDENT(
USN VARCHAR(10) PRIMARY KEY,
STUDENT_NAME VARCHAR(20),
STUDENT_PHONE VARCHAR(10) CHECK(  LENGTH(STUDENT_PHONE)=10  ),
STUDENT_EMAIL VARCHAR(30) CHECK(STUDENT_EMAIL LIKE '%@gmail.com') ,
STUDENT_CITY VARCHAR(20),
STUDENT_DOB DATE CHECK( STUDENT_DOB BETWEEN TO_DATE('01-01-2000', 'DD-MM-YYYY') AND TO_DATE('01-01-2005', 'DD-MM-YYYY'))
-- ADD HOSTEL , ROOM ID
);

CREATE TABLE RENT 
(RENT_ID VARCHAR(10) PRIMARY KEY,
RENT_TITLE VARCHAR(15),
RENT_AMOUNT NUMBER(10));

CREATE TABLE ROOM
(ROOM_ID NUMBER(3) PRIMARY KEY,
ROOM_FLOOR NUMBER(10),
ROOM_TYPE VARCHAR(10),
RENT_ID REFERENCES RENT ON DELETE CASCADE,
HOSTEL_ID REFERENCES HOSTEL ON DELETE CASCADE);

CREATE TABLE STUDENT_LIVE(
USN REFERENCES STUDENT ON DELETE CASCADE,
ROOM_ID REFERENCES ROOM ON DELETE CASCADE,
STATUS VARCHAR(20) CHECK(STATUS IN ('PRESENT','ABSENT')),
PRIMARY KEY(USN,ROOM_ID)
);

CREATE TABLE EQUIPMENT
(EQUIPMENT_ID VARCHAR(10) PRIMARY KEY,
EQUIPMENT_NAME VARCHAR(30),
EQUIPMENT_PRICE NUMBER(8),
EQUIPMENT_TYPE VARCHAR(20),
ROOM_ID VARCHAR(10),
HOSTEL_ID VARCHAR(10));

CREATE TABLE PAYMENT
(PAYMENT_ID VARCHAR(10) PRIMARY KEY,
PAYMENT_DATE DATE,
PAYMENT_AMOUNT NUMBER(10),
USN VARCHAR(10));


