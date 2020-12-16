drop schema if exists project0 cascade;
create schema project0;
set schema 'project0';


create table users (
	
	user_id serial unique primary key,
	firstname text not null,
	lastname text not null,
	user_name text unique not null,
	pssword text not null,
	security_level int check (security_level >= 0 and  security_level < 3)
);

create table account (

	accountid serial unique primary key,
	userid int unique references users (user_id),
	ballence double precision not null,
	status int check(status >= 0 and status <3)

);

 ALTER SEQUENCE account_accountid_seq RESTART WITH 1000 ;


create table transfer (

	transaction_id serial unique primary key,
	from_account_acid int references account (accountid) not null,
	to_account_acid int not null,
	amount double precision not null,
	approval int check(approval >=0 and approval <3)
	

);



   ALTER SEQUENCE users_user_id_seq RESTART WITH 1000 ;

insert into users ( firstname, lastname, user_name, pssword, security_level)
           values('Arjun', 'patel', 'arjun22', '7829', 0);
           
        select * from users;
 insert into users ( firstname, lastname, user_name, pssword, security_level)
           values('Arjun', 'patel', 'arjun21', '7829', 1);
 
 insert into users ( firstname, lastname, user_name, pssword, security_level)
           values('Arjun', 'patel', 'arjun20', '7829', 2);
       
       
 select user_id from users 
 where user_name = 'arjun22' and pssword = '7829';
 
select accountid from account where userid


select firstname, lastname, a.accountid, t.amount 
from users u  
inner join 
account a on a.userid = a.userid 
inner join 
transfer t on a.accountid = t.from_account_acid
where t.approval =0 ;


