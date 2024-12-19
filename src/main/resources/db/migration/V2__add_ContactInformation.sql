alter table adress
    rename to address;

create SEQUENCE contact_information_seq start with 1 increment by 1;
create table contact_information
(
    id                     bigint primary key default nextval('contact_information_seq'),
    first_name             varchar(255) not null,
    last_name              varchar(255) not null,
    primary_phone_number   varchar(255) not null,
    secondary_phone_number varchar(255),
    email_address          varchar(255) not null,
    fk_address_id          bigint,
    FOREIGN KEY (fk_address_id) REFERENCES address (id)
);