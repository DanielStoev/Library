package dreamix.library.services;

import dreamix.library.models.Forms;
import dreamix.library.repositories.FormsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FormService {

    @Autowired
    private FormsRepository formsRepository;

    public void findAll() {
        for (Forms form : formsRepository.findAll()
        ) {
            System.out.println(form.getId());
        }
    }

    public void findById(Integer id) {
        System.out.println(((Forms) formsRepository.findById(id)).getForm());
    }

    public void create() {
        Forms form = new Forms();
        formsRepository.create(form);
    }

    public void update() {
        Forms form = new Forms();
        formsRepository.update(form);
    }

    public void delete(Integer id) {
        formsRepository.delete(id);
    }
}


