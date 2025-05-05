package anotations.uno;

import java.lang.reflect.Method;

public class AnnotationProcessor {

    public static void main(String[] args) throws NoSuchMethodException {
        Class<MyClass> clazz = MyClass.class;

        Method myMethod = clazz.getMethod("myAnnotation");
        if(myMethod.isAnnotationPresent(MyCustomAnnotation.class)){
            MyCustomAnnotation annotation = myMethod.getAnnotation(MyCustomAnnotation.class);
            assert annotation != null;
            String value = annotation.value();
            int count = annotation.count();

            System.out.println("MyCustomAnnotation value(): " + value);
            System.out.println("MyCustomAnnotation count(): " + count);
        }
    }

}
