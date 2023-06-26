package dreamix.library.repositories;

import dreamix.library.models.Authors;
import org.springframework.stereotype.Repository;

@Repository
public class AuthorsRepository extends SubRepository<Authors> {


    @Override
    public String getEntityName() {
        return Authors.class.getSimpleName();
    }
}