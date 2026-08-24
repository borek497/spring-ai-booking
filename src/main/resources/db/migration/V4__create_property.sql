CREATE TABLE property (
                          id BIGSERIAL PRIMARY KEY,
                          uuid VARCHAR(255) NOT NULL,
                          version BIGINT NOT NULL,
                          name VARCHAR(255) NOT NULL,
                          description TEXT,
                          property_type VARCHAR(50) NOT NULL,
                          property_status VARCHAR(50) NOT NULL,
                          province_id BIGINT NOT NULL,

                          CONSTRAINT fk_property_province
                              FOREIGN KEY (province_id)
                                  REFERENCES province(id)
);