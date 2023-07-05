package dreamix.library.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Data
@Entity
public class Copies extends IdSubclass {

    private Integer copy_number;

    private Boolean isAvailable;

    @JsonBackReference
    @ManyToOne
    @JoinColumn
    private Books book;
}
