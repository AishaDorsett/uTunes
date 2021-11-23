DROP TABLE IF EXISTS tunes;

CREATE TABLE tunes (
  id bigserial PRIMARY KEY,
  trackname varchar(250) NOT NULL,
  artistname varchar(250) NOT NULL,
  genre varchar(250) NOT NULL,
  link varchar(250) NOT NULL
);
