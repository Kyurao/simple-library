create table users
(
    id               bigint       not null,
    email            varchar(255),
    phone_number     varchar(255),
    date_of_birthday date,
    first_name       varchar(255) not null,
    id_card          varchar(255),
    last_name        varchar(255) not null,
    primary key (id)
);

alter table users
    add constraint UK_USERS_ID_CARD unique (id_card);

create table book
(
    id               bigint not null,
    author           varchar(255),
    name             varchar(255),
    publication_year integer,
    state            varchar(255),
    user_id          bigint,
    primary key (id)
);

alter table book
    add constraint FK_CLIENT_ID foreign key (user_id) references users;




