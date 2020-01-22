DROP TABLE IF EXISTS advert;

CREATE TABLE advert(
id SERIAL NOT NULL PRIMARY KEY,
person_id INTEGER NOT NULL REFERENCES person(id),
head VARCHAR(50) NOT NULL,
body VARCHAR(2000) NOT NULL,
category VARCHAR(50) NOT NULL,
phone_number VARCHAR(12) NOT NULL,
date_of_creation DATE NOT NULL
);