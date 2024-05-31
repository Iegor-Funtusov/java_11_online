# create
insert into users values (default, 'qq', 'qqq', 23);
# insert into users values (default, 'ww', 'www', 24);
# read
select * from users;
select * from users where id = 1;
# update
update users set age = 25 where id = 2;
# delete
delete from users where id = 2;



select * from students;
select count(id) as count_of_students from students;

select avg(age) as average_of_age from students;
select sum(age) as sum_of_age from students;
select min(age) as min_of_age from students;
select max(age) as max_of_age from students;
select distinct (age) as distinct_of_age from students;
select count(distinct (age)) as distinct_of_age from students;

select * from students where age >=20 and age <= 30;

select * from students where age >=20 and age <= 30 order by age asc;
select * from students where age >=20 and age <= 30 order by age desc;
select * from students limit 20, 100;
select * from students where age >=20 and age <= 30 order by age limit 0, 10;

select * from students where first_name like 'qq';
select * from students where first_name like 'q%';
select * from students where first_name like '%e%';
select * from students where first_name like '%e%' and last_name like '%bb%' and age > 20 order by age desc limit 0, 10;
select * from students where first_name like '%e%' and last_name like '%bb%' and age between 20 and 22 order by age desc limit 0, 10;

select * from students where age in (20, 25, 27);
select * from students where age in (select age from students where first_name like 'qq') order by age desc;

select distinct (age) as distinct_of_age from students order by age desc;
select count(age) as count_of_age, age from students group by age order by age desc;

