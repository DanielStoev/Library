package dreamix.library.controllers;

import dreamix.library.models.Copies;
import dreamix.library.services.CopyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/copies")
public class CopyController {

    @Autowired
    private CopyService copyService;

    @GetMapping("/all")
    public List<Copies> findAll() {
        return copyService.findAll();
    }

    @PostMapping("/add")
    public Copies create(@RequestBody Copies copy) {
        return copyService.create(copy);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id) {
        copyService.delete(id);
    }
}
