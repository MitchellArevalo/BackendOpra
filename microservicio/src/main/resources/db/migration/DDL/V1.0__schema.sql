
CREATE TABLE newopra.clientes
(
    id INT NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1),
    cliente_name VARCHAR (255) NOT NULL,
    cliente_email VARCHAR (255) NOT NULL,
    cliente_identity VARCHAR (255) NOT NULL,
    cliente_address VARCHAR (255) NOT NULL,
    cliente_phone_number VARCHAR (255) NOT NULL,
    cliente_username VARCHAR (255) NOT NULL,
    cliente_password VARCHAR (255) NOT NULL,
    PRIMARY KEY (id),
    UNIQUE (cliente_identity, cliente_username, cliente_email)
);


CREATE TABLE modulos
(
    id INT NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    module_name VARCHAR (255) NOT NULL,
    module_permission boolean NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE roles
(
    id INT NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    rol_name VARCHAR (255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE modulosRoles
(
    rol_id INT NOT NULL,
    module_id INT NOT NULL,
    CONSTRAINT module_id FOREIGN KEY (module_id)
        REFERENCES modulos(id)
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT rol_id FOREIGN KEY (rol_id)
        REFERENCES roles(id)
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

CREATE TABLE personas
(
    id INT NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    persona_avatar TEXT,
    persona_username VARCHAR (255) NOT NULL,
    persona_password VARCHAR (255) NOT NULL,
    persona_document VARCHAR (255) NOT NULL,
    persona_name VARCHAR (255) NOT NULL,
    persona_email VARCHAR (255) NOT NULL,
    persona_phone_number VARCHAR (255) NOT NULL,
    rol_id INT NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT rol_id FOREIGN KEY (rol_id)
    REFERENCES roles(id)
    ON UPDATE NO ACTION
    ON DELETE NO ACTION,
    UNIQUE (persona_username),
    UNIQUE (persona_document),
    UNIQUE (persona_email)
);

CREATE TABLE ordenCompraProvedor
(
    orden_fechacompra date NOT NULL,
    proveedor_id INT,
    persona_id INT,
    CONSTRAINT persona_id FOREIGN KEY (persona_id)
        REFERENCES personas (id)
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

CREATE TABLE proveedor
(
    id INT NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    proveedor_name VARCHAR (255) NOT NULL,
    proveedor_document_identity VARCHAR (255) NOT NULL,
    proveedor_phone_number VARCHAR (255) NOT NULL,
    PRIMARY KEY (id)
);

ALTER TABLE ordenCompraProvedor ADD CONSTRAINT proveedor_id FOREIGN KEY (proveedor_id) REFERENCES proveedor(id) ON UPDATE NO ACTION ON DELETE NO ACTION;

CREATE TABLE detalleCompraProveedor
(
    id INT NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1),
    proveedor_id INT NOT NULL,
    detallecompra_quantity INT NOT NULL,
    detallecompra_producto_precio_compra INT NOT NULL,
    producto_id INT NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT proveedor_id FOREIGN KEY (proveedor_id)
    REFERENCES proveedor(id)
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
);


CREATE TABLE productos
(
    id INT NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1),
    producto_name VARCHAR (255) NOT NULL,
    producto_size VARCHAR (255) NOT NULL,
    producto_family VARCHAR (255) NOT NULL,
    producto_color VARCHAR (255) NOT NULL,
    producto_style VARCHAR (255) NOT NULL,
    producto_description VARCHAR (255) NOT NULL,
    producto_precio_venta INT NOT NULL,
    producto_stock INT,
    detallecompra_id INT NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT detallecompra_id FOREIGN KEY (detallecompra_id)
    REFERENCES detalleCompraProveedor (id)
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
);

ALTER TABLE detalleCompraProveedor ADD CONSTRAINT producto_id FOREIGN KEY (producto_id) REFERENCES productos (id) ON UPDATE NO ACTION ON DELETE NO ACTION;


CREATE TABLE categorias
(
    id INT NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 ),
    categoria_nombre VARCHAR (255) NOT NULL,
    producto_id INT NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT producto_id FOREIGN KEY (producto_id)
    REFERENCES productos (id)
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
);

CREATE TABLE detalleVenta
(
    id INT NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    detalle_quantity INT NOT NULL,
    detalle_fecha_venta date,
    producto_id INT NOT NULL,
    cliente_id INT NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT cliente_id FOREIGN KEY (cliente_id)
    REFERENCES clientes (id)
    ON UPDATE NO ACTION
    ON DELETE NO ACTION,
    CONSTRAINT producto_id FOREIGN KEY (producto_id)
    REFERENCES productos (id)
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
);