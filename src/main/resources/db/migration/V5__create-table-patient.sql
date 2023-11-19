create table patient(

    id BIGSERIAL NOT NULL,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    cpf varchar(14) not null unique,
     street VARCHAR(100) NOT NULL,
        neighborhood VARCHAR(100) NOT NULL,
        zip_code VARCHAR(9) NOT NULL,
        city VARCHAR(100) NOT NULL,
        uf CHAR(2) NOT NULL,
        number VARCHAR(20),
        complement VARCHAR(100),
    telephone varchar(20) not null,
    active boolean not null,

    primary key(id)

);