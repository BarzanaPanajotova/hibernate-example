create table plots (
	id bigint not null, 
	coordinates varchar(255), 
	culture varchar(255), 
	name varchar(255), 
	user_id bigint, 
	primary key (id));
	
create table plot_seq (next_val bigint);
insert into plot_seq values ( 1 );

alter table plots add constraint plots_users_fk foreign key (user_id) references users;