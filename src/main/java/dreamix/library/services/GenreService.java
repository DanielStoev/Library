package dreamix.library.services;

import dreamix.library.models.Genres;
import dreamix.library.repositories.GenresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GenreService {

    @Autowired
    private GenresRepository genresRepository;

    public void findAll() {
        for (Genres genre : genresRepository.findAll()
        ) {
            System.out.println(genre.getId());
        }
    }

    public void findById(Integer id) {
        System.out.println(((Genres) genresRepository.findById(id)).getGenre());
    }

    public void create() {
        Genres genre = new Genres();
        genresRepository.create(genre);
    }

    public void update() {
        Genres genre = new Genres();
        genresRepository.update(genre);
    }

    public void delete(Integer id) {
        genresRepository.delete(id);
    }
}


