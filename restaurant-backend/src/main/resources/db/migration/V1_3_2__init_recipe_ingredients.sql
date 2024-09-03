CREATE TABLE recipe_ingredients
(
    id            SERIAL       NOT NULL PRIMARY KEY,
    recipe_id     INT          NOT NULL,
    ingredient_id INT          NOT NULL,
    quantity      varchar(128) NOT NULL,
    CONSTRAINT fk_recipe_ingredients_recipe FOREIGN KEY (recipe_id)
        REFERENCES recipe (id),
    CONSTRAINT fk_recipe_ingredients_ingredient FOREIGN KEY (ingredient_id)
        REFERENCES ingredient (id)
)