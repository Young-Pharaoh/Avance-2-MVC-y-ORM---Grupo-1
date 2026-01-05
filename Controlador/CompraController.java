package Controlador;

import DAO.CompraDAO;
import DAO.ProductoDAO;
import Modelo.Compra;
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
        // 1. Llamar a ProductoDAO.verificarDisponibilidad()
        boolean disponible = ProductoDAO.verificarDisponibilidad();

        if (disponible) {
            // Crear objeto Compra con datos básicos (simulados o del request)
            Compra compra = new Compra();
            compra.setFecha(new Date());
            // En un caso real, el total y el cliente vendrían del carrito o sesión
            compra.setTotal(1500.00); 
            compra.setIdCliente(1); 

            // 2. Si hay disponibilidad, llamar a CompraDAO.registrarCompra()
            CompraDAO compraDAO = new CompraDAO();
            boolean registrado = compraDAO.registrarCompra(compra);

            if (registrado) {
                // 3. Obtener los datos actualizados con CompraDAO.obtenerDatos()
                // Usamos el ID que se generó/asignó en registrarCompra
                Compra compraActualizada = compraDAO.obtenerDatos(compra.getId());

                // 4. Guardar los datos en el request y hacer un forward a la vista
                request.setAttribute("compra", compraActualizada);
                request.getRequestDispatcher("jsp/resumenCompra.jsp").forward(request, response);
            } else {
                // Manejo de error si no se pudo registrar
                response.getWriter().println("Error al registrar la compra.");
            }
        } else {
            // Manejo si no hay disponibilidad
            response.getWriter().println("El producto no está disponible.");
        }
    }
}
