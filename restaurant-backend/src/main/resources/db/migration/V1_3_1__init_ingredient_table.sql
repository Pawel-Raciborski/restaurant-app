CREATE table ingredient
(
    id          SERIAL       NOT NULL PRIMARY KEY,
    name        varchar(256) NOT NULL,
    description text,
    category_id INT          NOT NULL
)