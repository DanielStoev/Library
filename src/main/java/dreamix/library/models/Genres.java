package dreamix.library.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@NoArgsConstructor
@Data
@Entity
public class Genres {

    @Id
    private Integer genre_id;

    private String genre;
}
