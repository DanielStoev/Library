package dreamix.library.services;

import dreamix.library.models.Authors;
import dreamix.library.repositories.AuthorsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {

    @Autowired
    private AuthorsRepository authorsRepository;

    public void findAll() {
        for (Authors author : authorsRepository.findAll()
        ) {
            System.out.println(author.getId());
        }
    }

    public void findById(Integer id) {
        System.out.println(((Authors) authorsRepository.findById(8)).getName());
    }

    public void create() {
        Authors authors = new Authors("naoibfauopfbauof");
        authorsRepository.create(authors);
    }

    public void update() {
        Authors authors = new Authors("naoibfauopfbauof");
        authorsRepository.update(authors);
    }

    public void delete(Integer id) {
        authorsRepository.delete(id);
    }


}