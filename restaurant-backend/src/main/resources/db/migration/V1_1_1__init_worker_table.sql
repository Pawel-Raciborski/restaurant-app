CREATE table worker(
    id SERIAL NOT NULL PRIMARY KEY,
    pesel varchar(64) NOT NULL,
    name varchar(64) NOT NULL,
    surname varchar(64) NOT NULL,
    password varchar(256) NOT NULL,
    email varchar(64) NOT NULL,
    date_of_employment timestamp with time zone
);