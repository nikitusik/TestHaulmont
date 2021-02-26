drop schema if exists public cascade ;
create table client
(
    id uuid primary key not null ,
    first_name varchar(30) not null,
    middle_name varchar(30) not null,
    last_name varchar(30) not null,
    mobile_phone numeric(11) not null,
    email varchar(100) not null,
    passport numeric(10) not null
);

create table bank
(
    id uuid primary key not null,
    client_id uuid not null,
    credit_id uuid not null
);

create table credit
(
    id uuid primary key not null,
    name varchar(100),
    limit bigint not null,
    percent float not null
);

create table credit_offer
(
    id uuid primary key not null,
    bank_id uuid not null,
    client_id uuid not null,
    credit_id uuid not null,
    sum_credit float not null,
    month int not null
);

create table payment_schedule
(
    id uuid primary key not null,
    date_payment date not null,
    sum_payment decimal(10, 2) not null,
    sum_body decimal(10, 2) not null,
    sum_percent decimal(10, 2) not null,
    credit_offer_id uuid not null
);