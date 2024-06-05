create table todolist(

    id bigint not null auto_increment,
    description varchar(250) not null,
    completed tinyint,


    primary key(id)
);
