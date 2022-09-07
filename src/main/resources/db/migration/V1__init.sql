create table batch
(
    id         int auto_increment
        primary key,
    priority   int          null,
    comment    varchar(256) null,
    created_at datetime     null,
    updated_at datetime     null
);

create table product
(
    id          int auto_increment
        primary key,
    upc         varchar(32)  null,
    short_name  varchar(32)  null,
    full_name   varchar(128) null,
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
    id         int auto_increment
        primary key,
    amount     int      null,
    product_id int      null,
    user_id    int      null,
    batch_id   int      null,
    created_at datetime null,
    updated_at datetime null,
    constraint transaction_batch_id_fk
        foreign key (batch_id) references nft.batch (id),
    constraint transaction_product_id_fk
        foreign key (product_id) references nft.product (id),
    constraint transaction_user_id_fk
        foreign key (user_id) references nft.user (id)
);
