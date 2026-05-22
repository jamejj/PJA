package MAS.MP4.src.main.java.repository;

import jakarta.persistence.EntityManager;
import model.Klient;
import utility.JpaUtility;

import java.util.List;

public class KlientRepository {

    public void save(Klient klient) {

        EntityManager em = JpaUtility.getEntityManager();

        em.getTransaction().begin();

        em.persist(klient);

        em.getTransaction().commit();

        em.close();
    }

    public Klient findById(Long id) {

        EntityManager em = JpaUtility.getEntityManager();

        Klient klient = em.find(Klient.class, id);

        em.close();

        return klient;
    }

    public List<Klient> findAll() {

        EntityManager em = JpaUtility.getEntityManager();

        List<Klient> lista = em.createQuery(
                "SELECT k FROM Klient k",
                Klient.class
        ).getResultList();

        em.close();

        return lista;
    }

    public void delete(Long id) {

        EntityManager em = JpaUtility.getEntityManager();

        em.getTransaction().begin();

        Klient klient = em.find(Klient.class, id);

        if (klient != null) {
            em.remove(klient);
        }

        em.getTransaction().commit();

        em.close();
    }
}