# Caso de Uso 1: Explorar Catálogo de Productos

## Arquitectura Implementada

Patrón **MVC** con capas: Modelo → DAO → Controlador → Vista

---

## Componentes Implementados

### 1. **Modelo** - `Producto.java`
**Representa un producto del catálogo**

Atributos:
- `id`: int - Identificador único
- `nombre`: String - Nombre del producto
- `descripcion`: String - Descripción detallada
- `precio`: double - Precio del producto
- `cantidad`: int - Stock disponible
- `categoria`: String - Categoría del producto

Métodos:
- `Producto()` - Constructor vacío
- `Producto(id, nombre, descripcion, precio, cantidad, categoria)` - Constructor con parámetros
- Getters y setters para todos los atributos
- `toString()` - Representación en string

---

### 2. **DAO** - `ProductoDAO.java`
**Acceso a datos - Implementa operaciones CRUD sobre productos**

Métodos:
- `obtenerTodosLosProductos(): List<Producto>` - Obtiene todos los productos
- `buscarPorNombre(String nombre): List<Producto>` - Búsqueda por nombre (LIKE)
- `obtenerPorId(int id): Producto` - Obtiene un producto específico
- `crearProducto(Producto): boolean` - Inserta nuevo producto
- `actualizarProducto(Producto): boolean` - Actualiza datos de producto
- `eliminarProducto(int id): boolean` - Elimina un producto

---

### 3. **Controlador** - `ExplorarCatalogoController.java`
**Lógica de negocio - Orquesta la consulta de productos**

Métodos:
- `verListaProductos(): List<Producto>` - Obtiene lista completa
- `buscarProducto(String nombre): List<Producto>` - Busca por nombre
- `presentarProducto(String nombre): Producto` - Retorna un producto encontrado
- `obtenerDetallesProducto(int id): Producto` - Obtiene detalles por ID
- `mostrarMensajeError(String mensaje): String` - Formatea mensajes de error

---

### 4. **Servlet** - `ExplorarCatalogoServlet.java`
**Controlador HTTP - Maneja solicitudes web y enruta a vistas**

Métodos:
- `doGet()` - Maneja solicitudes GET
- `doPost()` - Delega a doGet
- `listarProductos()` - Muestra catálogo completo
- `buscarProducto()` - Busca productos
- `verDetallesProducto()` - Muestra detalles
- `mostrarError()` - Muestra página de error

Acciones HTTP:
- `?action=listar` - Ver catálogo
- `?action=buscar&busqueda=nombre` - Buscar producto
- `?action=detalles&id=1` - Ver detalles

---

### 5. **ORM** - `ORMConfig.java`
**Configuración de mapeo objeto-relacional**

Constantes:
- `DB_DRIVER` - Driver MySQL JDBC
- `DB_URL` - URL de conexión a BD
- `DB_USER` - Usuario de BD
- `DB_PASSWORD` - Contraseña de BD

Métodos:
- `inicializar()` - Carga el driver JDBC
- `getDBUrl()`, `getDBUser()`, `getDBPassword()`, `getDBDriver()` - Getters

---

### 6. **ORM Config XML** - `ormconfig.xml`
**Mapeo de entidades a tablas de BD**

- Base de datos: `catalogo_productos`
- Tabla: `productos`
- Mapeo de campos Java a columnas SQL
- Tipos de datos y validaciones

---

### 7. **Vistas JSP**

#### `PantallaCatalogo.jsp`
- Muestra lista de productos en grid responsivo
- Incluye buscador de productos
- Información: nombre, descripción, precio, stock, categoría

#### `MensajeError.jsp`
- Presenta mensajes de error
- Botón para volver al catálogo

#### `DetallesProducto.jsp`
- Muestra detalles completos del producto
- Indicador de stock disponible
- Información de categoría y precio

---

### 8. **Configuración Web** - `web.xml`

Define:
- Servlet: ExplorarCatalogoServlet
- Mapeo URL: `/explorarCatalogo`
- Páginas de error

---

## 🔄 Flujos Implementados

### Flujo 1: Ver Catálogo
```
Cliente → GET /explorarCatalogo?action=listar
        → listarProductos()
        → verListaProductos()
        → obtenerTodosLosProductos()
        → PantallaCatalogo.jsp
```

### Flujo 2: Buscar Producto
```
Cliente → GET /explorarCatalogo?action=buscar&busqueda=Laptop
        → buscarProducto()
        → buscarProducto()
        → buscarPorNombre()
        → PantallaCatalogo.jsp
```

### Flujo 3: Ver Detalles
```
Cliente → GET /explorarCatalogo?action=detalles&id=1
        → verDetallesProducto()
        → obtenerDetallesProducto()
        → obtenerPorId()
        → DetallesProducto.jsp
```

### Flujo 4: Error
```
Excepción → mostrarError()
         → MensajeError.jsp
```

##  URLs de Acceso

```
Catálogo:  http://localhost:8080/app/explorarCatalogo?action=listar
Buscar:    http://localhost:8080/app/explorarCatalogo?action=buscar&busqueda=Laptop
Detalles:  http://localhost:8080/app/explorarCatalogo?action=detalles&id=1
```

---

##  Validaciones Implementadas

- Parámetros no nulos
- Búsqueda no vacía
- ID válido (numérico)
- Producto existe en BD
- Manejo de excepciones
- Mensajes de error claros
