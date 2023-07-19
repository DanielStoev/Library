package dreamix.library.services;

import dreamix.library.dtos.BooksDTO;
import dreamix.library.dtos.User_cardDTO;
import dreamix.library.dtos.UsersDTO;
import dreamix.library.models.Books;
import dreamix.library.models.User_card;
import dreamix.library.models.Users;
import dreamix.library.services.reusables.BookChecker;
import dreamix.library.services.reusables.SubService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class User_cardService extends BookChecker {

    private User_cardDTO UserCardDTOer(User_card userCard) {
        User_cardDTO userCardDTO = new User_cardDTO();
        userCardDTO.setTake_date(userCard.getTake_date());
        userCardDTO.setReturn_date(userCard.getReturn_date());
        userCardDTO.setId(userCard.getId());

        List<BooksDTO> bookTitles = new ArrayList<>();
        for (Books book : userCard.getBooks()) {
            BooksDTO booksDTO = new BooksDTO();
            booksDTO.setTitle(book.getTitle());
            bookTitles.add(booksDTO);
        }
        userCardDTO.setBook(bookTitles);
        Users users = userCard.getUser();
        UsersDTO usersDTO = new UsersDTO();
        usersDTO.setName(users.getName());
        usersDTO.setId(users.getId());
        userCardDTO.setUser(usersDTO);
        return userCardDTO;
    }

    private User_card authorsENTer(User_cardDTO userCardDTO) {
        User_card userCard = new User_card();
        userCard.setTake_date(userCardDTO.getTake_date());
        userCard.setReturn_date(userCardDTO.getReturn_date());
        if (userCardDTO.getId() != null) {
            userCard.setId(userCardDTO.getId());
        }

        if (userCardDTO.getBook() != null) {
            List<Books> books = new ArrayList<>();
            for (BooksDTO booksDTO : userCardDTO.getBook()) {
                Books book = SubService.mapToEntity(booksDTO);
                books.add(book);
            }
            userCard.setBooks(books);
        }
        return userCard;
    }

    public List<User_cardDTO> findAll() {
        List userCards = userCardRepository.findAll();
        List<User_cardDTO> userCardDTOS = new ArrayList<>();

        for (Object userCard : userCards) {
            userCardDTOS.add(UserCardDTOer((User_card) userCard));
        }

        return userCardDTOS;
    }

    public User_cardDTO findById(Integer id) {
        User_card userCard = (User_card) authorsRepository.findById(id);
        return UserCardDTOer(userCard);
    }

    public User_cardDTO create(User_cardDTO userCardDTO) {
        User_card userCard = authorsENTer(userCardDTO);
        if (userCard.getBooks() != null) {
            bookCheckMultiple(userCard.getBooks());
        }
        if (userCard.getId() != null) {
            userCardRepository.update(userCard);
        } else {
            userCardRepository.create(userCard);
        }
        return userCardDTO;
    }

    public User_cardDTO update(User_cardDTO userCardDTO) {
        User_card userCard = authorsENTer(userCardDTO);
        if (userCard.getBooks() != null) {
            for (Books book : userCard.getBooks()) {
                booksRepository.update(book);
            }
        }
        userCardRepository.update(userCard);
        return userCardDTO;
    }

    public void delete(Integer id) {
        userCardRepository.delete(id);
    }
}