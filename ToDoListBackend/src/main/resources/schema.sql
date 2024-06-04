create table todolist(

    id bigint not null auto_increment,
    description varchar(250) not null,
--    date_created varchar(250) not null,
    completed tinyint,
--    local_time varchar(250) not null,


    primary key(id)
);
