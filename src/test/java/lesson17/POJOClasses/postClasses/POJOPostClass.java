package lesson17.POJOClasses.postClasses;

import com.fasterxml.jackson.databind.JsonNode;
import lesson17.POJOClasses.POJOBase;
import lombok.Getter;

@Getter
public class POJOPostClass extends POJOBase {

    private JsonNode args;

    private String data;

    private JsonNode files;

    private JsonNode form;

    private POJOPostHeader headers;

    private JsonNode json;

    private String url;

}
