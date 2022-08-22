Create database DB_JPA_DEMO;

use DB_JPA_DEMO;

select * from company;
select * from employee;

create table user(
    ID BIGINT PRIMARY KEY AUTO_INCREMENT,
    USER_NAME NVARCHAR(256),
    HASH_CODE NVARCHAR(256) UNIQUE ,
    RULE NVARCHAR(256) DEFAULT 'USER',
    PHONE_NUMBER NVARCHAR(256) DEFAULT '113'
);

select * from user where HASH_CODE LIKE '%670345E3AC393AF43DA0998ED89C80F8%';


select (COUNT(uuid)) from user;

create unique index index_hashcode on user(HASH_CODE);


INSERT INTO db_jpa_demo.user (USER_NAME, HASH_CODE, RULE, PHONE_NUMBER)
 VALUES ('ducla_2', '778899', '789', '356');


select * from user where name like '%ducla%';


