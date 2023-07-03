package dreamix.library.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Data
@Entity
public class Users extends IdSubclass {

    private String name;

    @JsonManagedReference
    @OneToOne(mappedBy = "user")
    private User_card card;

    public Users(String name) {
        this.name = name;
    }
}
