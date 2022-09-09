create table `chat`(
	`id` bigint not null auto_increment,
	`name` varchar(20) not null,
	`type` varchar(20) not null,
	`created_at` datetime not null,
    `updated_at` datetime not null,
    primary key(`id`)
);