package orm;

import Modelo.Compra;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.Date;

public class TestORM {
    public static void main(String[] args) {
        System.out.println("Iniciando prueba ORM...");
        EntityManagerFactory emf = null;
        try {
            emf = Persistence.createEntityManagerFactory("persistencia");
            EntityManager em = emf.createEntityManager();

            Compra c = new Compra();
            c.setFecha(new Date());
            c.setTotal(123.45);
            c.setIdCliente(1);

            em.getTransaction().begin();
            em.persist(c);
            em.getTransaction().commit();

            System.out.println("Compra persistida con id: " + c.getId());

            Compra found = em.find(Compra.class, c.getId());
            System.out.println("Compra recuperada: id=" + found.getId() + ", total=" + found.getTotal());

            em.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (emf != null && emf.isOpen()) emf.close();
        }
        System.out.println("Prueba finalizada.");
    }
}
