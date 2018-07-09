package Input_Output_Stream;

import java.io.*;
import java.util.ArrayList;

public class Serialization_Example {
    public static class Person implements Serializable{
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }
    public static void main(String[] args){
        Person person = new Person("Artem",17);
        Person person1 = new Person("Max",18);
        Person person2 = new Person("Maxim",11);
        ArrayList<Person> arrayList = new ArrayList<>();
        arrayList.add(person);arrayList.add(person1);arrayList.add(person2);
        try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("Person.dat"))){
            objectOutputStream.writeObject(arrayList);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try(ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("Person.dat"))){
            ArrayList<Person> arrayList1 = ((ArrayList<Person>)(objectInputStream.readObject()));
            for(Person person3 : arrayList1){
                System.out.println(person3.name + " " + person3.age);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
