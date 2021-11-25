DROP TABLE IF EXISTS favourites;

CREATE TABLE favourites (
user_id bigint NOT NULL references users (id), 
tune_id bigint NOT NULL references tunes (id)
);