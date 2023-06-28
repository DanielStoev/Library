package dreamix.library.repositories;

import dreamix.library.models.Genres;
import dreamix.library.models.User_card;
import org.springframework.stereotype.Repository;

@Repository
public class User_cardRepository extends SubRepository<User_card> {
    @Override
    public String getEntityName() {
        return User_card.class.getSimpleName();
    }

    @Override
    public Class<User_card> getEntityClass() {
        return User_card.class;
    }
}