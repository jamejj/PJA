package MAS.MP4.src.main.java.repository;

import jakarta.persistence.EntityManager;
import model.PlanTreningowy;
import utility.JpaUtility;

import java.util.List;

public class PlanTreningowyRepository {

    public void save(PlanTreningowy plan) {
        EntityManager em = JpaUtility.getEntityManager();

        em.getTransaction().begin();
        em.persist(plan);
        em.getTransaction().commit();

        em.close();
    }

    public PlanTreningowy findById(Long id) {
        EntityManager em = JpaUtility.getEntityManager();

        PlanTreningowy plan = em.find(PlanTreningowy.class, id);

        em.close();
        return plan;
    }

    public List<PlanTreningowy> findAll() {
        EntityManager em = JpaUtility.getEntityManager();

        List<PlanTreningowy> lista = em.createQuery(
                "SELECT p FROM PlanTreningowy p",
                PlanTreningowy.class
        ).getResultList();

        em.close();
        return lista;
    }

    public void delete(Long id) {
        EntityManager em = JpaUtility.getEntityManager();

        em.getTransaction().begin();

        PlanTreningowy plan = em.find(PlanTreningowy.class, id);

        if (plan != null) {
            em.remove(plan);
        }

        em.getTransaction().commit();
        em.close();
    }
}