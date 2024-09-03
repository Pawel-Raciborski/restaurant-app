create table recipe
(
    id           SERIAL       NOT NULL PRIMARY KEY,
    name         varchar(256) NOT NULL,
    description  text         not null,
    prepare_time time
)