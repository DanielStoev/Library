package dreamix.library;

import dreamix.library.services.AuthorService;
import dreamix.library.services.BookService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class LibraryProjectApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(LibraryProjectApplication.class, args);
        AuthorService authorService = context.getBean(AuthorService.class);
        BookService bookService = context.getBean(BookService.class);
//        authorService.create();
//        authorService.delete(7);
//        authorService.findById(8);
        authorService.findAll();
    }
}
