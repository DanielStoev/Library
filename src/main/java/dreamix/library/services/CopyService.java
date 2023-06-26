package dreamix.library.services;

import dreamix.library.models.Copies;
import dreamix.library.repositories.CopiesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CopyService {

    @Autowired
    private CopiesRepository copiesRepository;

    public void test() {
        for (Copies copy : copiesRepository.findAll()
        ) {
            System.out.println(copy);
        }
    }
}