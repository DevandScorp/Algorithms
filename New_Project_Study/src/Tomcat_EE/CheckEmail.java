package Tomcat_EE;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
@NotNull
@Size(min = 7)
@Pattern(regexp = "[A-z][a-z]*")
@Constraint(validatedBy = {})
@Target({ElementType.METHOD,ElementType.FIELD,ElementType.ANNOTATION_TYPE,ElementType.CONSTRUCTOR,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckEmail {
    String message() default "Email adress doesn't look good";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
