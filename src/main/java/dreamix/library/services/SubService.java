package dreamix.library.services;

import dreamix.library.dtos.*;
import dreamix.library.models.*;
import dreamix.library.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

public class SubService {

    @Autowired
    private BooksRepository booksRepository;

    @Autowired
    private AuthorsRepository authorsRepository;

    @Autowired
    private GenresRepository genresRepository;

    @Autowired
    private LanguagesRepository languagesRepository;

    @Autowired
    private User_cardRepository userCardRepository;

    @Autowired
    private FormsRepository formsRepository;

    @Autowired
    private CopiesRepository copiesRepository;

    public static Books mapToEntity(BooksDTO booksDTO) {
        Books book = new Books();
        if (booksDTO.getId() != null) {
            book.setId(booksDTO.getId());
        }

        // Authors
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

        // Title
        if (booksDTO.getTitle() != null) {
            book.setTitle(booksDTO.getTitle());
        }

        // Genres
        if (booksDTO.getGenres() != null) {
            List<Genres> bookGenres = new ArrayList<>();
            for (GenresDTO genreDTO : booksDTO.getGenres()) {
                Genres genres = new Genres();
                genres.setGenre(genreDTO.getGenre());
                bookGenres.add(genres);
            }
            book.setGenres(bookGenres);
        }

        // Form
        if (booksDTO.getForm() != null) {
            FormsDTO formsDTO = booksDTO.getForm();
            Forms bookForms = new Forms();
            bookForms.setForm(formsDTO.getForm());
            book.setForm(bookForms);
        }

        // Year
        if (booksDTO.getYear() != null) {
            book.setYear(booksDTO.getYear());
        }

        // Copies
        if (booksDTO.getCopies() != null) {
            List<Copies> bookCopies = new ArrayList<>();
            for (CopiesDTO copyDTO : booksDTO.getCopies()) {
                Copies copies = new Copies();
                copies.setCopy_number(copyDTO.getCopy_number());
                bookCopies.add(copies);
            }
            book.setCopies(bookCopies);
        }

        // Languages
        if (booksDTO.getLanguages() != null) {
            List<Languages> bookLanguages = new ArrayList<>();
            for (LanguagesDTO langDTO : booksDTO.getLanguages()) {
                Languages languages = new Languages();
                languages.setLanguage(langDTO.getLanguage());
                bookLanguages.add(languages);
            }
            book.setLanguages(bookLanguages);
        }

        return book;
    }

    public static BooksDTO mapToDTO(Books book) {
        BooksDTO booksDTO = new BooksDTO();

        if (book.getId() != null) {
            booksDTO.setId(book.getId());
        }

        //Authors
        if (book.getAuthors() != null) {
            List<AuthorsDTO> bookAuthors = new ArrayList<>();
            for (Authors author : book.getAuthors()) {
                AuthorsDTO authorsDTO = new AuthorsDTO();
                authorsDTO.setName(author.getName());
                bookAuthors.add(authorsDTO);
            }
            booksDTO.setAuthors(bookAuthors);
        }

        //Tittle
        if (book.getTitle() != null) {
            booksDTO.setTitle(book.getTitle());
        }

        //Genres
        if (book.getGenres() != null) {
            List<GenresDTO> bookGenres = new ArrayList<>();
            for (Genres genre : book.getGenres()) {
                GenresDTO genresDTO = new GenresDTO();
                genresDTO.setGenre(genre.getGenre());
                bookGenres.add(genresDTO);
            }
            booksDTO.setGenres(bookGenres);
        }

        //Form
        if (book.getForm() != null) {
            Forms form = book.getForm();
            FormsDTO bookForms = new FormsDTO();
            bookForms.setForm(form.getForm());
            booksDTO.setForm(bookForms);
        }

        //Year
        if (book.getYear() != null) {
            booksDTO.setYear(book.getYear());
        }

        //Copies
        if (book.getCopies() != null) {
            List<CopiesDTO> bookCopies = new ArrayList<>();
            for (Copies copy : book.getCopies()) {
                CopiesDTO copiesDTO = new CopiesDTO();
                copiesDTO.setCopy_number(copy.getCopy_number());
                bookCopies.add(copiesDTO);
            }
            booksDTO.setCopies(bookCopies);
        }

        //Languages
        if (book.getLanguages() != null) {
            List<LanguagesDTO> bookLanguages = new ArrayList<>();
            for (Languages lang : book.getLanguages()) {
                LanguagesDTO languagesDTO = new LanguagesDTO();
                languagesDTO.setLanguage(lang.getLanguage());
                bookLanguages.add(languagesDTO);
            }
            booksDTO.setLanguages(bookLanguages);
        }

        return booksDTO;
    }

    @Transactional
    public void saver(Books book) {
        if (book.getId() != null) {
            booksRepository.update(book);
        } else {
            booksRepository.create(book);
        }
        if (book.getAuthors() != null) {
            for (Authors authors : book.getAuthors()) {
                if (authors.getId() != null) {
                    authorsRepository.update(authors);
                } else {
                    authorsRepository.create(authors);
                }
            }
        }
        if (book.getGenres() != null) {
            for (Genres genres : book.getGenres()) {
                if (genres.getId() != null) {
                    genresRepository.update(genres);
                } else {
                    genresRepository.create(genres);
                }
            }
        }
        if (book.getLanguages() != null) {
            for (Languages languages : book.getLanguages()) {
                if (languages.getId() != null) {
                    languagesRepository.update(languages);
                } else {
                    languagesRepository.create(languages);
                }
            }
        }
        if (book.getUserCard() != null) {
            User_card userCard = book.getUserCard();
            if (userCard.getId() != null) {
                userCardRepository.update(userCard);
            } else {
                userCardRepository.create(userCard);
            }
        }
        if (book.getForm() != null) {
            Forms forms = book.getForm();
            if (forms.getId() != null) {
                formsRepository.update(forms);
            } else {
                formsRepository.create(forms);
            }
        }
        if (book.getCopies() != null) {
            for (Copies copies : book.getCopies()) {
                if (copies.getId() != null) {
                    copiesRepository.update(copies);
                } else {
                    copiesRepository.create(copies);
                }
            }
        }
    }
}
