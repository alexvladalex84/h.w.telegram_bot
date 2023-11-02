-- liquibase formatted sql


-- changeset alexandr:1
create table notification_task
(
 id         bigserial primary key,
 chat_Id    bigint,
 text       varchar,
 exec_date  timestamp
 );



