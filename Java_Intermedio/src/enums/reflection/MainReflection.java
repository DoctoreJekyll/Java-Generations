package enums.reflection;

import java.lang.reflect.InvocationTargetException;

public class MainReflection {
    public static void main(String[] args) {

        Class clazz = null;

        try {
            clazz = Class.forName("enums.reflection.MiClase");
            Object mClass = clazz.getDeclaredConstructor().newInstance();
        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException |
                 InvocationTargetException e) {
            throw new RuntimeException(e);
        }

    }
}
