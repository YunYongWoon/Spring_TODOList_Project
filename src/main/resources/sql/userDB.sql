create table UserDB(
                       idx int not null auto_increment primary key,
                       ID varchar(15) not null unique,
                       password varchar(20) not null,
                       created_at TIMESTAMP default CURRENT_TIMESTAMP);
