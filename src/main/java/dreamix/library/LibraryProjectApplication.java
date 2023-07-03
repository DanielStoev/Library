package dreamix.library;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class LibraryProjectApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(LibraryProjectApplication.class, args);
    }
}
