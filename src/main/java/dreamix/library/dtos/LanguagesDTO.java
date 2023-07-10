package dreamix.library.dtos;

import lombok.Data;

import java.util.List;

@Data
public class LanguagesDTO {

    private Integer id;

    private String language;

    private List<BooksDTO> books;
}
