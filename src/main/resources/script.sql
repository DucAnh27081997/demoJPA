Create database DB_JPA_DEMO;

use DB_JPA_DEMO;

select *
from company;
select *
from employee;

create table user
(
    ID           BIGINT PRIMARY KEY AUTO_INCREMENT,
    USER_NAME    NVARCHAR(256),
    HASH_CODE    NVARCHAR(256) UNIQUE,
    RULE         NVARCHAR(256) DEFAULT 'USER',
    PHONE_NUMBER NVARCHAR(256) DEFAULT '113'
);

select *
from user
where HASH_CODE LIKE '%670345E3AC393AF43DA0998ED89C80F8%';


select (COUNT(uuid))
from user;

create unique index index_hashcode on user (HASH_CODE);


INSERT INTO DB_JPA_DEMO.user (uuid, name, hash_code, salary)
VALUES (UUID(), 'ducla', 'adbaskjnkjankankja', '356');


SELECT UUID() AS UUID_Value;
SELECT MD5('admin') AS md5_Value;
SELECT SHA2('admin',256) AS md5_Value;

select * from user;

select *
from user
where name like '%phong%';

select *
from rule;

select *
from user_rule;

select u.department, sum(u.salary)
from user u
group by u.department;

update user
set department = 'HR',
    salary     = 3000
where name not like '%ducla%'
  and name not like '%phong%';