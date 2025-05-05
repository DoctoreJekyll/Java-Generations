package org.example.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileReadTest {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\jarma\\Desktop\\GenerationsJAVA\\Java-Generations\\Java-Generations\\java-func\\src\\main\\java\\org\\example\\io\\file.txt");

        try{
            FileInputStream fileInputStream = new FileInputStream(file);
            int charM;

            while (fileInputStream.available() != 0){
                charM = fileInputStream.read();
                System.out.println(charM);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
