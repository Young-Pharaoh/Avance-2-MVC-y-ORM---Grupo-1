package controlador;

import dao.ProductoDAO;
import java.util.List;
import modelo.Producto;

/**
 * Controlador para el caso de uso "Explorar Catálogo de Productos"
 * 
 * Encapsula la lógica de negocio para listar y buscar productos.
 * Coordina la comunicación entre el servlet y el DAO.
 */
public class ExplorarCatalogoController {
    
    private ProductoDAO productoDAO;
    
    /**
     * Constructor - Inicializa el DAO
     */
    public ExplorarCatalogoController() {
        this.productoDAO = new ProductoDAO();
    }
    
    /**
     * Obtiene la lista completa de productos del catálogo
     * Flujo básico paso 1: verListaProductos
     * 
     * @return Lista de todos los productos disponibles
     */
    public List<Producto> verListaProductos() {
        return productoDAO.obtenerTodosLosProductos();
    }
    
    /**
     * Busca un producto por nombre
     * Flujo básico paso 3: buscarProducto
     * 
     * @param nombre Nombre o parte del nombre del producto a buscar
     * @return Lista de productos que coinciden con la búsqueda
     */
    public List<Producto> buscarProducto(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del producto no puede estar vacío");
        }
        return productoDAO.buscarPorNombre(nombre);
    }
    
    /**
     * Presenta un producto al cliente
     * Flujo básico paso 4: presentarProducto
     * 
     * @param nombreProducto Nombre del producto a presentar
     * @return El producto encontrado
     */
    public Producto presentarProducto(String nombreProducto) {
        List<Producto> resultados = buscarProducto(nombreProducto);
        
        if (resultados == null || resultados.isEmpty()) {
            throw new RuntimeException("El producto no está disponible");
        }
        
        return resultados.get(0);
    }
    
    /**
     * Obtiene los detalles de un producto específico por su ID
     * 
     * @param id ID del producto
     * @return Producto con detalles completos
     */
    public Producto obtenerDetallesProducto(int id) {
        Producto producto = productoDAO.obtenerPorId(id);
        if (producto == null) {
            throw new RuntimeException("El producto no está disponible");
        }
        return producto;
    }
    
    /**
     * Formatea un mensaje de error para presentar al cliente
     * Flujo alternativo: mostrarMensaje()
     * 
     * @param mensaje Descripción del error
     * @return Mensaje de error formateado
     */
    public String mostrarMensajeError(String mensaje) {
        return mensaje;
    }
}
