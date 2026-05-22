package MAS.MP4.src.main.java.repository;

import jakarta.persistence.EntityManager;
import model.PrzypisaniePlanu;
import utility.JpaUtility;

import java.util.List;

public class PrzypisaniePlanuRepository {

    public void save(PrzypisaniePlanu przypisanie) {
        EntityManager em = JpaUtility.getEntityManager();

        em.getTransaction().begin();
        em.persist(przypisanie);
        em.getTransaction().commit();

        em.close();
    }

    public PrzypisaniePlanu findById(Long id) {
        EntityManager em = JpaUtility.getEntityManager();

        PrzypisaniePlanu przypisanie = em.find(PrzypisaniePlanu.class, id);

        em.close();
        return przypisanie;
    }

    public List<PrzypisaniePlanu> findAll() {
        EntityManager em = JpaUtility.getEntityManager();

        List<PrzypisaniePlanu> lista = em.createQuery(
                "SELECT p FROM PrzypisaniePlanu p",
                PrzypisaniePlanu.class
        ).getResultList();

        em.close();
        return lista;
    }

    public void delete(Long id) {
        EntityManager em = JpaUtility.getEntityManager();

        em.getTransaction().begin();

        PrzypisaniePlanu przypisanie = em.find(PrzypisaniePlanu.class, id);

        if (przypisanie != null) {
            em.remove(przypisanie);
        }

        em.getTransaction().commit();
        em.close();
    }
}