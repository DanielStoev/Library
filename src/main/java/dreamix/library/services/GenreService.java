package dreamix.library.services;

import dreamix.library.dtos.*;
import dreamix.library.models.*;
import dreamix.library.repositories.BooksRepository;
import dreamix.library.repositories.GenresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class GenreService {

    @Autowired
    private GenresRepository genresRepository;
    @Autowired
    private BooksRepository booksRepository;

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

        List<Books> books = new ArrayList<>();
        if (genresDTO.getBooks() != null) {
            for (BooksDTO booksDTO : genresDTO.getBooks()) {
                Books book = new Books();

                if (booksDTO.getId() != null) {
                    book.setId(booksDTO.getId());
                }

                //Authors
                if (booksDTO.getAuthors() != null) {
                    List<Authors> bookAuthors = new ArrayList<>();
                    for (AuthorsDTO authorDTO : booksDTO.getAuthors()) {
                        Authors author = new Authors();
                        author.setName(authorDTO.getName());
                        author.setId(authorDTO.getId());
                        bookAuthors.add(author);
                    }
                    book.setAuthors(bookAuthors);
                }

                //Tittle
                if (booksDTO.getTitle() != null) {
                    book.setTitle(booksDTO.getTitle());
                }

                //Genres
                if (booksDTO.getGenres() != null) {
                    List<Genres> bookGenres = new ArrayList<>();
                    for (GenresDTO genreDTO : booksDTO.getGenres()) {
                        Genres genre = new Genres();
                        genre.setGenre(genreDTO.getGenre());
                        bookGenres.add(genre);
                    }
                    book.setGenres(bookGenres);
                }

                //Form
                if (booksDTO.getForm() != null) {
                    FormsDTO formsDTO = booksDTO.getForm();
                    Forms bookForms = new Forms();
                    bookForms.setForm(formsDTO.getForm());
                    book.setForm(bookForms);
                }

                //Year
                if (booksDTO.getYear() != null) {
                    book.setYear(booksDTO.getYear());
                }

                //Copies
                if (booksDTO.getCopies() != null) {
                    List<Copies> bookCopies = new ArrayList<>();
                    for (CopiesDTO copyDTO : booksDTO.getCopies()) {
                        Copies copies = new Copies();
                        copies.setCopy_number(copyDTO.getCopy_number());
                        bookCopies.add(copies);
                    }
                    book.setCopies(bookCopies);
                }

                //Languages
                if (booksDTO.getLanguages() != null) {
                    List<Languages> bookLanguages = new ArrayList<>();
                    for (LanguagesDTO langDTO : booksDTO.getLanguages()) {
                        Languages languages = new Languages();
                        languages.setLanguage(langDTO.getLanguage());
                        bookLanguages.add(languages);
                    }
                    book.setLanguages(bookLanguages);
                }
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
                    booksRepository.create(book);
                } else {
                    booksRepository.update(book);
                }
            }
        }
        genresRepository.create(genres);
        return genresDTO;
    }

    @Transactional
    public GenresDTO update(GenresDTO genresDTO) {
        Genres genres = genresENTer(genresDTO);
        genres.setId(genresDTO.getId());
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