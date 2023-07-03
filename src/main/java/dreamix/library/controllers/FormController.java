package dreamix.library.controllers;

import dreamix.library.models.Forms;
import dreamix.library.services.FormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/forms")
public class FormController {

    @Autowired
    private FormService formService;

    @GetMapping("/all")
    public List<Forms> findAll() {
        return formService.findAll();
    }

    @PostMapping("/add")
    public Forms addRecord(@RequestBody Forms form) {
        return formService.create(form);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteRecord(@PathVariable Integer id) {
        formService.delete(id);
    }
}
