CREATE TABLE province (
                          id BIGSERIAL PRIMARY KEY,
                          uuid VARCHAR(255) NOT NULL,
                          version BIGINT NOT NULL,
                          name VARCHAR(100) NOT NULL
);