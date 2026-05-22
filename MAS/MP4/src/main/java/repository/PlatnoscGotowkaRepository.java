package MAS.MP4.src.main.java.repository;

import jakarta.persistence.EntityManager;
import model.PlatnoscGotowka;
import utility.JpaUtility;

import java.util.List;

public class PlatnoscGotowkaRepository {

    public void save(PlatnoscGotowka platnosc) {
        EntityManager em = JpaUtility.getEntityManager();

        em.getTransaction().begin();
        em.persist(platnosc);
        em.getTransaction().commit();

        em.close();
    }

    public PlatnoscGotowka findById(Long id) {
        EntityManager em = JpaUtility.getEntityManager();

        PlatnoscGotowka platnosc = em.find(PlatnoscGotowka.class, id);

        em.close();
        return platnosc;
    }

    public List<PlatnoscGotowka> findAll() {
        EntityManager em = JpaUtility.getEntityManager();

        List<PlatnoscGotowka> lista = em.createQuery(
                "SELECT p FROM PlatnoscGotowka p",
                PlatnoscGotowka.class
        ).getResultList();

        em.close();
        return lista;
    }

    public void delete(Long id) {
        EntityManager em = JpaUtility.getEntityManager();

        em.getTransaction().begin();

        PlatnoscGotowka platnosc = em.find(PlatnoscGotowka.class, id);

        if (platnosc != null) {
            em.remove(platnosc);
        }

        em.getTransaction().commit();
        em.close();
    }
}