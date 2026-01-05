package Modelo;

import java.util.Date;

public class Compra {
    private int id;
    private Date fecha;
    private double total;
    private int idCliente;

    public Compra() {
    }

    public Compra(int id, Date fecha, double total, int idCliente) {
        this.id = id;
        this.fecha = fecha;
        this.total = total;
        this.idCliente = idCliente;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
}
