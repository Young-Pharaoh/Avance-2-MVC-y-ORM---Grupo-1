package DAO;

import Modelo.Compra;
import orm.ORMConfig;
import java.sql.*;

public class CompraDAO {

    private Connection getConexion() throws SQLException, ClassNotFoundException {
        Class.forName(ORMConfig.getDBDriver());
        return DriverManager.getConnection(
                ORMConfig.getDBUrl(),
                ORMConfig.getDBUser(),
                ORMConfig.getDBPassword()
        );
    }

    public boolean registrarCompra(Compra c) {
        boolean registrado = false;
        String sql = "INSERT INTO compras (fecha, total, id_cliente) VALUES (?, ?, ?)";
        
        try (Connection con = getConexion();
             PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            
            ps.setDate(1, new java.sql.Date(c.getFecha().getTime()));
            ps.setDouble(2, c.getTotal());
            ps.setInt(3, c.getIdCliente());
            
            if (ps.executeUpdate() > 0) {
                try (ResultSet rs = ps.getGeneratedKeys()) {
                    if (rs.next()) {
                        c.setId(rs.getInt(1));
                    }
                }
                registrado = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return registrado;
    }

    public Compra obtenerDatos(int idCompra) {
        Compra c = null;
        String sql = "SELECT * FROM compras WHERE id = ?";
        
        try (Connection con = getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setInt(1, idCompra);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    c = new Compra();
                    c.setId(rs.getInt("id"));
                    c.setFecha(rs.getDate("fecha"));
                    c.setTotal(rs.getDouble("total"));
                    c.setIdCliente(rs.getInt("id_cliente"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return c;
    }
}
