package MAS.MP4.src.main.java.repository;

import jakarta.persistence.EntityManager;
import model.Cwiczenie;
import utility.JpaUtility;

import java.util.List;

public class CwiczenieRepository {

    public void save(Cwiczenie cwiczenie) {
        EntityManager em = JpaUtility.getEntityManager();

        em.getTransaction().begin();
        em.persist(cwiczenie);
        em.getTransaction().commit();

        em.close();
    }

    public Cwiczenie findById(Long id) {
        EntityManager em = JpaUtility.getEntityManager();

        Cwiczenie cwiczenie = em.find(Cwiczenie.class, id);

        em.close();
        return cwiczenie;
    }

    public List<Cwiczenie> findAll() {
        EntityManager em = JpaUtility.getEntityManager();

        List<Cwiczenie> lista = em.createQuery(
                "SELECT c FROM Cwiczenie c",
                Cwiczenie.class
        ).getResultList();

        em.close();
        return lista;
    }

    public void delete(Long id) {
        EntityManager em = JpaUtility.getEntityManager();

        em.getTransaction().begin();

        Cwiczenie cwiczenie = em.find(Cwiczenie.class, id);

        if (cwiczenie != null) {
            em.remove(cwiczenie);
        }

        em.getTransaction().commit();
        em.close();
    }
}