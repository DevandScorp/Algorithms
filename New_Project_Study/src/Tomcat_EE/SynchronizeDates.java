package Tomcat_EE;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = {CheckDates.class})
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface SynchronizeDates {
    String message() default "dates invalid";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
