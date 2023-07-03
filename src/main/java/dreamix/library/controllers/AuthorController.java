package dreamix.library.controllers;

import dreamix.library.models.Authors;
import dreamix.library.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping("/all")
    public List<Authors> findAll() {
        return authorService.findAll();
    }

    @PostMapping("/add")
    public Authors addRecord(@RequestBody Authors author) {
        return authorService.create(author);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteRecord(@PathVariable Integer id) {
        authorService.delete(id);
    }
}
