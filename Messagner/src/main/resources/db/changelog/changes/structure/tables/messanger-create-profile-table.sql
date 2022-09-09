create table `profile`(
	`id` bigint not null auto_increment,
    `first_name` varchar(45) default null,
    `last_name` varchar(45) default null,
    `gender` varchar(20) default null,
    `birth_date` Date default null,
    `user_id` bigint not null,
	`created_at` datetime not null,
    `updated_at` datetime not null,
    primary key (`id`),
    key `INDX_USER_ID`(`user_id`),
    constraint `FK_USER_PROFILE` foreign key (`user_id`) references `user` (`id`) on update cascade on delete cascade
);