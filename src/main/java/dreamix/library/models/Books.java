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
public class Books extends IdSubclass {

    private String title;

    @JsonManagedReference
    @ManyToMany(mappedBy = "books")
    private List<Authors> authors;

    @JsonBackReference
    @ManyToMany
    @JoinTable(
            name = "book_genre",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id"))
    private List<Genres> genres;

    @JsonBackReference
    @ManyToOne
    @JoinColumn
    private Forms form;

    private Integer year;

    @JsonManagedReference
    @ManyToMany(mappedBy = "books")
    private List<Languages> languages;

    @JsonManagedReference
    @OneToMany(mappedBy = "book")
    private List<Copies> copies;

    @JsonBackReference
    @ManyToOne
    @JoinColumn
    private User_card userCard;
}
