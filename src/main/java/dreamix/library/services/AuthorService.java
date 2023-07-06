package dreamix.library.services;

import dreamix.library.dtos.*;
import dreamix.library.models.*;
import dreamix.library.repositories.AuthorsRepository;
import dreamix.library.repositories.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorService {

    @Autowired
    private AuthorsRepository authorsRepository;
    @Autowired
    private BooksRepository booksRepository;

    private AuthorsDTO authorsDTOer(Authors author) {
        AuthorsDTO authorsDTO = new AuthorsDTO();
        authorsDTO.setName(author.getName());
        authorsDTO.setId(author.getId());

        List<BooksDTO> bookTitles = new ArrayList<>();
        for (Books book : author.getBooks()) {
            BooksDTO booksDTO = new BooksDTO();
            booksDTO.setTitle(book.getTitle());
            bookTitles.add(booksDTO);
        }
        authorsDTO.setBooks(bookTitles);
        return authorsDTO;
    }

    private Authors authorsENTer(AuthorsDTO authorsDTO) {
        Authors authors = new Authors();
        authors.setName(authorsDTO.getName());

        List<Books> books = new ArrayList<>();
        if (authorsDTO.getBooks() != null) {
            for (BooksDTO booksDTO : authorsDTO.getBooks()) {
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
                        Genres genres = new Genres();
                        genres.setGenre(genreDTO.getGenre());
                        bookGenres.add(genres);
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
            authors.setBooks(books);
        }
        return authors;
    }

    public List<AuthorsDTO> findAll() {
        List<Authors> authors = authorsRepository.findAll();
        List<AuthorsDTO> authorsDTOs = new ArrayList<>();

        for (Authors author : authors) {
            authorsDTOs.add(authorsDTOer(author));
        }

        return authorsDTOs;
    }

    public AuthorsDTO findById(Integer id) {
        Authors author = (Authors) authorsRepository.findById(id);
        return authorsDTOer(author);
    }

    @Transactional
    public AuthorsDTO create(AuthorsDTO authorDTO) {
        Authors author = authorsENTer(authorDTO);
        if (author.getBooks() != null) {
            for (Books book : author.getBooks()) {
                booksRepository.create(book);
            }
        }
        authorsRepository.create(author);
        return authorDTO;
    }

    @Transactional
    public AuthorsDTO update(AuthorsDTO authorDTO) {
        Authors author = authorsENTer(authorDTO);
        author.setId(authorDTO.getId());
        if (author.getBooks() != null) {
            for (Books book : author.getBooks()) {
                booksRepository.update(book);
            }
        }
        authorsRepository.update(author);
        return authorDTO;
    }

    public void delete(Integer id) {
        authorsRepository.delete(id);
    }


}