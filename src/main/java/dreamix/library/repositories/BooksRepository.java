package dreamix.library.repositories;

import dreamix.library.models.Authors;
import dreamix.library.models.Books;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
@EnableJpaRepositories
public class BooksRepository extends SubRepository<Books> {


    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public String getEntityName() {
        return Books.class.getSimpleName();
    }

    @Override
    public Class<Books> getEntityClass() {
        return Books.class;
    }

    public List<Books> findBooksByAuthor(String authorName) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Books> query = cb.createQuery(Books.class);
        Root<Books> bookRoot = query.from(Books.class);

        Join<Books, Authors> authorJoin = bookRoot.join("authors");
        query.select(bookRoot);
        query.where(cb.equal(authorJoin.get("name"), authorName));

        return entityManager.createQuery(query).getResultList();
    }
}