package jsp;

public class MyModel {
   public Person getPerson(){
       Person person = new Person();
       person.setName("Artem");
       person.setAge(17);
       return person;
   }
}
