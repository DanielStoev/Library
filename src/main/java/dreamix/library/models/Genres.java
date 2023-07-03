package dreamix.library.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Data
@Entity
public class Genres extends IdSubclass {

    private String genre;

    @ManyToMany(mappedBy = "genres")
    private Set<Books> books;

    public Genres(String genre) {
        this.genre = genre;
    }

}
