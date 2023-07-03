package dreamix.library.controllers;

import dreamix.library.models.Books;
import dreamix.library.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/all")
    public List<Books> findAll() {
        return bookService.findAll();
    }

    @PostMapping("/add")
    public Books create(@RequestBody Books book) {
        return bookService.create(book);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id) {
        bookService.delete(id);
    }
}
