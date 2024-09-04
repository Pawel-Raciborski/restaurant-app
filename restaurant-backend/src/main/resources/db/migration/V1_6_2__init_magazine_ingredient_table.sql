create table magazine_ingredient(
    id SERIAL NOT NULL PRIMARY KEY,
    magazine_id INT NOT NULL,
    ingredient_id INT NOT NULL,
    quantity INT NOT NULL,
    unit_id INT NOT NULL,
    CONSTRAINT fk_magazine_ingredient_magazine FOREIGN KEY (magazine_id)
                                REFERENCES magazine(id),
    CONSTRAINT fk_magazine_ingredient_ingredient FOREIGN KEY (ingredient_id)
                                REFERENCES ingredient(id),
    CONSTRAINT fk_magazine_ingredient_unit FOREIGN KEY (unit_id)
                                references unit(id)
)