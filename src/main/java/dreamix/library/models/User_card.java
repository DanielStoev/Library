package dreamix.library.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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

    @JsonBackReference
    @OneToOne
    private Users user;

    @JsonManagedReference
    @OneToMany(mappedBy = "userCard")
    private List<Books> books;

    private String take_date;

    private String return_date;
}
