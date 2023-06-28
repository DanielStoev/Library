package dreamix.library.repositories;

import dreamix.library.models.Forms;
import org.springframework.stereotype.Repository;

@Repository
public class FormsRepository extends SubRepository<Forms> {

    @Override
    public String getEntityName() {
        return Forms.class.getSimpleName();
    }

    @Override
    public Class<Forms> getEntityClass() {
        return Forms.class;
    }
}
