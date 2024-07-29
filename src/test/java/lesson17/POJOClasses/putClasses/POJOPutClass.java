package lesson17.POJOClasses.putClasses;

import com.fasterxml.jackson.databind.JsonNode;
import lesson17.POJOClasses.POJOBase;
import lombok.Getter;

import java.lang.reflect.Field;


@Getter
public class POJOPutClass extends POJOBase {

    private JsonNode args;

    private String data;

    private JsonNode files;

    private JsonNode form;

    private POJOPutHeader headers;

    private JsonNode json;

    private String url;


    //Делаем исключение для json поля
    @Override
    public boolean isSomeFieldNull() throws NullPointerException {
        for (Field f : getClass().getDeclaredFields()) {
            f.setAccessible(true);
            try {
                if (f.get(this) == null || (f.get(this).toString()).equals("null") && !f.getName().equals("json")) {
                    throw new NullPointerException(f.getName());
                }
            } catch (IllegalAccessException e) {
                System.out.println(e.getMessage());
            }
        }
        return false;
    }
}
