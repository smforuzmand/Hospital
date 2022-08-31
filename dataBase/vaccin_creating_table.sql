drop table if exists booking;
drop table if exists patient;
drop table if exists premises;
drop table if exists contact_info;
create table if not exists contact_info
(
    id varchar(255) not null
        primary key,
    email varchar(100) not null,
    phone varchar(100) null,
    address varchar(500) null
);
create table if not exists premises
(
    id varchar(255) not null
        primary key,
    name varchar(255) not null,
    fk_contact_info varchar(255) null,
    constraint fk_premises_contact_info1
        foreign key (fk_contact_info) references contact_info (id)
);
create index fk_premises_contact_info1_idx
    on premises (fk_contact_info);
create table if not exists patient
(
    id varchar(255) not null
        primary key,
    ssn varchar(12)  not null,
    first_name varchar(100) not null,
    last_name varchar(100) not null,
    birth_date date         not null,
    fk_contact_info varchar(255) null,
    constraint ssn_UNIQUE
        unique (ssn),
    constraint fk_patient_contact_info1
        foreign key (fk_contact_info) references contact_info (id)
);
create table if not exists booking
(
    id varchar(255) not null
        primary key,
    date_time datetime     not null,
    price decimal      not null,
    administrator varchar(255) null,
    vaccineType varchar(255) not null,
    vacant tinyint(1)   not null,
    fk_premises varchar(255) null,
    fk_patient varchar(255) null,
    constraint fk_booking_premises1
        foreign key (fk_premises) references premises (id),
    constraint fk_booking_patient1
        foreign key (fk_patient) references patient (id)
);
create index fk_booking_premises1_idx
    on booking (fk_premises);
create index fk_booking_patient1_idx
    on booking (fk_patient);
create index fk_patient_contact_info1_idx
    on patient (fk_contact_info);
-- INSERTS
INSERT INTO contact_info (id, email, phone, address)
VALUES ('info1', 'info@testcenter.se', '1234567890', 'Storgatan 50 123 45 Varstad');
INSERT INTO contact_info (id, email, phone, address)
VALUES ('info2', 'info@testcenter.se', '0987654321', 'lillgatan 25 123 45 Varstad');
INSERT INTO contact_info (id, email, phone, address)
VALUES ('info3', 'info@notestcenter.se', '1597534826', 'Tvärgatan 48 159 26 Därstad');

