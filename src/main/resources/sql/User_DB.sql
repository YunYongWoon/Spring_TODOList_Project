create table Users(
                      ID bigint not null auto_increment primary key,
                      AccountID varchar(16) not null unique,
                      Password varchar(100) not null,
                      created_at TIMESTAMP default CURRENT_TIMESTAMP,
                      updated_at TIMESTAMP default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP);
