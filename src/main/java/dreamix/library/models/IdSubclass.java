package dreamix.library.models;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@Data
@MappedSuperclass
public class IdSubclass {
    @Id
    private Integer id;
}
