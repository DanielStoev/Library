package dreamix.library.dtos;

import lombok.Data;

@Data
public class UsersDTO {

    private Integer id;

    private String name;

    private User_cardDTO card;

    private String password;
}
