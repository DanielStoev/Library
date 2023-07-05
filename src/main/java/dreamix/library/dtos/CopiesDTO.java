package dreamix.library.dtos;

import lombok.Data;

@Data
public class CopiesDTO {

    private Integer copy_number;

    private Boolean isAvailable;

    private BooksDTO book;
}
