create table usuario (
	id bigserial unique not null,
	name text not null,
	email text unique not null,
	password text not null,

	primary key(id)
);

create table task(
	id bigserial unique not null,
	usuario_fk bigint not null,
	name text not null,
	done boolean not null,
	primary key (id)
);

alter table task add constraint task_user_fk foreign key (usuario_fk) references usuario(id)