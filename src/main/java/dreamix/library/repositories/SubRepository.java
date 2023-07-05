package dreamix.library.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public abstract class SubRepository<T> {

    @PersistenceContext
    @Autowired
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
    public void create(T object) {
        try {
            entityManager.persist(object);
        } catch (Exception e) {
            e.printStackTrace();
        }
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