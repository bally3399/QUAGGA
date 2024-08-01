truncate table users cascade;
truncate table specialists cascade;

insert into users(id, first_name, last_name, email, password, address, phone_number, role) values
(100, 'john', 'carter', 'john@email.com', '$2a$10$wqdT5ndwlN8WL83AZH7Fp.evLqldxFxmIYW5wraO8kORgPsn56oKW', 'Sabo Yaba', '09072635262', 'CLIENT'),
(101, 'jane', 'cena', 'jane@email.com', '$2a$10$wqdT5ndwlN8WL83AZH7Fp.evLqldxFxmIYW5wraO8kORgPsn56oKW', 'Abule oja', '08173737272', 'CLIENT'),
(102, 'jonny', 'cage', 'johnny@email.com', '$2a$10$wqdT5ndwlN8WL83AZH7Fp.evLqldxFxmIYW5wraO8kORgPsn56oKW', 'Unilag Lagos', '07053627211', 'CLIENT'),
(103, 'james', 'bond', 'james@email.com', '$2a$10$wqdT5ndwlN8WL83AZH7Fp.evLqldxFxmIYW5wraO8kORgPsn56oKW', 'Sabo Yaba', '08172635262', 'CLIENT'),
(104, 'george', 'bush', 'george@email.com', '$2a$10$wqdT5ndwlN8WL83AZH7Fp.evLqldxFxmIYW5wraO8kORgPsn56oKW', 'Abule Ijesha', '09080432262', 'CLIENT'),
(105, 'John', 'Doe', 'john.doe@email.com', '$2a$10$examplehashedpassword1', '123 Main St, Springfield', '555-1234', 'SPECIALIST'),
(106, 'Jane', 'Smith', 'jane.smith@email.com', '$2a$10$examplehashedpassword2', '456 Elm St, Shelbyville', '555-5678', 'SPECIALIST'),
(107, 'Emily', 'Johnson', 'emily.johnson@email.com', '$2a$10$examplehashedpassword3', '789 Oak St, Capital City', '555-9101', 'SPECIALIST'),
(108, 'Michael', 'Brown', 'michael.brown@email.com', '$2a$10$examplehashedpassword4', '101 Maple St, Springfield', '555-1122', 'SPECIALIST'),
(109, 'Alice', 'Williams', 'alice.williams@email.com', '$2a$10$examplehashedpassword5', '202 Birch St, Oakville', '555-1313', 'SUPPLIER'),
(110, 'Bob', 'Taylor', 'bob.taylor@email.com', '$2a$10$examplehashedpassword6', '303 Pine St, Rivertown', '555-1414', 'SUPPLIER'),
(111, 'Carol', 'Davis', 'carol.davis@email.com', '$2a$10$examplehashedpassword7', '404 Cedar St, Lakewood', '555-1515', 'SUPPLIER'),
(112, 'David', 'Wilson', 'david.wilson@email.com', '$2a$10$examplehashedpassword8', '505 Walnut St, Hillcrest', '555-1616', 'SUPPLIER');

insert into specialists(specialist_id, user_id, availability, company_name, company_reg_no ) values
    (200, 105, 'true', 'ABC Construction Ltd', 'ABC123456'),
    (201, 106, 'true', 'XYZ Engineering Services', 'XYZ654321'),
    (202, 107, 'true', 'LMN Architects', 'LMN987654'),
    (203, 108, 'false', 'PQR Plumbing Co.', 'PQR456789');

insert into client(id, user_id) values
    (300, 109),
    (301, 110),
    (302, 111),
    (303, 112);

-- insert into suppliers()

--     private Long supplierId;
--     private String typeOfMaterial;
--     private List<Product> products;
--     private User user;
--     private Review review;