create sequence parking_lot_seq start with 1 increment by 1;
create table parking_lot
(
    id bigint primary key default nextval('parking_lot_seq'),
    name varchar(255) not null,
    parking_lot_category enum('UNDERGROUND_BUILDING', 'ABOVEGROUND_BUILDING') not null,
    capacity int not null,
    fk_contact_information_id bigint not null,
    fk_address_id bigint not null,
    price_per_hour numeric(4,2) not null,
);
