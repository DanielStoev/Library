package dreamix.library.services;

import dreamix.library.models.User_card;
import dreamix.library.repositories.User_cardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class User_cardService {

    @Autowired
    private User_cardRepository userCardRepository;

    public void findAll() {
        for (User_card userCard : userCardRepository.findAll()
        ) {
            System.out.println(userCard.getId());
        }
    }

    public void findById(Integer id) {
        System.out.println(((User_card) userCardRepository.findById(id)).getUser());
    }

    public void create() {
        User_card userCard = new User_card();
        userCardRepository.create(userCard);
    }

    public void update() {
        User_card userCard = new User_card();
        userCardRepository.update(userCard);
    }

    public void delete(Integer id) {
        userCardRepository.delete(id);
    }
}


