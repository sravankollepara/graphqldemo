CREATE TABLE regions
  (
    region_id INT AUTO_INCREMENT  PRIMARY KEY,
    region_name VARCHAR2( 50 ) NOT NULL
  );
-- countries table
CREATE TABLE countries
  (
    country_id   CHAR( 2 ) PRIMARY KEY  ,
    country_name VARCHAR2( 40 ) NOT NULL,
    region_id    NUMBER
  );

-- location
CREATE TABLE locations
  (
    location_id INT AUTO_INCREMENT  PRIMARY KEY       ,
    address     VARCHAR2( 255 ) NOT NULL,
    postal_code VARCHAR2( 20 )          ,
    city        VARCHAR2( 50 )          ,
    state       VARCHAR2( 50 )          ,
    country_id  CHAR( 2 )
  );
-- warehouses
CREATE TABLE warehouses
  (
    warehouse_id                  INT AUTO_INCREMENT  PRIMARY KEY,
    warehouse_name VARCHAR( 255 ) ,
    location_id    NUMBER( 12, 0 )
  );
-- employees
CREATE TABLE employees
  (
    employee_id
                INT AUTO_INCREMENT  PRIMARY KEY,
    first_name VARCHAR( 255 ) NOT NULL,
    last_name  VARCHAR( 255 ) NOT NULL,
    email      VARCHAR( 255 ) NOT NULL,
    phone      VARCHAR( 50 ) NOT NULL ,
    hire_date  VARCHAR(50) NOT NULL          ,
    manager_id NUMBER( 12, 0 )        , -- fk
    job_title  VARCHAR( 255 ) NOT NULL
  );
-- product category
CREATE TABLE product_categories
  (
    category_id
               INT AUTO_INCREMENT  PRIMARY KEY,
    category_name VARCHAR2( 255 ) NOT NULL
  );

-- products table
CREATE TABLE products
  (
    product_id
              INT AUTO_INCREMENT  PRIMARY KEY,
    product_name  VARCHAR2( 255 ) NOT NULL,
    description   VARCHAR2( 2000 )        ,
    standard_cost NUMBER( 9, 2 )          ,
    list_price    NUMBER( 9, 2 )          ,
    category_id   NUMBER NOT NULL
  );
-- customers
CREATE TABLE customers
  (
    customer_id INT AUTO_INCREMENT  PRIMARY KEY,
    name         VARCHAR2( 255 ) NOT NULL,
    address      VARCHAR2( 255 )         ,
    website      VARCHAR2( 255 )         ,
    credit_limit NUMBER( 8, 2 )
  );
-- contacts
CREATE TABLE contacts
  (
    contact_id INT AUTO_INCREMENT  PRIMARY KEY,
    first_name  VARCHAR2( 255 ) NOT NULL,
    last_name   VARCHAR2( 255 ) NOT NULL,
    email       VARCHAR2( 255 ) NOT NULL,
    phone       VARCHAR2( 20 )          ,
    customer_id NUMBER
  );
-- orders table
CREATE TABLE orders
  (
    order_id INT AUTO_INCREMENT  PRIMARY KEY,
    customer_id NUMBER( 6, 0 ) NOT NULL, -- fk
    status      VARCHAR( 20 ) NOT NULL ,
    salesman_id NUMBER( 6, 0 )         , -- fk
    order_date  VARCHAR(50) NOT NULL
  );
-- order items
CREATE TABLE order_items
  (
    order_id   NUMBER( 12, 0 )                                , -- fk
    item_id    NUMBER( 12, 0 )                                ,
    product_id NUMBER( 12, 0 ) NOT NULL                       , -- fk
    quantity   NUMBER( 8, 2 ) NOT NULL                        ,
    unit_price NUMBER( 8, 2 ) NOT NULL
  );
-- inventories
CREATE TABLE inventories
  (
    product_id   NUMBER( 12, 0 )        , -- fk
    warehouse_id NUMBER( 12, 0 )        , -- fk
    quantity     NUMBER( 8, 0 ) NOT NULL,
    CONSTRAINT pk_inventories
      PRIMARY KEY( product_id, warehouse_id )
  );