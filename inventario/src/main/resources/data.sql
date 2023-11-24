CREATE TABLE IF NOT EXISTS Usuario(
    id_usuario SERIAL PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    curp VARCHAR(20) NOT NULL,
    a_paterno VARCHAR(50) NOT NULL,
    a_materno VARCHAR(50) NOT NULL,
    saldo FLOAT NOT NULL
);

CREATE TABLE IF NOT EXISTS Producto
(
    id_producto SERIAL PRIMARY KEY,
    nombre_producto VARCHAR(100) NOT NULL,
    tipo_producto VARCHAR(100) NOT NULL,
    stock INTEGER NOT NULL,
    medida VARCHAR(10) NOT NULL,
    costo FLOAT NOT NULL,
    fecha_adquision DATE NOT NULL,
    fecha_caducidad DATE NOT NULL,
    nombre_proveedor VARCHAR(100) NOT NULL,
    descripcion VARCHAR(100) NOT NULL,
    comentarios VARCHAR(100)
);