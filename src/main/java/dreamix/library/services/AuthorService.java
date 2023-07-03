package dreamix.library.services;

import dreamix.library.models.Authors;
import dreamix.library.repositories.AuthorsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    @Autowired
    private AuthorsRepository authorsRepository;

    public List<Authors> findAll() {
        for (Authors author : authorsRepository.findAll()
        ) {
            System.out.println(author.getName());
        }
        return null;
    }

    public void findById(Integer id) {
        System.out.println(((Authors) authorsRepository.findById(id)).getName());
    }

    public Authors create(Authors author) {
        authorsRepository.create(author);
        return author;
    }

    public void update() {
        Authors authors = new Authors();
        authorsRepository.update(authors);
    }

    public void delete(Integer id) {
        authorsRepository.delete(id);
    }


}