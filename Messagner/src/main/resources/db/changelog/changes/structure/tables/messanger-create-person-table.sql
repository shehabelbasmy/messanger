create table `person` (
	`id` bigint not null auto_increment,
    `email` varchar(45) not null ,
    `role` varchar(20) not null ,
    `password` varchar(120) not null ,
    `created_at` datetime not null,
    `updated_at` datetime not null,
	primary key(`id`),
    unique key `INDX_EMAIL`(`email`)
);