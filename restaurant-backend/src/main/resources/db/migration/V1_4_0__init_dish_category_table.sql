CREATE TABLE dish_category
(
    id          SERIAL       NOT NULL PRIMARY KEY,
    name        varchar(128) NOT NULL,
    description text         NOT NULL
);