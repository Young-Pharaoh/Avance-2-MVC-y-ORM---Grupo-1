package servlet;

import controlador.ExplorarCatalogoController;
import modelo.Producto;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet que maneja las solicitudes HTTP para el caso de uso 
 * "Explorar Catálogo de Productos"
 * 
 * Enruta las solicitudes al controlador y redirige a las vistas apropidas.
 */
public class ExplorarCatalogoServlet extends HttpServlet {
    
    private ExplorarCatalogoController controlador;
    
    @Override
    public void init() throws ServletException {
        super.init();
        controlador = new ExplorarCatalogoController();
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        String action = request.getParameter("action");
        
        try {
            if (action == null || action.equals("listar")) {
                listarProductos(request, response);
            } else if (action.equals("buscar")) {
                buscarProducto(request, response);
            } else if (action.equals("detalles")) {
                verDetallesProducto(request, response);
            } else {
                mostrarError(request, response, "Acción no reconocida");
            }
        } catch (Exception e) {
            mostrarError(request, response, e.getMessage());
        }
    }
    
    /**
     * Lista todos los productos del catálogo
     */
    private void listarProductos(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        try {
            List<Producto> productos = controlador.verListaProductos();
            request.setAttribute("productos", productos);
            request.setAttribute("mensaje", "Catálogo de Productos");
            request.getRequestDispatcher("/jsp/PantallaCatalogo.jsp").forward(request, response);
        } catch (Exception e) {
            mostrarError(request, response, "Error al cargar el catálogo");
        }
    }
    
    /**
     * Busca un producto por nombre
     */
    private void buscarProducto(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        try {
            String busqueda = request.getParameter("busqueda");
            
            if (busqueda == null || busqueda.trim().isEmpty()) {
                mostrarError(request, response, "Por favor, ingrese un nombre de producto");
                return;
            }
            
            List<Producto> productos = controlador.buscarProducto(busqueda);
            
            if (productos == null || productos.isEmpty()) {
                mostrarError(request, response, "El producto '" + busqueda + "' no está disponible");
                return;
            }
            
            request.setAttribute("productos", productos);
            request.setAttribute("mensaje", "Resultados para: " + busqueda);
            request.getRequestDispatcher("/jsp/PantallaCatalogo.jsp").forward(request, response);
        } catch (Exception e) {
            mostrarError(request, response, "Error en la búsqueda");
        }
    }
    
    /**
     * Muestra los detalles de un producto específico
     */
    private void verDetallesProducto(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        try {
            String idParam = request.getParameter("id");
            
            if (idParam == null || idParam.trim().isEmpty()) {
                mostrarError(request, response, "ID de producto no especificado");
                return;
            }
            
            int id = Integer.parseInt(idParam);
            Producto producto = controlador.obtenerDetallesProducto(id);
            
            request.setAttribute("producto", producto);
            request.getRequestDispatcher("/jsp/DetallesProducto.jsp").forward(request, response);
        } catch (NumberFormatException e) {
            mostrarError(request, response, "ID de producto inválido");
        } catch (Exception e) {
            mostrarError(request, response, e.getMessage());
        }
    }
    
    /**
     * Muestra la vista de error
     */
    private void mostrarError(HttpServletRequest request, HttpServletResponse response, String mensaje) 
            throws ServletException, IOException {
        request.setAttribute("mensaje", mensaje);
        request.getRequestDispatcher("/jsp/MensajeError.jsp").forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        doGet(request, response);
    }
}
