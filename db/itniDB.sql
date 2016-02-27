-- Database: testdb1

-- DROP DATABASE testdb1;

CREATE DATABASE testdb1
  WITH OWNER = postgres
       ENCODING = 'UTF8'
       TABLESPACE = pg_default
       LC_COLLATE = 'Russian_Russia.1251'
       LC_CTYPE = 'Russian_Russia.1251'
       CONNECTION LIMIT = -1;


-- Table: public.nomenclature

-- DROP TABLE public.nomenclature;

CREATE TABLE public.nomenclature
(
  id integer NOT NULL,
  name character varying(100),
  comment character varying(500),
  CONSTRAINT "aaa_pk_Id" PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.nomenclature
  OWNER TO postgres;
