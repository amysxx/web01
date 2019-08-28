create table user
(
    id       int(11) primary key not null auto_increment,
    username varchar(255),
    password varchar(255),
    sex      varchar(255),
    age      int(11)
)