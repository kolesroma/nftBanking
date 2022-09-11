use nft;

alter table transaction
    drop foreign key FK1bkeyn2xhcnk7jnxpj1xvjd5m;
alter table transaction
    drop foreign key FK488qkru416qg1j5djdbr4honw;
alter table transaction
    drop foreign key FKsg7jp0aj6qipr50856wf6vbw1;


alter table batch
    modify id int auto_increment;
alter table batch
    modify created_at datetime not null after priority;

alter table product
    modify id int auto_increment;
alter table product
    modify price int not null after short_name;
alter table product
    modify full_name varchar(255) not null after price;

alter table user
    modify id int auto_increment;
alter table user
    modify balance int not null after email;
alter table user
    modify username varchar(255) not null after id;
alter table user
    modify phone varchar(255) not null after username;

alter table transaction
    modify id int auto_increment;
alter table transaction
    modify created_at datetime not null;
alter table transaction
    modify updated_at datetime not null;
alter table transaction
    modify batch_id int not null;
alter table transaction
    modify product_id int not null;
alter table transaction
    modify user_id int not null;

alter table transaction
    add constraint fk_user_id foreign key
        (user_id) references user (id);

alter table transaction
    add constraint fk_batch_id foreign key
        (batch_id) references batch (id);

alter table transaction
    add constraint fk_product_id foreign key
        (product_id) references product (id);
