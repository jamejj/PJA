package MAS.MP4.src.main.java.utility;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JpaUtility {

    private static final EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("mp4Unit");

    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public static void close() {
        emf.close();
    }
}
