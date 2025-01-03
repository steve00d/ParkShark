

create sequence zip_seq start with 1 increment by 1;
create table zip_code
(
    id       bigint default nextval('zip_seq') primary key ,
    zip_code varchar(255),
    city     varchar(255),
    country  varchar(255)
);

CREATE sequence address_seq start with 1 increment by 1;

Create table adress
(
    id     bigint default nextval('address_seq') primary key,
    street varchar(255),
    number integer,
    extra  varchar(255),
    fk_zip_code bigint,
    foreign key (fk_zip_code) references zip_code(id)
);