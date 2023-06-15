package dreamix.library.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@NoArgsConstructor
@Data
@Entity
public class Authors {

    @Id
    private Integer author_id;

    private String name;
}
