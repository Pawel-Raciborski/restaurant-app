create table magazine
(
    id          SERIAL      NOT NULL PRIMARY KEY,
    name        varchar(32) NOT NULL,
    description text        NOT NULL
);