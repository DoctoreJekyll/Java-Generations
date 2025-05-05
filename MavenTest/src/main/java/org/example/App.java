package org.example;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        String json = "{\"id\":1,\"name\":\"<NAME>\",\"email\":\"<EMAIL>\"}";
        User user = new User(1, "<NAME>", "<EMAIL>");
        System.out.println(user);
    }
}
