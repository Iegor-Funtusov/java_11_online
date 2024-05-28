create schema java_11_online default character set utf8;

create table students(
    id bigint auto_increment primary key,
    first_name varchar(255) null,
    last_name varchar(255) null,
    age int null
);