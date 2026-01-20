-- Script para crear la base de datos y tablas en MySQL
-- Ejecutar en phpMyAdmin o: mysql -u root < schema.sql

-- Crear la base de datos
CREATE DATABASE IF NOT EXISTS catalogo_productos;
USE catalogo_productos;

-- Tabla productos
CREATE TABLE IF NOT EXISTS productos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    imagen VARCHAR(500),
    descripcion VARCHAR(1000),
    precio DECIMAL(10, 2) NOT NULL,
    condicion VARCHAR(50),
    disponibilidad BOOLEAN DEFAULT true
) CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Tabla compras
CREATE TABLE IF NOT EXISTS compras (
    id INT AUTO_INCREMENT PRIMARY KEY,
    fecha TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    total DECIMAL(10, 2) NOT NULL,
    id_cliente INT
) CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Insertar datos de ejemplo
INSERT INTO productos (imagen, descripcion, precio, condicion, disponibilidad) VALUES
('images/dark-side-moon.jpg', 'The Dark Side of the Moon - Pink Floyd (1973)', 45.99, 'nuevo', true),
('images/abbey-road.jpg', 'Abbey Road - The Beatles (1969)', 89.99, 'usado', true),
('images/thriller.jpg', 'Thriller - Michael Jackson (1982)', 38.50, 'nuevo', true),
('images/rumours.jpg', 'Rumours - Fleetwood Mac (1977)', 42.00, 'nuevo', false),
('images/nevermind.jpg', 'Nevermind - Nirvana (1991)', 35.99, 'nuevo', true),
('images/back-in-black.jpg', 'Back in Black - AC/DC (1980)', 52.50, 'usado', true),
('images/hotel-california.jpg', 'Hotel California - Eagles (1976)', 67.00, 'usado', false);
