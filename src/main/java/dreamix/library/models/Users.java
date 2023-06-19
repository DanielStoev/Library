package dreamix.library.models;

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

    @OneToOne(mappedBy = "user")
    private User_card card;
}
