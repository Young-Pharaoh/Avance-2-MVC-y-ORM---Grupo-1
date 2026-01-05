package modelo;

/**
 * Entidad Producto - Representa un producto del catálogo
 * 
 * Esta clase modela los datos de un producto con sus atributos
 * y proporciona métodos de acceso para cada uno de ellos.
 */
public class Producto {
    
    private int id;
    private String nombre;
    private String descripcion;
    private double precio;
    private int cantidad;
    private String categoria;
    
    /**
     * Constructor por defecto
     */
    public Producto() {
    }
    
    /**
     * Constructor con parámetros
     */
    public Producto(int id, String nombre, String descripcion, 
                    double precio, int cantidad, String categoria) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.cantidad = cantidad;
        this.categoria = categoria;
    }
    
    // ============= GETTERS Y SETTERS =============
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getDescripcion() {
        return descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public double getPrecio() {
        return precio;
    }
    
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    public int getCantidad() {
        return cantidad;
    }
    
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    public String getCategoria() {
        return categoria;
    }
    
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    
    @Override
    public String toString() {
        return "Producto{" + 
               "id=" + id + 
               ", nombre=" + nombre + 
               ", precio=$" + precio + 
               ", stock=" + cantidad + 
               '}';
    }
}
