package dreamix.library.controllers;

import dreamix.library.dtos.CopiesDTO;
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
    public List<CopiesDTO> findAll() {
        return copyService.findAll();
    }

    @GetMapping("/find/{id}")
    public CopiesDTO findById(@PathVariable Integer id) {
        return copyService.findById(id);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json; CHARSET=UTF-8", consumes = "application/json;charset=UTF-8")
    public CopiesDTO create(@RequestBody CopiesDTO copiesDTO) {
        return copyService.create(copiesDTO);
    }

    @PutMapping(value = "/update", produces = "application/json; CHARSET=UTF-8", consumes = "application/json;charset=UTF-8")
    public CopiesDTO update(@RequestBody CopiesDTO copiesDTO) {
        return copyService.update(copiesDTO);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id) {
        copyService.delete(id);
    }
}
