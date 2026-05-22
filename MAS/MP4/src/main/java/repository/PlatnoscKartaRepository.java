package MAS.MP4.src.main.java.repository;

import jakarta.persistence.EntityManager;
import model.PlatnoscKarta;
import utility.JpaUtility;

import java.util.List;

public class PlatnoscKartaRepository {

    public void save(PlatnoscKarta platnosc) {
        EntityManager em = JpaUtility.getEntityManager();

        em.getTransaction().begin();
        em.persist(platnosc);
        em.getTransaction().commit();

        em.close();
    }

    public PlatnoscKarta findById(Long id) {
        EntityManager em = JpaUtility.getEntityManager();

        PlatnoscKarta platnosc = em.find(PlatnoscKarta.class, id);

        em.close();
        return platnosc;
    }

    public List<PlatnoscKarta> findAll() {
        EntityManager em = JpaUtility.getEntityManager();

        List<PlatnoscKarta> lista = em.createQuery(
                "SELECT p FROM PlatnoscKarta p",
                PlatnoscKarta.class
        ).getResultList();

        em.close();
        return lista;
    }

    public void delete(Long id) {
        EntityManager em = JpaUtility.getEntityManager();

        em.getTransaction().begin();

        PlatnoscKarta platnosc = em.find(PlatnoscKarta.class, id);

        if (platnosc != null) {
            em.remove(platnosc);
        }

        em.getTransaction().commit();
        em.close();
    }
}