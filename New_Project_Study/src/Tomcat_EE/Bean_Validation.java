package Tomcat_EE;


import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.*;
import javax.validation.constraints.*;
import javax.validation.executable.ExecutableValidator;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

@WebServlet("/validation")
public class Bean_Validation extends HttpServlet {
    @Inject
    Validator_Class validator_class;
    @Inject
    Validator custom_validatior;
    @Inject
    User_2 user_2;
    @Inject
    User user;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        user_2.age = 15;
        user_2.name = "Max";
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        Set<ConstraintViolation<User_2>> validate = validator.validate(user_2);
        if(validate.size()>0){
            System.out.println("Something went wrong");
        }
        for(ConstraintViolation<User_2> constraintViolation:validate){
            System.out.println(constraintViolation.getMessage());
            System.out.println(constraintViolation.getInvalidValue());
        }
        Set<ConstraintViolation<User_2>> name = validator.validateProperty(user_2, "name");
        if(name.size()>0){
            System.out.println("name is wrong");
        }
        /**
         * Нижеприведенная функция чекнет,подходит ли значение условиям валидации
         */
        Set<ConstraintViolation<User_2>> constraintViolations = validator.validateValue(User_2.class, "name", "anton");
        if(constraintViolations.size()>0){
            System.out.println("anton is wrong name in parameter");
        }
        /**
         * Для валидации методов
         */
        ExecutableValidator executableValidator = validator.forExecutables();
        try {
            /**
             * последний - это тот объект,который ты туда передаешь
             */
            Set<ConstraintViolation<Class<User_2>>> setName = executableValidator.validateParameters(User_2.class, User_2.class.getMethod("setName", String.class), new Object[]{null});
            if(setName.size()>0){
                System.out.println("Wrong name in setter method");
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        System.out.println("CUSTOM VALIDATION");
        validatorFactory.close();
        Set<ConstraintViolation<Custom_Validator>> email = custom_validatior.validateValue(Custom_Validator.class, "email", "mymail@gmail.com");
        Set<ConstraintViolation<Custom_Validator>> email1 = custom_validatior.validateValue(Custom_Validator.class, "email", "mymail@gmail.ru");
        for(ConstraintViolation<Custom_Validator> constraintViolation : email){
            System.out.println(constraintViolation.getMessage());
            System.out.println(constraintViolation.getInvalidValue());
        }
        for(ConstraintViolation<Custom_Validator> constraintViolation : email1){
            System.out.println(constraintViolation.getMessage());
            System.out.println(constraintViolation.getInvalidValue());
        }
        Set<ConstraintViolation<Custom_Validator>> webpage = custom_validatior.validateValue(Custom_Validator.class, "webPage", "mysite.com");
        for(ConstraintViolation<Custom_Validator> constraintViolation : webpage){
            System.out.println(constraintViolation.getMessage());
            System.out.println(constraintViolation.getInvalidValue());
        }
        Set<ConstraintViolation<Custom_Validator>> webpage2 = custom_validatior.validateValue(Custom_Validator.class, "webPage2", "https://mysite.com");
        for(ConstraintViolation<Custom_Validator> constraintViolation : webpage2){
            System.out.println(constraintViolation.getMessage());
            System.out.println(constraintViolation.getInvalidValue());
        }
        System.out.println();
        System.out.println("___________________________________________");
        validator_class.setBirthDate(LocalDate.of(2017,01,01));
        validator_class.setDeathDate(LocalDate.of(2016,01,01));
        Set<ConstraintViolation<Validator_Class>> validate1 = custom_validatior.validate(validator_class);
        for(ConstraintViolation<Validator_Class> constraintViolation : validate1){
            System.out.println(constraintViolation.getMessage());
            System.out.println(constraintViolation.getInvalidValue());
        }
    }
}

/**
 * Валидация класса
 * !!!!!!!!!!Валидации работают и на наследниках класса
 */
@SynchronizeDates
class Validator_Class {
    LocalDate birthDate;
    LocalDate deathDate;

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public LocalDate getDeathDate() {
        return deathDate;
    }

    public void setDeathDate(LocalDate deathDate) {
        this.deathDate = deathDate;
    }
}
class Custom_Validator{
    /**Это был валидатор,сделанный на основе существующих.*/
    @CheckEmail
    String email;
    /**Здесь мы будем создавать свой так называемый кастомный валидатор*/
    @CheckWebPage(host = "mysite.com")
    String webPage;
    @CheckWebPage(port = 5)
    String webPage1;
    @CheckWebPage(protocol = "http")
    String webPage2;
}

/**
 * Для кастомного валидатора
 */
class CheckWebLogic implements ConstraintValidator<CheckWebPage,String>{
    String protocol;
    String host;
    int port;
    @Override
    public void initialize(CheckWebPage checkWebPage) {
        /**
         * Нахера они?Можно инициализировать как показано выше
         */
        protocol = checkWebPage.protocol();
        host = checkWebPage.host();
        port = checkWebPage.port();
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if(s==null || s.equals(""))return true;
        /**
         * Почему true?Потому что по сути предварительно ты должен использовать @NotNull,поэтому ты считаешь,
         * что если строка нулевая,то так и надо
         */
        URL url;
        try {
            url = new URL(s);
        } catch (MalformedURLException e) {
            return false;
        }
        if(protocol!=null && !protocol.equals("") && !protocol.equals(url.getProtocol())){
            constraintValidatorContext.disableDefaultConstraintViolation();
            /**
             * Сообщение,которое ты получишь
             */
            constraintValidatorContext.buildConstraintViolationWithTemplate("protocol invalid").addConstraintViolation();
            return false;
        }
        if(host!=null && host.length()>0 && !host.equals(url.getHost())){
            constraintValidatorContext.disableDefaultConstraintViolation();
            /**
             * Сообщение,которое ты получишь
             */
            constraintValidatorContext.buildConstraintViolationWithTemplate("host invalid").addConstraintViolation();
        }
        if(port!=-1 && port!=url.getPort()){
            constraintValidatorContext.disableDefaultConstraintViolation();
            /**
             * Сообщение,которое ты получишь
             */
            constraintValidatorContext.buildConstraintViolationWithTemplate("port invalid").addConstraintViolation();
            return false;
        }
        return true;
    }
}
class User_2{
    @Pattern(regexp = "[A-Z][a-z]*")
    String name;
    @Min(18)
    int age;

    public void setName(@NotNull String name) {
        this.name = name;
    }
}
/**
 * Проверки на валидность
 */
class User{
    /**
     *Может быть как одна аннотация,так и множество
     */
    @NotNull
            @Pattern(regexp = "[A-Z][a-z]*")
    String name;
    /**
     * Минимальное значение
     */
    @Min(18)
    int age;
    @Size(max = 200)
    String description;
    @Past
    Date date;//должно быть до текущей даты
    /**
     * Можно и над методами,но если это например геттер,то аннотация должна быть либо над геттером,либо над соответствующим полем
     */
    String userName;
    @NotNull
    public void getUserName(String userName) {
        this.userName = userName;
    }

    public void setUserName(@NotNull String userName) {
        this.userName = userName;
    }
}
