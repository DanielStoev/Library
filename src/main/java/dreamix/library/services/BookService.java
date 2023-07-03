package dreamix.library.services;

import dreamix.library.models.Books;
import dreamix.library.repositories.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BooksRepository booksRepository;

    public List<Books> findAll() {
        return booksRepository.findAll();
    }

    public void findById(Integer id) {
        System.out.println(((Books) booksRepository.findById(id)).getTitle());
    }

    public Books create(Books book) {
        booksRepository.create(book);
        return book;
    }

    public void update() {
        Books book = new Books();
        booksRepository.update(book);
    }

    public void delete(Integer id) {
        booksRepository.delete(id);
    }
}


