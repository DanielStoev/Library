package dreamix.library.services;

import dreamix.library.dtos.BooksDTO;
import dreamix.library.dtos.FormsDTO;
import dreamix.library.models.Books;
import dreamix.library.models.Forms;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class FormService extends SubService {

    private FormsDTO formsDTOer(Forms forms) {
        FormsDTO formsDTO = new FormsDTO();
        formsDTO.setForm(forms.getForm());
        formsDTO.setId(forms.getId());

        List<BooksDTO> bookTitles = new ArrayList<>();
        for (Books book : forms.getBooks()) {
            BooksDTO booksDTO = new BooksDTO();
            booksDTO.setTitle(book.getTitle());
            bookTitles.add(booksDTO);
        }
        formsDTO.setBooks(bookTitles);
        return formsDTO;
    }

    private Forms formsENTer(FormsDTO formsDTO) {
        Forms forms = new Forms();
        forms.setForm(formsDTO.getForm());
        if (formsDTO.getId() != null) {
            forms.setId(formsDTO.getId());
        }

        if (formsDTO.getBooks() != null) {
            List<Books> books = new ArrayList<>();
            for (BooksDTO booksDTO : formsDTO.getBooks()) {
                Books book = SubService.mapToEntity(booksDTO);
                books.add(book);
            }
            forms.setBooks(books);
        }
        return forms;
    }

    public List<FormsDTO> findAll() {
        List<Forms> forms = formsRepository.findAll();
        List<FormsDTO> formsDTO = new ArrayList<>();

        for (Forms form : forms) {
            formsDTO.add(formsDTOer(form));
        }

        return formsDTO;
    }

    public FormsDTO findById(Integer id) {
        Forms forms = (Forms) formsRepository.findById(id);
        return formsDTOer(forms);
    }

    @Transactional
    public FormsDTO create(FormsDTO formsDTO) {
        Forms forms = formsENTer(formsDTO);
        if (forms.getBooks() != null) {
            for (Books book : forms.getBooks()) {
                if (book.getId() != null) {
                    booksRepository.update(book);
                } else {
                    booksRepository.create(book);
                }
            }
        }
        if (forms.getId() != null) {
            formsRepository.update(forms);
        } else {
            formsRepository.create(forms);
        }
        return formsDTO;
    }

    @Transactional
    public FormsDTO update(FormsDTO formsDTO) {
        Forms forms = formsENTer(formsDTO);
        if (forms.getBooks() != null) {
            for (Books book : forms.getBooks()) {
                booksRepository.update(book);
            }
        }
        formsRepository.update(forms);
        return formsDTO;
    }

    public void delete(Integer id) {
        formsRepository.delete(id);
    }
}