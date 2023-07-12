package dreamix.library.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@NoArgsConstructor
public class AuthorsDTO {

    private Integer id;

    private String name;

    private List<BooksDTO> books;
}
