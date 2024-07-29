package lesson17.POJOClasses.getClasses;

import com.fasterxml.jackson.databind.JsonNode;
import lesson17.POJOClasses.POJOBase;
import lombok.Getter;


@Getter
public class POJOGetClass extends POJOBase {

    private JsonNode args;

    private POJOGetHeader headers;

    private String url;
}
