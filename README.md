# Catálogo de Productos - MVC + JPA/EclipseLink

Aplicación web Java con patrón MVC, ORM (EclipseLink) y base de datos MySQL.

## 📋 Requisitos

- Java JDK 8+
- Eclipse IDE
- XAMPP (MySQL + Apache)
- MySQL Connector JDBC (`mysql-connector-j-8.0.33.jar`)

## 🚀 Configuración Rápida

### 1. Base de Datos

En **phpMyAdmin** (http://localhost/phpmyadmin):
1. Ve a la pestaña "SQL"
2. Abre y ejecuta el archivo [`schema.sql`](schema.sql)

### 2. Conectar a Eclipse

1. Añade el JAR al proyecto:
   - Click derecho → **Build Path → Configure Build Path**
   - **Libraries** → **Add External JARs**
   - Selecciona `mysql-connector-j-8.0.33.jar`

### 3. Verificar Conexión

Los archivos de configuración están listos:
- `ORM/src/main/resources/META-INF/persistence.xml` - Configuración JPA
- `ORM/ORMConfig.java` - Credenciales BD

Credenciales:
- Usuario: `root`
- Contraseña: (vacía)
- BD: `catalogo_productos`
- URL: `jdbc:mysql://localhost:3306/catalogo_productos?useSSL=false&serverTimezone=UTC`

## 📁 Estructura

```
├── ORM/                    # Mapeo JPA/EclipseLink
│   └── src/main/resources/META-INF/persistence.xml
├── Modelo/                 # Entidades (Producto, Compra)
├── DAO/                    # Acceso a datos
├── Controlador/            # Servlets
├── jsp/                    # Vistas
├── schema.sql              # Script de BD
└── README.md               # Este archivo
```

## 💾 Base de Datos

**Tablas:** `productos` (7 registros) y `compras`

**Campos de productos:**
- `id` - PK Auto-incremento
- `imagen` - URL de imagen
- `descripcion` - Descripción
- `precio` - DECIMAL(10,2)
- `condicion` - "nuevo" o "usado"
- `disponibilidad` - BOOLEAN

## 🔗 Usar los DAOs

```java
// Obtener productos disponibles
ProductoDAO dao = new ProductoDAOImpl();
List<Producto> productos = dao.obtenerDisponibles();

// Crear una compra
Compra compra = new Compra();
compra.setFecha(new Date());
compra.setTotal(99.99);
compra.setIdCliente(1);

CompraDAO compraDAO = new CompraDAO();
compraDAO.registrarCompra(compra);
```

## 🐛 Solución de Problemas

| Problema | Solución |
|----------|----------|
| "Unknown database" | Ejecuta `schema.sql` en phpMyAdmin |
| "Access denied" | Verifica usuario/contraseña en `persistence.xml` |
| "No driver found" | Añade el MySQL Connector JAR al Build Path |
| Connection refused | MySQL no está corriendo en XAMPP |

## ✅ Características

- ✓ JPA/EclipseLink ORM
- ✓ Patrón MVC
- ✓ MySQL en XAMPP
- ✓ DAOs para Producto y Compra
- ✓ Configuración centralizada

---

**Última actualización:** Enero 20, 2026
