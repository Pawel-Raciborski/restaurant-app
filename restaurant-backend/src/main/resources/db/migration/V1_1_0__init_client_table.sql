CREATE TABLE client
(
    id       SERIAL       NOT NULL PRIMARY KEY,
    name     varchar(64)  NOT NULL,
    surname  varchar(128) NOT NULL,
    email    varchar(128) NOT NULL,
    password varchar(256) NOT NULL
);