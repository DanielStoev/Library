package dreamix.library.controllers;

import dreamix.library.dtos.LanguagesDTO;
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
    public List<LanguagesDTO> findAll() {
        return languageService.findAll();
    }

    @GetMapping("/find/{id}")
    public LanguagesDTO findById(@PathVariable Integer id) {
        return languageService.findById(id);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json; CHARSET=UTF-8", consumes = "application/json;charset=UTF-8")
    public LanguagesDTO create(@RequestBody LanguagesDTO languagesDTO) {
        return languageService.create(languagesDTO);
    }

    @PutMapping(value = "/update", produces = "application/json; CHARSET=UTF-8", consumes = "application/json;charset=UTF-8")
    public LanguagesDTO update(@RequestBody LanguagesDTO languagesDTO) {
        return languageService.update(languagesDTO);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id) {
        languageService.delete(id);
    }
}
