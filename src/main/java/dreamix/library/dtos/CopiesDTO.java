package dreamix.library.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class CopiesDTO {

    private Integer id;

    private Integer copy_number;

    private Boolean isAvailable;

    private BooksDTO book;
}
