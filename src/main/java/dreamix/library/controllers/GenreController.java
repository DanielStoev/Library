package dreamix.library.controllers;

import dreamix.library.dtos.GenresDTO;
import dreamix.library.services.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/genres", consumes = "application/json;charset=UTF-8")
public class GenreController {

    @Autowired
    private GenreService genreService;

    @GetMapping("/all")
    public List<GenresDTO> findAll() {
        return genreService.findAll();
    }

    @GetMapping("/find/{id}")
    public GenresDTO findById(@PathVariable Integer id) {
        return genreService.findById(id);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json; CHARSET=UTF-8", consumes = "application/json;charset=UTF-8")
    public GenresDTO create(@RequestBody GenresDTO genresDTO) {
        return genreService.create(genresDTO);
    }

    @PutMapping(value = "/update", produces = "application/json; CHARSET=UTF-8", consumes = "application/json;charset=UTF-8")
    public GenresDTO update(@RequestBody GenresDTO genresDTO) {
        return genreService.update(genresDTO);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id) {
        genreService.delete(id);
    }
}