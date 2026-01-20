package dao;

import model.Producto;
import jakarta.persistence.*;
import java.util.List;

public class ProductoDAOImpl implements ProductoDAO {

    private EntityManagerFactory emf;

    public ProductoDAOImpl() {
        this.emf = Persistence.createEntityManagerFactory("persistencia");
    }

    public ProductoDAOImpl(EntityManagerFactory emf) {
        this.emf = emf;
    }

    @Override
    public void crear(Producto producto) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = null;
        try {
            tx = em.getTransaction();
            tx.begin();
            em.persist(producto);
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    @Override
    public Producto obtenerPorId(Long id) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Producto.class, id);
        } finally {
            em.close();
        }
    }

    @Override
    public List<Producto> obtenerTodos() {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Producto> query = em.createQuery("SELECT p FROM Producto p", Producto.class);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    @Override
    public void actualizar(Producto producto) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = null;
        try {
            tx = em.getTransaction();
            tx.begin();
            em.merge(producto);
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    @Override
    public void eliminar(Long id) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = null;
        try {
            tx = em.getTransaction();
            tx.begin();
            Producto producto = em.find(Producto.class, id);
            if (producto != null) {
                em.remove(producto);
            }
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    @Override
    public List<Producto> buscarPorCondicion(String condicion) {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Producto> query = em.createQuery(
                "SELECT p FROM Producto p WHERE p.condicion = :condicion",
                Producto.class
            );
            query.setParameter("condicion", condicion);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    @Override
    public List<Producto> obtenerDisponibles() {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Producto> query = em.createQuery(
                "SELECT p FROM Producto p WHERE p.disponibilidad = true",
                Producto.class
            );
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    @Override
    public boolean verificarDisponibilidad(Long id) {
        Producto producto = obtenerPorId(id);
        return producto != null && producto.verificarDisponibilidad();
    }

    @Override
    public void actualizarInventario(Long id, boolean disponibilidad) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = null;
        try {
            tx = em.getTransaction();
            tx.begin();
            Producto producto = em.find(Producto.class, id);
            if (producto != null) {
                producto.actualizarInventario(disponibilidad);
                em.merge(producto);
            }
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace();
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