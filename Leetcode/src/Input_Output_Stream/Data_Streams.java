package Input_Output_Stream;

import java.io.*;

public class Data_Streams {
    private String name;
    private int year;
    private boolean isIt;

    public Data_Streams(String name, int year, boolean isIt) {
        this.name = name;
        this.year = year;
        this.isIt = isIt;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public boolean isIt() {
        return isIt;
    }

    public static void main(String[] args){
        Data_Streams data_streams = new Data_Streams("Artem",17,true);
        try(DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream("src\\Input_Output_Stream\\data.bin"))){
            dataOutputStream.writeInt(data_streams.getYear());
            dataOutputStream.writeUTF(data_streams.getName());
            dataOutputStream.writeBoolean(data_streams.isIt);
            dataOutputStream.writeBoolean(false);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try(DataInputStream dataInputStream = new DataInputStream(new FileInputStream("src\\Input_Output_Stream\\data.bin"))){
            System.out.println(dataInputStream.readInt() + " " + dataInputStream.readUTF() + " " + dataInputStream.readBoolean());
            System.out.println(dataInputStream.readBoolean());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
