create table `user-chat`(
    `chat_id` bigint not null,
    `user_id` bigint not null,
    primary key (`user_id`,`chat_id`),
    constraint `FK_USER_USER_CHAT` foreign key (`user_id`) references `user`(`id`),
    constraint `FK_CHAT_USER_CHAT` foreign key (`chat_id`) references `chat`(`id`)
);