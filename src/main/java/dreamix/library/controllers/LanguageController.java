package dreamix.library.controllers;

import dreamix.library.models.Languages;
import dreamix.library.services.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/languages")
public class LanguageController {

    @Autowired
    private LanguageService languageService;

    @GetMapping("/all")
    public List<Languages> findAll() {
        return languageService.findAll();
    }

    @PostMapping("/add")
    public Languages create(@RequestBody Languages language) {
        return languageService.create(language);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id) {
        languageService.delete(id);
    }
}
