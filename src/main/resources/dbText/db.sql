show databases;

create database BaseTestDemo01;

create table User(
                     userName varchar(20) primary key ,
                     password varchar(10)
);

show tables;

select * from User;



INSERT INTO User (username, password) VALUES
                                          ('demo1', '1111'),
                                          ('demo2', '2222'),
                                          ('demo3', '3333'),
                                          ('demo4', '4444'),
                                          ('demo5', '5555');



