package dreamix.library.services;

import dreamix.library.models.Copies;
import dreamix.library.repositories.CopiesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CopyService {

    @Autowired
    private CopiesRepository copiesRepository;

    public List<Copies> findAll() {
        return copiesRepository.findAll();
    }

    public void findById(Integer id) {
        System.out.println(((Copies) copiesRepository.findById(id)).getBook());
    }

    public Copies create(Copies copy) {
        copiesRepository.create(copy);
        return copy;
    }

    public void update() {
        Copies copy = new Copies();
        copiesRepository.update(copy);
    }

    public void delete(Integer id) {
        copiesRepository.delete(id);
    }
}


