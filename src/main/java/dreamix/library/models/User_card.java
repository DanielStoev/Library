package dreamix.library.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@NoArgsConstructor
@Data
@Entity
public class User_card {

    @Id
    private Integer card_id;

    private Integer book_id;

    private String take_date;

    private String return_date;
}
