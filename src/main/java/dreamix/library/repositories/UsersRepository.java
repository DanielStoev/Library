package dreamix.library.repositories;

import dreamix.library.models.User_card;
import dreamix.library.models.Users;
import org.springframework.stereotype.Repository;

@Repository
public class UsersRepository extends SubRepository<Users> {

    @Override
    public String getEntityName() {
        return Users.class.getSimpleName();
    }

    @Override
    public Class<Users> getEntityClass() {
        return Users.class;
    }
}