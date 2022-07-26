ALTER TABLE customer DROP CONSTRAINT customer_customer_code_key;
ALTER TABLE customer DROP CONSTRAINT customer_vat_number_key;
ALTER TABLE product DROP CONSTRAINT product_product_id_key;
ALTER TABLE inquiry ADD job_category INTEGER;