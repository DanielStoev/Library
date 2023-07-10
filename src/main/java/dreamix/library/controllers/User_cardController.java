package dreamix.library.controllers;

import dreamix.library.dtos.User_cardDTO;
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
    public List<User_cardDTO> findAll() {
        return userCardService.findAll();
    }

    @GetMapping("/find/{id}")
    public User_cardDTO findById(@PathVariable Integer id) {
        return userCardService.findById(id);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json; CHARSET=UTF-8", consumes = "application/json;charset=UTF-8")
    public User_cardDTO create(@RequestBody User_cardDTO userCardDTO) {
        return userCardService.create(userCardDTO);
    }

    @PutMapping(value = "/update", produces = "application/json; CHARSET=UTF-8", consumes = "application/json;charset=UTF-8")
    public User_cardDTO update(@RequestBody User_cardDTO userCardDTO) {
        return userCardService.update(userCardDTO);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id) {
        userCardService.delete(id);
    }
}
