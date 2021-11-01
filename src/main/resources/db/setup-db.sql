create database notedb;

create user 'note_user'@'localhost' identified by 'note123';
grant all privileges on notedb.* to 'note_user'@'localhost';
flush privileges;