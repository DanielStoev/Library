package dreamix.library.controllers;

import dreamix.library.models.Users;
import dreamix.library.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public List<Users> findAll() {
        return userService.findAll();
    }

    @PostMapping("/add")
    public Users addRecord(@RequestBody Users user) {
        return userService.create(user);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteRecord(@PathVariable Integer id) {
        userService.delete(id);
    }
}
