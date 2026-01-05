package DAO;

import Modelo.Compra;
import java.sql.*;
// import ORM.Conexion; // Asumimos que esta clase existe y tiene un método getConexion()

public class CompraDAO {

    public boolean registrarCompra(Compra c) {
        boolean registrado = false;
        // String sql = "INSERT INTO compras (fecha, total, id_cliente) VALUES (?, ?, ?)";
        
        try {
            // Connection con = ORM.Conexion.getConexion();
            // PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            // ps.setDate(1, new java.sql.Date(c.getFecha().getTime()));
            // ps.setDouble(2, c.getTotal());
            // ps.setInt(3, c.getIdCliente());
            
            // if (ps.executeUpdate() > 0) {
            //     ResultSet rs = ps.getGeneratedKeys();
            //     if (rs.next()) {
            //         c.setId(rs.getInt(1));
            //     }
            //     registrado = true;
            // }
            
            // Simulación para el ejercicio
            c.setId((int)(Math.random() * 10000)); // Simular ID generado
            registrado = true;
            System.out.println("Compra registrada con ID: " + c.getId());

        } catch (Exception e) {
            e.printStackTrace();
        }
        return registrado;
    }

    public Compra obtenerDatos(int idCompra) {
        Compra c = null;
        // String sql = "SELECT * FROM compras WHERE id = ?";
        
        try {
            // Connection con = ORM.Conexion.getConexion();
            // PreparedStatement ps = con.prepareStatement(sql);
            // ps.setInt(1, idCompra);
            // ResultSet rs = ps.executeQuery();
            
            // if (rs.next()) {
            //     c = new Compra();
            //     c.setId(rs.getInt("id"));
            //     c.setFecha(rs.getDate("fecha"));
            //     c.setTotal(rs.getDouble("total"));
            //     c.setIdCliente(rs.getInt("id_cliente"));
            // }
            
            // Simulación para el ejercicio
            c = new Compra();
            c.setId(idCompra);
            c.setFecha(new java.util.Date());
            c.setTotal(1500.00);
            c.setIdCliente(1);
            System.out.println("Datos de compra obtenidos para ID: " + idCompra);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return c;
    }
}
