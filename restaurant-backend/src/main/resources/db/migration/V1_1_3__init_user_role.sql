CREATE table user_role
(
    id        SERIAL NOT NULL PRIMARY KEY,
    worker_id INT    NOT NULL,
    role_id   INT    NOT NULL,
    CONSTRAINT fk_user_role_worker FOREIGN KEY (worker_id)
        REFERENCES worker (id),
    CONSTRAINT fk_user_role_role FOREIGN KEY (role_id)
        REFERENCES role (id)
)