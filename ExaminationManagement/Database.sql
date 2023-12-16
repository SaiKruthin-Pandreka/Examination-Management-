create database Examination;
use Examination;
create table details(name varchar(20),rollnum int,email varchar(20),password varchar(20));
select * from details;
drop table details;

create table questions(question_id int,question varchar(100),option1 varchar(40),option2 varchar(40),option3 varchar(40),option4 varchar(40),correct_answer varchar(20));

insert into questions values
(1,'1.Number of primitive data types in Java are?','A. 6','B. 7','C. 8','D.9','c'),
(2,'2.What is the size of float and double in java?','A. 32 and 64','B. 32 and 32','C. 64 and 64','D. 64 and 32','a'),
(3,'3.Automatic type conversion is possible in which of the possible cases?','A. Byte to int','B. int to long','C. long to int','D. short to int','b'),
(4,'4.When an array is passed to a method, what does the method receive?','A. The reference of the array','B. A copy of the array','C. length of the array','D. Copy of first element','b'),
(5,'5.Arrays in java are -','A. Object references','B. objects','C. Primitive data type','D. None','b'),
(6,'6.Which component is used to compile, debug and execute the java programs?','A.JRE','B.JIT','C.JDK','D.JVM','c'),
(7,'7.what is Runnable ?','A. catch','B. throw','C. final','D. None','d'),
(8,'8.Which one of the following is not a Java feature?','A. Object-oriented','B. Use of pointers','C. Portable','D. Dynamic and Extensible','b'),
(9,'9.Which of these cannot be used for a variable name in Java?','A. identifier & keyword','B. identifier','C. keyword','D. none of the mentioned','c'),
(10,'10.When is the object created with new keyword?','A. At run time','B. At compile time','C. Depends on the code','D. None','a');

create table grades(rollnum int,grade double);
create table user_answers(rollnum int ,question_id int,user_answer varchar(20));


SELECT * FROM questions;
SELECT * FROM grades;
SELECT * FROM USER_ANSWERS;

drop table questions;
drop table grades;
drop table USER_ANSWERS;