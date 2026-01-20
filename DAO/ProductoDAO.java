package dao;

import java.util.List;
import model.Producto;

public interface ProductoDAO {

    // Crear un nuevo producto
    void crear(Producto producto);

    // Obtener un producto por ID
    Producto obtenerPorId(Long id);

    // Obtener todos los productos
    List<Producto> obtenerTodos();

    // Actualizar un producto existente
    void actualizar(Producto producto);

    // Eliminar un producto
    void eliminar(Long id);

    // Buscar productos por condición (nuevo/usado)
    List<Producto> buscarPorCondicion(String condicion);

    // Buscar productos disponibles
    List<Producto> obtenerDisponibles();

    // Verificar disponibilidad de un producto
    boolean verificarDisponibilidad(Long id);

    // Actualizar inventario
    void actualizarInventario(Long id, boolean disponibilidad);
}