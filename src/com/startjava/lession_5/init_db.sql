\c robots;
DROP TABLE IF EXISTS jaegers CASCADE;

CREATE TABLE jaegers(
    id SERIAL PRIMARY KEY,
    model_name TEXT,
    mark TEXT,
    height DOUBLE PRECISION,
    weight INTEGER,
    status TEXT,
    origin TEXT,
    launch DATE,
    kaiju_kill INTEGER);

-- Включаем populate.sql
\include_relative populate.sql

-- Включаем queries.sql
\include_relative queries.sql