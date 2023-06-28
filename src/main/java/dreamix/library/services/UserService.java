package dreamix.library.services;

import dreamix.library.models.Users;
import dreamix.library.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UsersRepository usersRepository;

    public void test() {
        for (Users users : usersRepository.findAll()
        ) {
            System.out.println(users);
        }
    }
}
