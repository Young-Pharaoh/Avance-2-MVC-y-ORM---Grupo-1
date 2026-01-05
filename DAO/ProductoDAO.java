package dao;

import java.util.ArrayList;
import java.util.List;
import modelo.Producto;

/**
 * Data Access Object (DAO) para la entidad Producto
 * 
 * Proporciona métodos para acceder y manipular datos de productos
 * en la base de datos. Implementa operaciones CRUD y búsquedas.
 */
public class ProductoDAO {
    
    /**
     * Obtiene la lista completa de productos
     * 
     * @return Lista de todos los productos disponibles en BD
     */
    public List<Producto> obtenerTodosLosProductos() {
        List<Producto> productos = new ArrayList<>();
        
        try {
            // TODO: Conectar a base de datos real
            // String sql = "SELECT * FROM productos";
            
            // Datos de prueba
            productos.add(new Producto(1, "Laptop Dell", "Laptop de 15 pulgadas", 899.99, 5, "Electrónica"));
            productos.add(new Producto(2, "Mouse Logitech", "Mouse inalámbrico", 29.99, 15, "Accesorios"));
            productos.add(new Producto(3, "Teclado Mecánico", "Teclado RGB", 129.99, 8, "Accesorios"));
            productos.add(new Producto(4, "Monitor LG 24\"", "Monitor Full HD", 199.99, 12, "Electrónica"));
            productos.add(new Producto(5, "Webcam HD", "Webcam 1080p", 59.99, 20, "Accesorios"));
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return productos;
    }
    
    /**
     * Busca productos por nombre (búsqueda parcial con LIKE)
     * 
     * @param nombre Nombre o parte del nombre del producto a buscar
     * @return Lista de productos que coinciden con la búsqueda
     */
    public List<Producto> buscarPorNombre(String nombre) {
        List<Producto> resultados = new ArrayList<>();
        
        try {
            // TODO: Implementar consulta a BD con LIKE
            // String sql = "SELECT * FROM productos WHERE nombre LIKE ?";
            // PreparedStatement ps = conexion.prepareStatement(sql);
            // ps.setString(1, "%" + nombre + "%");
            
            List<Producto> todos = obtenerTodosLosProductos();
            
            for (Producto producto : todos) {
                if (producto.getNombre().toLowerCase().contains(nombre.toLowerCase())) {
                    resultados.add(producto);
                }
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return resultados;
    }
    
    /**
     * Obtiene un producto específico por su ID
     * 
     * @param id ID del producto a obtener
     * @return Producto encontrado, o null si no existe
     */
    public Producto obtenerPorId(int id) {
        try {
            // TODO: Conectar a base de datos real
            // String sql = "SELECT * FROM productos WHERE id = ?";
            
            List<Producto> todos = obtenerTodosLosProductos();
            for (Producto producto : todos) {
                if (producto.getId() == id) {
                    return producto;
                }
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return null;
    }
    
    /**
     * Inserta un nuevo producto en la base de datos
     * 
     * @param producto Producto a insertar
     * @return true si la inserción fue exitosa, false en caso contrario
     */
    public boolean crearProducto(Producto producto) {
        try {
            // TODO: Conectar a base de datos real
            // String sql = "INSERT INTO productos (nombre, descripcion, precio, cantidad, categoria) VALUES (?, ?, ?, ?, ?)";
            
            return true;
            
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    /**
     * Actualiza un producto existente en la base de datos
     * 
     * @param producto Producto con datos actualizados
     * @return true si la actualización fue exitosa, false en caso contrario
     */
    public boolean actualizarProducto(Producto producto) {
        try {
            // TODO: Conectar a base de datos real
            // String sql = "UPDATE productos SET nombre=?, descripcion=?, precio=?, cantidad=?, categoria=? WHERE id=?";
            
            return true;
            
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    /**
     * Elimina un producto de la base de datos
     * 
     * @param id ID del producto a eliminar
     * @return true si la eliminación fue exitosa, false en caso contrario
     */
    public boolean eliminarProducto(int id) {
        try {
            // TODO: Conectar a base de datos real
            // String sql = "DELETE FROM productos WHERE id = ?";
            
            return true;
            
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
