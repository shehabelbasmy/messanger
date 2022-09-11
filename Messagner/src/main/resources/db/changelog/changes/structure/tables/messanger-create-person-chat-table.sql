create table `person-chat`(
    `chat_id` bigint not null,
    `person_id` bigint not null,
    primary key (`person_id`,`chat_id`),
    constraint `FK_USER_USER_CHAT` foreign key (`person_id`) references `person`(`id`),
    constraint `FK_CHAT_USER_CHAT` foreign key (`chat_id`) references `chat`(`id`)
);