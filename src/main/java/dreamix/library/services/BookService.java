package dreamix.library.services;

import dreamix.library.dtos.BooksDTO;
import dreamix.library.models.*;
import dreamix.library.services.reusables.SubService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookService extends SubService {

    public List<BooksDTO> findAll() {
        List<Books> books = booksRepository.findAll();
        List<BooksDTO> booksDTOs = new ArrayList<>();

        for (Books book : books) {
            booksDTOs.add(SubService.mapToDTO(book));
        }
        return booksDTOs;
    }

    public BooksDTO findById(Integer id) {
        Books books = (Books) booksRepository.findById(id);
        return SubService.mapToDTO(books);
    }

    public List<BooksDTO> findBooksByAuthors(String authorName) {
        List<BooksDTO> booksDTO = new ArrayList<>();
        List<Books> books = booksRepository.findBooksByAuthor(authorName);
        for (Books book : books) {
            booksDTO.add(SubService.mapToDTO(book));
        }
        return booksDTO;
    }

    @Transactional
    public BooksDTO create(BooksDTO booksDTO) {
        Books book = mapToEntity(booksDTO);
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
        return booksDTO;
    }

    @Transactional
    public BooksDTO update(BooksDTO booksDTO) {
        Books book = mapToEntity(booksDTO);
        booksRepository.update(book);
        return booksDTO;
    }

    public void delete(Integer id) {
        booksRepository.delete(id);
    }
}