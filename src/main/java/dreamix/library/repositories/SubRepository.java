package dreamix.library.repositories;

import dreamix.library.models.IdSubclass;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

@Repository
@EnableJpaRepositories
public abstract class SubRepository<T> {

    @PersistenceContext
    private EntityManager entityManager;


    public abstract String getEntityName();

    public abstract Class<T> getEntityClass();

    public List findAll() {
        return entityManager.createQuery("from " + getEntityName()).getResultList();
    }

    public Object findById(Integer id) {
        String entityName = getEntityName();
        String jpql = "from " + entityName;
        return entityManager.createQuery(jpql + " where id = :id").setParameter("id", id).getSingleResult();
    }

    public List<T> filter(List<Filter> filters) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(getEntityClass());
        Root<T> root = criteriaQuery.from(getEntityClass());
        List<Predicate> predicates = new ArrayList<>();
        for (Filter filter : filters) {
            switch (filter.getOperator()) {
                case "findBooksByAuthors":
                    predicates.add(criteriaBuilder.equal(root.get("name"), filter.getName()));
                    break;
                case "findBooksByName":
                    predicates.add(criteriaBuilder.equal(root.get("title"), filter.getName()));
                    break;
                case "like":
                    predicates.add(criteriaBuilder.like(root.get(filter.getName()), "%" + filter.getValue1() + "%"));
                    break;
                case "between":
                    predicates.add(criteriaBuilder.between(root.get(filter.getName()), (int) filter.getValue1(), (int) filter.getValue2()));
                    break;
                case "more":
                    predicates.add(criteriaBuilder.ge(root.get(filter.getName()), (int) filter.getValue1()));
                    break;
                case "less":
                    predicates.add(criteriaBuilder.le(root.get(filter.getName()), (int) filter.getValue1()));
                    break;
                default:
                    System.out.println("Passed not needed argument " + filter.getName());
                    break;
            }
        }
        criteriaQuery.where(criteriaBuilder.and(predicates.toArray(new Predicate[0])));
        TypedQuery<T> query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }

    @Transactional
    public T create(T object) {
        entityManager.persist(object);
        return object;
    }

    @Transactional
    public <P extends IdSubclass> void update(P object) {
        try {
            Integer id = object.getId();
            Object foundObject = findById(id);
            Field[] fields = object.getClass().getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                Object value = field.get(foundObject);
                if (value != null && field.get(object) == null) {
                    field.set(object, value);
                }
            }
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
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