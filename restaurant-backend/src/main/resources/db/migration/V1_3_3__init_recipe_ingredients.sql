CREATE TABLE recipe_ingredient
(
    id            SERIAL NOT NULL PRIMARY KEY,
    recipe_id     INT    NOT NULL,
    ingredient_id INT    NOT NULL,
    quantity      INT    NOT NULL,
    unit_id       INT,
    CONSTRAINT fk_recipe_ingredients_recipe FOREIGN KEY (recipe_id)
        REFERENCES recipe (id),
    CONSTRAINT fk_recipe_ingredients_ingredient FOREIGN KEY (ingredient_id)
        REFERENCES ingredient (id),
    CONSTRAINT fk_recipe_ingredients_unit FOREIGN KEY (unit_id)
        REFERENCES unit (id)
)