package dreamix.library.services;

import dreamix.library.models.Forms;
import dreamix.library.repositories.FormsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FormService {

    @Autowired
    private FormsRepository formsRepository;

    public List<Forms> findAll() {
        for (Forms form : formsRepository.findAll()
        ) {
            System.out.println(form.getForm());
        }
        return null;
    }

    public void findById(Integer id) {
        System.out.println(((Forms) formsRepository.findById(id)).getForm());
    }

    public Forms create(Forms form) {
        formsRepository.create(form);
        return form;
    }

    public void update() {
        Forms form = new Forms();
        formsRepository.update(form);
    }

    public void delete(Integer id) {
        formsRepository.delete(id);
    }
}


