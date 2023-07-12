package dreamix.library.controllers;

import dreamix.library.dtos.BooksDTO;
import dreamix.library.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/books", consumes = "application/json;charset=UTF-8")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/all")
    public List<BooksDTO> findAll() {
        return bookService.findAll();
    }

    @GetMapping("/findById/{id}")
    public BooksDTO findById(@PathVariable Integer id) {
        return bookService.findById(id);
    }

    @GetMapping("/findByAuthor/{author}")
    public List<BooksDTO> findAuthors(@PathVariable String author) {
        return bookService.findBooksByAuthors(author);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json; CHARSET=UTF-8", consumes = "application/json;charset=UTF-8")
    public BooksDTO create(@RequestBody BooksDTO booksDTO) {
        return bookService.create(booksDTO);
    }

    @PutMapping(value = "/update", produces = "application/json; CHARSET=UTF-8", consumes = "application/json;charset=UTF-8")
    public BooksDTO update(@RequestBody BooksDTO booksDTO) {
        return bookService.update(booksDTO);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id) {
        bookService.delete(id);
    }
}