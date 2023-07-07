package dreamix.library.dtos;

import lombok.Data;

import java.util.List;

@Data
public class User_cardDTO {

    private Integer id;

    private UsersDTO user;

    private List<BooksDTO> book;

    private String take_date;

    private String return_date;
}
