package dreamix.library.controllers;

import dreamix.library.dtos.BooksDTO;
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
    public List<BooksDTO> findAll() {
        return bookService.findAll();
    }

    @GetMapping("/find/{id}")
    public BooksDTO findById(@PathVariable Integer id) {
        return bookService.findById(id);
    }

    @PostMapping("/add")
    public Books create(@RequestBody Books book) {
        return bookService.create(book);
    }

    @GetMapping("/update/{id}")
    public Books update(@PathVariable Integer id) {
        return bookService.update();
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id) {
        bookService.delete(id);
    }
}
