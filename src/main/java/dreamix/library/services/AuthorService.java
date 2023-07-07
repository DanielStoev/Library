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
public class AuthorService extends SubService {

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
        if (authorsDTO.getId() != null) {
            authors.setId(authorsDTO.getId());
        }

        if (authorsDTO.getBooks() != null) {
            List<Books> books = new ArrayList<>();
            for (BooksDTO booksDTO : authorsDTO.getBooks()) {
                Books book = SubService.mapToEntity(booksDTO);
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
                if (book.getId() != null) {
                    booksRepository.update(book);
                } else {
                    booksRepository.create(book);
                }
            }
        }
        if (author.getId() != null) {
            authorsRepository.update(author);
        } else {
            authorsRepository.create(author);
        }
        return authorDTO;
    }

    @Transactional
    public AuthorsDTO update(AuthorsDTO authorDTO) {
        Authors author = authorsENTer(authorDTO);
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