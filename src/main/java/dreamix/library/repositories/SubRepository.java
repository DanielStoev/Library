package dreamix.library.repositories;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@EnableJpaRepositories
public abstract class SubRepository<T> {

    @PersistenceContext
    private EntityManager entityManager;


    public abstract String getEntityName();

    public abstract Class<T> getEntityClass();

    public List<T> findAll() {
        return entityManager.createQuery("from " + getEntityName()).getResultList();
    }

    public Object findById(Integer id) {
        String entityName = getEntityName();
        String jpql = "from " + entityName;
        return entityManager.createQuery(jpql + " where id = :id").setParameter("id", id).getSingleResult();
    }

    @Transactional
    public T create(T object) {
        entityManager.persist(object);
        return object;
    }

    @Transactional
    public void update(T object) {
        try {
            entityManager.merge(object);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Transactional
    public void delete(Integer id) {
        try {
            String jpql = "delete from " + getEntityName();
            entityManager.createQuery(jpql + " where id = :id")
                    .setParameter("id", id)
                    .executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}