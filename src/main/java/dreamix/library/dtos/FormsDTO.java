package dreamix.library.dtos;

import lombok.Data;

import java.util.List;

@Data
public class FormsDTO {

    private Integer id;

    private String form;

    private List<BooksDTO> books;
}
