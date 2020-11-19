SET FOREIGN_KEY_CHECKS = 0;

truncate table pet;
truncate table store;

-- INSERT into store(`id`, `name`, location, `contact`)
-- VALUES(21, 'dstore', 'Lagos', '01-00123456');
--
-- INSERT into pet(`id`, `name`, `age`, `color`, `gender`, `breed`, `store_id`)
-- VALUES(31, 'captain', '3', 'black', 'MALE','dog', 21 ),
-- (32, 'major', '5', 'brown', 'FEMALE', 'dog',21 ),
-- (33, 'jill', '3', 'black', 'FEMALE','dog', 21 ),
-- (34, 'jo', '3', 'blue', 'MALE', 'horse', 21 ),
-- (35, 'cat', '3', 'black', 'MALE', 'cat',21 );

INSERT into store(`id`, `name`, `location`, `contact`)
VALUES(2, 'theHub', 'Sabo', '081234567'),
(3, 'thePlace', 'Abuja', '081234500'),
(4, 'semicolon', 'Yaba', '0801234567'),
(5, 'pets', 'VI', '081235567');

INSERT into pet(`id`, `name`, `age`, `color`, `gender`, `breed`, `store_id`)
VALUES(22, 'captain', '3', 'black', 'MALE','dog', 2 ),
(32, 'major', '5', 'brown', 'FEMALE', 'dog',2 ),
(23, 'jill', '3', 'black', 'FEMALE','dog', 3 ),
(25, 'jo', '3', 'blue', 'MALE', 'horse', 5),
(35, 'cat', '3', 'black', 'MALE', 'cat',5 );

SET FOREIGN_KEY_CHECKS = 1;