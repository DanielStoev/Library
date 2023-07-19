package dreamix.library.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class User_cardDTO {

    private Integer id;

    private UsersDTO user;

    private List<BooksDTO> book;

    private String take_date;

    private String return_date;
}
