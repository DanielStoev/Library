package dreamix.library.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class AuthorsDTO {

    private Integer id;

    private String name;

    private List<BooksDTO> books;
}
