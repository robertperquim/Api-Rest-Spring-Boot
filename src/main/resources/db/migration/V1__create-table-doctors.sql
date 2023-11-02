CREATE TABLE doctor (
    id BIGSERIAL NOT NULL,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    crm VARCHAR(6) NOT NULL UNIQUE,
    speciality VARCHAR(100) NOT NULL,
    street VARCHAR(100) NOT NULL,
    neighborhood VARCHAR(100) NOT NULL,
    zip_code VARCHAR(9) NOT NULL,
    city VARCHAR(100) NOT NULL,
    uf CHAR(2) NOT NULL,
    number VARCHAR(20),
    complement VARCHAR(100),
    PRIMARY KEY (id)
);
