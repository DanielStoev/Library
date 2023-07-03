package dreamix.library.services;

import dreamix.library.models.Users;
import dreamix.library.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UsersRepository usersRepository;

    public List<Users> findAll() {
        for (Users users : usersRepository.findAll()
        ) {
            System.out.println(users.getName());
        }
        return null;
    }

    public void findById(Integer id) {
        System.out.println(((Users) usersRepository.findById(id)).getName());
    }

    public Users create(Users user) {
        usersRepository.create(user);
        return user;
    }

    public void update() {
        Users users = new Users();
        usersRepository.update(users);
    }

    public void delete(Integer id) {
        usersRepository.delete(id);
    }
}


