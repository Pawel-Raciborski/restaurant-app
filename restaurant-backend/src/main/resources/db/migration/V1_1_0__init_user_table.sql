create table user_table
(
    id         SERIAL       NOT NULL PRIMARY KEY,
    first_name varchar(64)  NOT NULL,
    surname    varchar(64)  NOT NULL,
    email      varchar(64)  NOT NULL,
    password   varchar(256) NOT NULL
);