-- Kustutab public schema (mis põhimõtteliselt kustutab kõik tabelid)
DROP SCHEMA public CASCADE;
-- Loob uue public schema vajalikud õigused
CREATE SCHEMA public
-- taastab vajalikud andmebaasi õigused
    GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;




-- SIIA ALLA TULEB VERTABELO TABELITE LOOMISE OSA

-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2022-09-08 11:28:06.399

-- tables
-- Table: contact
CREATE TABLE contact (
    id serial  NOT NULL,
    first_name varchar(255)  NOT NULL,
    last_name varchar(255)  NOT NULL,
    personal_code varchar(11)  NOT NULL,
    phone_number varchar(255)  NOT NULL,
    email varchar(255)  NOT NULL,
    CONSTRAINT contact_ak_1 UNIQUE (personal_code) NOT DEFERRABLE  INITIALLY IMMEDIATE,
    CONSTRAINT contact_ak_2 UNIQUE (email) NOT DEFERRABLE  INITIALLY IMMEDIATE,
    CONSTRAINT contact_pk PRIMARY KEY (id)
);

-- Table: district
CREATE TABLE district (
    id serial  NOT NULL,
    name varchar(255)  NOT NULL,
    CONSTRAINT district_pk PRIMARY KEY (id)
);

-- Table: image
CREATE TABLE image (
    id serial  NOT NULL,
    base64 bytea  NOT NULL,
    CONSTRAINT image_pk PRIMARY KEY (id)
);

-- Table: location
CREATE TABLE location (
    id serial  NOT NULL,
    address varchar(500)  NOT NULL,
    latitude decimal(8,6)  NULL,
    longitude decimal(8,6)  NULL,
    district_id int  NOT NULL,
    CONSTRAINT location_pk PRIMARY KEY (id)
);

-- Table: order
CREATE TABLE "order" (
    id serial  NOT NULL,
    sender_user_id int  NOT NULL,
    receiver_phone_number varchar(255)  NOT NULL,
    courier_user_id int  NULL,
    delivery_date date  NOT NULL,
    from_hour int  NOT NULL,
    to_hour int  NOT NULL,
    comment varchar(500)  NULL,
    status char(1)  NOT NULL,
    shipment_id int  NOT NULL,
    CONSTRAINT order_pk PRIMARY KEY (id)
);

-- Table: order_image
CREATE TABLE order_image (
    id serial  NOT NULL,
    order_id int  NOT NULL,
    image_id int  NOT NULL,
    type char(1)  NULL,
    CONSTRAINT order_image_pk PRIMARY KEY (id)
);

-- Table: pickup_dropoff
CREATE TABLE pickup_dropoff (
    id serial  NOT NULL,
    order_id int  NOT NULL,
    location_id int  NOT NULL,
    type char(1)  NOT NULL,
    CONSTRAINT pickup_dropoff_pk PRIMARY KEY (id)
);

-- Table: role
CREATE TABLE role (
    id serial  NOT NULL,
    name varchar(255)  NOT NULL,
    CONSTRAINT role_pk PRIMARY KEY (id)
);

-- Table: shipment
CREATE TABLE shipment (
    id serial  NOT NULL,
    amount int  NOT NULL,
    description varchar(500)  NULL,
    shipment_price_id int  NOT NULL,
    CONSTRAINT shipment_pk PRIMARY KEY (id)
);

-- Table: shipment_price
CREATE TABLE shipment_price (
    id serial  NOT NULL,
    dimensions varchar(255)  NOT NULL,
    weight int  NOT NULL,
    price int  NOT NULL,
    type varchar(2)  NOT NULL,
    CONSTRAINT shipment_price_pk PRIMARY KEY (id)
);

-- Table: user
CREATE TABLE "user" (
    id serial  NOT NULL,
    user_name varchar(255)  NOT NULL,
    password varchar(255)  NOT NULL,
    contact_id int  NOT NULL,
    is_active boolean  NOT NULL DEFAULT true,
    CONSTRAINT user_ak_1 UNIQUE (user_name) NOT DEFERRABLE  INITIALLY IMMEDIATE,
    CONSTRAINT user_pk PRIMARY KEY (id)
);

-- Table: user_role
CREATE TABLE user_role (
    id serial  NOT NULL,
    user_id int  NOT NULL,
    role_id int  NOT NULL,
    CONSTRAINT user_role_pk PRIMARY KEY (id)
);

-- foreign keys
-- Reference: location_district (table: location)
ALTER TABLE location ADD CONSTRAINT location_district
    FOREIGN KEY (district_id)
    REFERENCES district (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: order_image_image (table: order_image)
ALTER TABLE order_image ADD CONSTRAINT order_image_image
    FOREIGN KEY (image_id)
    REFERENCES image (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: order_image_order (table: order_image)
ALTER TABLE order_image ADD CONSTRAINT order_image_order
    FOREIGN KEY (order_id)
    REFERENCES "order" (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: order_shipment (table: order)
ALTER TABLE "order" ADD CONSTRAINT order_shipment
    FOREIGN KEY (shipment_id)
    REFERENCES shipment (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: order_user_courier (table: order)
ALTER TABLE "order" ADD CONSTRAINT order_user_courier
    FOREIGN KEY (courier_user_id)
    REFERENCES "user" (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: order_user_sender (table: order)
ALTER TABLE "order" ADD CONSTRAINT order_user_sender
    FOREIGN KEY (sender_user_id)
    REFERENCES "user" (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: pickup_dropoff_location (table: pickup_dropoff)
ALTER TABLE pickup_dropoff ADD CONSTRAINT pickup_dropoff_location
    FOREIGN KEY (location_id)
    REFERENCES location (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: pickup_dropoff_order (table: pickup_dropoff)
ALTER TABLE pickup_dropoff ADD CONSTRAINT pickup_dropoff_order
    FOREIGN KEY (order_id)
    REFERENCES "order" (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: shipment_shipment_price (table: shipment)
ALTER TABLE shipment ADD CONSTRAINT shipment_shipment_price
    FOREIGN KEY (shipment_price_id)
    REFERENCES shipment_price (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: user_customer (table: user)
ALTER TABLE "user" ADD CONSTRAINT user_customer
    FOREIGN KEY (contact_id)
    REFERENCES contact (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: user_role_role (table: user_role)
ALTER TABLE user_role ADD CONSTRAINT user_role_role
    FOREIGN KEY (role_id)
    REFERENCES role (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: user_role_user (table: user_role)
ALTER TABLE user_role ADD CONSTRAINT user_role_user
    FOREIGN KEY (user_id)
    REFERENCES "user" (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- End of file.

