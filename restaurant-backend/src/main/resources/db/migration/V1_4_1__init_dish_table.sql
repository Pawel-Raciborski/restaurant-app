CREATE TABLE dish
(
    id          SERIAL        NOT NULL PRIMARY KEY,
    name        varchar(256)  NOT NULL,
    description text,
    recipe_id   INT           NOT NULL,
    price       numeric(7, 2) NOT NULL,
    calories    varchar(32)   NOT NULL,
    category_id INT           NOT NULL,
    CONSTRAINT fk_dish_recipe FOREIGN KEY (recipe_id)
        REFERENCES recipe (id),
    CONSTRAINT fk_dish_category FOREIGN KEY (category_id)
        REFERENCES category (id)
);