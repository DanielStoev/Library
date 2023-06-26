package dreamix.library.services;

import dreamix.library.models.Authors;
import dreamix.library.repositories.AuthorsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {

    @Autowired
    private AuthorsRepository authorsRepository;

    public void test() {
        for (Authors author : authorsRepository.findAll()
        ) {
            System.out.println(author);
        }
    }
}