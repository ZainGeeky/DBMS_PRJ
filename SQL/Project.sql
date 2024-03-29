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

desc hostel;
CREATE TABLE RENT 
(
RENT_TITLE VARCHAR(30) PRIMARY KEY,
RENT_AMOUNT NUMBER(10)
);


CREATE TABLE ROOM
(ROOM_ID NUMBER(3) PRIMARY KEY,
ROOM_FLOOR NUMBER(1),
ROOM_TYPE VARCHAR(30),
RENT_TITLE REFERENCES RENT ON DELETE CASCADE,
HOSTEL_ID REFERENCES HOSTEL ON DELETE CASCADE
);
DROP TABLE ROOM;
--select rent_title from room r, student s where r.room_id=s.room_id and s.usn='4SF20CI014' ; 
CREATE TABLE STUDENT(
USN VARCHAR(10) PRIMARY KEY,
STUDENT_NAME VARCHAR(20),
STUDENT_PHONE VARCHAR(10) CHECK(  LENGTH(STUDENT_PHONE)=10  ),
STUDENT_EMAIL VARCHAR(30) CHECK(STUDENT_EMAIL LIKE '%@gmail.com') ,
STUDENT_CITY VARCHAR(20),
STUDENT_DOB DATE CHECK( STUDENT_DOB BETWEEN TO_DATE('01-01-2000', 'DD-MM-YYYY') AND TO_DATE('01-01-2005', 'DD-MM-YYYY')),
ROOM_ID REFERENCES ROOM ON DELETE CASCADE,
HOSTEL_ID REFERENCES HOSTEL ON DELETE CASCADE
);
DROP TABLE STUDENT;

CREATE TABLE EQUIPMENT
(EQUIPMENT_ID VARCHAR(10) PRIMARY KEY,
EQUIPMENT_NAME VARCHAR(30),
EQUIPMENT_PRICE NUMBER(8),
EQUIPMENT_TYPE VARCHAR(20),
ROOM_ID REFERENCES ROOM ON DELETE CASCADE);

CREATE TABLE PAYMENT
(PAYMENT_ID INT PRIMARY KEY ,
USN REFERENCES STUDENT ON DELETE CASCADE,
RENT_TITLE REFERENCES RENT ON DELETE CASCADE,
PAYMENT_AMOUNT NUMBER(10),
PAYMENT_DATE DATE);
drop table payment;

INSERT INTO PAYMENT VALUES(1,'4SF20CI002','SUITE',12000,'01-01-2002');
INSERT INTO PAYMENT VALUES(2,'4SF20CI002','SUITE',30000,'01-01-2002');
INSERT INTO PAYMENT VALUES(3,'4SF20CI002','PREMIUM',30000,sysdate);
select * from payment;
delete from payment;


--1. Finding Roommates
SELECT s2.room_id,s2.USN,s2.student_name
FROM STUDENT s1
JOIN ROOM r ON s1.ROOM_ID = r.ROOM_ID
JOIN STUDENT s2 ON r.ROOM_ID = s2.ROOM_ID
WHERE s1.USN = '4SF20CI014' AND s2.USN != '4SF20CI014';

--2. Room_id and Number of students
SELECT r.ROOM_ID, COUNT(s.ROOM_ID) AS "Number of Students"
FROM ROOM r
JOIN STUDENT s ON r.ROOM_ID = s.ROOM_ID
WHERE r.HOSTEL_ID = '2'
GROUP BY r.ROOM_ID;


--3. Pending Fees
SELECT s.USN, s.student_name,r.ROOM_TYPE, SUM(rt.RENT_AMOUNT - COALESCE(p.PAYMENT_AMOUNT, 0)) AS "Pending Fee"
FROM STUDENT s
JOIN ROOM r ON s.ROOM_ID = r.ROOM_ID
JOIN RENT rt ON r.RENT_TITLE = rt.RENT_TITLE
LEFT JOIN (SELECT RENT_TITLE, SUM(PAYMENT_AMOUNT) as PAYMENT_AMOUNT, USN FROM PAYMENT group by RENT_TITLE, USN) p ON r.RENT_TITLE = p.RENT_TITLE AND s.USN = p.USN
GROUP BY s.USN, r.ROOM_TYPE,s.student_name
order by usn
;

--4. Eqipments inside a room
SELECT EQUIPMENT_ID,EQUIPMENT_NAME,EQUIPMENT_PRICE,EQUIPMENT_TYPE
FROM EQUIPMENT
JOIN ROOM ON EQUIPMENT.ROOM_ID = ROOM.ROOM_ID
JOIN HOSTEL ON ROOM.HOSTEL_ID = HOSTEL.HOSTEL_ID
WHERE HOSTEL.HOSTEL_ID = '1' AND ROOM.ROOM_ID = '102';


--5. Room Capacity Trigger
--drop trigger room_capacity_check;
CREATE OR REPLACE TRIGGER room_capacity_check
BEFORE INSERT ON STUDENT
FOR EACH ROW
DECLARE
  current_count INT;
  room_type varchar2(20);
BEGIN
  SELECT ROOM_TYPE INTO room_type FROM ROOM WHERE ROOM_ID = :new.ROOM_ID;
  SELECT COUNT(*) INTO current_count FROM STUDENT WHERE ROOM_ID = :new.ROOM_ID;
  IF current_count >= 
  CASE
    WHEN room_type = 'SINGLE' THEN 1
    WHEN room_type = 'DOUBLE' THEN 2
    WHEN room_type = 'TRIPLE' THEN 3
    WHEN room_type = 'QUADRUPLE' THEN 4
    ELSE 0
  END THEN
    RAISE_APPLICATION_ERROR(-20001, 'The maximum number of students for this room type has been exceeded');
  END IF;
END;

--Procedure for finding roomates
 CREATE OR REPLACE PROCEDURE find_roommates(p_usn IN VARCHAR2) AS
    roommates VARCHAR2(10);
BEGIN
    SELECT USN 
      INTO roommates 
      FROM STUDENT 
     WHERE ROOM_ID = (SELECT ROOM_ID FROM STUDENT WHERE USN = p_usn) 
       AND USN != p_usn
       AND ROWNUM = 1;

    DBMS_OUTPUT.PUT_LINE('Roommate USN: '|| roommates);
END;
--Calling Procedure
EXECUTE find_roommates('4SF20CI052');





drop table equipment;
drop table student_live;
drop table room;
drop table rent;
drop table student;
drop table hostel;
drop payment;
DESC EQUIPMENT;

