package dreamix.library.repositories;

import dreamix.library.models.Genres;
import org.springframework.stereotype.Repository;

@Repository
public class GenresRepository extends SubRepository<Genres> {

    @Override
    public String getEntityName() {
        return Genres.class.getSimpleName();
    }

    @Override
    public Class<Genres> getEntityClass() {
        return Genres.class;
    }
}
