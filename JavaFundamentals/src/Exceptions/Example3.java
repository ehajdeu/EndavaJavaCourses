package Exceptions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Example3 {
    public static void main(String[] args) {
        FileInputStream fileInputStream = null;

        try {
            fileInputStream = new FileInputStream("");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally{
            try {
                fileInputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

//        try (fileInputStream = new FileInputStream("")) {
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } finally{
//            fileInputStream.close();
//        }
    }
}
