insert into users (id, id_card, first_name, last_name, date_of_birthday, phone_number, email)
values
    (1, '23UAESERA', 'Ivan', 'Ivanov', '2002-07-30', '+380734568291', 'ivanov@mail.com'),
    (2, '23USA2NICE', 'John', 'Doe', '1983-03-14', '+380654798291', 'john.doe@mail.com');


insert into book (id, name, author, publication_year, state, user_id)
values
(1, 'Tom Sawyer', 'Mark Twain', 1876, 'AVAILABLE', null),
(2, 'Thinking in Java', 'Bruce Eckel', 1998, 'AVAILABLE', null),
(3, 'Clean Code', 'Robert Martin', 2008, 'AVAILABLE', null),
(4, 'Effective Java 3 ed.', 'Joshua Bloch', 2018, 'AVAILABLE', null);