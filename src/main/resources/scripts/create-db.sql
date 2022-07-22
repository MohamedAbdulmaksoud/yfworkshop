DROP SCHEMA IF EXISTS yf_workshop;
CREATE SCHEMA yf_workshop;

DROP TABLE IF EXISTS customer;

CREATE TABLE customer (
  	customer_id serial,
	customer_code text UNIQUE CONSTRAINT proper_code CHECK (customer_code ~ '\d{6}'),
  	name text NOT NULL,
	phone text,	
	street text,
	city text,	
	vat_number text UNIQUE CONSTRAINT proper_vat CHECK (vat_number ~ '\d{3}-\d{3}-\d{3}'),	   
  	PRIMARY KEY (customer_id)
  	
);

DROP TABLE IF EXISTS customer_contact;

CREATE TABLE customer_contact (
  customer_contact_id serial,
  first_name text NOT NULL,
  last_name text DEFAULT NULL,
  customer_id serial,
  
 PRIMARY KEY (customer_contact_id),
  CONSTRAINT fk_customer 
  	FOREIGN KEY (customer_id) 
  		REFERENCES customer (customer_id) 
);

DROP TABLE IF EXISTS inquiry;

CREATE TABLE inquiry (
  job_number serial,
  created_on TIMESTAMP NOT NULL,
  customer_id serial,
  customer_contact_id serial,
  customer_rfq text NOT NULL,
  job_category job_category NOT NULL,
  PRIMARY KEY (job_number),

CONSTRAINT fk_customer
      		FOREIGN KEY(customer_id) 
	  		REFERENCES customer(customer_id),
CONSTRAINT fk_customer_contact
      		FOREIGN KEY(customer_contact_id) 
	  		REFERENCES customer_contact(customer_contact_id)
);

DROP TABLE IF EXISTS product;

CREATE TABLE product (
  id serial,
  product_id text UNIQUE NOT NULL,
  description text NOT NULL, 
   PRIMARY KEY (id)  
);


DROP TABLE IF EXISTS visual_inspection;

CREATE TABLE visual_inspection (
  id serial,
  line_comment text DEFAULT NULL,
  job_number serial,
  product_id serial,	
  received_by text,

  PRIMARY KEY (id),

  CONSTRAINT fk_job_number 
	  FOREIGN KEY (job_number) 
	  REFERENCES inquiry (job_number)
	  ON DELETE NO ACTION ON UPDATE NO ACTION,

  CONSTRAINT fk_product_id 
	  FOREIGN KEY (product_id) 
	  REFERENCES product (id)
);

DROP TABLE IF EXISTS detailed_inspection;

CREATE TABLE detailed_inspection (
  id serial,
  inspection_id serial,
  product_id serial,
  created_on TIMESTAMP NOT NULL,
  last_updated_on TIMESTAMP NOT NULL,
  submit_by text DEFAULT NULL,
  PRIMARY KEY (id),
  CONSTRAINT fk_product_id 
	  FOREIGN KEY (product_id) 
	  REFERENCES product (id)
	  ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT fk_inspection_id
	  FOREIGN KEY (inspection_id) 
	  REFERENCES visual_inspection (id)	  
);


