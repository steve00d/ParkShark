create sequence division_seq start with 1 increment by 1;

create table division
(
    id                    bigint default nextval('division_seq') primary key,
    name                  varchar(255) not null,
    original_company_name varchar(255),
    fk_director_id        bigint,
    foreign key (fk_director_id) references "user" (id)
);
