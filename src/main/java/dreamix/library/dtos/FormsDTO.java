package dreamix.library.dtos;

import lombok.Data;

import java.util.List;

@Data
public class FormsDTO {

    private String form;

    private List<BooksDTO> books;
}
