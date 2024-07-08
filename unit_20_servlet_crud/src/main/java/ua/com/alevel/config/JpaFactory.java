package ua.com.alevel.config;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public final class JpaFactory {

    private static JpaFactory instance;
    private final EntityManagerFactory emf;

    private JpaFactory() {
        this.emf = Persistence
                .createEntityManagerFactory("jpa-a-level-hibernate-mysql");
    }

    public static JpaFactory getInstance() {
        if (instance == null) {
            instance = new JpaFactory();
        }
        return instance;
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
}
