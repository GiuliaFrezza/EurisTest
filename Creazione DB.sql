create database euris;
use euris;
 create table articoli
 (
 codice varchar(50) primary key,
 nome varchar(50),
 costo varchar (20)
 );
 insert into articoli values ('a111','acetone','5p 17s 8d');
 insert into articoli values ('a112','astuccio','3p 4s 8d');
 insert into articoli values ('1233','borraccia','5p 3s 10d');
 insert into articoli values ('qrfda','tazzina','9p 8s 8d');
 insert into articoli values ('fcawerf','lampada','4p 15s 6d');
 
 select * from articoli;