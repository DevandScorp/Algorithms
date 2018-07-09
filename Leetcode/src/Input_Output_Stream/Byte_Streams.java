package Input_Output_Stream;

import java.io.*;
import java.util.Arrays;
public class Byte_Streams {
    public static void main(String[] args) throws IOException {
        //ByteArrayInputStream-ничего особенного.В параметрах либо просто массив байтов,
        //либо offset и length
        //А вот ByteArrayOutputStream-
        try(ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()){
            byte[] buffer = new String("Welcome").getBytes();
            byteArrayOutputStream.write(buffer);
            System.out.println(byteArrayOutputStream.toString());//вот это прикольно
            System.out.println(Arrays.toString(byteArrayOutputStream.toByteArray()));//и это тоже
        } catch (IOException e) {
            e.printStackTrace();
        }
        //Вот как работает BufferedWriter.
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src\\Input_Output_Stream\\Text.txt"));
        bufferedWriter.write("Hello");
        bufferedWriter.newLine();
        bufferedWriter.write("Again");
        bufferedWriter.flush();
        bufferedWriter.close();
    }
}
