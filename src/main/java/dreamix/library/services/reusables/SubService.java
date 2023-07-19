package dreamix.library.services.reusables;

import dreamix.library.dtos.*;
import dreamix.library.models.*;
import dreamix.library.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public abstract class SubService {

    @Autowired
    public BooksRepository booksRepository;
    @Autowired
    public AuthorsRepository authorsRepository;
    @Autowired
    public GenresRepository genresRepository;
    @Autowired
    public LanguagesRepository languagesRepository;
    @Autowired
    public User_cardRepository userCardRepository;
    @Autowired
    public FormsRepository formsRepository;
    @Autowired
    public CopiesRepository copiesRepository;
    @Autowired
    public UsersRepository usersRepository;

    public static Books mapToEntity(BooksDTO booksDTO) {
        Books book = new Books();
        if (booksDTO.getId() != null) {
            book.setId(booksDTO.getId());
        }

        if (booksDTO.getAuthors() != null) {
            authorsAddToBook(booksDTO, book);
        }

        // Title
        if (booksDTO.getTitle() != null) {
            book.setTitle(booksDTO.getTitle());
        }

        // Genres
        if (booksDTO.getGenres() != null) {
            genresAddToBook(booksDTO, book);
        }

        // Form
        if (booksDTO.getForm() != null) {
            formsAddToBook(booksDTO, book);
        }

        // Year
        if (booksDTO.getYear() != null) {
            book.setYear(booksDTO.getYear());
        }

        // Copies
        if (booksDTO.getCopies() != null) {
            copiesAddToBook(booksDTO, book);
        }

        // Languages
        if (booksDTO.getLanguages() != null) {
            languagesAddToBook(booksDTO, book);
        }

        return book;
    }

    private static void languagesAddToBook(BooksDTO booksDTO, Books book) {
        List<Languages> bookLanguages = new ArrayList<>();
        for (LanguagesDTO langDTO : booksDTO.getLanguages()) {
            Languages languages = new Languages();
            languages.setLanguage(langDTO.getLanguage());
            bookLanguages.add(languages);
        }
        book.setLanguages(bookLanguages);
    }

    private static void copiesAddToBook(BooksDTO booksDTO, Books book) {
        List<Copies> bookCopies = new ArrayList<>();
        for (CopiesDTO copyDTO : booksDTO.getCopies()) {
            Copies copies = new Copies();
            copies.setCopy_number(copyDTO.getCopy_number());
            bookCopies.add(copies);
        }
        book.setCopies(bookCopies);
    }

    private static void formsAddToBook(BooksDTO booksDTO, Books book) {
        FormsDTO formsDTO = booksDTO.getForm();
        Forms bookForms = new Forms();
        bookForms.setForm(formsDTO.getForm());
        book.setForm(bookForms);
    }

    private static void genresAddToBook(BooksDTO booksDTO, Books book) {
        List<Genres> bookGenres = new ArrayList<>();
        for (GenresDTO genreDTO : booksDTO.getGenres()) {
            Genres genres = new Genres();
            genres.setGenre(genreDTO.getGenre());
            bookGenres.add(genres);
        }
        book.setGenres(bookGenres);
    }

    private static void authorsAddToBook(BooksDTO booksDTO, Books book) {
        List<Authors> bookAuthors = new ArrayList<>();
        for (AuthorsDTO authorDTO : booksDTO.getAuthors()) {
            Authors author = new Authors();
            author.setName(authorDTO.getName());
            author.setId(authorDTO.getId());
            bookAuthors.add(author);
        }
        book.setAuthors(bookAuthors);
    }

    public static BooksDTO mapToDTO(Books book) {
        BooksDTO booksDTO = new BooksDTO();

        if (book.getId() != null) {
            booksDTO.setId(book.getId());
        }

        if (book.getAuthors() != null) {
            authorsAddToBookDTO(book, booksDTO);
        }

        if (book.getTitle() != null) {
            booksDTO.setTitle(book.getTitle());
        }

        if (book.getGenres() != null) {
            genresAddToBookDTO(book, booksDTO);
        }

        if (book.getForm() != null) {
            formAddToBookDTO(book, booksDTO);
        }

        if (book.getYear() != null) {
            booksDTO.setYear(book.getYear());
        }

        if (book.getCopies() != null) {
            copiesAddToBookDTO(book, booksDTO);
        }

        if (book.getLanguages() != null) {
            languagesAddToBookDTO(book, booksDTO);
        }

        return booksDTO;
    }

    private static void languagesAddToBookDTO(Books book, BooksDTO booksDTO) {
        List<LanguagesDTO> bookLanguages = new ArrayList<>();
        for (Languages lang : book.getLanguages()) {
            LanguagesDTO languagesDTO = new LanguagesDTO();
            languagesDTO.setLanguage(lang.getLanguage());
            bookLanguages.add(languagesDTO);
        }
        booksDTO.setLanguages(bookLanguages);
    }

    private static void copiesAddToBookDTO(Books book, BooksDTO booksDTO) {
        List<CopiesDTO> bookCopies = new ArrayList<>();
        for (Copies copy : book.getCopies()) {
            CopiesDTO copiesDTO = new CopiesDTO();
            copiesDTO.setCopy_number(copy.getCopy_number());
            bookCopies.add(copiesDTO);
        }
        booksDTO.setCopies(bookCopies);
    }

    private static void formAddToBookDTO(Books book, BooksDTO booksDTO) {
        Forms form = book.getForm();
        FormsDTO bookForms = new FormsDTO();
        bookForms.setForm(form.getForm());
        booksDTO.setForm(bookForms);
    }

    private static void genresAddToBookDTO(Books book, BooksDTO booksDTO) {
        List<GenresDTO> bookGenres = new ArrayList<>();
        for (Genres genre : book.getGenres()) {
            GenresDTO genresDTO = new GenresDTO();
            genresDTO.setGenre(genre.getGenre());
            bookGenres.add(genresDTO);
        }
        booksDTO.setGenres(bookGenres);
    }

    private static void authorsAddToBookDTO(Books book, BooksDTO booksDTO) {
        List<AuthorsDTO> bookAuthors = new ArrayList<>();
        for (Authors author : book.getAuthors()) {
            AuthorsDTO authorsDTO = new AuthorsDTO();
            authorsDTO.setName(author.getName());
            bookAuthors.add(authorsDTO);
        }
        booksDTO.setAuthors(bookAuthors);
    }


}