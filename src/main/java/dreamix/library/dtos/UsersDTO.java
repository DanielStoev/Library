package dreamix.library.dtos;

import dreamix.library.models.User_card;
import lombok.Data;

@Data
public class UsersDTO {

    private String name;

    private User_card card;

    private String password;
}
