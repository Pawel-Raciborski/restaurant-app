create table payment(
    id SERIAL NOT NULL PRIMARY KEY,
    price numeric(7,2) NOT NULL,
    currency_id INT NOT NULL,
    payment_method_id INT NOT NULL,
    CONSTRAINT fk_payment_currency FOREIGN KEY (currency_id)
                    REFERENCES currency(id),
    CONSTRAINT fk_payment_payment_method FOREIGN KEY (payment_method_id)
                    REFERENCES payment_method(id)
)