insert into
    client (client_id, email, first_name, identification, lastname)
values
       (1,'jalozanog93@hotmail.com', 'julian', 101865745, 'Lozano'),
       (2,'daniel23@hotmail.com', 'Daniel', 101865734, 'Lozano'),
       (3,'david@hotmail.com', 'David', 101865342, 'Lozano'),
       (4,'diana@hotmail.com', 'Diana', 101865745, 'Lozano');



INSERT INTO
    credit_card (card_id, card_brand, client_name, expiration_date, keynumber_card, client_id)
values
       (1, 'visa', 'JULIAN LOZANO', '2022-05-15', 543, 1),
       (2, 'master', 'JULIAN LOZANO', '2022-05-15', 733, 1),
       (3, 'diners', 'JULIAN LOZANO', '2022-05-15', 543, 1),
       (4, 'visa', 'DIANA LOZANO', '2022-05-15', 543, 4),
       (5, 'visa', 'DAVID LOZANO', '2022-05-15', 543, 3);
