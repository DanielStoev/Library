package dreamix.library.services;


import dreamix.library.models.Copies;
import dreamix.library.repositories.CopiesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CopyService {

    @Autowired
    private CopiesRepository copiesRepository;

    public void findAll() {
        for (Copies copy : copiesRepository.findAll()
        ) {
            System.out.println(copy.getId());
        }
    }

    public void findById(Integer id) {
        System.out.println(((Copies) copiesRepository.findById(id)).getBook());
    }

    public void create() {
        Copies copy = new Copies();
        copiesRepository.create(copy);
    }

    public void update() {
        Copies copy = new Copies();
        copiesRepository.update(copy);
    }

    public void delete(Integer id) {
        copiesRepository.delete(id);
    }
}


