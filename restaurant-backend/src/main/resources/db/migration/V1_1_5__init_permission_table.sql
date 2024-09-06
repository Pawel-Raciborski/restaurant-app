create table permission(
    id SERIAL NOT NULL PRIMARY KEY,
    name varchar(64) NOT NULL UNIQUE
);