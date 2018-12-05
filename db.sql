# CREATE DATABASE bankapi;

DROP TABLE IF EXISTS customers;

CREATE TABLE customers(
	cname varchar(255),
    customer_addr varchar(255),
    email_addr varchar(255),
    password varchar(25),
    customer_id int,
    PRIMARY KEY (customer_id)
);

DROP TABLE IF EXISTS account;

CREATE TABLE account(
	sort_code varchar(255),
    account_num int,
    balance double,
    account_type varchar(255),
    account_id int,
    customer_id int,
    PRIMARY KEY (account_id),
    FOREIGN KEY (customer_id) REFERENCES customers(customer_id)
);

DROP TABLE IF EXISTS transaction;

CREATE TABLE transaction(
	trans_date timestamp,
    trans_desc varchar(255),
    new_balance double,
    trans_type varchar(255),
    trans_to int,
    trans_id int,
    account_id int,
    PRIMARY KEY (trans_id),
    FOREIGN KEY (trans_to) REFERENCES account(account_id),
    FOREIGN KEY (account_id) REFERENCES account(account_id)
);
    