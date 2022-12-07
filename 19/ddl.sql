
CREATE TABLE account(
	id serial,
	name varchar(64) not null,
	mail varchar(256) not null unique,
	salt varchar(32) not null,
	password varchar(64) not null,
	created_at timestamp,
	primary key(id)
);

CREATE TABLE employment_exam (
	id serial,
	company_name varchar(128) not null,
	exam_date date,
	account_id integer not null,
	note text not null,
	created_at timestamp,
	primary key(id),
	foreign key(account_id) references account(id)
);

