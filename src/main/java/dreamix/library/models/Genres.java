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
public class Genres extends IdSubclass {

    private String genre;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "book_genre",
            joinColumns = @JoinColumn(name = "genre_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id"))
    private List<Books> books;
}
