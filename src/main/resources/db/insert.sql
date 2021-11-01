set foreign_key_checks = 0;

truncate table note;
insert into note(`id`, `title`, `content`)
values
    (110, 'first note',  'why do i sing so well....'),
    (111, 'second note', 'just saying i am absolutely stunning'),
    (112, 'away', 'i cannot wait to visit more countries around the world'),
    (113, 'luxury table', 'how about i buy a luxury table');


set foreign_key_checks =  1;