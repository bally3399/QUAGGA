truncate table users cascade;
truncate table specialists cascade;

insert into users(id, first_name, last_name, email, password, address, phone_number, role) values
(100, 'john', 'carter', 'john@email.com', '$2a$10$wqdT5ndwlN8WL83AZH7Fp.evLqldxFxmIYW5wraO8kORgPsn56oKW', 'Sabo Yaba', '09072635262', 'CLIENT'),
(101, 'jane', 'cena', 'jane@email.com', '$2a$10$wqdT5ndwlN8WL83AZH7Fp.evLqldxFxmIYW5wraO8kORgPsn56oKW', 'Abule oja', '08173737272', 'CLIENT'),
(102, 'jonny', 'cage', 'johnny@email.com', '$2a$10$wqdT5ndwlN8WL83AZH7Fp.evLqldxFxmIYW5wraO8kORgPsn56oKW', 'Unilag Lagos', '07053627211', 'CLIENT'),
(103, 'james', 'bond', 'james@email.com', '$2a$10$wqdT5ndwlN8WL83AZH7Fp.evLqldxFxmIYW5wraO8kORgPsn56oKW', 'Sabo Yaba', '08172635262', 'CLIENT'),
(104, 'george', 'bush', 'george@email.com', '$2a$10$wqdT5ndwlN8WL83AZH7Fp.evLqldxFxmIYW5wraO8kORgPsn56oKW', 'Abule Ijesha', '09080432262', 'CLIENT');

insert into specialist(id, user, )