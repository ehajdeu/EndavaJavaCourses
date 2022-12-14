create database tech_courses;

create table t_students
(
    id         int GENERATED BY DEFAULT AS IDENTITY (START WITH 1 INCREMENT BY 5),
    first_name varchar(30),
    last_name  varchar(30)
);

create table t_mentor
(
    id         int GENERATED BY DEFAULT AS IDENTITY (START WITH 1 INCREMENT BY 5),
    first_name varchar(30),
    last_name  varchar(30)
);

drop table t_students;

alter table t_students
    add birth_date date;

create table t_lesson
(
    lesson_id     int,
    lesson_title  varchar(30),
    lesson_mentor varchar(60)
);

create table t_student_lesson
(
    student_lesson_id int PRIMARY KEY,
    student_id int REFERENCES t_students(id),
    lesson_id int REFERENCES t_lesson(lesson_id)
);

select * from t_student_lesson;

insert into t_student_lesson
values (1, 3, null);

alter table t_lesson
    drop column lesson_mentor;

alter table t_lesson
    add column lesson_mentor_id int;

alter table t_lesson
    add primary key(lesson_id);

alter table t_mentor
    add primary key(id);

alter table t_lesson
    add foreign key(lesson_mentor_id) references t_mentor(id);

drop table t_lesson;

select now();

insert into t_students(id, first_name, last_name, birth_date)
values (1, 'test', 'last', '2022-10-10'),
       (2, 'kdvjas', 'djvas', '2022-10-09');

insert into t_students
values (1, 'test', '2022-10-10', 'last'),
       (2, 'kdvjas', 'djvas', '2022-10-09');

select *
from t_students;

select first_name, last_name
from t_students;

update t_students
set first_name = 'new name';

select distinct first_name
from t_students;

select *
from t_students
limit 2;

delete
from t_students;

truncate table t_students;



create table t_students
(
    id             int GENERATED BY DEFAULT AS IDENTITY (START WITH 1 INCREMENT BY 1)
                   NOT NULL UNIQUE,
    first_name     varchar(30),
    last_name      varchar(30),
    student_age    date check (student_age > '2000-01-01'),
    student_gender varchar(7) default 'Unknown'
);

insert into t_students(first_name, last_name, student_age)
values ('abc', 'adce', '2001-01-01');
       --('dce', 'dcea', '1999-01-01')

insert into t_students(first_name, last_name, student_age, student_gender)
values ('abc', 'adce', '2001-01-01', null);
--('dce', 'dcea', '1999-01-01')

select * from t_students;






