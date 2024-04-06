CREATE TABLE IF NOT EXISTS Content (
--     id SERIAL PRIMARY KEY ,  -- for postgres im am assuming.
    id INTEGER AUTO_INCREMENT,
    title varchar(255) NOT NULL,
    description text,
    status VARCHAR(20) NOT NULL,
    content_type VARCHAR(50) NOT NULL,
    date_created TIMESTAMP NOT NULL,
    date_updated TIMESTAMP,
    url VARCHAR(255),
    primary key (id)
);

INSERT INTO Content(title, description, status, content_type, date_created)
VALUES ( 'Testing Title', 'A description', 'IDEA', 'ARTICLE', CURRENT_TIMESTAMP() )