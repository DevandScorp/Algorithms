package Tomcat_EE;


import javax.enterprise.event.Event;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.inject.Qualifier;
import javax.inject.Singleton;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/events")
public class Bean_Events  extends HttpServlet {
    @Inject
    BookService bookService;
    @Inject
    BookSubscriber bookSubscriber;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Book book = new Book("one");
        bookService.addBook(book);
        System.out.println(bookSubscriber.bookList.size());
        bookService.removeBook(book);
        System.out.println(bookSubscriber.bookList.size());
    }
}
@Qualifier
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD,ElementType.TYPE,ElementType.METHOD,ElementType.PARAMETER})
@interface Add {}
@Qualifier
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD,ElementType.TYPE,ElementType.METHOD,ElementType.PARAMETER})
@interface Remove {}
class Book{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Book(String name) {

        this.name = name;
    }
}
class BookService{
    @Inject
    @Add
    Event<Book> addEvent;
    @Inject
    @Remove
    Event<Book> removeEvent;
    public void addBook(Book book){
        System.out.println(book.getName()+ " book was added");
        addEvent.fire(book);
    }
    public void removeBook(Book book){
        System.out.println(book.getName() + " was deleted");
        removeEvent.fire(book);
    }
}

/**
 * Это observer.
 */
@Singleton
class BookSubscriber{
    List<Book> bookList = new ArrayList<>();
    public void add(@Observes @Add Book book){
        System.out.println(book.getName()+ " was added to list");
        bookList.add(book);
    }
    public void delete(@Observes @Remove Book book){
        System.out.println(book.getName() + " was removed from the list");
        bookList.remove(book);
    }
}
