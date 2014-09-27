drop database if exists homework;
create database homework default character set utf8;

use homework;

drop table if exists t_word;
create table t_word(
id int auto_increment primary key,
word varchar(100) not null,
content varchar(1000) not null
) engine=InnoDB;

drop table if exists t_recite_history;
create table t_recite_history(
id int auto_increment primary key,
word_id int not null,
tm datetime not null,
result varchar(2) not null
) engine=InnoDB;