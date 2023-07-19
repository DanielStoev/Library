package dreamix.library.controllers;

import dreamix.library.dtos.AuthorsDTO;
import dreamix.library.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/authors", consumes = "application/json;charset=UTF-8")
public class AuthorController {

    @Autowired
    public AuthorService authorService;

    @GetMapping("/all")
    public List<AuthorsDTO> findAll() {
        return authorService.findAll();
    }

    @GetMapping("/find/{id}")
    public AuthorsDTO findById(@PathVariable Integer id) {
        return authorService.findById(id);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json; CHARSET=UTF-8", consumes = "application/json;charset=UTF-8")
    public AuthorsDTO create(@RequestBody AuthorsDTO authorsDTO) {
        return authorService.create(authorsDTO);
    }

    @PutMapping(value = "/update", produces = "application/json; CHARSET=UTF-8", consumes = "application/json;charset=UTF-8")
    public AuthorsDTO update(@RequestBody AuthorsDTO authorsDTO) {
        return authorService.update(authorsDTO);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id) {
        authorService.delete(id);
    }
}