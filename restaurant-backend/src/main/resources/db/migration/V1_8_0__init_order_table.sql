create table order_summary(
    id SERIAL NOT NULL PRIMARY KEY,
    client_id INT NOT NULL,
    order_date timestamp with time zone NOT NULL,
    realized_order_date timestamp with time zone,
    on_site boolean NOT NULL,
    paid boolean NOT NULL,
    payment_id INT NOT NULL,
    CONSTRAINT fk_order_client FOREIGN KEY (client_id)
                  REFERENCES client(id),
    CONSTRAINT fk_order_payment FOREIGN KEY (payment_id)
                  REFERENCES payment(id)
);