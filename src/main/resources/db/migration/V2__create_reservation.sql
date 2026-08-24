CREATE TABLE reservation (
                             id BIGSERIAL PRIMARY KEY,
                             uuid VARCHAR(255) NOT NULL,
                             version BIGINT NOT NULL,
                             propertyId BIGINT NOT NULL,
                             guestId BIGINT NOT NULL,
                             startDate DATE NOT NULL,
                             endDate DATE NOT NULL,
                             status SMALLINT NOT NULL,
                             totalPrice NUMERIC(19, 2) NOT NULL,
                             createdAt TIMESTAMP NOT NULL,
                             updatedAt TIMESTAMP NOT NULL
);