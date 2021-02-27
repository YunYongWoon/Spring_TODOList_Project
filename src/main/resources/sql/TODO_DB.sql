create table TODO_Lists(
                           id bigint not null auto_increment primary key,
                           TodoType Enum('TODO','Progress','Done'),
                           Todo varchar(200) not null,
                           user_ID bigint not null,
                           scheduled_at TIMESTAMP,
                           created_at TIMESTAMP default CURRENT_TIMESTAMP,
                           updated_at TIMESTAMP default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
                           is_deleted boolean not null default 0,
                           is_finished boolean not null default 0,
                           is_archieved boolean not null default 0);
