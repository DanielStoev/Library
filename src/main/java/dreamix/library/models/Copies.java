package dreamix.library.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@NoArgsConstructor
@Data
@Entity
public class Copies {
    @Id
    private Integer copy_id;

    private Integer copy_number;
}
