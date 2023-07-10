package dreamix.library.repositories;

import dreamix.library.models.Books;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public class BooksRepository extends SubRepository<Books> {

    @Override
    public String getEntityName() {
        return Books.class.getSimpleName();
    }

    @Override
    public Class<Books> getEntityClass() {
        return Books.class;
    }
}