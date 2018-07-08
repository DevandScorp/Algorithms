package Threads;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

public class Piped_Reader_Writer_Example {
    final static PipedReader pipedReader = new PipedReader();
    final static PipedWriter pipedWriter = new PipedWriter();
    static {
        try {
            pipedReader.connect(pipedWriter);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        Thread writer_Thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 65;i<=70;++i){
                    try {
                        pipedWriter.write((char)i);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        Thread reader_Thread = new Thread(new Runnable() {
            @Override
            public void run() {
                char c;
                try {
                    while ((c = (char)pipedReader.read()) != -1) {
                        System.out.println(c);
                    }
                }catch(IOException e){

                }
            }
        });
        writer_Thread.start();
        reader_Thread.start();
    }
}
