# Avance 2: MVC y ORM - Grupo 1

## 🎯 Objetivo del Proyecto

Implementación del patrón arquitectónico MVC (Model-View-Controller) con ORM (Object-Relational Mapping) para un sistema de gestión de catálogo de productos.

## 📋 Casos de Uso Implementados

### ✅ Caso de Uso 1: Explorar Catálogo de Productos
- **Estado:** Completamente implementado
- **Descripción:** Permite a los clientes autenticados ver la lista completa de productos y buscar productos específicos por nombre
- **Documentación:** Ver [DOCUMENTACION_CASO_USO_1.md](DOCUMENTACION_CASO_USO_1.md)

## 📁 Estructura del Proyecto

```
Avance-2-MVC-y-ORM---Grupo-1/
├── Modelo/
│   └── Producto.java
├── DAO/
│   └── ProductoDAO.java
├── Controlador/
│   ├── ExplorarCatalogoController.java
│   └── ExplorarCatalogoServlet.java
├── ORM/
│   ├── ormconfig.xml
│   └── ORMConfig.java
├── jsp/
│   ├── PantallaCatalogo.jsp
│   ├── MensajeError.jsp
│   └── DetallesProducto.jsp
├── web.xml
├── DOCUMENTACION_CASO_USO_1.md
└── README.md
```

## 🏗️ Arquitectura MVC

### Modelo (M)
- **Producto.java:** Entidad que representa un producto

### Vista (V)
- **PantallaCatalogo.jsp:** Lista de productos con búsqueda
- **MensajeError.jsp:** Mensajes de error
- **DetallesProducto.jsp:** Detalles de un producto

### Controlador (C)
- **ExplorarCatalogoController.java:** Lógica de negocio
- **ExplorarCatalogoServlet.java:** Manejo de solicitudes HTTP

## 🔌 Capa DAO y ORM

### DAO (Data Access Object)
- **ProductoDAO.java:** Operaciones CRUD y búsquedas

### ORM (Object-Relational Mapping)
- **ormconfig.xml:** Mapeos objeto-relacional
- **ORMConfig.java:** Configuración de conexión

## 🚀 Cómo Utilizar

### 1. Configurar Base de Datos
```sql
CREATE DATABASE catalogo_productos;
USE catalogo_productos;

CREATE TABLE productos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    descripcion TEXT,
    precio DECIMAL(10, 2) NOT NULL,
    cantidad INT NOT NULL,
    categoria VARCHAR(50)
);
```

### 2. Acceder desde el Navegador
- **Ver catálogo:** `http://localhost:8080/app/explorarCatalogo?action=listar`
- **Buscar producto:** `http://localhost:8080/app/explorarCatalogo?action=buscar&busqueda=Laptop`
- **Ver detalles:** `http://localhost:8080/app/explorarCatalogo?action=detalles&id=1`

### 3. Ejemplo de Uso Programático
```java
// Crear controlador
ExplorarCatalogoController controlador = new ExplorarCatalogoController();

// Ver lista de productos
List<Producto> productos = controlador.verListaProductos();

// Buscar producto
List<Producto> resultados = controlador.buscarProducto("Laptop");

// Obtener detalles
Producto producto = controlador.obtenerDetallesProducto(1);
```

## 📦 Dependencias

### JARs Necesarios
- `mysql-connector-java-5.1.49.jar` - Driver JDBC para MySQL
- `javax.servlet-api-3.1.0.jar` - API de Servlets
- `jsp-api-2.3.1.jar` - API de JSP

## ✨ Características Implementadas

- ✅ Patrón MVC completo
- ✅ Patrón DAO para acceso a datos
- ✅ ORM con mapeos XML
- ✅ JSP con HTML5 y CSS3
- ✅ Manejo de errores
- ✅ Búsqueda de productos
- ✅ Interfaz responsiva
- ✅ Documentación completa

## 📝 Documentación

Para más detalles, consulte [DOCUMENTACION_CASO_USO_1.md](DOCUMENTACION_CASO_USO_1.md)

## 👥 Grupo 1

Integrantes del equipo que contribuyeron a este proyecto.

---

**Última actualización:** Enero 2026  
**Estado:** Caso de Uso 1 Completado
