package dreamix.library.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class LanguagesDTO {

    private Integer id;

    private String language;

    private List<BooksDTO> books;
}
