package anotations.uno;

public class MyClass
{

    @MyCustomAnnotation(value = "custom value", count = 42)
    public void myAnnotation()
    {
        System.out.println("Hola mundo");
    }
}
