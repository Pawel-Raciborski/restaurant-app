create table currency(
    id SERIAL NOT NULL PRIMARY KEY,
    name varchar(16) NOT NULL UNIQUE
)