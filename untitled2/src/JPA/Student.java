package JPA;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * имя таблицы
 */
@Entity(name = "students3")
@Access(AccessType.FIELD)
/**
 * AccessType.FIELD-будем иметь доступ через поля
 * AccessType.PROPERTY-только через геттеры и сеттеры
 * Т.е. если ты укажешь property,то оно будет возвращать занчение,полученное из геттера(где ты можешь
 * менять значение),а не непосредственно из поля
 */
//@SecondaryTable(name = "address")
public class Student {
/**   @Id */
    /**
     * AUTO-по умолчанию
     *
     */
/**   @GeneratedValue*/
    @EmbeddedId
    MyId myId;
/**   int id;
//    @Id
//    String name;
//    @Id

//    int age;*/
/**Храниться в базе не будет*/
@Transient
String surname;
    /**
     * EAGER будет сразу загружаться в память полностью
     * LAZY -загружается частично,и только при обращении загрузится полностью
     * (Юзать для редко используемых и больших объектов)
     */
    @Basic(fetch = FetchType.EAGER,optional = false)
    /**
     * optional-может быть null,not null
     */
    /**
     * Имя колонки
     * nullable-чтобы не был нулевой
     */
    /**
     * @Temporal-для удобства воспроизведения
     */
    @Column(name = "birth_day",length = 50,unique = true,nullable = false)
            @Temporal(TemporalType.TIMESTAMP)
    Date birth;/**LocalDate не пашет.А вот Calendar пашет**/
    /**    @Column(table = "address")
//    String city;
//    @Column(table = "address")
//    String street;*/
    public Student() {
    }

    public Student(String name, int age, Date birth) {
        this.myId = new MyId();
        myId.setAge(age);
        myId.setName(name);
/**        this.age = age;*/
        this.birth = birth;
    }
}
@Embeddable
class MyId implements Serializable {
    String name;
    int age;

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

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
