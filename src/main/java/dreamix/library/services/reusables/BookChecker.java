package dreamix.library.services.reusables;

import dreamix.library.models.Books;

import java.util.List;

public class BookChecker extends SubService {

    public void bookCheckMultiple(List<Books> books) {
        for (Books book : books) {
            if (book.getId() != null) {
                booksRepository.update(book);
            } else {
                booksRepository.create(book);
            }
        }
    }

    public void bookCheckSingle(Books book) {
        if (book.getId() != null) {
            booksRepository.update(book);
        } else {
            booksRepository.create(book);
        }
    }
}
