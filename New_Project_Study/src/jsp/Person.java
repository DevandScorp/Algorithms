package jsp;

public class Person {
    private String name;
    private int age;

    /**
     * Бин-это класс,у которого есть приватные поля и геттеры и сеттеры к нему
     * @return
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
