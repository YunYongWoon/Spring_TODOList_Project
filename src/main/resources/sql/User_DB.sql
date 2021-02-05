create table Users(
                        User_ID bigint not null auto_increment primary key,
                        User_AccountID varchar(15) not null unique,
                        User_Password varchar(20) not null,
                        created_at TIMESTAMP default CURRENT_TIMESTAMP,
                        updated_at TIMESTAMP default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP);