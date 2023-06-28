package dreamix.library.services;

import dreamix.library.models.User_card;
import dreamix.library.repositories.User_cardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class User_cardService {

    @Autowired
    private User_cardRepository userCardRepository;

    public void test() {
        for (User_card userCard : userCardRepository.findAll()
        ) {
            System.out.println(userCard);
        }
    }
}