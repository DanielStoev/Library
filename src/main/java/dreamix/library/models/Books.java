package dreamix.library.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@NoArgsConstructor
@Data
@Entity
public class Books {

    @Id
    private Integer book_id;

    private String title;

    private Integer author_id;

    private Integer genre_id;

    private Integer form_id;

    private Integer year;

    private Integer language_id;

    private Integer copy_id;
}
