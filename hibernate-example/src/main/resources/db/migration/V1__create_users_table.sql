CREATE TABLE USERS (
	id BIGINT NOT NULL,
	name VARCHAR(100) NOT NULL,
	email VARCHAR(255),
	age INTEGER,
	username VARCHAR(255),
	password VARCHAR(255),
	PRIMARY KEY (id)
);

CREATE TABLE user_seq (next_val BIGINT);
INSERT INTO user_seq values ( 1 );