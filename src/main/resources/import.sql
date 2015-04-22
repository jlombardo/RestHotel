-- CREATE SCHEMA HOTELS;
-- CREATE TABLE HOTEL(id INT IDENTITY PRIMARY KEY NOT NULL,address VARCHAR(255),city VARCHAR(50),name VARCHAR(50),zip VARCHAR(25));
--
-- Sample dataset containing a number of Hotels in various Cities across the world.
--

-- =================================================================================================
-- AUSTRALIA

-- Brisbane
insert into hotel(address, city, name, zip) values ('William & George Streets', 'Brisbane', 'Conrad Treasury Place', '4001');

-- =================================================================================================
-- CANADA

-- Montreal
insert into hotel(address, city, name, zip) values ('1228 Sherbrooke St', 'Montreal', 'Ritz Carlton', 'H3G1H6');

-- =================================================================================================
-- SPAIN

-- Barcelona
insert into hotel(address, city, name, zip) values ('Passeig del Taulat 262-264', 'Barcelona', 'Hilton Diagonal Mar', '08019');

-- =================================================================================================
-- SWITZERLAND

-- Neuchatel
insert into hotel(address, city, name, zip) values ('Esplanade Leopold-Robert 2', 'Neuchatel', 'Hotel Beaulac', '2000');


-- =================================================================================================
-- UNITED KINGDOM

-- Bath
insert into hotel(address, city, name, zip) values ('Weston Road', 'Bath', 'The Bath Priory Hotel', 'BA1 2XT');
insert into hotel(address, city, name, zip) values ('Rossiter Road, Widcombe Basin', 'Bath', 'Bath Travelodge', 'BA2 4JP');

-- London
insert into hotel(address, city, name, zip) values ('Albany Street', 'London', 'Melia White House', 'NW1 3UP');

-- Southampton
insert into hotel(address, city, name, zip) values ('The Cottage, Southampton Business Park', 'Southampton', 'Chilworth Manor', 'SO16 7JF');


-- =================================================================================================
-- USA

-- Atlanta
insert into hotel(address, city, name, zip) values ('Tower Place, Buckhead', 'Atlanta', 'Marriott Courtyard', '30305');
insert into hotel(address, city, name, zip) values ('Peachtree Rd, Buckhead', 'Atlanta', 'Ritz Carlton', '30326');

-- Chicago
insert into hotel(address, city, name, zip) values ('171 West Randolph Street', 'Chicago', 'Hotel Allegro', '60601');
