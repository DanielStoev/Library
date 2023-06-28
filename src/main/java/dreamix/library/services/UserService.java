package dreamix.library.services;

import dreamix.library.models.Users;
import dreamix.library.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UsersRepository usersRepository;

    public void findAll() {
        for (Users users : usersRepository.findAll()
        ) {
            System.out.println(users.getId());
        }
    }

    public void findById(Integer id) {
        System.out.println(((Users) usersRepository.findById(id)).getName());
    }

    public void create() {
        Users users = new Users();
        usersRepository.create(users);
    }

    public void update() {
        Users users = new Users();
        usersRepository.update(users);
    }

    public void delete(Integer id) {
        usersRepository.delete(id);
    }
}


