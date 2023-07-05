package dreamix.library.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.JoinColumn;
import java.util.List;

@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@Data
@Entity
public class Languages extends IdSubclass {

    private String language;

    @JsonBackReference
    @ManyToMany
    @JoinTable(
            name = "book_language",
            joinColumns = @JoinColumn(name = "languages_id"),
            inverseJoinColumns = @JoinColumn(name = "books_id"))
    private List<Books> books;
}
