-- Author: Harun Dasteki
-- March 2022
DROP TABLE "Product";
DROP TABLE "Product_Group";
DROP TABLE "belongs";


CREATE TABLE IF NOT EXISTS public."Product"
(
    id SERIAL PRIMARY KEY,
    product_nr integer NOT NULL,
    name character varying(30) NOT NULL,
    name_manufacturer character varying(30),
    ean bigint,
    inhalt name[],
    mhd date
    );

CREATE TABLE IF NOT EXISTS public."Product_Group"
(
    product_group_nr integer,
    name character varying(30),
    id bigint,
    img character varying(35),
    department character varying(30),
    PRIMARY KEY (product_group_nr)
    );

CREATE TABLE IF NOT EXISTS public.belongs
(
    product_nr integer NOT NULL,
    product_group_nr integer NOT NULL,
    PRIMARY KEY (product_nr, product_group_nr)
    );

CREATE SEQUENCE product_sequence
    start 0
  increment 2;


START TRANSACTION;

DELETE FROM "Product";
DELETE FROM "Product_Group";
DELETE FROM "belongs";

INSERT INTO "Product"(id,product_nr, name,name_manufacturer,ean,inhalt,mhd)
VALUES (nextval('product_sequence'),65, 'Snickers', 'Mars Incorporated', 123458,ARRAY ['Taurin', 'Zucker'],'2022-01-15');


INSERT INTO "Product"( id,product_nr, name,name_manufacturer,ean,inhalt,mhd)
VALUES (nextval('product_sequence'),17, 'Effect', 'BNG International Premium', 4025127020997
       ,ARRAY ['Taurin', 'Zucker'],'2022-01-15');

INSERT INTO "Product"(id,product_nr, name,name_manufacturer,ean,inhalt,mhd)
VALUES (nextval('product_sequence'),18, 'Rüber Rübe', 'Zuegg', 4013034730061
       ,ARRAY ['Rübensirup', 'Zucker'],'2023-08-18');

INSERT INTO "Product"(id,product_nr, name,name_manufacturer,ean,inhalt,mhd)
VALUES (nextval('product_sequence'),22, 'Schlagsahne', 'Milbora', 4056489115021
       ,ARRAY ['Schlagsahne', 'Carrageen'],'2022-06-13');

INSERT INTO "Product"(id,product_nr, name,name_manufacturer,ean,inhalt,mhd)
VALUES (nextval('product_sequence'),23, 'Ahorm Sirup', 'Mcennedy', 20177492
       ,ARRAY ['leer'],'2024-11-23');

INSERT INTO "Product"(id,product_nr, name,name_manufacturer,ean,inhalt,mhd)
VALUES (nextval('product_sequence'),24, 'Kaffe Oro', 'Lavazza', 8000070012141
       ,ARRAY ['leer'],'2023-09-30');

INSERT INTO "Product"(id,product_nr, name,name_manufacturer,ean,inhalt,mhd)
VALUES (nextval('product_sequence'),25, 'Instant Getränk', 'King George', 4021155175104
       ,ARRAY ['Orangenpulver', 'Zucker'],'2022-09-01');




INSERT INTO "Product_Group"(product_group_nr, name,id,img,department)
VALUES (65, 'Schokoladentheke', 122, 'path/to/Mars/picture.jpg', 'Süßigkeiten');

INSERT INTO "Product_Group"(product_group_nr, name,id,img,department)
VALUES (17, 'Spirituose', 55, 'path/to/Energy/picture.jpg', 'Getränkeabteilung');

INSERT INTO "Product_Group"(product_group_nr, name,id,img,department)
VALUES (18, 'Trockenwaren', 784, 'path/to/Mars/picture.jpg', 'Frühstücksregal');

INSERT INTO "Product_Group"(product_group_nr, name,id,img,department)
VALUES (22, 'Trockenprodukte', 784, 'path/to//picture.jpg', 'Milchregal');

INSERT INTO "Product_Group"(product_group_nr, name,id,img,department)
VALUES (23, 'Trockenprodukte', 784, 'path/to/Sirup/picture.jpg', 'Frühstücksregal');

INSERT INTO "Product_Group"(product_group_nr, name,id,img,department)
VALUES (24, 'Trocken', 12, 'path/to/kaffe/picture.jpg', 'Kaffe');

INSERT INTO "Product_Group"(product_group_nr, name,id,img,department)
VALUES (25, 'Tee', 664, 'path/to/kaffe/instantgertränk.jpg', 'orange');

commit;
