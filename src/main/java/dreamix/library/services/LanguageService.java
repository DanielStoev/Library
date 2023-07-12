package dreamix.library.services;

import dreamix.library.dtos.BooksDTO;
import dreamix.library.dtos.LanguagesDTO;
import dreamix.library.models.Books;
import dreamix.library.models.Languages;
import dreamix.library.services.reusables.BookChecker;
import dreamix.library.services.reusables.SubService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class LanguageService extends BookChecker {
    private LanguagesDTO genresDTOer(Languages language) {
        LanguagesDTO languagesDTO = new LanguagesDTO();
        languagesDTO.setLanguage(language.getLanguage());
        languagesDTO.setId(language.getId());

        List<BooksDTO> bookTitles = new ArrayList<>();
        for (Books book : language.getBooks()) {
            BooksDTO booksDTO = new BooksDTO();
            booksDTO.setTitle(book.getTitle());
            bookTitles.add(booksDTO);
        }
        languagesDTO.setBooks(bookTitles);
        return languagesDTO;
    }

    private Languages genresENTer(LanguagesDTO languagesDTO) {
        Languages languages = new Languages();
        languages.setLanguage(languagesDTO.getLanguage());
        if (languagesDTO.getId() != null) {
            languages.setId(languagesDTO.getId());
        }

        if (languagesDTO.getBooks() != null) {
            List<Books> books = new ArrayList<>();
            for (BooksDTO booksDTO : languagesDTO.getBooks()) {
                Books book = SubService.mapToEntity(booksDTO);
                books.add(book);
            }
            languages.setBooks(books);
        }
        return languages;
    }

    public List<LanguagesDTO> findAll() {
        List<Languages> languages = languagesRepository.findAll();
        List<LanguagesDTO> languagesDTOS = new ArrayList<>();

        for (Languages language : languages) {
            languagesDTOS.add(genresDTOer(language));
        }

        return languagesDTOS;
    }

    public LanguagesDTO findById(Integer id) {
        Languages languages = (Languages) languagesRepository.findById(id);
        return genresDTOer(languages);
    }

    @Transactional
    public LanguagesDTO create(LanguagesDTO languagesDTO) {
        Languages languages = genresENTer(languagesDTO);
        if (languages.getBooks() != null) {
            bookCheckMultiple(languages.getBooks());
        }
        if (languages.getId() != null) {
            languagesRepository.update(languages);
        } else {
            languagesRepository.create(languages);
        }
        return languagesDTO;
    }

    @Transactional
    public LanguagesDTO update(LanguagesDTO languagesDTO) {
        Languages languages = genresENTer(languagesDTO);
        if (languages.getBooks() != null) {
            for (Books book : languages.getBooks()) {
                booksRepository.update(book);
            }
        }
        languagesRepository.update(languages);
        return languagesDTO;
    }

    public void delete(Integer id) {
        genresRepository.delete(id);
    }
}


