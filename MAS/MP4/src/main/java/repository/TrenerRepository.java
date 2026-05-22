package MAS.MP4.src.main.java.repository;

import jakarta.persistence.EntityManager;
import model.Trener;
import utility.JpaUtility;

import java.util.List;

public class TrenerRepository {

    public void save(Trener trener) {
        EntityManager em = JpaUtility.getEntityManager();

        em.getTransaction().begin();
        em.persist(trener);
        em.getTransaction().commit();

        em.close();
    }

    public Trener findById(Long id) {
        EntityManager em = JpaUtility.getEntityManager();

        Trener trener = em.find(Trener.class, id);

        em.close();
        return trener;
    }

    public List<Trener> findAll() {
        EntityManager em = JpaUtility.getEntityManager();

        List<Trener> lista = em.createQuery(
                "SELECT t FROM Trener t",
                Trener.class
        ).getResultList();

        em.close();
        return lista;
    }

    public void delete(Long id) {
        EntityManager em = JpaUtility.getEntityManager();

        em.getTransaction().begin();

        Trener trener = em.find(Trener.class, id);

        if (trener != null) {
            em.remove(trener);
        }

        em.getTransaction().commit();
        em.close();
    }
}