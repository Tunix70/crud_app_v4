CREATE TABLE IF NOT EXISTS region
(region_id SERIAL PRIMARY KEY,
 name VARCHAR(10) NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS writer
(writer_id SERIAL PRIMARY KEY,
 firstname VARCHAR (30),
 lastname VARCHAR (30),
 region_id INTEGER
);

CREATE TABLE IF NOT EXISTS post
(post_id SERIAL PRIMARY KEY,
 content TEXT,
 created TIMESTAMP NOT NULL,
 UPDATED TIMESTAMP NOT NULL,
 post_status VARCHAR(10),
 writer_id INTEGER,
 FOREIGN KEY (writer_id) REFERENCES writer (writer_id)
);



