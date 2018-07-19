package Tomcat_EE;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = {CheckWebLogic.class})
@Target({ElementType.METHOD,ElementType.FIELD,ElementType.ANNOTATION_TYPE,ElementType.CONSTRUCTOR,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckWebPage {
    String message() default "This webpage is wrong";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    int port() default -1;
    String host() default "";
    String protocol() default "";
}
