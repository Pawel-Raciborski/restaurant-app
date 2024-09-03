CREATE table main_menu
(
    id          SERIAL NOT NULL PRIMARY KEY,
    sub_menu_id INT    NOT NULL,
    CONSTRAINT fk_main_menu_sub_menu FOREIGN KEY (sub_menu_id)
        REFERENCES time_of_day_menu (id)
)