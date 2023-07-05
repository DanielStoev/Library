package dreamix.library.services;

import dreamix.library.dtos.*;
import dreamix.library.models.*;
import dreamix.library.repositories.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    @Autowired
    private BooksRepository booksRepository;

    private BooksDTO BookDTOer(Books book) {
        BooksDTO booksDTO = new BooksDTO();

        //Authors
        List<AuthorsDTO> bookAuthors = new ArrayList<>();
        for (Authors author : book.getAuthors()) {
            AuthorsDTO authorsDTO = new AuthorsDTO();
            authorsDTO.setName(author.getName());
            bookAuthors.add(authorsDTO);
        }
        booksDTO.setAuthors(bookAuthors);

        //Tittle
        booksDTO.setTitle(book.getTitle());

        //Genres
        List<GenresDTO> bookGenres = new ArrayList<>();
        for (Genres genre : book.getGenres()) {
            GenresDTO genresDTO = new GenresDTO();
            genresDTO.setGenre(genre.getGenre());
            bookGenres.add(genresDTO);
        }
        booksDTO.setGenres(bookGenres);

        //Form
        Forms form = book.getForm();
        FormsDTO bookForms = new FormsDTO();
        bookForms.setForm(form.getForm());
        booksDTO.setForm(bookForms);

        //Year
        booksDTO.setYear(book.getYear());

        //Copies
        List<CopiesDTO> bookCopies = new ArrayList<>();
        for (Copies copy : book.getCopies()) {
            CopiesDTO copiesDTO = new CopiesDTO();
            copiesDTO.setCopy_number(copy.getCopy_number());
            bookCopies.add(copiesDTO);
        }
        booksDTO.setCopies(bookCopies);

        //Languages
        List<LanguagesDTO> bookLanguages = new ArrayList<>();
        for (Languages lang : book.getLanguages()) {
            LanguagesDTO languagesDTO = new LanguagesDTO();
            languagesDTO.setLanguage(lang.getLanguage());
            bookLanguages.add(languagesDTO);
        }
        booksDTO.setLanguages(bookLanguages);

        return booksDTO;
    }

    public List<BooksDTO> findAll() {
        List<Books> books = booksRepository.findAll();
        List<BooksDTO> booksDTOs = new ArrayList<>();

        for (Books book : books) {
            booksDTOs.add(BookDTOer(book));
        }

        return booksDTOs;
    }

    public BooksDTO findById(Integer id) {
        Books book = (Books) booksRepository.findById(id);

        return BookDTOer(book);
    }

    public Books create(Books book) {
        booksRepository.create(book);
        return book;
    }

    public Books update() {
        Books book = new Books();
        booksRepository.update(book);
        return null;
    }

    public void delete(Integer id) {
        booksRepository.delete(id);
    }
}


