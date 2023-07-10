package dreamix.library.services;

import dreamix.library.dtos.BooksDTO;
import dreamix.library.dtos.CopiesDTO;
import dreamix.library.models.Books;
import dreamix.library.models.Copies;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class CopyService extends SubService {

    private CopiesDTO copiesDTOer(Copies copies) {
        CopiesDTO copiesDTO = new CopiesDTO();
        copiesDTO.setCopy_number(copies.getCopy_number());
        copiesDTO.setId(copies.getId());
        copiesDTO.setIsAvailable(copies.getIsAvailable());
        Books books = new Books();
        BooksDTO booksDTO = new BooksDTO();
        booksDTO.setTitle(books.getTitle());
        copiesDTO.setBook(booksDTO);
        return copiesDTO;
    }

    private Copies copiesENTer(CopiesDTO copiesDTO) {
        Copies copies = new Copies();
        copies.setCopy_number(copiesDTO.getCopy_number());
        copies.setIsAvailable(copiesDTO.getIsAvailable());
        if (copiesDTO.getId() != null) {
            copies.setId(copiesDTO.getId());
        }

        if (copiesDTO.getBook() != null) {
            BooksDTO booksDTO = copiesDTO.getBook();
            Books book = SubService.mapToEntity(booksDTO);
            copies.setBook(book);
        }
        return copies;
    }

    public List<CopiesDTO> findAll() {
        List<Copies> copy = copiesRepository.findAll();
        List<CopiesDTO> copiesDTOS = new ArrayList<>();

        for (Copies copies : copy) {
            copiesDTOS.add(copiesDTOer(copies));
        }

        return copiesDTOS;
    }

    public CopiesDTO findById(Integer id) {
        Copies copies = (Copies) copiesRepository.findById(id);
        return copiesDTOer(copies);
    }

    @Transactional
    public CopiesDTO create(CopiesDTO copiesDTO) {
        Copies copies = copiesENTer(copiesDTO);
        if (copies.getBook() != null) {
            Books books = copies.getBook();
            if (books.getId() != null) {
                booksRepository.update(books);
            } else {
                booksRepository.create(books);
            }
        }
        if (copies.getId() != null) {
            copiesRepository.update(copies);
        } else {
            copiesRepository.create(copies);
        }
        return copiesDTO;
    }

    @Transactional
    public CopiesDTO update(CopiesDTO copiesDTO) {
        Copies copies = copiesENTer(copiesDTO);
        if (copies.getBook() != null) {
            Books book = copies.getBook();
            booksRepository.update(book);
        }
        copiesRepository.update(copies);
        return copiesDTO;
    }

    public void delete(Integer id) {
        copiesRepository.delete(id);
    }
}