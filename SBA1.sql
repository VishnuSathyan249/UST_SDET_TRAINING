create database db1;

use db1;

show tables;

create table EMP(name varchar(20),age int,salary float);

drop table emp;

drop database db1;

CREATE SCHEMA employeedatabase;

CREATE TABLE `employeedatabase`.`employee` (
  `EMP_ID` INT NOT NULL,
  `EMP_NAME` VARCHAR(45) NOT NULL,
  `EMP_AGE` INT NOT NULL,
  `EMP_DEP` VARCHAR(45) NOT NULL,
  `DEP_ID` INT NOT NULL,
  `EMP_LOCATION` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`EMP_ID`));
  
  SELECT * FROM employeedatabase.employee;
  
INSERT INTO employeedatabase.employee(
EMP_ID,
NAME1,
EMP_AGE,
EMP_DEP,
DEP_ID,
EMP_LOCATION,
EMP_SALARY,
EMP_GENDER)VAlUES(101,'RAHUL',35,'SALES',110,'CHENNAI','10000','MALE'),
(104,'KIRAN',30,'HR',111,'PUNE','100000','MALE'),
(105,'THEJAS',46,'IT',112,'KERALA','20000','MALE'),
(106,'ACHUTH',25,'IT',113,'BANGLORE','15000','MALE'),
(107,'ABHINAV',55,'SALES',115,'SINGAPORE','122000','MALE'),
('108', 'SONIYA', '21', 'SALES', '116', 'RAJASTAN', '150000', 'FEMALE'),
('109', 'DIYA', '27', 'IT', '117', 'BUTAN', '20000', 'FEMALE'),
('110', 'KARTHIKA', '30', 'IT', '118', 'GOA', '30000', 'FEMALE');


ALTER TABLE `employeedatabase`.`employee` 
ADD COLUMN `EMP_SALARY` VARCHAR(45) 
NOT NULL AFTER `EMP_LOCATION`;

ALTER TABLE `employeedatabase`.`employee` 
ADD COLUMN `EMP_GENDER` VARCHAR(45) 
NOT NULL AFTER `EMP_SALARY`;

ALTER TABLE `employeedatabase`.`employee` 
CHANGE COLUMN `NAME` `NAME1` VARCHAR(45) NOT NULL ;

SELECT NAME1,EMP_LOCATION
FROM employee
WHERE NAME1= 'RAMESH';

CREATE TABLE `employeedatabase`.`project` (
  `ID_PROJECT` INT NOT NULL,
  `PROJECT_NAME` VARCHAR(45) NOT NULL,
  `PROJECT_LOCATION` VARCHAR(45) NOT NULL,
  `PROJECT_STRENGTH` INT NOT NULL,
  PRIMARY KEY (`ID_PROJECT`));
  
INSERT INTO `employeedatabase`.`project` (`ID_PROJECT`, `PROJECT_NAME`, `PROJECT_LOCATION`, `PROJECT_STRENGTH`)
VALUES
 ('11', 'Health_care', 'Banglore', '5'),
('12', 'Epay', 'Hyderabad', '6'),
('13', 'Status', 'Chennai', '3'),
('14', 'ML Algol', 'pune', '5'),
('15', 'Basecamp', 'Chennai', '7');

CREATE TABLE `employeedatabase`.`dependent` (
  `E_ID` INT NOT NULL,
  `DEPENDENT_NAME` VARCHAR(45) NOT NULL,
  `DEPENDENT_RELATION` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`E_ID`));
  
  INSERT INTO `employeedatabase`.`dependent` (`E_ID`, `DEPENDENT_NAME`, `DEPENDENT_RELATION`)
VALUES
 ('101', 'Surabi', 'Wife'),
('102', 'Mahesh', 'Brother'),
('103', 'Rama Rao', 'Father'),
('104', 'Sujitha', 'Mother');

CREATE TABLE `employeedatabase`.`department` (
  `DEP_NO` INT NOT NULL,
  `DEP_NAME` VARCHAR(45) NOT NULL,
  `DEP_LOCATION` VARCHAR(45) NOT NULL,
  `PROJECT_ID` INT NOT NULL,
  PRIMARY KEY (`DEP_NO`));
  
INSERT INTO `employeedatabase`.`department` (`DEP_NO`, `DEP_NAME`, `DEP_LOCATION`, `PROJECT_ID`) 
VALUES ('111', 'HR', 'Banglore', '11'),
('112', 'IT', 'Chennai', '12'),
('113', 'Sales', 'Pune', '15');

delete from `employeedatabase`.`employee`
where EMP_ID = 101;

SELECT employee.NAME1,employee.DEP_ID,department.DEP_NAME,department.DEP_LOCATION
FROM   employeedatabase.employee
INNER JOIN employeedatabase.department
ON employee.DEP_ID=department.DEP_NO;

SELECT employee.NAME1,employee.EMP_LOCATION,dependent.DEPENDENT_NAME,dependent.DEPENDENT_RELATION
FROM employeedatabase.employee
LEFT JOIN employeedatabase.dependent
on employee.EMP_ID = dependent.E_ID; 

SELECT employee.NAME1,employee.EMP_LOCATION,dependent.DEPENDENT_NAME,dependent.DEPENDENT_RELATION
FROM employeedatabase.employee
right JOIN employeedatabase.dependent
on employee.EMP_ID = dependent.E_ID; 

select * from employeedatabase.project cross join employeedatabase.department
where PROJECT_STRENGTH>0;

SELECT * FROM employeedatabase.employee E1 
WHERE 2=(select COUNT(EMP_ID) FROM employeedatabase.employee E2 
WHERE E2.EMP_SALARY>E1.EMP_SALARY);

SELECT * FROM (SELECT SUM(EMP_SALARY) 
AS "TOTAL SALARY",EMP_GENDER AS GENDER 
FROM employeedatabase.employee 
GROUP BY EMP_GENDER) 
AS GENDER;

USE `employeedatabase`;
DROP procedure IF EXISTS `update_salary`;

DELIMITER $$
USE `employeedatabase`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `update_salary`(in NEW_SALARY DOUBLE,IN NEW_ID INT)
BEGIN
UPDATE EMPLOYEEDATABASE.EMPLOYEE 
set EMP_SALARY = NEW_SALARY 
WHERE EMP_ID = NEW_ID;
END$$

DELIMITER ;

USE `employeedatabase`;
DROP function IF EXISTS `Department_name`;

USE `employeedatabase`;
DROP function IF EXISTS `employeedatabase`.`Department_name`;
;

DELIMITER $$
USE `employeedatabase`$$
CREATE DEFINER=`root`@`localhost` FUNCTION `Department_name`(id int) RETURNS varchar(20) CHARSET utf8mb3
    DETERMINISTIC
BEGIN
declare designation varchar(10);
select DEP_NAME into designation 
from employee 
inner join department
on DEP_ID = DEP_NO
where EMP_ID = ID;
RETURN designation;
END$$

DELIMITER ;
;

CREATE TABLE `employeedatabase`.`sale_mast` (
  `BILL_NO` INT NOT NULL,
  `QUANTITY` INT NOT NULL,
  PRIMARY KEY (`BILL_NO`));

INSERT INTO `employeedatabase`.`sale_mast` (`BILL_NO`, `QUANTITY`)
 VALUES ('1', '12'),
 ('2', '34'),
('3', '22'),
('4', '67'),
('5', '89'),
 ('6', '56'),
('7', '14');

ALTER TABLE `employeedatabase`.`sale_mast`
	partition by range(BILL_NO)(
    partition p0 values less than(1),
    partition p1 values less than(2),
    partition p2 values less than(3),
    partition p3 values less than(4),
	partition p4 values less than(5),
    partition p5 values less than(6),
    partition p7 values less than maxvalue
);

SELECT PARTITION_NAME, TABLE_ROWS FROM 
INFORMATION_SCHEMA.PARTITIONS WHERE TABLE_NAME='sale_mast';

ALTER TABLE `employeedatabase`.`sale_mast`
 PARTITION BY HASH(BILL_NO) 
 PARTITIONS 2; 
 
 SELECT PARTITION_NAME, TABLE_ROWS FROM 
INFORMATION_SCHEMA.PARTITIONS WHERE TABLE_NAME='sale_mast';


ALTER TABLE `employeedatabase`.`department` 
ADD INDEX `PROJECT_ID_id` (`PROJECT_ID` ASC) VISIBLE;
;
ALTER TABLE `employeedatabase`.`department` 
ADD CONSTRAINT `PROJECT_ID`
  FOREIGN KEY (`PROJECT_ID`)
  REFERENCES `employeedatabase`.`project` (`ID_PROJECT`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;
  
  ALTER TABLE `employeedatabase`.`employee` 
ADD COLUMN `EMP_SSN` INT NULL AFTER `EMP_LOCATION`;

UPDATE `employeedatabase`.`employee` SET `EMP_SSN` = '234' WHERE (`EMP_ID` = '104');
UPDATE `employeedatabase`.`employee` SET `EMP_SSN` = '235' WHERE (`EMP_ID` = '105');
UPDATE `employeedatabase`.`employee` SET `EMP_SSN` = '238' WHERE (`EMP_ID` = '106');
UPDATE `employeedatabase`.`employee` SET `EMP_SSN` = '230' WHERE (`EMP_ID` = '109');

 SELECT NAME1
FROM `employeedatabase`.`employee` 
WHERE EMP_SSN IS NULL;

ALTER TABLE `employeedatabase`.`project` 
ADD COLUMN `DEP_NUM` INT NULL AFTER `PROJECT_STRENGTH`,
ADD COLUMN `PRJ_MANGER` VARCHAR(45) NULL DEFAULT NULL AFTER `DEP_NUM`;

UPDATE `employeedatabase`.`project` SET `DEP_NUM` = '111' WHERE (`ID_PROJECT` = '11');
UPDATE `employeedatabase`.`project` SET `DEP_NUM` = '112' WHERE (`ID_PROJECT` = '12');
UPDATE `employeedatabase`.`project` SET `DEP_NUM` = '113' WHERE (`ID_PROJECT` = '13');


SELECT ID_PROJECT
FROM  project as PROJECT, department as DEPARTMENT, employee as EMPLOYEE
WHERE project.DEP_NUM=department.DEP_NO AND employee.EMP_Ssn= 234;

SELECT * FROM project CROSS JOIN employee;

SELECT   E.NAME1, D.DEP_NAME
FROM    employee E JOIN department D ON E.DEP_ID= D.DEP_NO;

use employeedatabase;

SELECT NAME1,EMP_DEP,DEP_NO
FROM employee right join department 
on employee.EMP_DEP = department.DEP_NAME;

SELECT DISTINCT ID_PROJECT
FROM project
WHERE ID_PROJECT IN  
( SELECT ID_PROJECT
FROM PROJECT, DEPARTMENT, EMPLOYEE
WHERE DEP_NUM=DEP_NO AND
EMP_SSN=234 AND NAME1="KIRAN" );

SELECT NAME1
FROM EMPLOYEE
WHERE EMP_SALARY > ALL ( SELECT EMP_SALARY
FROM EMPLOYEE
WHERE DEP_ID=105 );

ALTER TABLE `employeedatabase`.`dependent` 
ADD COLUMN `DEPENDENT_GENDER` VARCHAR(45) NULL AFTER `DEPENDENT_RELATION`;

UPDATE `employeedatabase`.`dependent` SET `DEPENDENT_GENDER` = 'MALE' WHERE (`E_ID` = '101');
UPDATE `employeedatabase`.`dependent` SET `DEPENDENT_GENDER` = 'FEMALE' WHERE (`E_ID` = '102');
UPDATE `employeedatabase`.`dependent` SET `DEPENDENT_GENDER` = 'FEMALE' WHERE (`E_ID` = '103');
UPDATE `employeedatabase`.`dependent` SET `DEPENDENT_GENDER` = 'MALE' WHERE (`E_ID` = '104');

INSERT INTO `employeedatabase`.`dependent` (`E_ID`, `DEPENDENT_NAME`, `DEPENDENT_RELATION`, `DEPENDENT_GENDER`) VALUES ('107', 'ABHINAV', 'father', 'MALE');

UPDATE `employeedatabase`.`employee` SET `EMP_SSN` = '107' WHERE (`EMP_ID` = '108');

INSERT INTO `employeedatabase`.`dependent` (`E_ID`, `DEPENDENT_NAME`, `DEPENDENT_RELATION`, `DEPENDENT_GENDER`) VALUES ('108', 'SONIYA', 'MOTHER', 'FEMALE');

UPDATE `employeedatabase`.`employee` SET `EMP_SSN` = '108' WHERE (`EMP_ID` = '110');

use employeedatabase;
 
SELECT E.NAME1
FROM EMPLOYEE AS E
WHERE EMP_SSN IN (  
SELECT EMP_SSN
FROM DEPENDENT AS D
WHERE E.NAME1=D.DEPENDENT_NAME  
AND E.EMP_GENDER=D.DEPENDENT_GENDER );

SELECT E.name1
FROM EMPLOYEE AS E, DEPENDENT AS D
WHERE E.EMP_SSN=D.E_ID AND E.EMP_GENDER=D.DEPENDENT_GENDER
AND E.name1=D.Dependent_name;

 SELECT name1
FROM EMPLOYEE
WHERE NOT EXISTS ( SELECT *
FROM DEPENDENT
WHERE e_id=EMP_SSN );

SELECT dep_id, COUNT(*), AVG (emp_salary) 
FROM EMPLOYEE 
GROUP BY dep_id; 




