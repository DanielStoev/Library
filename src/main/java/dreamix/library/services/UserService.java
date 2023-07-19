package dreamix.library.services;

import dreamix.library.dtos.UsersDTO;
import dreamix.library.models.User_card;
import dreamix.library.models.Users;
import dreamix.library.services.reusables.BookChecker;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService extends BookChecker {

    private UsersDTO usersDTOer(Users users) {
        UsersDTO usersDTO = new UsersDTO();
        usersDTO.setName(users.getName());
        usersDTO.setId(users.getId());
//        usersDTO.setCard(users.getCard());
        return usersDTO;
    }

    private Users usersENTer(UsersDTO usersDTO) {
        Users users = new Users();
        users.setName(usersDTO.getName());
        users.setPassword(usersDTO.getPassword());
//        users.setCard(usersDTO.getCard());
        if (usersDTO.getId() != null) {
            users.setId(usersDTO.getId());
        }

        return users;
    }

    public List<UsersDTO> findAll() {
        List users = usersRepository.findAll();
        List<UsersDTO> usersDTOS = new ArrayList<>();

        for (Object user : users) {
            usersDTOS.add(usersDTOer((Users) user));
        }

        return usersDTOS;
    }

    public UsersDTO findById(Integer id) {
        Users users = (Users) usersRepository.findById(id);
        return usersDTOer(users);
    }

    @Transactional
    public UsersDTO create(UsersDTO usersDTO) {
        Users users = usersENTer(usersDTO);
        if (users.getCard() != null) {
            User_card userCard = users.getCard();
            if (userCard.getId() != null) {
                userCardRepository.update(userCard);
            } else {
                userCardRepository.create(userCard);
            }
        }
        if (users.getId() != null) {
            usersRepository.update(users);
        } else {
            usersRepository.create(users);
        }
        return usersDTO;
    }

    @Transactional
    public UsersDTO update(UsersDTO usersDTO) {
        Users users = usersENTer(usersDTO);
        if (users.getCard() != null) {
            User_card userCard = users.getCard();
            userCardRepository.update(userCard);
        }
        usersRepository.update(users);
        return usersDTO;
    }

    public void delete(Integer id) {
        copiesRepository.delete(id);
    }
}