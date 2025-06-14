create database travelmanagementsystem;

use travelmanagementsystem;

create table account(
	username varchar(20),
    name varchar(20),
    password varchar(20),
    security varchar(100),
    answer varchar(50)
);

select * from account;

create table customer(
	username varchar(20),
    id varchar(30),
    number varchar(30),
    name varchar(30),
    gender varchar(20),
    country varchar(20),
    address varchar(20),
    phone varchar(20),
    email varchar(20)
);

select * from customer;

create table bookpackage(
	username  varchar(20),
    package varchar(30),
    persons varchar(20),
    id varchar(20),
    number varchar(20),
    phone varchar(20),
    price varchar(20)
);

select * from bookpackage;

create table hotel (name varchar(100), costperperson varchar(20), acroom varchar(20), foodincluded varchar(10));

insert into hotel values('JW Mariott Hotel', '3400', '1500', '2000');
insert into hotel values('Madarin Oriental Hotel', '3000', '1000', '1500');
insert into hotel values('Hyatt Regency Hotel', '2000', '600', '1600');
insert into hotel values('The Imperial Hotel', '2600', '1500', '1600');
insert into hotel values('The Oberoi Grands Hotel', '2200', '900', '1700');
insert into hotel values('Amanbagh Palace Hotel', '2400', '700', '1400');
insert into hotel values('Hilton Garden Hotel', '3200', '800', '2000');
insert into hotel values('Six Senses Fort Hotel', '5400', '3500', '6000');
insert into hotel values('Lake Palace Hotel', '3500', '2500', '4000');
insert into hotel values('Vedic Villas Hotel Grand', '2500', '800', '1000');
 
 select * from hotel;
 