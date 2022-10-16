select *
from actor
where act_gender_id = 2;

select *
from movie
where mov_dt_rel between '1962-10-31' AND '1990-10-10';

select *
from movie
where trim(mov_title) LIKE 'A%'
   OR trim(mov_title) LIKE '_h%';

select distinct mov_lang
from movie;

select *
from movie
where trim(mov_lang) IN ('Japanese', 'Russian', 'Romanian');

select *
from movie
order by mov_dt_rel desc;

update actor
set act_fname = trim(act_fname),
    act_lname = trim(act_lname);


select act_fname AS "First name",
       act_lname AS lastName,
       lower(act_lname),
       upper(act_fname),
       concat(act_fname, ', ', act_lname),
       concat_ws(',', act_fname, act_lname),
       act_fname || ', ' || act_lname
from actor;



select mov_title,
       position('va' IN mov_title),
       replace(mov_title, 'l', 'sakjkasd'),
       substring(mov_title, 3, 5)
from movie
order by char_length(trim(mov_title));

update movie
set mov_time = null
where mov_id = 901;

select current_time,
       mov_dt_rel,
       date_part('year', mov_dt_rel)
from movie;



select mov_dt_rel,
       mov_time,
       mov_rel_country,
       nullif('JP', mov_rel_country),
       coalesce(cast(mov_dt_rel as varchar), mov_time, mov_rel_country)
from movie;

select mov_lang,
       case trim(mov_lang)
           when 'English' then 'EN'
           when 'Japanese' then 'JP'
           else 'other'
           end as_another_name
from movie;


select gender,
       case gender
           when 'female' then 'f'
           when 'male' then 'm'
           end
from gender;


select mov_lang, count(mov_id)
from movie
group by mov_lang
having count(mov_id) > 2;

select max(cast(mov_time as int)),
       mov_rel_country
from movie
group by mov_rel_country
having max(cast(mov_time as int)) = (SELECT cast(mov_time as int)
                                     from movie

                                     limit 1
);



select concat_ws(' ', act_lname, act_fname)
from actor
where act_gender_id = (select gender_id
                       from gender
                       where gender_id = 1
);


select concat_ws(' ', act_fname, act_lname), g.gender
from actor a
         join gender g
              on a.act_gender_id = g.gender_id;

select *
from actor a
         left join movie_cast mc on a.act_id = mc.act_id;


select m.mov_title, g.gen_title from movie m
join movie_genres mg on m.mov_id = mg.mov_id
join genres g on mg.gen_id = g.gen_id
where g.gen_title IN ('Action', 'Biography');


select *
from movie
where mov_id IN (
    select movie_genres.mov_id
    from movie_genres
    where gen_id IN (
        select gen_id
        from genres
        where gen_title IN ('Action', 'Biography')));

--all dirs from movie with gen_title 'Action', 'Biography'
select concat(dir_fname, ' ', dir_lname)
from director
where dir_id in (
    select dir_id
    from movie_direction
    where mov_id in (
        select mov_id
        from movie_genres
        where gen_id in (
            select gen_id
            from genres
            where gen_title in ('Action', 'Biography')
        )
    )
);
explain
select m.mov_title, concat(dir_fname, ' ', dir_lname), g.gen_title
from director
full join movie_direction md on director.dir_id = md.dir_id
full join movie_genres mg on md.mov_id = mg.mov_id
full join genres g on mg.gen_id = g.gen_id
full join movie m on md.mov_id = m.mov_id;
--where g.gen_title in ('Action', 'Biography');



select * from director;

select *
from gender;

--mov_time, mov_rel_country
--group by country and mov_time = max(mov_time)
--find in each country the movie with max duration




drop table employee;

create table employee (
    empl_id int,
    empl_name varchar(20),
    mng_id int
);

insert into employee values (1, 'sakd', null),
                            (2, 'dksjad', 1),
                            (3, 'duahk', 1);

select empl.empl_name, mng.empl_name
from employee empl join employee mng
on empl.empl_id = mng.mng_id;


select concat(a.act_lname, ' ', a.act_fname)
from actor a
union
select concat(d.dir_fname, ' ', d.dir_lname)
from director d;

--max of avg(rev_stars)
-- group by mov_id
-- rating.mov_id = movie.mov_id

create or replace view v_sel
as
    select * from movie;


select * from v_sel;


begin transaction;

insert into employee values (1, 'sadsad', null);
select * from employee;

commit ;
update employee
set empl_name = 'test transaction'
where empl_id = 2;

create index i_test
on employee(mng_id);

explain
select * from movie;


rollback