CREATE TABLE time_of_day_dish
(
    id                           SERIAL NOT NULL PRIMARY KEY,
    time_of_day_menu_category_id INT    NOT NULL,
    dish_id                      INT    NOT NULL,
    CONSTRAINT fk_time_of_day_dishes_time_of_day_menu_category FOREIGN KEY (time_of_day_menu_category_id)
        REFERENCES time_of_day_menu_category (id)
)