CREATE table ingredient
(
    id          SERIAL       NOT NULL PRIMARY KEY,
    name        varchar(256) NOT NULL,
    description text,
    category    varchar(256) NOT NULL
)