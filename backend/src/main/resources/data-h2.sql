INSERT INTO publishers VALUES (default, 'Manning Publications Co.');
INSERT INTO publishers VALUES (default, 'Pearson Education, Inc.');

INSERT INTO books VALUES (default, '9781617294945', 'Spring IN ACTION', 1);
INSERT INTO authors VALUES (default, 'Craig', 'Walls');
INSERT INTO book_authors VALUES (1, 1);

INSERT INTO books VALUES (default, '9781617293566', 'Modern Java IN ACTION', 1);
INSERT INTO authors VALUES (default, 'Raoul-Gabriel', 'Urma');
INSERT INTO authors VALUES (default, 'Mario', 'Fusco');
INSERT INTO authors VALUES (default, 'Alan', 'Mycroft');
INSERT INTO book_authors VALUES (2, 2);
INSERT INTO book_authors VALUES (2, 3);
INSERT INTO book_authors VALUES (2, 4);

INSERT INTO books VALUES (default, '9780132847377', 'Data Structures and Algorithm Analysis in C++', 2);
INSERT INTO authors VALUES (default, 'Mark Allen', 'Weiss');
INSERT INTO book_authors VALUES (3, 5);

INSERT INTO books VALUES (default, '9781617295218', 'The Well-Grounded Rubyist', 1);
INSERT INTO authors VALUES (default, 'David A.', 'Black');
INSERT INTO authors VALUES (default, 'Joseph', 'LEO III');
INSERT INTO book_authors VALUES (4, 6);
INSERT INTO book_authors VALUES (4, 7);

INSERT INTO books VALUES (default, '9780134190440', 'The Go Programming Language', 1);
INSERT INTO authors VALUES (default, 'Alan A. A.', 'Donovan');
INSERT INTO authors VALUES (default, 'Brian W.', 'Kernighan');
INSERT INTO book_authors VALUES (5, 8);
INSERT INTO book_authors VALUES (5, 9);
