package dreamix.library.services;

import dreamix.library.dtos.BooksDTO;
import dreamix.library.models.Books;
import dreamix.library.repositories.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookService extends SubService {

    SubService subService = new SubService();
    @Autowired
    private BooksRepository booksRepository;

    public List<BooksDTO> findAll() {
        List<Books> books = booksRepository.findAll();
        List<BooksDTO> booksDTOs = new ArrayList<>();

        for (Books book : books) {
            booksDTOs.add(SubService.mapToDTO(book));
        }
        return booksDTOs;
    }

    public BooksDTO findById(Integer id) {
        Books books = (Books) booksRepository.findById(id);
        return SubService.mapToDTO(books);
    }

    @Transactional
    public BooksDTO create(BooksDTO booksDTO) {
        Books books = SubService.mapToEntity(booksDTO);
        subService.saver(books);
        return booksDTO;
    }

    @Transactional
    public BooksDTO update(BooksDTO booksDTO) {
        Books books = SubService.mapToEntity(booksDTO);
        subService.saver(books);
        return booksDTO;
    }

    public void delete(Integer id) {
        booksRepository.delete(id);
    }
}


