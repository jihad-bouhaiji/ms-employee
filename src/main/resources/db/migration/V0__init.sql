create table employees
(
	employee_id integer not null, 
	active boolean not null,
	date_in_service date not null, 
	employee_number VARCHAR(15), 
	first_name VARCHAR(40),
	last_name VARCHAR(60) not null,
	wage double not null, 
	primary key (employee_id)
);


