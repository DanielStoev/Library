package dreamix.library.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Data
@Entity
public class Genres extends IdSubclass {

    private String genre;

    @JsonManagedReference
    @ManyToMany(mappedBy = "genres")
    private List<Books> books;

    public Genres(String genre) {
        this.genre = genre;
    }

}
