create table DB_name(
                        idx int not null auto_increment primary key,
                        TODO varchar(200) not null,
                        Due_Time TIMESTAMP,
                        created_at TIMESTAMP default CURRENT_TIMESTAMP);
