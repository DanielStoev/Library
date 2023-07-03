package dreamix.library.controllers;

import dreamix.library.models.User_card;
import dreamix.library.services.User_cardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user_card")
public class User_cardController {

    @Autowired
    private User_cardService userCardService;

    @GetMapping("/all")
    public List<User_card> findAll() {
        return userCardService.findAll();
    }

    @PostMapping("/add")
    public User_card addRecord(@RequestBody User_card userCard) {
        return userCardService.create(userCard);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteRecord(@PathVariable Integer id) {
        userCardService.delete(id);
    }
}
