package dreamix.library.services;

import dreamix.library.models.Genres;
import dreamix.library.repositories.GenresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreService {

    @Autowired
    private GenresRepository genresRepository;

    public List<Genres> findAll() {
        for (Genres genre : genresRepository.findAll()
        ) {
            System.out.println(genre.getGenre());
        }
        return null;
    }

    public void findById(Integer id) {
        System.out.println(((Genres) genresRepository.findById(id)).getGenre());
    }

    public Genres create(Genres genre) {
        genresRepository.create(genre);
        return genre;
    }

    public void update() {
        Genres genre = new Genres();
        genresRepository.update(genre);
    }

    public void delete(Integer id) {
        genresRepository.delete(id);
    }
}


