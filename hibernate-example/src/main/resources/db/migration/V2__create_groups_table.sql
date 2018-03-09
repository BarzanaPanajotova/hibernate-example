CREATE TABLE groups (
	id BIGINT NOT NULL,
	name VARCHAR(255),
	user_id BIGINT,
	PRIMARY KEY (id),
	CONSTRAINT groups_users_fk FOREIGN KEY (user_id) REFERENCES users
);

CREATE TABLE group_seq (next_val BIGINT);
INSERT INTO group_seq VALUES ( 1 );
 