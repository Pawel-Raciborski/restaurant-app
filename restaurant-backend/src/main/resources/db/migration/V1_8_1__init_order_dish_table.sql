create table order_dish(
    id SERIAL NOT NULL PRIMARY KEY,
    dish_id INT NOT NULL,
    order_id INT NOT NULL,
    quantity INT NOT NULL,
    CONSTRAINT fk_order_dish_dish FOREIGN KEY (dish_id)
                       REFERENCES dish(id),
    CONSTRAINT fk_order_dish_order FOREIGN KEY (order_id)
                       REFERENCES order_summary(id)

)