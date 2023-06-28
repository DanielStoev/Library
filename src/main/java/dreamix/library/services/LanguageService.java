package dreamix.library.services;

import dreamix.library.models.Languages;
import dreamix.library.repositories.LanguagesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LanguageService {

    @Autowired
    private LanguagesRepository languagesRepository;

    public void findAll() {
        for (Languages language : languagesRepository.findAll()
        ) {
            System.out.println(language.getId());
        }
    }

    public void findById(Integer id) {
        System.out.println(((Languages) languagesRepository.findById(id)).getLanguage());
    }

    public void create() {
        Languages language = new Languages();
        languagesRepository.create(language);
    }

    public void update() {
        Languages language = new Languages();
        languagesRepository.update(language);
    }

    public void delete(Integer id) {
        languagesRepository.delete(id);
    }
}


