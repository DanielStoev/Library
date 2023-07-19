package dreamix.library.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class UsersDTO {

    private Integer id;

    private String name;

    private User_cardDTO card;

    private String password;
}
