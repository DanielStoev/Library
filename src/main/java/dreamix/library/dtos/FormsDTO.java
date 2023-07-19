package dreamix.library.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class FormsDTO {

    private Integer id;

    private String form;

    private List<BooksDTO> books;
}
