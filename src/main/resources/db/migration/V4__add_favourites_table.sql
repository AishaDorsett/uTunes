DROP TABLE IF EXISTS favourites;

CREATE TABLE favourites (
id bigserial PRIMARY KEY,
user_id bigint NOT NULL references users (id), 
post_id bigint NOT NULL references tunes (id)

);