package dreamix.library.services;

import dreamix.library.models.Genres;
import dreamix.library.repositories.GenresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GenreService {

    @Autowired
    private GenresRepository genresRepository;

    public void test() {
        for (Genres genres : genresRepository.findAll()
        ) {
            System.out.println(genres);
        }
    }
}