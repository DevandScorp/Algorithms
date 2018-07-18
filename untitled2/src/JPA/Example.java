package JPA;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Date;

public class Example {
    public static void main(String[] args){
        /**
         * select * FROM students d WHERE d.name="Leha" and id = 1
         */
            EntityManagerFactory unit = Persistence.createEntityManagerFactory("NewPersistenceUnit");
            EntityManager entityManager = unit.createEntityManager();
            /**Это самая обычная транзакция со всеми соответствующими методами*/
            EntityTransaction transaction = entityManager.getTransaction();
            /**
             * entityManager.getTransaction().begin();
             * entityManager.persist(new Student("Nikita",19,new Date()));
             * entityManager.getTransaction().commit();
             */
        /**
         * Чтобы все работало,не забывай,что таблица то одна.И тип если в одной ты установил
         * primary key отдельный,то изменить его уже нельзя и нужно создавать новую таблицу
         */
        transaction.begin();
            entityManager.persist(new Student("Leha", 19, new Date()));
            transaction.commit();
            unit.close();


    }
}
