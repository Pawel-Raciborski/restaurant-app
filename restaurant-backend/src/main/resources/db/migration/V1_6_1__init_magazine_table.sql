create table magazine
(
    id            SERIAL        NOT NULL PRIMARY KEY,
    ingredient_id INT           NOT NULL,
    quantity      numeric(7, 2) NOT NULL,
    unit          varchar(16)   NOT NULL,
    CONSTRAINT fk_magazine_ingredient FOREIGN KEY (ingredient_id)
        REFERENCES ingredient (id)
)