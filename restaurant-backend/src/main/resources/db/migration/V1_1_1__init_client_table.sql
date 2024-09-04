CREATE TABLE client
(
    id         SERIAL NOT NULL PRIMARY KEY,
    user_id    INT    NOT NULL,
    birth_date date   NOT NULL,
    CONSTRAINT fk_client_user FOREIGN KEY (user_id)
        REFERENCES user_table (id)
);