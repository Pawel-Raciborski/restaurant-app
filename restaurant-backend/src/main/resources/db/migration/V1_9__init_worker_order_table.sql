CREATE table worker_order
(
    id        SERIAL NOT NULL PRIMARY KEY,
    worker_id INT    NOT NULL,
    order_id  INT    NOT NULL,
    CONSTRAINT fk_worker_order FOREIGN KEY (worker_id)
REFERENCES worker(id),
    CONSTRAINT fk_worker_order_summary FOREIGN KEY (order_id)
REFERENCES order_summary(id)
);