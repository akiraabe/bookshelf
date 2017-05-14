CREATE SEQUENCE if not exists hibernate_sequence
INCREMENT 1
MINVALUE 1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

CREATE TABLE if not exists book
(
  id bigint NOT NULL,
  author character varying(255),
  publish_date date,
  publisher character varying(255),
  title character varying(255),
  CONSTRAINT book_pkey PRIMARY KEY (id)
)
WITH (
OIDS=FALSE
);

CREATE TABLE if not exists category
(
  id bigint NOT NULL,
  name character varying(255),
  CONSTRAINT category_pkey PRIMARY KEY (id)
)
WITH (
OIDS=FALSE
);

CREATE TABLE if not exists book_category_list
(
  book_id bigint NOT NULL,
  category_list_id bigint NOT NULL,
  CONSTRAINT fk_const_to_book1 FOREIGN KEY (book_id)
  REFERENCES book (id) MATCH SIMPLE
  ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_const_to_category1 FOREIGN KEY (category_list_id)
  REFERENCES category (id) MATCH SIMPLE
  ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
OIDS=FALSE
);