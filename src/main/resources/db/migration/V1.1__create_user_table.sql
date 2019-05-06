create table if not exists user (
    id identity not null primary key,
    name varchar(50) not null,
    designation varchar(50) not null,
    label int,
    system_name varchar(50)
)