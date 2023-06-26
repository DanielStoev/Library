package dreamix.library.services;

import dreamix.library.models.Forms;
import dreamix.library.repositories.FormsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FormService {

    @Autowired
    private FormsRepository formsRepository;

    public void test() {
        for (Forms forms : formsRepository.findAll()
        ) {
            System.out.println(forms);
        }
    }
}