

create sequence zip_seq start with 1 increment by 1;
create table zip_code
(
    id       int primary key default nextval('zip_seq'),
    zip_code varchar(255),
    city     varchar(255),
    country  varchar(255)
);

CREATE sequence address_seq start with 1 increment by 1;

Create table adress
(
    id     int primary key default nextval('address_seq'),
    street varchar(255),
    number integer,
    extra  varchar(255),
    fk_zip_code integer,
    Fk_zip_code int references zip_code(id)
);