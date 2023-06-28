package dreamix.library.repositories;

import dreamix.library.models.Languages;
import org.springframework.stereotype.Repository;

@Repository
public class LanguagesRepository extends SubRepository<Languages> {

    @Override
    public String getEntityName() {
        return Languages.class.getSimpleName();
    }

    @Override
    public Class<Languages> getEntityClass() {
        return Languages.class;
    }
}
