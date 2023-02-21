CREATE DATABASE CanastaCampesina; 

CREATE TABLE USUARIO(
Cedula INT NOT NULL PRIMARY KEY,
Usuario VARCHAR(64) UNIQUE NOT NULL,
Contraseña VARCHAR(64) NOT NULL,
Nombre VARCHAR(64) NOT NULL,
Apellido VARCHAR(64) NOT NULL,
Email VARCHAR(64) UNIQUE NOT NULL,
Telefono VARCHAR(10) UNIQUE NOT NULL,
Rol VARCHAR(20) NOT NULL
);

CREATE TABLE PRODUCTOS(
id_producto INT NOT NULL PRIMARY KEY, 
nombre VARCHAR(64),
categoria VARCHAR(64),
precio FLOAT(40),
cantidad INTEGER
);

CREATE TABLE PEDIDO (
num_pedido INT NOT NULL PRIMARY KEY,
cc_usuario INT NOT NULL UNIQUE, 
valor_total FLOAT,
domicilio VARCHAR(40), 
fecha DATE, 
FOREIGN KEY (cc_usuario) REFERENCES usuario(cedula)
);

CREATE TABLE DETALLE_PEDIDO (
id_detalles SERIAL PRIMARY KEY,
cantidad_pedido INT,
id_pedido INT NOT NULL UNIQUE,
id_producto INT NOT NULL UNIQUE, 
FOREIGN KEY (id_pedido) REFERENCES pedido (num_pedido),
FOREIGN KEY (id_producto) REFERENCES productos(id_producto)
);
