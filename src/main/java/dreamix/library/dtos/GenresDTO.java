package dreamix.library.dtos;

import lombok.Data;

import java.util.List;

@Data
public class GenresDTO {

    private String genre;

    private List<BooksDTO> books;
}
