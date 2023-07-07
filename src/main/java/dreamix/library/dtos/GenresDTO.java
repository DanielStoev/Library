package dreamix.library.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class GenresDTO {

    private Integer id;

    private String genre;

    private List<BooksDTO> books;
}
