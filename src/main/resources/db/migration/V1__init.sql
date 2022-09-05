create table batch
(
    id        int auto_increment
        primary key,
    priority  int          null,
    comment   varchar(256) null,
    createdAt datetime     null,
    updatedAt datetime     null
);

create table product
(
    id          int auto_increment
        primary key,
    upc         varchar(32)  null,
    shortName   varchar(32)  null,
    fullName    varchar(128) null,
    description varchar(256) null,
    price       int          null
);

create table user
(
    id       int auto_increment
        primary key,
    username varchar(16) not null,
    email    varchar(32) null,
    phone    varchar(12) not null,
    balance  int         not null,
    enabled  tinyint(1)  not null
);

create table transaction
(
    id        int auto_increment
        primary key,
    amount    int      null,
    productId int      null,
    userId    int      null,
    createdAt datetime null,
    updatedAt datetime null,
    constraint transaction_product_id_fk
        foreign key (productId) references nft.product (id),
    constraint transaction_user_id_fk
        foreign key (userId) references nft.user (id)
);

