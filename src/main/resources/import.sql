
insert into usercredentials (username, password, enabled) values ('Lin', '$2a$10$CwfywdhOo4lQ62IA3Es5heixxkw2g8zH6oeHL2JqaxqRPdiG7mdyy', true);

insert into usercredentials (username, password, enabled) values ('root', '$2a$10$CwfywdhOo4lQ62IA3Es5heixxkw2g8zH6oeHL2JqaxqRPdiG7mdyy', true);

alter table usercredentials modify password varchar(60);

insert into authority(name) values ('ROLE_USER');

insert into authority(name) values ('ROLE_ADMIN');

insert into user_authority (user_id, authority_id) values ('1', '1');

insert into user_authority (user_id, authority_id) values ('2', '2');

insert into user_authority (user_id, authority_id) values ('2', '1');

insert into member (age, email, firstName, lastName, gender, height, weight, username, userCredential_id) values (35, 'root@123.com', 'root', 'root', 'Male', 180, 190, 'root', 1);

insert into member (age, email, firstName, lastName, gender, height, weight, username, userCredential_id) values (36, 'Lin@123.com', 'Lin', 'Cong', 'Male', 183, 190, 'Lin', 2);

insert into goals (date, MINUTES, mood, member_id) values ('2016-07-26', 150, 'Happy', 2);

insert into goals (date, MINUTES, mood, member_id) values ('2016-07-27', 100, 'Happy', 2);

insert into exercise (activity, description, minutes, reps, sets, goal_id) values ('Bike', 'Bikeeeeeeee', 30, 0, 0, 1);

insert into exercise (activity, description, minutes, reps, sets,  goal_id) values ('Run', 'Runnnnnnn', 80,  0, 0, 1);

insert into exercise (activity, description, minutes, reps, sets,  goal_id) values ('Swim', 'Swimmmmmmm', 60,  0, 0, 2);

insert into exercise (activity, description, minutes, reps, sets,  goal_id) values ('Bike', 'Biking is a very good exercise', 90,  0, 0, 2);





