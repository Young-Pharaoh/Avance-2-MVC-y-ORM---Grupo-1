package DAO;

import Modelo.Compra;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 * DAO convertido a JPA/EclipseLink siguiendo el patrón del ejemplo.
 */
public class CompraDAO {

    private EntityManagerFactory emf;

    public CompraDAO() {
        this.emf = Persistence.createEntityManagerFactory("persistencia");
    }

    /**
     * Registra una compra usando JPA (persist)
     */
    public boolean registrarCompra(Compra c) {
        boolean registrado = false;
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(c);
            em.getTransaction().commit();
            registrado = true;
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
        return registrado;
    }

    /**
     * Obtiene una compra por su id usando EntityManager.find
     */
    public Compra obtenerDatos(int idCompra) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Compra.class, idCompra);
        } finally {
            em.close();
        }
    }

    public void close() {
        if (emf != null && emf.isOpen()) {
            emf.close();
        }
    }
}
