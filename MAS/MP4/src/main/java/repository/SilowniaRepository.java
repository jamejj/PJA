package MAS.MP4.src.main.java.repository;

import jakarta.persistence.EntityManager;
import model.Silownia;
import utility.JpaUtility;

import java.util.List;

public class SilowniaRepository {

    public void save(Silownia silownia) {
        EntityManager em = JpaUtility.getEntityManager();

        em.getTransaction().begin();
        em.persist(silownia);
        em.getTransaction().commit();

        em.close();
    }

    public Silownia findById(Long id) {
        EntityManager em = JpaUtility.getEntityManager();

        Silownia silownia = em.find(Silownia.class, id);

        em.close();
        return silownia;
    }

    public List<Silownia> findAll() {
        EntityManager em = JpaUtility.getEntityManager();

        List<Silownia> lista = em.createQuery(
                "SELECT s FROM Silownia s",
                Silownia.class
        ).getResultList();

        em.close();
        return lista;
    }

    public void delete(Long id) {
        EntityManager em = JpaUtility.getEntityManager();

        em.getTransaction().begin();

        Silownia silownia = em.find(Silownia.class, id);

        if (silownia != null) {
            em.remove(silownia);
        }

        em.getTransaction().commit();
        em.close();
    }
}