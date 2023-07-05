package dreamix.library.services;

import dreamix.library.dtos.UsersDTO;
import dreamix.library.models.Users;
import dreamix.library.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UsersRepository usersRepository;

    public List<UsersDTO> findAll() {
        List<Users> users = usersRepository.findAll();
        List<UsersDTO> usersDTOs = new ArrayList<>();

        for (Users user : users) {
            UsersDTO usersDTO = new UsersDTO();
            usersDTO.setName(user.getName());
            usersDTO.setCard(user.getCard());
            usersDTOs.add(usersDTO);
        }

        return usersDTOs;
    }

    public UsersDTO findById(Integer id) {
        Users user = (Users) usersRepository.findById(id);
        UsersDTO usersDTO = new UsersDTO();
        usersDTO.setName(user.getName());
        usersDTO.setCard(user.getCard());
        return usersDTO;
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


