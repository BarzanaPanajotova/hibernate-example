CREATE TABLE groups (
	id BIGINT NOT NULL,
	name VARCHAR(255),
	user_id BIGINT,
	PRIMARY KEY (id)
);

CREATE TABLE group_seq (next_val BIGINT);
INSERT INTO group_seq VALUES ( 1 );

create table user_group (
	user_id bigint not null,
	group_id bigint not null);

alter table user_group add constraint groups_users_fk foreign key (user_id) references users;
alter table user_group add constraint users_groups_fk foreign key (group_id) references groups;