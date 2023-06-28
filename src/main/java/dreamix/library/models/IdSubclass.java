package dreamix.library.models;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@Data
@MappedSuperclass
public class IdSubclass {
    @Id
    @GeneratedValue
    private Integer id;
}
