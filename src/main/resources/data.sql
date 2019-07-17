INSERT INTO publishers (id, publisher_name, address) VALUES (-1,'Luceafarul','Stefan Cel Mare si Sfint 67');
INSERT INTO publishers (id, publisher_name, address) VALUES (-2,'Romania','Liviu Rebreanu 35');
INSERT into authors (id,first_name, last_name, nationality) VALUES (-1,'James', 'Clavell','British');
INSERT into authors (id,first_name, last_name, nationality) VALUES (-2,'Liviu', 'Rebreanu','Romania');
insert into books (id,book_name,publish_date,is_borrowed,is_edited,author_id,publisher_id,exemplar_numbers)
values(-1,'Shogun Vol.1','1995-12-31',false,false,-1,-1,2);
insert into books (id,book_name,publish_date,is_borrowed,is_edited,author_id,publisher_id,exemplar_numbers)
values(-2,'Shogun  Vol.2','1198-06-21',false,false,-1,-1,2);
insert into books (id,book_name,publish_date,is_borrowed,is_edited,author_id,publisher_id,exemplar_numbers)
values(-3,'Shogun  Vol.3','2000-10-05',false,false,-1,-1,2);
insert into books (id,book_name,publish_date,is_borrowed,is_edited,author_id,publisher_id,exemplar_numbers)
values(-4,'Padurea Spinzuratilor','1880-10-05',false,false,-2,-2,2);

insert into public."role" values(1,'ADMIN');
insert into public."role" values(2,'USER');

insert into "user" (user_id,email,"password","name",last_name,active) values(-1,'vasiafurdui@yahoo.com','$2a$10$tvdPysi5VIZvjdS492QU5uHmV6Qzhrj1njY9ZtuoXEj9JFWzGuche','Vasile','Furdui',true);
insert into user_role (user_id,role_id) values (-1,1);

insert into "user" (user_id,email,"password","name",last_name,active) values(-2,'vasia.furdui@gmail.com','$2a$10$tvdPysi5VIZvjdS492QU5uHmV6Qzhrj1njY9ZtuoXEj9JFWzGuche','Vasile','Furdui',true);
insert into user_role (user_id,role_id) values (-2,2);







