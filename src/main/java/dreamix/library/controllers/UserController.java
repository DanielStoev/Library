package dreamix.library.controllers;


import dreamix.library.dtos.UsersDTO;
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
    public List<UsersDTO> findAll() {
        return userService.findAll();
    }

    @GetMapping("/find/{id}")
    public UsersDTO findById(@PathVariable Integer id) {
        return userService.findById(id);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json; CHARSET=UTF-8", consumes = "application/json;charset=UTF-8")
    public UsersDTO create(@RequestBody UsersDTO usersDTO) {
        return userService.create(usersDTO);
    }

    @PutMapping(value = "/update", produces = "application/json; CHARSET=UTF-8", consumes = "application/json;charset=UTF-8")
    public UsersDTO update(@RequestBody UsersDTO usersDTO) {
        return userService.update(usersDTO);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id) {
        userService.delete(id);
    }
}
