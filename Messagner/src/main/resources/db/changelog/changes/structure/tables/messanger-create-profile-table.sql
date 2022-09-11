create table `profile`(
	`id` bigint not null auto_increment,
    `first_name` varchar(45) default null,
    `last_name` varchar(45) default null,
    `gender` varchar(20) default null,
    `birth_date` Date default null,
    `person_id` bigint not null,
	`created_at` datetime not null,
    `updated_at` datetime not null,
    `blocked` bit(1) default b'0',
    primary key (`id`),
    key `INDX_PERSON_ID`(`person_id`),
    constraint `FK_USER_PROFILE` foreign key (`person_id`) references `person` (`id`) on update cascade on delete cascade
);