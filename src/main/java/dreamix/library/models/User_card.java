package dreamix.library.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Data
@Entity
public class User_card extends IdSubclass {

    @OneToOne
    private Users user;

    @OneToMany(mappedBy = "userCard")
    private List<Books> books;

    private String take_date;

    private String return_date;
}
