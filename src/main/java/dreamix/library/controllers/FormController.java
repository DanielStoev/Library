package dreamix.library.controllers;

import dreamix.library.dtos.FormsDTO;
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
    public List<FormsDTO> findAll() {
        return formService.findAll();
    }

    @GetMapping("/find/{id}")
    public FormsDTO findById(@PathVariable Integer id) {
        return formService.findById(id);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json; CHARSET=UTF-8", consumes = "application/json;charset=UTF-8")
    public FormsDTO create(@RequestBody FormsDTO formsDTO) {
        return formService.create(formsDTO);
    }

    @PutMapping(value = "/update", produces = "application/json; CHARSET=UTF-8", consumes = "application/json;charset=UTF-8")
    public FormsDTO update(@RequestBody FormsDTO formsDTO) {
        return formService.update(formsDTO);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id) {
        formService.delete(id);
    }
}
