package Input_Output_Stream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class File_Output_Stream {
    public static void main(String[] args) {
        String word = "Hello world";
        try(FileOutputStream fileOutputStream = new FileOutputStream("src\\Input_Output_Stream\\Text.txt")){
            byte[] words = word.getBytes();
            fileOutputStream.write(words,0,words.length);
            fileOutputStream.flush();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        StringBuilder stringBuilder = new StringBuilder();
        try(FileInputStream fileInputStream = new FileInputStream("src\\Input_Output_Stream\\Text.txt")){
            int c=-1;
            while((c = fileInputStream.read())!=-1){
                stringBuilder.append((char)c);
                            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(stringBuilder.toString());
        try(FileInputStream fileInputStream = new FileInputStream("src\\Input_Output_Stream\\Text.txt");
        FileOutputStream fileOutputStream = new FileOutputStream("src\\Input_Output_Stream\\Text_2.txt")){
            byte[] buffer = new byte[fileInputStream.available()];
            fileInputStream.read(buffer,0,buffer.length);
            fileOutputStream.write(buffer,0,buffer.length);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
