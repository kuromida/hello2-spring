create table member
(
 id bigint generated by default as identity, => ( id값 자동생성)
 name varchar(255),
 primary key (id)
);
