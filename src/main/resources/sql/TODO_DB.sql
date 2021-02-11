create table TODO_Lists(
                        idx bigint not null auto_increment primary key,
                        Type Enum('TODO','Progress','Done'),
                        TODO varchar(200) not null,
                        User_ID bigint not null,
                        created_at TIMESTAMP default CURRENT_TIMESTAMP,
                        updated_at TIMESTAMP default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP);
