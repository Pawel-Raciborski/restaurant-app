FROM postgres:latest

ENV POSTGRES_USER=postgres
ENV POSTGRES_PASSWORD=postgres
ENV POSTGRES_DB=restaurant

COPY ./src/main/resources/db/migration/*.sql /docker-entrypoint-initdb.d/

EXPOSE 5432