package Controlador;

import DAO.CompraDAO;
import dao.ProductoDAO;
import Modelo.Compra;
import modelo.Producto;
import java.io.IOException;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CompraController")
public class CompraController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String idProdParam = request.getParameter("idProducto");
            String cantParam = request.getParameter("cantidad");

            if (idProdParam == null || cantParam == null) {
                response.getWriter().println("Error: Faltan datos del producto.");
                return;
            }

            int idProducto = Integer.parseInt(idProdParam);
            int cantidad = Integer.parseInt(cantParam);

            ProductoDAO productoDAO = new ProductoDAO();
            CompraDAO compraDAO = new CompraDAO();

            Producto producto = productoDAO.obtenerPorId(idProducto);

            if (producto != null && producto.getCantidad() >= cantidad) {
                
                double totalCompra = producto.getPrecio() * cantidad;

                Compra compra = new Compra();
                compra.setFecha(new Date());
                compra.setTotal(totalCompra);
                compra.setIdCliente(1); 

                boolean registrado = compraDAO.registrarCompra(compra);

                if (registrado) {
                    producto.setCantidad(producto.getCantidad() - cantidad);
                    productoDAO.actualizarProducto(producto);

                    Compra compraActualizada = compraDAO.obtenerDatos(compra.getId());

                    request.setAttribute("compra", compraActualizada);
                    request.setAttribute("producto", producto);
                    request.getRequestDispatcher("jsp/resumenCompra.jsp").forward(request, response);
                } else {
                    request.setAttribute("mensaje", "Error al registrar la compra.");
                    request.getRequestDispatcher("jsp/MensajeError.jsp").forward(request, response);
                }
            } else {
                request.setAttribute("mensaje", "Stock insuficiente o producto no encontrado.");
                request.getRequestDispatcher("jsp/MensajeError.jsp").forward(request, response);
            }

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("mensaje", "Error: " + e.getMessage());
            request.getRequestDispatcher("jsp/MensajeError.jsp").forward(request, response);
        }
    }
}
