package dreamix.library.repositories;

import lombok.Data;

@Data
public class Filter {
    private String name;
    private Object value1;
    private Object value2;
    private String operator;
}
