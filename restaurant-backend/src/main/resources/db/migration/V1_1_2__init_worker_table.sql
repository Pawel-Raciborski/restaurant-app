CREATE table worker
(
    id                 SERIAL        NOT NULL PRIMARY KEY,
    pesel              varchar(16)   NOT NULL,
    user_id            INT           NOT NULL,
    hourly_rate        numeric(6, 2) NOT NULL,
    date_of_employment timestamp with time zone,
    CONSTRAINT fk_worker_user FOREIGN KEY (user_id)
        REFERENCES user_table (id)
);