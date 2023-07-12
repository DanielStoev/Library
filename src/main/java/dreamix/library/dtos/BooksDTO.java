package dreamix.library.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@Data
public class BooksDTO {

    private Integer id;

    private String title;

    private List<AuthorsDTO> authors;

    private List<GenresDTO> genres;

    private FormsDTO form;

    private Integer year;

    private List<LanguagesDTO> languages;

    private List<CopiesDTO> copies;

    private User_cardDTO userCard;
}
