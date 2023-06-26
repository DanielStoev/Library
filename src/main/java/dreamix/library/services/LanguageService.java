package dreamix.library.services;

import dreamix.library.models.Languages;
import dreamix.library.repositories.LanguagesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LanguageService {

    @Autowired
    private LanguagesRepository languagesRepository;

    public void test() {
        for (Languages languages : languagesRepository.findAll()
        ) {
            System.out.println(languages);
        }
    }
}