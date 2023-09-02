
CREATE TABLE opraecommerce.clients
(
    id INT NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1),
    client_name VARCHAR (255) NOT NULL,
    client_email VARCHAR (255) NOT NULL,
    client_identity VARCHAR (255) NOT NULL,
    client_address VARCHAR (255) NOT NULL,
    client_phone_number VARCHAR (255) NOT NULL,
    client_password VARCHAR (255) NOT NULL,
    PRIMARY KEY (id),
    UNIQUE (client_identity, client_email)
);


CREATE TABLE modules
(
    id INT NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    module_name VARCHAR (255) NOT NULL,
    module_edit boolean NOT NULL,
    module_create boolean NOT NULL,
    module_delete boolean NOT NULL,
    module_view boolean NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE roles
(
    id INT NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    rol_name VARCHAR (255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE moduleRol
(
    rol_id INT NOT NULL,
    module_id INT NOT NULL,
    CONSTRAINT module_id FOREIGN KEY (module_id)
        REFERENCES modules(id)
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT rol_id FOREIGN KEY (rol_id)
        REFERENCES roles(id)
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

create table notifications
(
    id INT NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    employee_id int not null,
    notification_subject VARCHAR (255) NOT NULL,
    notification_message VARCHAR (255) NOT NULL,
    notification_readed boolean,
    PRIMARY KEY (id)
);

CREATE TABLE employees
(
    id INT NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    employee_avatar TEXT,
    employee_name VARCHAR (50) NOT NULL,
    employee_email VARCHAR (150) NOT NULL,
    employee_password VARCHAR (255) NOT NULL,
    employee_document VARCHAR (255) NOT NULL,
    employee_address VARCHAR (255),
    employee_phone_number VARCHAR (255) NOT NULL,
    employee_active boolean default true,
    employee_notifications_email boolean default false,
    rol_id INT NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT rol_id FOREIGN KEY (rol_id)
    REFERENCES roles(id)
    ON UPDATE NO ACTION
    ON DELETE NO ACTION,
    UNIQUE (employee_document),
    UNIQUE (employee_email)
);

CREATE TABLE sales
(
    id INT NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    sale_product_id int not null,
    employee_id int not null,
    client_id int not null,
    PRIMARY KEY (id),
    CONSTRAINT employee_id FOREIGN KEY (employee_id)
        REFERENCES employees (id)
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT client_id FOREIGN KEY (client_id)
            REFERENCES clients (id)
            ON UPDATE NO ACTION
            ON DELETE NO ACTION
);


create table saleProducts
(
    id INT NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    product_id int not null,
    product_quantity int not null,
    product_unit_price decimal not null,
    product_profit decimal not null,
    product_total decimal not null,
    PRIMARY KEY (id)
);

ALTER TABLE sales ADD CONSTRAINT sale_product_id FOREIGN KEY (sale_product_id) REFERENCES saleProducts(id) ON UPDATE NO ACTION ON DELETE NO ACTION;

CREATE TABLE products
(
    id INT NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1),
    product_name VARCHAR (255) NOT NULL,
    product_item_code VARCHAR (255) NOT NULL,
    product_size VARCHAR (255) NOT NULL,
    product_sales_price DECIMAL NOT NULL,
    product_cost_price DECIMAL NOT NULL,
    product_description VARCHAR (255) NOT NULL,
    product_image TEXT NOT NULL,
    product_stock INT default 0,
    category_id int not null,
    PRIMARY KEY (id)
);

ALTER TABLE saleProducts ADD CONSTRAINT product_id FOREIGN KEY (product_id) REFERENCES products(id) ON UPDATE NO ACTION ON DELETE NO ACTION;

CREATE TABLE category
(
    id INT NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 ),
    category_name VARCHAR (255) NOT NULL,
    PRIMARY KEY (id)
);

ALTER TABLE products ADD CONSTRAINT category_id FOREIGN KEY (category_id) REFERENCES category(id) ON UPDATE NO ACTION ON DELETE NO ACTION;


create table outputProducts
(
    id INT NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1),
    employee_id int not null,
    product_id int not null,
    output_quantity int not null,
    ouput_description VARCHAR (255) NOT NULL,
    output_date DATE,
    PRIMARY KEY (id),
    CONSTRAINT employee_id FOREIGN KEY (employee_id)
            REFERENCES employees (id)
            ON UPDATE NO ACTION
            ON DELETE NO ACTION,
    CONSTRAINT product_id FOREIGN KEY (product_id)
            REFERENCES products (id)
            ON UPDATE NO ACTION
            ON DELETE NO ACTION
);

create table inputProducts
(
    id INT NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1),
    employee_id int not null,
    product_id int not null,
    input_product_cost decimal not null,
    input_description VARCHAR (255) NOT NULL,
    input_quantity int NOT NULL,
    input_date DATE,
    PRIMARY KEY (id),
    CONSTRAINT employee_id FOREIGN KEY (employee_id)
            REFERENCES employees (id)
            ON UPDATE NO ACTION
            ON DELETE NO ACTION,
    CONSTRAINT product_id FOREIGN KEY (product_id)
            REFERENCES products (id)
            ON UPDATE NO ACTION
            ON DELETE NO ACTION
);