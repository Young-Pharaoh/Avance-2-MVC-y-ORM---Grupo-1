package controller;

import java.io.IOException;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet. http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.tuempresa. model.Producto;
import com.tuempresa.dao.ProductoDAO;
import com.tuempresa.dao.ProductoDAOImpl;

@WebServlet("/producto")
public class ProductoServlet extends HttpServlet {
    
    private ProductoDAO productoDAO;
    
    @Override
    public void init() throws ServletException {
        productoDAO = new ProductoDAOImpl();
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        String action = request.getParameter("action");
        
        if (action == null) {
            action = "lista";
        }
        
        switch (action) {
            case "detalle":
                mostrarDetalle(request, response);
                break;
            case "lista": 
                mostrarLista(request, response);
                break;
            case "disponibles":
                mostrarDisponibles(request, response);
                break;
            case "nuevos":
                mostrarNuevos(request, response);
                break;
            case "usados":
                mostrarUsados(request, response);
                break;
            default:
                mostrarLista(request, response);
                break;
        }
    }
    
    private void mostrarDetalle(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        String idParam = request.getParameter("id");
        
        if (idParam != null && ! idParam.isEmpty()) {
            try {
                Long id = Long. parseLong(idParam);
                Producto producto = productoDAO.obtenerPorId(id);
                
                if (producto != null) {
                    // Obtener detalles usando el método del bean
                    Producto detalle = producto.obtenerDetalles();
                    request.setAttribute("producto", detalle);
                    request.getRequestDispatcher("/WEB-INF/views/detalle-producto.jsp").forward(request, response);
                } else {
                    response.sendError(HttpServletResponse.SC_NOT_FOUND, "Producto no encontrado");
                }
            } catch (NumberFormatException e) {
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID inválido");
            }
        } else {
            // Si no hay ID, usar lista estática para demo
            Producto producto = Producto.buscar(0);
            request.setAttribute("producto", producto. obtenerDetalles());
            request.getRequestDispatcher("/WEB-INF/views/detalle-producto.jsp").forward(request, response);
        }
    }
    
    private void mostrarLista(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        List<Producto> productos = productoDAO.obtenerTodos();
        
        // Si no hay productos en BD, usar lista estática
        if (productos.isEmpty()) {
            productos = Producto.obtenerProductos();
        }
        
        request.setAttribute("productos", productos);
        request.getRequestDispatcher("/WEB-INF/views/lista-productos.jsp").forward(request, response);
    }
    
    private void mostrarDisponibles(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        List<Producto> productos = productoDAO. obtenerDisponibles();
        request.setAttribute("productos", productos);
        request.setAttribute("filtro", "Disponibles");
        request.getRequestDispatcher("/WEB-INF/views/lista-productos. jsp").forward(request, response);
    }
    
    private void mostrarNuevos(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        List<Producto> productos = productoDAO.buscarPorCondicion("nuevo");
        request.setAttribute("productos", productos);
        request.setAttribute("filtro", "Nuevos");
        request.getRequestDispatcher("/WEB-INF/views/lista-productos.jsp").forward(request, response);
    }
    
    private void mostrarUsados(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        List<Producto> productos = productoDAO.buscarPorCondicion("usado");
        request.setAttribute("productos", productos);
        request.setAttribute("filtro", "Usados");
        request.getRequestDispatcher("/WEB-INF/views/lista-productos.jsp").forward(request, response);
    }
    
    @Override
    public void destroy() {
        if (productoDAO instanceof ProductoDAOImpl) {
            ((ProductoDAOImpl) productoDAO).close();
        }
    }
}