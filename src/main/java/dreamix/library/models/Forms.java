package dreamix.library.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Data
@Entity
public class Forms extends IdSubclass {

    private String form;

    @OneToMany(mappedBy = "form")
    private List<Books> books;

    public Forms(String form) {
        this.form = form;
    }
}
