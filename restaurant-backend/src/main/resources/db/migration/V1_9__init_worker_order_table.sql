CREATE table worker_order
(
    id        SERIAL NOT NULL PRIMARY KEY,
    worker_id INT    NOT NULL,
    order_id  INT    NOT NULL
);