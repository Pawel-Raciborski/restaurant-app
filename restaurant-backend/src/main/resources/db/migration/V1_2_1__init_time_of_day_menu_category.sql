CREATE TABLE time_of_day_menu_category
(
    id                  SERIAL       NOT NULL PRIMARY KEY,
    category_name       varchar(256) NOT NULL,
    description         text,
    time_of_day_menu_id INT          NOT NULL,
    CONSTRAINT fk_time_of_day_menu_category_time_of_day_menu FOREIGN KEY (time_of_day_menu_id)
        REFERENCES time_of_day_menu (id)
)