package dreamix.library.controllers;

import dreamix.library.models.Genres;
import dreamix.library.services.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/genres")
public class GenreController {

    @Autowired
    private GenreService genreService;

    @GetMapping("/all")
    public List<Genres> findAll() {
        return genreService.findAll();
    }

    @PostMapping("/add")
    public Genres addRecord(@RequestBody Genres genre) {
        return genreService.create(genre);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteRecord(@PathVariable Integer id) {
        genreService.delete(id);
    }
}
