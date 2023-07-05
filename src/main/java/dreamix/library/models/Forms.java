package dreamix.library.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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

    @JsonManagedReference
    @OneToMany(mappedBy = "form")
    private List<Books> books;
}
