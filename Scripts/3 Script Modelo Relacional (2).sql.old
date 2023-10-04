


-- Rol
CREATE TABLE Rol (
    rol_id INT AUTO_INCREMENT PRIMARY KEY,
    rol VARCHAR(30) NOT NULL
);



-- Usuario con referencia a Ciudad
CREATE TABLE Usuario (
    usuario_id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(150) NOT NULL,
    email VARCHAR(150) UNIQUE NOT NULL,
    email_verificado BOOLEAN NOT NULL,
    contrasena VARCHAR(64) NOT NULL,
    direccion VARCHAR(64) NOT NULL,
    telefono VARCHAR(10) NOT NULL,
    token TEXT,
    ciudad TEXT
);


-- Rol de Usuario
CREATE TABLE Rol_usuario (
    rol_usuario INT AUTO_INCREMENT PRIMARY KEY,
    rol_id INT NOT NULL,
    usuario_id INT NOT NULL,
    CONSTRAINT FK1_rol_usuario FOREIGN KEY (rol_id) REFERENCES Rol(rol_id),
    CONSTRAINT FK2_rol_usuario FOREIGN KEY (usuario_id) REFERENCES Usuario(usuario_id)
);

-- Tienda
CREATE TABLE Tienda (
    tienda_id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(150) NOT NULL,
    descripcion TEXT NOT NULL
);

-- Categoria
CREATE TABLE Categoria (
    categoria_id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(200) NOT NULL
);

-- Tipo de Producto
CREATE TABLE Tipo_Producto (
    tipo_id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(200) NOT NULL
);

-- Producto
CREATE TABLE Producto (
    producto_id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(150) NOT NULL,
    descripcion TEXT NOT NULL,
    precio DECIMAL(8,2) NOT NULL,
    cantidad INT NOT NULL,
    photo TEXT NOT NULL,
    categoria_id INT NOT NULL,
    tipo_id INT NOT NULL,
    tienda_id INT NOT NULL,
    CONSTRAINT FK1_producto FOREIGN KEY (categoria_id) REFERENCES Categoria(categoria_id),
    CONSTRAINT FK2_producto FOREIGN KEY (tipo_id) REFERENCES Tipo_Producto(tipo_id),
    CONSTRAINT FK3_producto FOREIGN KEY (tienda_id) REFERENCES Tienda(tienda_id)
);

-- Resena
CREATE TABLE Resena (
    resena_id INT AUTO_INCREMENT PRIMARY KEY,
    resena VARCHAR(250) NOT NULL,
    calificacion INT NOT NULL,
    producto_id INT NOT NULL,
    usuario_id INT NOT NULL,
    CONSTRAINT FK1_resena FOREIGN KEY (producto_id) REFERENCES Producto(producto_id),
    CONSTRAINT FK2_resena FOREIGN KEY (usuario_id) REFERENCES Usuario(usuario_id)
);
-- Forma de pago
CREATE TABLE Tipo_Pago (
    tipo_pago_id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    descripcion TEXT
);
-- Venta
CREATE TABLE Venta (
    venta_id INT AUTO_INCREMENT PRIMARY KEY,
    usuario_id INT NOT NULL,
    tipo_pago_id INT NOT NULL,
    CONSTRAINT FK1_venta FOREIGN KEY (usuario_id) REFERENCES Usuario(usuario_id),
    CONSTRAINT FK2_venta FOREIGN KEY (tipo_pago_id) REFERENCES Tipo_Pago(tipo_pago_id)
);




-- Venta_detalle
CREATE TABLE Venta_detalle (
    id_venta_detalle INT AUTO_INCREMENT PRIMARY KEY,
    venta_id INT NOT NULL,
    producto_id INT NOT NULL,
    cantidad INT NOT NULL,
    precio DECIMAL(8,2),
    sub_total DECIMAL(8,2),
    CONSTRAINT FK1_Venta_detalle FOREIGN KEY (producto_id) REFERENCES Producto(producto_id),
    CONSTRAINT FK2_Venta_detalle FOREIGN KEY (venta_id) REFERENCES Venta(venta_id)
);



-- Pedido
CREATE TABLE Pedido (
    pedido_id INT AUTO_INCREMENT PRIMARY KEY,
    usuario_id INT NOT NULL,
    tienda_id INT NOT NULL,
    fecha_pedido DATETIME,
    venta_id INT NOT NULL,
    CONSTRAINT FK1_pedido FOREIGN KEY (usuario_id) REFERENCES Usuario(usuario_id),
    CONSTRAINT FK2_pedido FOREIGN KEY (tienda_id) REFERENCES Tienda(tienda_id),
    CONSTRAINT FK3_pedido FOREIGN KEY(venta_id) REFERENCES Venta(venta_id)
);

-- Estado_Pedido
CREATE TABLE Estado_Pedido (
    estado_pedido_id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL
);

-- Notificacion_Pedido
CREATE TABLE Notificacion_Pedido (
    notificacion_pedido_id INT AUTO_INCREMENT PRIMARY KEY,
    mensaje TEXT NOT NULL,
    fecha_hora_creacion DATETIME,
    pedido_id INT NOT NULL,
    estado_pedido_id INT NOT NULL,
    usuario_id INT NOT NULL,
    CONSTRAINT FK1_notificacion_pedido FOREIGN KEY (pedido_id) REFERENCES Pedido(pedido_id),
    CONSTRAINT FK2_notificacion_pedido FOREIGN KEY (estado_pedido_id) REFERENCES Estado_Pedido(estado_pedido_id),
    CONSTRAINT FK3_notificacion_pedido FOREIGN KEY (usuario_id) REFERENCES Usuario(usuario_id)
);



-- Pruebas
INSERT INTO Rol (rol) VALUES
('Admin'),
('Usuario'),
('Moderador'),
('Cliente'),
('Invitado');


-- Usuario
INSERT INTO Usuario (nombre, email, email_verificado, contrasena, direccion, telefono, token, ciudad) VALUES
('John Doe', 'johndoe@example.com', 1, 'contrasena1', '123 Main St', '555-1234', NULL, "Guanajuato"),
('Jane Smith', 'janesmith@example.com', 1, 'contrasena2', '456 Elm St', '555-5678', NULL, "Guanajuato"),
('Admin User', 'admin@example.com', 1, 'adminpass', '789 Oak St', '555-9012', NULL, "Guanajuato"),
('Moderator User', 'moderator@example.com', 1, 'moderatorpass', '101 Pine St', '555-3456', NULL,  "Guanajuato"),
('Guest User', 'guest@example.com', 1, 'guestpass', '202 Birch St', '555-7890', NULL,  "Guanajuato");
-- Continuar con inserciones en las otras tablas...

-- ----------------
-- Rol_usuario
INSERT INTO Rol_usuario (rol_id, usuario_id) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5);

-- Tienda
INSERT INTO Tienda (nombre, descripcion) VALUES
('Tienda A', 'Descripción de la Tienda A'),
('Tienda B', 'Descripción de la Tienda B'),
('Tienda C', 'Descripción de la Tienda C'),
('Tienda D', 'Descripción de la Tienda D'),
('Tienda E', 'Descripción de la Tienda E');

-- Categoria
INSERT INTO Categoria (nombre) VALUES
('Electrónica'),
('Ropa'),
('Alimentos'),
('Hogar'),
('Deportes');

-- Tipo de Producto
INSERT INTO Tipo_Producto (nombre) VALUES
('Electrónico'),
('Ropa'),
('Comida'),
('Decoración'),
('Deportes');

-- Producto
INSERT INTO Producto (nombre, descripcion, precio, cantidad, photo, categoria_id, tipo_id, tienda_id) VALUES
('Producto 1', 'Descripción del Producto 1', 100.00, 50, 'imagen1.jpg', 1, 1, 1),
('Producto 2', 'Descripción del Producto 2', 50.00, 100, 'imagen2.jpg', 2, 2, 2),
('Producto 3', 'Descripción del Producto 3', 10.00, 200, 'imagen3.jpg', 3, 3, 3),
('Producto 4', 'Descripción del Producto 4', 30.00, 75, 'imagen4.jpg', 4, 4, 4),
('Producto 5', 'Descripción del Producto 5', 80.00, 30, 'imagen5.jpg', 5, 5, 5);

-- Resena
INSERT INTO Resena (resena, calificacion, producto_id, usuario_id) VALUES
('Buena calidad', 5, 1, 1),
('Me gusta', 4, 2, 2),
('Buen sabor', 4, 3, 3),
('Excelente producto', 5, 4, 4),
('Recomendado', 4, 5, 5);

-- Tipo de Pago
INSERT INTO Tipo_Pago (nombre, descripcion) VALUES
('Tarjeta de Crédito', 'Pago con tarjeta de crédito'),
('PayPal', 'Pago a través de PayPal'),
('Transferencia Bancaria', 'Transferencia electrónica'),
('Efectivo', 'Pago en efectivo'),
('Cheque', 'Pago con cheque');

-- Venta
INSERT INTO Venta (usuario_id, tipo_pago_id) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5);

-- Venta_detalle
INSERT INTO Venta_detalle (venta_id, producto_id, cantidad, precio, sub_total) VALUES
(1, 1, 2, 100.00, 200.00),
(2, 2, 3, 50.00, 150.00),
(3, 3, 5, 10.00, 50.00),
(4, 4, 1, 30.00, 30.00),
(5, 5, 2, 80.00, 160.00);

-- Pedido
INSERT INTO Pedido (usuario_id, tienda_id, fecha_pedido, venta_id) VALUES
(1, 1, NOW(), 1),
(2, 2, NOW(), 2),
(3, 3, NOW(), 3),
(4, 4, NOW(), 4),
(5, 5, NOW(), 5);

-- Estado_Pedido
INSERT INTO Estado_Pedido (nombre) VALUES
('En Proceso'),
('En Ruta de Entrega'),
('Entregado'),
('Cancelado'),
('Pendiente de Pago');

-- Notificacion_Pedido
INSERT INTO Notificacion_Pedido (mensaje, fecha_hora_creacion, pedido_id, estado_pedido_id, usuario_id) VALUES
('Su pedido está en proceso', NOW(), 1, 1, 1),
('Su pedido está en ruta de entrega', NOW(), 2, 2, 2),
('Su pedido ha sido entregado', NOW(), 3, 3, 3),
('Su pedido ha sido cancelado', NOW(), 4, 4, 4),
('Pendiente de pago', NOW(), 5, 5, 5);




-- -----TRANZACCION
START TRANSACTION;

INSERT INTO pedido (pedido_id,fecha_pedido)
VALUES (6, NOW());

INSERT INTO venta_detalle (venta_id, producto_id, cantidad)
VALUES (LAST_INSERT_ID(), 1, 2);

UPDATE producto
SET cantidad = cantidad - 2
WHERE producto_id = 1;

COMMIT;


-- -------procedimiento almacenado
DELIMITER //
CREATE PROCEDURE CrearProducto(
    IN p_nombre VARCHAR(150),IN p_descripcion TEXT,IN p_precio DECIMAL(8,2),IN p_cantidad INT,IN p_photo TEXT,IN p_tienda_id INT)
BEGIN
    DECLARE p_categoria_id INT;
    DECLARE p_tipo_id INT;
    -- En este ejemplo, simplemente se asignan valores aleatorios entre 1 y 5 
    -- porque solo ingrese 5 datos de 5 tipos de categoria
    SET p_categoria_id = FLOOR(1 + RAND() * 5);
    SET p_tipo_id = FLOOR(1 + RAND() * 5);

    INSERT INTO Producto (nombre,descripcion,precio,cantidad,photo,categoria_id,tipo_id,tienda_id)
    VALUES (p_nombre,p_descripcion,p_precio,p_cantidad,p_photo,p_categoria_id,p_tipo_id,p_tienda_id
    );
END//
DELIMITER ;