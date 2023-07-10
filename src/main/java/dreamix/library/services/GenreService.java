package dreamix.library.services;

import dreamix.library.dtos.BooksDTO;
import dreamix.library.dtos.GenresDTO;
import dreamix.library.models.Books;
import dreamix.library.models.Genres;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class GenreService extends SubService {
    private GenresDTO genresDTOer(Genres genres) {
        GenresDTO genresDTO = new GenresDTO();
        genresDTO.setGenre(genres.getGenre());
        genresDTO.setId(genres.getId());

        List<BooksDTO> bookTitles = new ArrayList<>();
        for (Books book : genres.getBooks()) {
            BooksDTO booksDTO = new BooksDTO();
            booksDTO.setTitle(book.getTitle());
            bookTitles.add(booksDTO);
        }
        genresDTO.setBooks(bookTitles);
        return genresDTO;
    }

    private Genres genresENTer(GenresDTO genresDTO) {
        Genres genres = new Genres();
        genres.setGenre(genresDTO.getGenre());
        if (genresDTO.getId() != null) {
            genres.setId(genresDTO.getId());
        }

        if (genresDTO.getBooks() != null) {
            List<Books> books = new ArrayList<>();
            for (BooksDTO booksDTO : genresDTO.getBooks()) {
                Books book = SubService.mapToEntity(booksDTO);
                books.add(book);
            }
            genres.setBooks(books);
        }
        return genres;
    }

    public List<GenresDTO> findAll() {
        List<Genres> genres = genresRepository.findAll();
        List<GenresDTO> genresDTOS = new ArrayList<>();

        for (Genres genre : genres) {
            genresDTOS.add(genresDTOer(genre));
        }

        return genresDTOS;
    }

    public GenresDTO findById(Integer id) {
        Genres genres = (Genres) genresRepository.findById(id);
        return genresDTOer(genres);
    }

    @Transactional
    public GenresDTO create(GenresDTO genresDTO) {
        Genres genres = genresENTer(genresDTO);
        if (genres.getBooks() != null) {
            for (Books book : genres.getBooks()) {
                if (book.getId() != null) {
                    booksRepository.update(book);
                } else {
                    booksRepository.create(book);
                }
            }
        }
        if (genres.getId() != null) {
            genresRepository.update(genres);
        } else {
            genresRepository.create(genres);
        }
        return genresDTO;
    }

    @Transactional
    public GenresDTO update(GenresDTO genresDTO) {
        Genres genres = genresENTer(genresDTO);
        if (genres.getBooks() != null) {
            for (Books book : genres.getBooks()) {
                booksRepository.update(book);
            }
        }
        genresRepository.update(genres);
        return genresDTO;
    }

    public void delete(Integer id) {
        genresRepository.delete(id);
    }
}