package dreamix.library.repositories;

import dreamix.library.models.Copies;
import org.springframework.stereotype.Repository;

@Repository
public class CopiesRepository extends SubRepository<Copies> {

    @Override
    public String getEntityName() {
        return Copies.class.getSimpleName();
    }
}