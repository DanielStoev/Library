package dreamix.library.services;

import dreamix.library.models.Books;
import dreamix.library.repositories.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    private BooksRepository booksRepository;

    public void findAll() {
        for (Books book : booksRepository.findAll()
        ) {
            System.out.println(book.getId());
        }
    }

    public void findById(Integer id) {
        System.out.println(((Books) booksRepository.findById(id)).getTitle());
    }

    public void create() {
        Books book = new Books();
        booksRepository.create(book);
    }

    public void update() {
        Books book = new Books();
        booksRepository.update(book);
    }

    public void delete(Integer id) {
        booksRepository.delete(id);
    }
}


