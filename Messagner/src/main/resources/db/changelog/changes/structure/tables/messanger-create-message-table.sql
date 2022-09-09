create table `message`(
	`id` bigint not null auto_increment,
	`created_at` datetime not null,
    `updated_at` datetime not null,
    `sender_id` bigint not null,
    `chat_id` bigint not null,
    `text` blob not null,
    primary key (`id`),
    key `INDX_USER_ID`(`sender_id`),
    key `INDX_CHAT_ID`(`chat_id`),
    constraint `FK_FROM_USER_MESSAGE` foreign key (`sender_id`)  references `user`(`id`),
    constraint `FK_CHAT_MESSAGE` foreign key (`chat_id`) references`chat`(`id`)
);