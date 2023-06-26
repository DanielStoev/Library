package dreamix.library.repositories;

import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public abstract class SubRepository<T> {
    @PersistenceUnit
    private EntityManagerFactory entityManagerFactory;

    public abstract String getEntityName();


    public List<T> findAll() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        return entityManager.createQuery("from " + getEntityName()).getResultList();
    }

    @Transactional
    public void create(T object) {
        try {
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            entityManager.persist(object);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Transactional
    public void delete(Integer id) {
        try {
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            String entityName = getEntityName();
            String jpql = "delete from " + entityName;
            entityManager.createQuery(jpql + " where id = :id")
                    .setParameter("id", id)
                    .executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}