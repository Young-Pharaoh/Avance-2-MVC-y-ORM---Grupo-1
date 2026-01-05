package model;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "productos")
public class Producto implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    @Column(name = "imagen", length = 500)
    private String imagen;
    
    @Column(name = "descripcion", length = 1000)
    private String descripcion;
    
    @Column(name = "precio")
    private double precio;
    
    @Column(name = "condicion", length = 50)
    private String condicion;
    
    @Column(name = "disponibilidad")
    private boolean disponibilidad;
    
    // Lista estática de productos (tienda de vinilos) - para pruebas sin BD
    private static List<Producto> listaProductos = new ArrayList<>();
    
    // Bloque estático para inicializar la lista
    static {
        Producto p1 = new Producto();
        p1.setId(1L);
        p1.setImagen("images/vinilos/dark-side-moon.jpg");
        p1.setDescripcion("The Dark Side of the Moon - Pink Floyd (1973). Álbum conceptual icónico con temas como Money y Time.");
        p1.setPrecio(45.99);
        p1.setCondicion("nuevo");
        p1.setDisponibilidad(true);
        listaProductos.add(p1);
        
        Producto p2 = new Producto();
        p2.setId(2L);
        p2.setImagen("images/vinilos/abbey-road.jpg");
        p2.setDescripcion("Abbey Road - The Beatles (1969). Último álbum grabado por los Beatles.  Incluye Come Together.");
        p2.setPrecio(89.99);
        p2.setCondicion("usado");
        p2.setDisponibilidad(true);
        listaProductos. add(p2);
        
        Producto p3 = new Producto();
        p3.setId(3L);
        p3.setImagen("images/vinilos/thriller.jpg");
        p3.setDescripcion("Thriller - Michael Jackson (1982). El álbum más vendido de todos los tiempos.  Incluye Billie Jean.");
        p3.setPrecio(38.50);
        p3.setCondicion("nuevo");
        p3.setDisponibilidad(true);
        listaProductos.add(p3);
        
        Producto p4 = new Producto();
        p4.setId(4L);
        p4.setImagen("images/vinilos/rumours.jpg");
        p4.setDescripcion("Rumours - Fleetwood Mac (1977). Obra maestra del rock. Contiene Dreams y Go Your Own Way.");
        p4.setPrecio(42.00);
        p4.setCondicion("nuevo");
        p4.setDisponibilidad(false);
        listaProductos.add(p4);
        
        Producto p5 = new Producto();
        p5.setId(5L);
        p5.setImagen("images/vinilos/nevermind.jpg");
        p5.setDescripcion("Nevermind - Nirvana (1991). Álbum que definió el grunge. Con Smells Like Teen Spirit.");
        p5.setPrecio(35.99);
        p5.setCondicion("nuevo");
        p5.setDisponibilidad(true);
        listaProductos.add(p5);
        
        Producto p6 = new Producto();
        p6.setId(6L);
        p6.setImagen("images/vinilos/back-in-black.jpg");
        p6.setDescripcion("Back in Black - AC/DC (1980). Uno de los mejores álbums de hard rock.");
        p6.setPrecio(52.50);
        p6.setCondicion("usado");
        p6.setDisponibilidad(true);
        listaProductos. add(p6);
        
        Producto p7 = new Producto();
        p7.setId(7L);
        p7.setImagen("images/vinilos/hotel-california.jpg");
        p7.setDescripcion("Hotel California - Eagles (1976). Clásico del rock con la icónica canción título.");
        p7.setPrecio(67.00);
        p7.setCondicion("usado");
        p7.setDisponibilidad(false);
        listaProductos.add(p7);
        
        Producto p8 = new Producto();
        p8.setId(8L);
        p8.setImagen("images/vinilos/led-zeppelin-iv.jpg");
        p8.setDescripcion("Led Zeppelin IV (1971). Contiene Stairway to Heaven, Black Dog y Rock and Roll.");
        p8.setPrecio(48.99);
        p8.setCondicion("nuevo");
        p8.setDisponibilidad(true);
        listaProductos.add(p8);
        
        Producto p9 = new Producto();
        p9.setId(9L);
        p9.setImagen("images/vinilos/born-to-run.jpg");
        p9.setDescripcion("Born to Run - Bruce Springsteen (1975). Álbum definitorio del rock americano.");
        p9.setPrecio(41.25);
        p9.setCondicion("nuevo");
        p9.setDisponibilidad(true);
        listaProductos.add(p9);
        
        Producto p10 = new Producto();
        p10.setId(10L);
        p10.setImagen("images/vinilos/the-wall.jpg");
        p10.setDescripcion("The Wall - Pink Floyd (1979). Álbum doble conceptual.  Incluye Another Brick in the Wall.");
        p10.setPrecio(78.00);
        p10.setCondicion("usado");
        p10.setDisponibilidad(true);
        listaProductos.add(p10);
    }
    
    // Constructor vacío (requerido para JavaBean y JPA)
    public Producto() {
    }
    
    // Constructor con parámetros
    public Producto(String imagen, String descripcion, double precio, String condicion, boolean disponibilidad) {
        this.imagen = imagen;
        this.descripcion = descripcion;
        this.precio = precio;
        this.condicion = condicion;
        this.disponibilidad = disponibilidad;
    }
    
    // Getters y Setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getImagen() {
        return imagen;
    }
    
    public void setImagen(String imagen) {
        this.imagen = imagen;
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
    
    public String getCondicion() {
        return condicion;
    }
    
    public void setCondicion(String condicion) {
        this.condicion = condicion;
    }
    
    public boolean isDisponibilidad() {
        return disponibilidad;
    }
    
    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }
    
    // Método obtenerDetalles - Retorna el mismo objeto para usar en JSP
    public Producto obtenerDetalles() {
        return this;
    }
    
    // Método obtenerProductos (retorna la lista estática)
    public static List<Producto> obtenerProductos() {
        return new ArrayList<>(listaProductos);
    }
    
    // Método verificarDisponibilidad
    public boolean verificarDisponibilidad() {
        return this.disponibilidad;
    }
    
    // Método actualizarInventario
    public void actualizarInventario(boolean nuevaDisponibilidad) {
        this.disponibilidad = nuevaDisponibilidad;
    }
    
    // Método buscar por índice (lista estática)
    public static Producto buscar(int id) {
        if (id >= 0 && id < listaProductos.size()) {
            return listaProductos.get(id);
        }
        return null;
    }
    
    // toString
    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", imagen='" + imagen + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", precio=" + precio +
                ", condicion='" + condicion + '\'' +
                ", disponibilidad=" + disponibilidad +
                '}';
    }
}