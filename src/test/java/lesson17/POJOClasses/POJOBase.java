package lesson17.POJOClasses;

import java.lang.reflect.Field;

public abstract class POJOBase {

    public boolean isSomeFieldNull() throws NullPointerException {
        for (Field f : getClass().getDeclaredFields()) {
            f.setAccessible(true);
            try {
                if (f.get(this) == null || (f.get(this).toString()).equals("null")) {
                    throw new NullPointerException(f.getName());
                }
            } catch (IllegalAccessException e) {
                System.out.println(e.getMessage());
            }
        }
        return false;
    }
}
