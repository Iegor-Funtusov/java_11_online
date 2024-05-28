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