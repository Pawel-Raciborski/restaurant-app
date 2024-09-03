CREATE TABLE time_of_day_menu
(
    id                SERIAL                   NOT NULL PRIMARY KEY,
    category_name     varchar(128)             NOT NULL,
    description       text,
    last_updated      timestamp with time zone NOT NULL,
    worker_updated_id INT,
    start_time        time                     NOT NULL,
    end_time          time                     NOT NULL
);