ALTER TABLE customer_contact ADD email VARCHAR(255);

ALTER TABLE customer_contact ADD CONSTRAINT uc_customer_contact_email UNIQUE (email);