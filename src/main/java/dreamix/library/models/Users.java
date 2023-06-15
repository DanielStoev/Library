package dreamix.library.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@NoArgsConstructor
@Data
@Entity
public class Users {

    @Id
    private Integer user_id;

    private String name;

    private Integer card_id;
}
