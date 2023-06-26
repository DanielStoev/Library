package dreamix.library.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Data
@Entity(name = "BOOKS")
public class Books extends IdSubclass {

    private String title;

    @ManyToMany(mappedBy = "books")
    private List<Authors> authors;

    @ManyToMany(mappedBy = "books")
    private List<Genres> genres;

    @ManyToOne
    @JoinColumn
    private Forms form;

    private Integer year;

    @ManyToMany(mappedBy = "books")
    private List<Languages> languages;

    @OneToMany(mappedBy = "book")
    private List<Copies> copies;

    @ManyToOne
    @JoinColumn
    private User_card userCard;
}
