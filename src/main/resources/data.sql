insert into course(id,name,created_date,last_updated_date) values(1001,'Hibernate',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
insert into course(id,name,created_date,last_updated_date) values(1002,'Spring',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
insert into course(id,name,created_date,last_updated_date) values(1003,'Docker',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);

insert into passport(id,number) values(4001,'E12345');
insert into passport(id,number) values(4002,'B45678');
insert into passport(id,number) values(4003,'X67432');

insert into student(id,name,passport_id) values(2001,'Iron Man',4001);
insert into student(id,name,passport_id) values(2002,'Bat Man',4002);
insert into student(id,name,passport_id) values(2003,'Spider Man',4003);


insert into review(id,rating,description,course_id) values(5001,'3','Great course',1001);
insert into review(id,rating,description,course_id) values(5002,'2.5','nice',1001);
insert into review(id,rating,description,course_id) values(5003,'4','wonderful course',1003);