package dreamix.library.services;

import dreamix.library.dtos.AuthorsDTO;
import dreamix.library.dtos.BooksDTO;
import dreamix.library.models.Authors;
import dreamix.library.models.Books;
import dreamix.library.repositories.AuthorsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorService {

    @Autowired
    private AuthorsRepository authorsRepository;

    private AuthorsDTO AuthorsDTOer(Authors author) {
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

    private Authors AuthorsENTer(AuthorsDTO authorsDTO) {
        Authors authors = new Authors();
        authors.setName(authorsDTO.getName());
        authors.setId(authorsDTO.getId());

        List<Books> bookTitles = new ArrayList<>();
        for (BooksDTO booksDTO : authorsDTO.getBooks()) {
            Books books = new Books();
            books.setTitle(booksDTO.getTitle());
            bookTitles.add(books);
        }
        authors.setBooks(bookTitles);
        return authors;
    }

    public List<AuthorsDTO> findAll() {
        List<Authors> authors = authorsRepository.findAll();
        List<AuthorsDTO> authorsDTOs = new ArrayList<>();

        for (Authors author : authors) {
            authorsDTOs.add(AuthorsDTOer(author));
        }

        return authorsDTOs;
    }

    public AuthorsDTO findById(Integer id) {
        Authors author = (Authors) authorsRepository.findById(id);
        return AuthorsDTOer(author);
    }

    public AuthorsDTO create(AuthorsDTO authorDTO) {
        Authors author;
        author = AuthorsENTer(authorDTO);
        authorsRepository.create(author);
        return authorDTO;
    }

    public void update() {
        Authors authors = new Authors();
        authorsRepository.update(authors);
    }

    public void delete(Integer id) {
        authorsRepository.delete(id);
    }


}