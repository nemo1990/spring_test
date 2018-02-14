CREATE DATABASE IF NOT EXISTS spring;

USE spring;
CREATE TABLE book(
	isbn VARCHAR(50) PRIMARY KEY,
	book_name VARCHAR(100),
	price INT
);

CREATE TABLE book_stock(
	isbn VARCHAR(50) PRIMARY KEY,
	stock INT,
	CHECK(stock > 0)
);

CREATE TABLE account(
	username VARCHAR(50) PRIMARY KEY,
	balance INT,
	CHECK(balance > 0)
);

INSERT INTO book VALUES(1001, 'Java', 100);
INSERT INTO book VALUES(1002, 'Oracle', 70);
INSERT INTO account VALUES('AA', 160);
INSERT INTO book_stock VALUES(1001, 4);
INSERT INTO book_stock VALUES(1002, 8);

