CREATE sequence user_seq start with 1 increment by 1;

Create table user
(
    id  bigint primary key default nextval('user_seq'),
    first_name varchar(255),
    last_name varchar(255),
    email varchar(255),
    password varchar(255),
    person_type integer
);