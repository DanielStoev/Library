package dreamix.library.services;

import dreamix.library.models.Languages;
import dreamix.library.repositories.LanguagesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LanguageService {

    @Autowired
    private LanguagesRepository languagesRepository;

    public List<Languages> findAll() {
        return languagesRepository.findAll();
    }

    public void findById(Integer id) {
        System.out.println(((Languages) languagesRepository.findById(id)).getLanguage());
    }

    public Languages create(Languages language) {
        languagesRepository.create(language);
        return language;
    }

    public void update() {
        Languages language = new Languages();
        languagesRepository.update(language);
    }

    public void delete(Integer id) {
        languagesRepository.delete(id);
    }
}


