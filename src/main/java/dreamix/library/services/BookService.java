package dreamix.library.services;

import dreamix.library.models.Books;
import dreamix.library.repositories.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    private BooksRepository booksRepository;

    public void test() {
        for (Books book : booksRepository.findAll()
        ) {
            System.out.println(book);
        }
    }
}